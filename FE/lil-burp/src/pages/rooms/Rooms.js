import ChatroomsCarousel from '../../components/chatrooms-carousel/ChatroomsCarousel';
import MenubarDashboard from '../../components/menubar-dashboard/MenubarDashboard';
import DropdownLanguage from '../../components/dropdown-language/DropdownLanguage';
import './Rooms.css';
import { useState, useEffect } from 'react';
import LoadingComponent from '../../components/loading-component/LoadingComponent';
import { Service } from '../../service/Service';

const Rooms = (props) => {
  const [premium, setPremium] = useState(props.premium);
  const service = new Service();
  const [loadPage, setLoadPage] = useState(true);
  const [products, setProducts] = useState([]);

  /* let rooms = productService.getRooms(); */

  useEffect(() => {
    setPremium(props.premium);
    service.getProductsSmall().then((data) => {
      setProducts(data.slice(0, 9));
    });
    const interval = setInterval(() => {
      setLoadPage(false);
    }, 1650);
    return () => clearInterval(interval);
  }, []);
  return (
    <>
      {loadPage ? (
        <LoadingComponent />
      ) : (
        <>
          <div className='Rooms h-auto'>
            <div className='menu'>
              <MenubarDashboard status={premium} />
            </div>

            <div className='language'>
              <DropdownLanguage />
            </div>

            <div className='App-header block'>
              <ChatroomsCarousel status={premium} rooms={products} />
            </div>
          </div>
        </>
      )}
    </>
  );
};

export default Rooms;
