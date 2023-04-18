package Controller;
import Controller_Implementation.*;
import Dto.LoginUser;
import Dto.Room;
import Dto.User;
import Response.GetRoomResponse;
import Response.Login_Response;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.security.NoSuchAlgorithmException;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestControllers {
    @Autowired
    CreateRoomApiServiceImpl createRoomApiService;
    @Autowired
    CreateReferral createReferral;
    @Autowired
    LoginApiServiceImpl loginApiService;
    @Autowired
    ModifyRoomApiServiceImpl modifyRoomApiService;
    @Autowired
    ModifySettingsApiServiceImpl modifySettingsApiService;
    @Autowired
    RegistrazioneApiServiceImpl registrazioneApiService;
    @Autowired
    RoomApiServiceImpl roomApiService;
    @Autowired
    UserRoomApiServiceImpl userRoomApiService;
    @Autowired
    UserVipSettingsApiServiceImpl userVipSettingsApiService;

    @GetMapping("/api/room/{lang}")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "Get per la restituzione delle camere", description = "ritorna una lista di camere", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Room.class)))),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "general error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public GetRoomResponse getRoom(@PathVariable(value = "lang") String language) {
        return roomApiService.getRoom(language);
    }

    @PostMapping("/userRoom")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "Recupero room utente vip", description = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Room.class)))),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "general error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public List<Room> getVipRoom(@RequestBody User body) {
        return userRoomApiService.getVipRoom(body);
    }

    @GetMapping("/api/userVipSettings")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "Recupero room utente vip", description = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Dto.Settings.class)))),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "general error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public User getuserVipSettings(@RequestBody User body ) {
        return userVipSettingsApiService.getuserVipSettings(body);
    }
//    @PostMapping("/api/createReferral")
//    @Consumes({"application/json"})
//    @Produces({"application/json"})
//    @Operation(summary = "Create referral", description = "", tags = {})
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
//            @ApiResponse(responseCode = "405", description = "Invalid input"),
//            @ApiResponse(responseCode = "500", description = "general error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
//    })
//    public String createReferral(@RequestBody User body) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, InvalidKeyException {
//        return createReferral.takeReferral(body);
//    }
    @PostMapping("/api/registerUser")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "Registrazione", description = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "general error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public String registerUser(@RequestBody User body) throws NoSuchAlgorithmException {
        return registrazioneApiService.registerUser(body);
    }

    @org.springframework.web.bind.annotation.PutMapping("/modifySettings")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "modifica dei settings", description = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "general error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public String modifySettings(@RequestBody User body) {
        return modifySettingsApiService.modifySettings(body);
    }


    @PutMapping("/modifyRoom")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "modifica dei settings", description = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "general error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public String modifyRoom(@RequestBody Dto.Room body) {
        return modifyRoomApiService.modifyRoom(body);
    }


    @PostMapping("/loginUser")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Login_Response loginUser(@RequestBody LoginUser body) {
        return loginApiService.loginUser(body);
    }


    @PostMapping("/createRoom")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "crea nuova room", description = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "general error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public String createRoom(@RequestBody Room body) {
        return createRoomApiService.createRoom(body);
    }

    @PostMapping("/deleteRoom")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    @Operation(summary = "crea nuova room", description = "", tags = {})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "405", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "general error", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class)))
    })
    public String deleteRoom(@RequestBody Room body) {
        return createRoomApiService.deleteRoom(body);
    }
}

