package Controller_Implementation;

import Dto.Room;
import Interface.RoomServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2022-11-09T17:58:03.621Z[GMT]")
public class ModifyRoomApiServiceImpl {
    @Autowired
    RoomServiceInterface roomServiceInterface;

    public String modifyRoom(Room body) {
        try  {
            Room rooms = roomServiceInterface.findRoomBy_idAndReferal(body.get_id(), body.getReferal());
            if (rooms != null) {
                roomServiceInterface.save(body);
                return "Modifca effeuttata con successo";
            } else {
                return "Modifica eseguita con successo";
            }
        }catch (Exception e){
            return "Errore momentaneo";
        }
    }
}
