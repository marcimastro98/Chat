package Configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class JwtProvider {
    public static DecodedJWT verifyJwt(String littleBurp) {
        return JWT.require(Algorithm.HMAC256("lilburp")).build().verify(littleBurp);
    }

    private JwtProvider() {
    }

    public static String createJwt(String referral, Map<String,Object>claimMap) {
        Calendar cal =Calendar.getInstance();
        Date date=cal.getTime();
        cal.set(Calendar.HOUR_OF_DAY,cal.get(Calendar.HOUR_OF_DAY)+1);
        Date newMoreHour=cal.getTime();
        JWTCreator.Builder builder=JWT.create().withSubject(referral).withIssuer("lilburp").withIssuedAt(date).withExpiresAt(newMoreHour);
        if(claimMap!=null && !claimMap.isEmpty()) {
            for (Map.Entry<String, Object> entry : claimMap.entrySet()) {
                builder.withClaim(entry.getKey(), entry.getValue().toString());

            }
        }
           return builder.sign(Algorithm.HMAC256("lilburp"));
        }



}
