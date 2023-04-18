package Controller_Implementation;


import Dto.Room;
import Dto.User;
import Interface.RoomServiceInterface;
import Interface.UserServiceInteface;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2022-11-09T15:57:24.386Z[GMT]")
public class UserRoomApiServiceImpl {

    @Autowired
    UserServiceInteface userServicesInteface;

    @Autowired
    RoomServiceInterface roomServiceInterface;


    public List<Room> getVipRoom(User body) {
        List<Room> rooms = new ArrayList<>();
        try {
            User user = userServicesInteface.findUsersByReferral(body.getReferral());
            if (user != null && user.premiumORfree) {

                rooms = roomServiceInterface.findAllByReferal(body.referral);

            }
            return rooms;
        }
        catch (Exception e){
            e.printStackTrace();
            return rooms;
        }
    }
}
