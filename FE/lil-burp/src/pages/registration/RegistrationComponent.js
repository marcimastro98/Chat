/* eslint-disable no-unused-vars */
import './RegistrationComponent.css';
import '../Background.css';
import React, { useState, useRef, useCallback, useEffect } from 'react';
import { InputText } from 'primereact/inputtext';
import { Password } from 'primereact/password';
import { Button } from 'primereact/button';
import { BiCopy } from 'react-icons/bi';
import { CopyToClipboard } from 'react-copy-to-clipboard';
import SegmentedControl from '../../components/segmented-controller/SegmentedControl';
import { Link, redirect, useNavigate } from 'react-router-dom';
import { Service } from '../../service/Service';
import {
  getRandom,
  nameData,
} from '../../components/random-username/RandomUsername';
import { v4 as uuidv4 } from 'uuid';

const RegistrationComponent = () => {
  const firstName = getRandom(nameData.firstName);
  const lastNamePrefix = getRandom(nameData.lastNamePrefix);
  const lastNameSuffix = getRandom(nameData.lastNameSuffix);
  let now = new Date();
  const service = new Service();
  const randomNumber =
    Math.floor(Math.random() * (now.getSeconds() - now.getSeconds() + 1)) +
    now.getMilliseconds();
  const [selectedAccountType, setSelectedAccountType] = useState('free');
  const [referral, setReferral] = useState();
  const [copied, setCopied] = useState(referral);
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [repPassword, setRepPassword] = useState('');
  const [premiumResponse, setPremiumResponse] = useState(100);
  const [formError, setFormError] = useState({
    password: '',
    confirmPassword: '',
  });

  let freeUsername = `${firstName}_${lastNamePrefix}${lastNameSuffix}_${randomNumber.toString()}`;

  const createReferral = () => {
    const start = new Date();
    let uuid = uuidv4();
    let username = freeUsername;
    let concat = start.getMilliseconds() + uuid + username;
    let referral = window.btoa(concat.toString()).substring(0, 15);
    return referral;
  };

  useEffect(() => {
    setReferral(createReferral());
    setCopied(createReferral());
  }, []);

  const onCopy = useCallback(() => {
    if (referral != copied) {
      setCopied(referral);
    } else {
      setCopied('Copied !');
    }
  }, []);
  const saveFreeUser = () => {
    service.registration(freeUsername, referral);
  };

  const savePremiumUser = () => {
    return service
      .registrationPremiumUser(username, password, referral, 'image_prova')
      .then((res) => {
        const response = res.data;
        setPremiumResponse(parseInt(response));
      });
  };
  let navigate = useNavigate();
  const redirectPremiumUser = () => {
    if (premiumResponse === 1) {
      setInterval(() => {
        navigate('/');
      });
    }
  };
  const validateInput = () => {
    let inputError = {
      password: '',
      confirmPassword: '',
    };
    if (repPassword !== password) {
      setFormError({
        ...inputError,
        confirmPassword: 'Password and confirm password should be same',
      });
    } else {
      setFormError({
        ...inputError,
        confirmPassword: '',
      });
    }
  };

  const spans = [];
  for (let i = 0; i < 50; i++) {
    spans.push(<span key={i}></span>);
  }

  return (
    <>
      <div className='container'>
        <div className='background h-screen'>{spans}</div>
        {/* <div id='stars' className={"overflow-y-hidden"}></div>
                <div id='stars2' className={"overflow-y-hidden"}></div>
                <div id='stars3' className={"overflow-y-hidden"}></div> */}
        <SegmentedControl
          name='group-1'
          callback={(val) => setSelectedAccountType(val)}
          controlRef={useRef()}
          defaultIndex={0}
          segments={[
            {
              label: 'Free',
              value: 'free',
              ref: useRef(),
            },
            {
              label: 'Premium',
              value: 'premium',
              ref: useRef(),
            },
          ]}
        />

        {selectedAccountType === 'free' ? (
          <div className='container-registration'>
            <div className='registration blue'>
              <label className='referral '>{'Personal Referral:'}</label>
              <p className='referral-p'>
                {copied}
                <CopyToClipboard text={referral} onCopy={onCopy}>
                  {copied !== 'Copied !' ? (
                    <BiCopy className='copy' />
                  ) : (
                    <BiCopy className='copy' style={{ display: 'none' }} />
                  )}
                </CopyToClipboard>
              </p>

              <p className='referral-copy'>
                <b>
                  Copy and save your <u>referral</u> for future access!
                </b>
              </p>
              <div className='save'>
                <Link to='/'>
                  <Button
                    label='Continue'
                    icon='pi pi-check'
                    onClick={saveFreeUser}
                  />
                </Link>
              </div>
            </div>
          </div>
        ) : (
          <div className='container-registration premium-container-reg'>
            <div
              className={
                premiumResponse === 100
                  ? 'registration premium-registration'
                  : premiumResponse === 2 || premiumResponse === 0
                  ? 'registration premium-registrationFailed'
                  : 'registration premium-registrationOk'
              }>
              <div className='p-inputgroup mb-2 inputs-registration'>
                {premiumResponse === 100 ||
                premiumResponse === 0 ||
                premiumResponse === 1 ? (
                  <label className='username'>{'Username'}</label>
                ) : premiumResponse === 2 ? (
                  <label className='username' style={{ color: 'red' }}>
                    {'Username already exist!'}
                  </label>
                ) : null}
                <InputText
                  className='input-registration'
                  placeholder='Enter your Username'
                  id='premium-username'
                  type='text'
                  value={username}
                  onBlur={validateInput}
                  onChange={(e) => setUsername(e.target.value)}
                />
                <label className='password '>{'Password'}</label>
                <Password
                  className='input-registration'
                  placeholder='Enter your Password'
                  id='password'
                  type='password'
                  value={password}
                  onChange={(e) => setPassword(e.target.value)}
                  toggleMask
                />
                <label className='rep-password '>{'Repeat Password'}</label>
                <InputText
                  className={
                    formError.confirmPassword === ''
                      ? 'input-registration'
                      : 'wrong-password'
                  }
                  placeholder='Repeat Password'
                  id='repPassword'
                  type='password'
                  value={repPassword}
                  onBlur={validateInput}
                  onChange={(e) => setRepPassword(e.target.value)}
                />
                {formError && (
                  <span className='error-message'>
                    {formError.confirmPassword}
                  </span>
                )}
                <label className='referral '>{'Personal Referral:'}</label>
                <p className='referral-p'>
                  {copied}
                  <CopyToClipboard text={referral} onCopy={onCopy}>
                    {copied !== 'Copied !' ? (
                      <BiCopy className='copy' />
                    ) : (
                      <BiCopy className='copy' style={{ display: 'none' }} />
                    )}
                  </CopyToClipboard>
                </p>
                <p className='referral-copy'>
                  <b>
                    Copy and save your <u>username</u> and <u>referral</u> for
                    future access!
                  </b>
                </p>
                <div className='save'>
                  {(username !== '' &&
                    password !== '' &&
                    password === repPassword &&
                    premiumResponse === 100) ||
                  premiumResponse === 2 ? (
                    <Button
                      label='Check'
                      icon='pi pi-check'
                      onClick={savePremiumUser}
                    />
                  ) : username !== '' &&
                    password !== '' &&
                    password === repPassword &&
                    premiumResponse === 1 ? (
                    <Button
                      label='Login!'
                      icon='pi pi-check'
                      onClick={redirectPremiumUser}
                    />
                  ) : username === '' ||
                    password === '' ||
                    password !== repPassword ||
                    premiumResponse !== 2 ? (
                    <Button label='Check' icon='pi pi-check' disabled />
                  ) : null}
                </div>
              </div>
            </div>
          </div>
        )}
      </div>
    </>
  );
};
export default RegistrationComponent;
