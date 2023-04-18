package Controller_Implementation;

import Dto.User;
import org.springframework.transaction.annotation.Transactional;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class CreateReferral {
    private String setREF(String username) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        Date date = new Date();
        UUID uid = UUID.randomUUID();
        String concat = username.concat(date.toString()).concat(uid.toString());
        String ref = null;
        ref = Base64.getEncoder().withoutPadding().encodeToString(concat.getBytes()).substring(0, 10);
        return ref;
    }
    @Transactional
    public String takeReferral(User body) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
        try{
            String ref=setREF(body.getUsername());
            String encodedReferral= Base64.getEncoder().encodeToString(ref.getBytes());
            return encodedReferral;
        }catch (Exception e){
            return "Referral creation error!";
        }

    }





}
