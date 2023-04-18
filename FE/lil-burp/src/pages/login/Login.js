/* eslint-disable no-debugger */
/* eslint-disable no-unused-vars */
import React, { useRef, useState, useEffect } from 'react';
import logo from '../../logo.svg';
import './Login.css';
import '../Background.css';
import { InputText } from 'primereact/inputtext';
import { Button } from 'primereact/button';
import SegmentedControl from '../../components/segmented-controller/SegmentedControl';
import { Password } from 'primereact/password';
import 'primeflex/primeflex.css';
import {
  generateAvatar,
  getRandom,
  nameData,
} from '../../components/random-username/RandomUsername';
import { Link } from 'react-router-dom';
import { Service } from '../../service/Service';
import { useNavigate } from 'react-router-dom';
import DropDownLanguage from '../../components/dropdown-language/DropdownLanguage';

function Login(props) {
  const firstName = getRandom(nameData.firstName);
  const lastNamePrefix = getRandom(nameData.lastNamePrefix);
  const lastNameSuffix = getRandom(nameData.lastNameSuffix);
  let now = new Date();
  const [generateReferral, setGenerateReferral] = useState(false);
  const [selectedAccountType, setSelectedAccountType] = useState('free');
  const [avatar, setAvatar] = useState('');
  const [referral, setReferral] = useState('');
  const [password, setPassword] = useState('');
  const [premiumUsernameOrReferral, setPremiumUsernameOrReferral] =
    useState('');
  const [freeUsername, setfreeUsername] = useState();
  const [token, setToken] = useState('');
  const [errorFreeLogin, setErrorFreeLogin] = useState();
  const [errorPremiumLogin, setErrorPremiumFreeLogin] = useState();
  const [language, setLanguage] = useState({
    name: 'English',
    code: 'US',
    img: '🇺🇸',
  });
  const randomNumber =
    Math.floor(Math.random() * (now.getSeconds() - now.getSeconds() + 1)) +
    now.getMilliseconds();
  const service = new Service();

  try {
    useEffect(() => {
      setAvatar(generateAvatar(Math.random()));
      setfreeUsername(
        `${firstName}_${lastNamePrefix}${lastNameSuffix}_${randomNumber.toString()}`
      );
    }, []);
  } catch (error) {
    console.log(error);
  }

  let navigate = useNavigate();

  const freeLogin = () => {
    return service
      .freeLogin(freeUsername, referral, language.code)
      .then((res) => {
        let response_code = res.data.response_code;
        let free = res.data.vip;
        props.premium(free);
        response_code === 1 && free === false
          ? navigate('/rooms')
          : setErrorFreeLogin(true),
          setErrorPremiumFreeLogin(false);
      });
  };
  const premiumLogin = () => {
    return service
      .premiumLogin(true, premiumUsernameOrReferral, password, language.code)
      .then((res) => {
        let response_code = res.data.response_code;
        let free = res.data.vip;
        props.premium(free);
        response_code === 11 && free === true
          ? navigate('/rooms')
          : setErrorFreeLogin(false),
          setErrorPremiumFreeLogin(true);
      });
  };

  const spans = [];
  for (let i = 0; i < 50; i++) {
    spans.push(<span key={i}></span>);
  }
  return (
    <>
      <div className='background'>{spans}</div>
      <div className='Login overflow-hidden h-full'>
        <div className='App-header'>
          <div
            id={'login-card'}
            className='flex align-items-center justify-content-center px-10 py-10'>
            <div
              id='label-card'
              className='surface-card p-4 shadow-2 border-round w-full'>
              <div className='drop-down-language'>
                <DropDownLanguage
                  value={(value) => {
                    setLanguage(value);
                  }}
                />
              </div>
              <div className='text-center mb-5'>
                <img
                  src={logo}
                  alt='hyper'
                  height={50}
                  className='mb-3 App-logo'
                />

                <div className='text-900 text-3xl font-medium mb-3'>
                  Welcome to LilBurp
                </div>
                <span className='text-600 font-medium line-height-3'>
                  The anonymous debate chat.
                </span>
              </div>
              <div className='container'>
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
              </div>
              <div>
                <label className='block text-900 font-medium mb-2'>
                  {selectedAccountType === 'free'
                    ? 'Username'
                    : 'Username/Referral'}
                </label>
                <div className='p-inputgroup mb-2'>
                  <span className='p-inputgroup-addon'>
                    {selectedAccountType === 'free' ? (
                      <img src={avatar} width='20' alt='avatar' />
                    ) : (
                      <i className='pi pi-user' />
                    )}
                  </span>
                  {selectedAccountType === 'free' ? (
                    <div style={{ width: '100%' }}>
                      <InputText
                        className={'p-disabled'}
                        placeholder={`${freeUsername}`}
                        type='text'
                        style={{ width: '100%' }}
                      />
                    </div>
                  ) : (
                    <InputText
                      placeholder={'Username or Referral'}
                      type='text'
                      onChange={(e) =>
                        setPremiumUsernameOrReferral(e.target.value)
                      }
                    />
                  )}
                </div>
                <label
                  htmlFor='password'
                  className='block text-900 font-medium mb-2'>
                  {selectedAccountType === 'free' ? 'Referral' : 'Password'}
                </label>
                <div className='p-inputgroup mb-2'>
                  <span className='p-inputgroup-addon'>
                    <i
                      className={
                        selectedAccountType === 'free'
                          ? 'pi pi-ticket'
                          : 'pi pi-lock'
                      }
                    />
                  </span>
                  {selectedAccountType === 'free' ? (
                    <InputText
                      id='referral'
                      type={'text'}
                      className='w-full'
                      placeholder='Referral'
                      onChange={(e) => setReferral(e.target.value)}
                      validateOnly={true}
                    />
                  ) : (
                    <Password
                      value={password}
                      onChange={(e) => setPassword(e.target.value)}
                      toggleMask
                      feedback={false}
                      placeholder='Password'
                    />
                  )}
                </div>
                {errorFreeLogin && selectedAccountType === 'free' && (
                  <p className='error-dataLoad'>
                    Data loading error, check and try again!
                  </p>
                )}
                {errorPremiumLogin && selectedAccountType === 'premium' && (
                  <p className='error-dataLoad'>
                    Data loading error, check and try again!
                  </p>
                )}
                <img src={avatar} width='50' alt='avatar' />
                <br />
                <Button
                  label={selectedAccountType === 'free' ? 'Join' : 'Sign In'}
                  className='button-login mt-2'
                  onClick={
                    selectedAccountType === 'free' ? freeLogin : premiumLogin
                  }
                />
              </div>
              <div className='container-p-registration'>
                <p>If you don't have referral</p>
                <Link to='/registration' className='link-registration'>
                  <p className='p-registration'>Generate new referral</p>
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default Login;
