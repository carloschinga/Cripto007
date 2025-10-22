package com.example.Cripto007.dto;

public class CredencialDTO {
    private String login;
    private String password;

    public CredencialDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }
    public CredencialDTO() {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
