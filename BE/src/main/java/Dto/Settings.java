package Dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2022-11-09T15:57:24.386Z[GMT]")
public class Settings {
    private String username = null;
    private String language = null;
    private String photo = null;
    private String email = null;
    private String password = null;
    private String confirmPassword = null;

    /**
     *
     **/

    @Schema(example = "marcello", description = "")
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     **/

    @Schema(example = "en", description = "")
    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     *
     **/

    @Schema(example = "inserire base 64", description = "")
    @JsonProperty("photo")
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     *
     **/

    @Schema(example = "ciccio@live.it", description = "")
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     **/

    @Schema(example = "*******", description = "")
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     **/

    @Schema(example = "*******", description = "")
    @JsonProperty("confirmPassword")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Settings settings = (Settings) o;
        return Objects.equals(username, settings.username) &&
                Objects.equals(language, settings.language) &&
                Objects.equals(photo, settings.photo) &&
                Objects.equals(email, settings.email) &&
                Objects.equals(password, settings.password) &&
                Objects.equals(confirmPassword, settings.confirmPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, language, photo, email, password, confirmPassword);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Settings {\n");

        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    language: ").append(toIndentedString(language)).append("\n");
        sb.append("    photo: ").append(toIndentedString(photo)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
        sb.append("    confirmPassword: ").append(toIndentedString(confirmPassword)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
