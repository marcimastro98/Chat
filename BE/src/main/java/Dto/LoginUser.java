package Dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import org.jetbrains.annotations.NotNull;


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaResteasyEapServerCodegen", date = "2022-11-09T15:57:24.386Z[GMT]")
public class LoginUser {
    private String language = null;
    private String referral = null;
    private boolean vip = false;
    private String username = null;
    private String email = null;
    private String password = null;

    /**
     *
     **/

    @Schema(example = "en", required = true, description = "")
    @JsonProperty("language")
    @NotNull
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     *
     **/

    @Schema(example = "edfwd", required = true, description = "")
    @JsonProperty("referral")
    @NotNull
    public String getReferral() {
        return referral;
    }

    public void setReferral(String referral) {
        this.referral = referral;
    }

    /**
     *
     **/

    @Schema(example = "true", description = "")
    @JsonProperty("vip")
    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    /**
     *
     **/

    @Schema(example = "edfwd", required = true, description = "")
    @JsonProperty("username")
    @NotNull
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     **/

    @Schema(example = "sa@live.it", description = "")
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

    @Schema(example = "*******", required = true, description = "")
    @JsonProperty("password")
    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoginUser loginUser = (LoginUser) o;
        return Objects.equals(language, loginUser.language) &&
                Objects.equals(referral, loginUser.referral) &&
                Objects.equals(vip, loginUser.vip) &&
                Objects.equals(username, loginUser.username) &&
                Objects.equals(email, loginUser.email) &&
                Objects.equals(password, loginUser.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(language, referral, vip, username, email, password);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LoginUser {\n");

        sb.append("    language: ").append(toIndentedString(language)).append("\n");
        sb.append("    accessKey: ").append(toIndentedString(referral)).append("\n");
        sb.append("    vip: ").append(toIndentedString(vip)).append("\n");
        sb.append("    username: ").append(toIndentedString(username)).append("\n");
        sb.append("    email: ").append(toIndentedString(email)).append("\n");
        sb.append("    password: ").append(toIndentedString(password)).append("\n");
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
