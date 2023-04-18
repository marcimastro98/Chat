import axios from 'axios';
export class Service {
  getProductsSmall() {
    return fetch('mock-products-small.json')
      .then((res) => res.json())
      .then((d) => d.data);
  }

  // getProducts() {
  //     return fetch('data/products.json').then(res => res.json()).then(d => d.data);
  // }
  //
  // getProductsWithOrdersSmall() {
  //     return fetch('data/products-orders-small.json').then(res => res.json()).then(d => d.data);
  // }
  /*     getReferral(username) {
            return axios.post(process.env.REACT_APP_BE_PATH + "api/createReferral", {
                username: username
            })
    
        } */
  registration(username, referral) {
    return axios.post(process.env.REACT_APP_BE_PATH + 'api/registerUser', {
      username: username,
      referral: referral,
    });
  }
  registrationPremiumUser(username, password, referral, profile_image) {
    return axios.post(process.env.REACT_APP_BE_PATH + 'api/registerUser', {
      username: username,
      password,
      password,
      referral: referral,
      profile_image: profile_image,
    });
  }

  freeLogin(freeUsername, referral, language) {
    return axios.post(`${process.env.REACT_APP_BE_PATH}loginUser`, {
      username: freeUsername,
      referral: referral,
      language: language,
    });
  }

  premiumLogin(vip, usernameOrReferral, password, language) {
    return axios.post(process.env.REACT_APP_BE_PATH + 'loginUser', {
      vip: vip,
      username: usernameOrReferral,
      referral: usernameOrReferral,
      password: password,
      language: language,
    });
  }

  getRooms() {
    axios.get(process.env.REACT_APP_BE_PATH + 'api/room/ita');
  }
}
