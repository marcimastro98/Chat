package Controller_Implementation;

import Dto.User;
import Interface.UserServiceInteface;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;


import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2022-11-09T15:57:24.386Z[GMT]")
public class ModifySettingsApiServiceImpl {
    @Autowired
    UserServiceInteface userServicesInteface;

    public String modifySettings(User body) {
        try {
            if (userServicesInteface.findUsersByReferral(body.getReferral()) != null) {
                userServicesInteface.save(body);
                return "Modifica del profilo effettuata con successo";

            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Errore momentaneo";
        }
        return "Errore momentaneo";
    }
}
