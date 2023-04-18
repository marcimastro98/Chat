import 'primereact/resources/primereact.css';
/* import "primeflex/primeflex.css"; */
import 'primeicons/primeicons.css';
import ScaleText from 'react-scale-text';
import React, { useState, useEffect } from 'react';
import { Carousel } from 'primereact/carousel';
import { Button } from 'primereact/button';
import { TbFreeRights } from 'react-icons/tb';
import { TbPremiumRights } from 'react-icons/tb';
import { AiFillUnlock } from 'react-icons/ai';
import { AiFillLock } from 'react-icons/ai';
import './ChatroomsCarousel.css';
import RingLoader from 'react-spinners/RingLoader';

const ChatroomsCarousel = (props) => {
  const [premium, setPremium] = useState(props.status);

  const responsiveOptions = [
    {
      breakpoint: '3440px',
      numVisible: 8,
      numScroll: 3,
    },
    {
      breakpoint: '2000px',
      numVisible: 5,
      numScroll: 3,
    },
    {
      breakpoint: '1500px',
      numVisible: 4,
      numScroll: 3,
    },
    {
      breakpoint: '1024px',
      numVisible: 3,
      numScroll: 3,
    },
    {
      breakpoint: '600px',
      numVisible: 2,
      numScroll: 2,
    },
    {
      breakpoint: '480px',
      numVisible: 2,
      numScroll: 1,
    },
  ];

  const productTemplate = (product) => {
    return (
      <div className='product-item'>
        <div className='product-item-content'>
          {premium ? (
            <AiFillUnlock
              style={{ color: '#1f2d40', height: '20px', width: '30px' }}
            />
          ) : (
            <AiFillLock
              style={{ color: '#1f2d40', height: '20px', width: '30px' }}
            />
          )}
          <div className='mb-3'>
            <img
              src={`images/product/${product.image}`}
              onError={(e) =>
                (e.target.src =
                  'https://www.primefaces.org/wp-content/uploads/2020/05/placeholder.png')
              }
              alt={product.name}
              className='product-image'
            />
          </div>
          <div>
            <ScaleText minFontSize={11} maxFontSize={18}>
              <h4 className='mb-1'>{product.name}</h4>
            </ScaleText>
            <h6 className='flex justify-content-center flex-wrap'>
              <div className='online flex align-items-center justify-content-center'></div>
              <div className='flex align-items-center justify-content-center'>
                Online users: {product.price}
              </div>
            </h6>
            <span className={`product-badge `}>{product.inventoryStatus}</span>
            <div className='car-buttons mt-5'>
              <Button
                label='Enter'
                className='p-button-success p-button-rounded mr-2'
              />
            </div>
          </div>
        </div>
      </div>
    );
  };

  return (
    <>
      {premium ? (
        <div className='carousel-demo'>
          <div className='card'>
            <Carousel
              value={props.rooms}
              numVisible={4}
              numScroll={1}
              responsiveOptions={responsiveOptions}
              className='custom-carousel premium'
              circular
              autoplayInterval={6000}
              itemTemplate={productTemplate}
              header={
                <h4 className='premiumText'>
                  <TbPremiumRights
                    className='premium-icon'
                    style={{
                      color: '#ffd54f',
                      width: '40px',
                      height: '25px',
                    }}
                  />{' '}
                  Premium Rooms
                </h4>
              }
            />
          </div>
          <div className='card'>
            <Carousel
              value={props.rooms}
              numVisible={5}
              numScroll={1}
              responsiveOptions={responsiveOptions}
              className='custom-carousel'
              circular
              autoplayInterval={4000}
              itemTemplate={productTemplate}
              header={
                <h4 className='freeText'>
                  <TbFreeRights
                    className='free-icon'
                    style={{
                      color: 'green',
                      width: '40px',
                      height: '25px',
                    }}
                  />{' '}
                  Free Rooms
                </h4>
              }
            />
          </div>
        </div>
      ) : (
        <div className='carousel-demo'>
          <div className='card'>
            <Carousel
              value={props.rooms}
              numVisible={5}
              numScroll={1}
              responsiveOptions={responsiveOptions}
              className='custom-carousel'
              circular
              autoplayInterval={4000}
              itemTemplate={productTemplate}
              header={
                <h4 className='freeText'>
                  <TbFreeRights
                    className='free-icon'
                    style={{
                      color: 'green',
                      width: '40px',
                      height: '25px',
                    }}
                  />{' '}
                  Free Rooms
                </h4>
              }
            />
          </div>
          <div className='card'>
            <Carousel
              value={props.rooms}
              numVisible={4}
              numScroll={1}
              responsiveOptions={responsiveOptions}
              className='custom-carousel premium'
              circular
              autoplayInterval={6000}
              itemTemplate={productTemplate}
              header={
                <h4 className='premiumText'>
                  <TbPremiumRights
                    className='premium-icon'
                    style={{
                      color: '#ffd54f',
                      width: '40px',
                      height: '25px',
                    }}
                  />{' '}
                  Premium Rooms
                </h4>
              }
            />
          </div>
        </div>
      )}
    </>
  );
};

export default ChatroomsCarousel;
