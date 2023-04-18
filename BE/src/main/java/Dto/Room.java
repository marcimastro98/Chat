package Dto;


import lombok.*;
import nonapi.io.github.classgraph.json.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2022-11-09T15:57:24.386Z[GMT]")
@Document(collection = "Room")
public class Room {
    @Id
    private ObjectId _id;
    public String roomName;
    public int peopleOnlineInTheRoom;
    public int maxPeopleRoom;
    public boolean roomPremium;
    public String roomImage;
    public String roomLanguage;
    public String referal;

}
