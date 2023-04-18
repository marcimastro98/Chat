package Controller_Implementation;

import Configuration.JwtProvider;
import Configuration.SecurityEncryption;
import Dto.LoginUser;
import Dto.User;
import Interface.UserServiceInteface;
import Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import Response.Login_Response;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2022-11-09T15:57:24.386Z[GMT]")
public class LoginApiServiceImpl {
    @Autowired
    UserServiceInteface userServicesInteface;
    @Autowired
    UserServices userServices;
    @Autowired
    SecurityEncryption securityEncryption;

    public Login_Response loginUser(LoginUser body) {
        Login_Response login_response = new Login_Response();
        try {
            if (body.isVip()) {
                try{
                String encodeRef=securityEncryption.toHexString(securityEncryption.getSHA(body.getReferral()));
                User user = null;
                if(userServicesInteface.findUsersByReferral(encodeRef) != null){
                    user = userServicesInteface.findUsersByReferral(encodeRef);
                }else if(userServicesInteface.findUserByUsername(body.getUsername()) != null){
                    user=userServicesInteface.findUserByUsername(body.getUsername());
                }
                User usertoMap = new User();
                Map claimMap = new HashMap<>();
                if (user != null &&  user.getPassword().equals(body.getPassword())) {
                    claimMap.put("referral", user.getReferral());
                    claimMap.put("username", user.getUsername());
                    claimMap.put("password", user.getPassword());
                    user.setLanguage(body.getLanguage());
                    login_response.setVerifica("Utente loggato");
                    login_response.setReferal(user.getReferral());
                    login_response.setVip(true);
                    String jwt = JwtProvider.createJwt(user.getReferral(), claimMap);
                    login_response.setJwtToken(jwt);
                    login_response.setResponse_code(11);
                    userServicesInteface.save(user);
                    return login_response;
                } else {
                    login_response.setReferal(user.getReferral());
                    login_response.setVip(true);
                    login_response.setResponse_code(10);
                    return login_response;
                }
                }catch (Exception e){
                    login_response.setVerifica(e.toString());
                    login_response.setReferal(body.getReferral());
                    login_response.setVip(true);
                    login_response.setResponse_code(10);
                    return login_response;
                }
            } else {
                try{
                    Map claimMap = new HashMap<>();
                    String encodeRef= securityEncryption.toHexString(securityEncryption.getSHA(body.getReferral()));
                    User user=null;
                    user=userServices.editUserUsernameByReferral(encodeRef, body.getUsername());
                    if(userServices.editUserUsernameByReferral(encodeRef, body.getUsername()) != null){
                        user=userServices.editUserUsernameByReferral(encodeRef, body.getUsername());
                        user.setLanguage(body.getLanguage());
                        claimMap.put("referral", body.getReferral());
                        claimMap.put("username", body.getUsername());
                        login_response.setVip(false);
                        String jwt = JwtProvider.createJwt(body.getReferral(), claimMap);
                        login_response.setJwtToken(jwt);
                        login_response.setReferal(body.getReferral());
                        login_response.setUsername(body.getUsername());
                        login_response.setResponse_code(1);
                        userServicesInteface.save(user);
                        return login_response;
                    }else{
                        login_response.setVip(false);
                        login_response.setReferal(body.getReferral());
                        login_response.setUsername(body.getUsername());
                        login_response.setResponse_code(0);
                        return login_response;
                    }


                }catch (Exception e){
                    login_response.setVerifica(e.toString());
                    login_response.setVip(false);
                    login_response.setReferal(body.getReferral());
                    login_response.setUsername(body.getUsername());
                    login_response.setResponse_code(0);
                    return login_response;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
            login_response.setResponse_code(500);
            login_response.setVerifica(String.valueOf(e));
            return login_response;
        }

    }
}
