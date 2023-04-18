package Configuration;

import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

public class AuthorizationFilter extends BasicAuthenticationFilter {


    @Autowired
    public AuthorizationFilter(AuthenticationManager authenticationManager){
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header= request.getHeader("Authorization");

        if(header!=null && header.startsWith("Bearer LittleBurp")){
            DecodedJWT decodedJWT =JwtProvider.verifyJwt(header.replace("Bearer LittleBurp",""));
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(decodedJWT.getSubject(),null, Collections.emptyList()));
        }
        chain.doFilter(request, response);
    }

}
