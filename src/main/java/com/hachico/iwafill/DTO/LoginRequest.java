package com.hachico.iwafill.DTO;

public class LoginRequest {
    private String usenameOrEmail;
    private String password;

    LoginRequest(){}

    public LoginRequest(String usenameOrEmail, String password) {
        this.usenameOrEmail = usenameOrEmail;
        this.password = password;
    }

    public String getUsenameOrEmail() {
        return usenameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setUsenameOrEmail(String usenameOrEmail) {
        this.usenameOrEmail = usenameOrEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

}
