package Response;

import Dto.Room;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetRoomResponse {
    private String status;
    private String languange;
    private List<Room> roomsNumberPremium;
    private List<Room> roomsNumberFree;
}
