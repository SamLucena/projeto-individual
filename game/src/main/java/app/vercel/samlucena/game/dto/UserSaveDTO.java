package app.vercel.samlucena.game.dto;

import app.vercel.samlucena.game.services.validation.UserSaveValid;

@UserSaveValid
public class UserSaveDTO extends UserDTO{

    private String password;

    public UserSaveDTO(){
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
