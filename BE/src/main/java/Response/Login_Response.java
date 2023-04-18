package Response;

import Dto.User;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class Login_Response {
    private String verifica;
    private int response_code;
    private String referal;
    private String jwtToken;
    private boolean vip;
    private String username;
}
