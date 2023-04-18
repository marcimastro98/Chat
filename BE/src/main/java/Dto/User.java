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
@Document(collection = "User")
public class User {
    @Id
    private ObjectId _id;
    public String user_role;
    public String username;
    public Boolean premiumORfree;
    public String referral;
    public String profile_image;
    public String language;
    private String password;


}
