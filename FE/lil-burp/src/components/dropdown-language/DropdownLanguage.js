import React, { useState, useEffect, useRef } from 'react';
import { Dropdown } from 'primereact/dropdown';
import Flag from 'react-world-flags';
import './DropdownLanguage.css';
import 'primereact/resources/primereact.css';
import 'primeflex/primeflex.css';
import 'primeicons/primeicons.css';

const DropdownLanguage = (props) => {
  const [selectedCountry, setSelectedCountry] = useState({
    name: 'English',
    code: 'US',
    img: '🇺🇸',
  });
  const countries = [
    { name: 'English', code: 'US', img: '🇺🇸' },
    { name: 'Italian', code: 'IT', img: '🇮🇹' },
    { name: 'Spanish', code: 'ES', img: '🇪🇸' },
    { name: 'Germany', code: 'DE', img: '🇩🇪' },
    { name: 'French', code: 'FR', img: '🇫🇷' },
    { name: 'Portoguese', code: 'PT', img: '🇵🇹' },
    { name: 'Chinese', code: 'CN', img: '🇨🇳' },
    { name: 'Arabic', code: 'SA', img: '🇸🇦' },
  ];

  const selectedCountryTemplate = (option, props) => {
    if (option) {
      return (
        <div className='country-item country-item-value'>
          <Flag className={'w-2rem'} code={option.code} />
          <div className='code'>{option.code}</div>
        </div>
      );
    }

    return <span>{props.placeholder}</span>;
  };

  const countryOptionTemplate = (option) => {
    return (
      <div className='country-item'>
        <Flag className={'w-2rem'} code={option.code} />
        <div className='code'>{option.code}</div>
      </div>
    );
  };

  const onCountryChange = (e) => {
    setSelectedCountry(e.value);
    props.value(e.value);
  };

  return (
    <Dropdown
      value={selectedCountry}
      options={countries}
      onChange={onCountryChange}
      optionLabel='name'
      placeholder='Language'
      valueTemplate={selectedCountryTemplate}
      itemTemplate={countryOptionTemplate}
    />
  );
};
export default DropdownLanguage;
