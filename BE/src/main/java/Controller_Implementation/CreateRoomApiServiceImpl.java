package Controller_Implementation;

import Dto.Room;
import Interface.RoomServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2022-11-09T17:58:03.621Z[GMT]")
public class CreateRoomApiServiceImpl {
    @Autowired
    RoomServiceInterface roomServiceInterface;

    public String createRoom(Room body) {
        try {
            Room room = roomServiceInterface.insert(body);
            if (room != null) {
                return "Stanza creata con successo";
            } else {
                return "Errore servizio momentaneamente non disponibile";
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return "Errore servizio momentaneamente non disponibile";
        }
    }

    public String deleteRoom(Room body) {
        try {
            Room room = roomServiceInterface.deleteAllBy_id(body.get_id());
            if (room != null) {
                return "Stanza eliminata con successo";
            } else {
                return "Errore servizio momentaneamente non disponibile";
            }

        } catch (Exception e) {
            e.printStackTrace();

            return "Errore servizio momentaneamente non disponibile";
        }
    }
}
