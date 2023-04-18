package Configuration;

import Controller_Implementation.*;
import Service.UserServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.Serializable;
@Configuration

public class SpringConfiguration implements Serializable {

    private static final long serialVersionUID = -4471714605577702519L;

    @Bean
    public UserServices getUserService() {
        return new UserServices();
    }


    @Bean
    public UserVipSettingsApiServiceImpl getUserVipSettingsApiServiceImpl() {
        return new UserVipSettingsApiServiceImpl();
    }

    @Bean
    public UserRoomApiServiceImpl getUserRoomApiServiceImpl() {
        return new UserRoomApiServiceImpl();
    }


    @Bean
    public LoginApiServiceImpl loginApiServiceImpl() {
        return new LoginApiServiceImpl();
    }

    @Bean
    public RegistrazioneApiServiceImpl registrazioneApiServiceImpl() {
        return new RegistrazioneApiServiceImpl();
    }

    @Bean
    public CreateRoomApiServiceImpl createRoomApiServiceImpl() {
        return new CreateRoomApiServiceImpl();
    }


    @Bean
    public RoomApiServiceImpl getRoomApiServiceImpl() {
        return new RoomApiServiceImpl();
    }

    @Bean
    public ModifyRoomApiServiceImpl modifyRoomApiServiceImpl() {
        return new ModifyRoomApiServiceImpl();
    }

    @Bean
    public ModifySettingsApiServiceImpl modifySettingsApiServiceImpl() {
        return new ModifySettingsApiServiceImpl();
    }

    @Bean
    public CreateReferral createReferral(){return new CreateReferral();}
    @Bean
    public SecurityEncryption securityEncryption(){return new SecurityEncryption();}
}
