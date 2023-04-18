package Controller_Implementation;

import Configuration.SecurityEncryption;
import Dto.User;
import Interface.UserServiceInteface;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import static javax.crypto.Cipher.SECRET_KEY;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2022-11-09T15:57:24.386Z[GMT]")
public class RegistrazioneApiServiceImpl {

    @Autowired
    UserServiceInteface userServicesInteface;
    @Autowired
    SecurityEncryption securityEncryption;

    @Transactional
    public String registerUser(User body) throws NoSuchAlgorithmException {
        if(body.getPassword() != null){
            try{
                User usernameAlreadyExist=userServicesInteface.findUserByUsername(body.getUsername());
                if(usernameAlreadyExist == null){
                    User user=new User();
                    user.setUsername(body.getUsername());
                    user.setPassword(body.getPassword());
                    user.setPremiumORfree(true);
                    String encryptReferral=securityEncryption.toHexString(securityEncryption.getSHA(body.getReferral()));
                    user.setReferral(encryptReferral);
                    user.setUser_role("user");
                    user.setLanguage("US");
                    user.setProfile_image(body.getProfile_image());
                userServicesInteface.insert(user);
                    return "1";
                }else{
                    return "2";
                }
            }catch (Exception e){
                return "0";
            }

        }else{
            User user=new User();
            user.setPremiumORfree(false);
            String encryptReferral=securityEncryption.toHexString(securityEncryption.getSHA(body.getReferral()));
            user.setReferral(encryptReferral);
            user.setUser_role("user");
            user.setLanguage("US");
            try {
                userServicesInteface.insert(user);
                return "1";
            } catch (Exception e) {
                return "0";
            }
        }

    }




}
