package Controller_Implementation;


import Dto.Room;
import Interface.RoomServiceInterface;
import Response.GetRoomResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2022-11-09T15:57:24.386Z[GMT]")
public class RoomApiServiceImpl {

@Autowired
    RoomServiceInterface roomServiceInterface;

    public GetRoomResponse getRoom(String languange) {
        GetRoomResponse response = new GetRoomResponse();
        try {
            List<Room> roomFree = roomServiceInterface.findAllByRoomPremiumAndRoomLanguage(false, languange);
            List<Room> roomsPremium = roomServiceInterface.findAllByRoomPremiumAndRoomLanguage(true, languange);
            response.setRoomsNumberFree(roomFree);
            response.setRoomsNumberPremium(roomsPremium);
            response.setLanguange(languange);
            return response;
        }catch(Exception e){
            response.setStatus("Errore momentaneo");
            return response;

        }
    }
}
