package Controller_Implementation;

import Dto.User;
import Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2022-11-09T15:57:24.386Z[GMT]")public class UserVipSettingsApiServiceImpl  {

    @Autowired
    UserServices userService;

    public User getuserVipSettings(User body) {

          User user = userService.getUserbyReferral(body.referral);
          if(user!=null && user.premiumORfree){
              return user;
          }
          return null;
  }
}
