package Service;

import Interface.UserServiceInteface;
import Dto.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;
import java.util.List;

public class UserServices {


    @Autowired
    UserServiceInteface userServicesInteface;

    public List<User> getAllUsers() {
        return userServicesInteface.findAll();
    }



    public User getUserbyReferral(String referral) {return userServicesInteface.findUsersByReferral(referral);}


    public User editUserUsernameByReferral(String referral, String username){
        User user=userServicesInteface.findUsersByReferral(referral);
        user.setUsername(username);
        userServicesInteface.save(user);
        return user;
    }
}
