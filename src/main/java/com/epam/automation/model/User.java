package com.epam.automation.model;

public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private String e_mail;

    public User(){}

    public User(int id, String name, String login, String password, String e_mail){
        this.id=id;
        this.name=name;
        this.login=login;
        this.password=password;
        this.e_mail=e_mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    @Override
    public String toString() {
        return "User: ID=" + this.id + " com.epam.automation.data.Name=" + this.name + " Login=" + this.login + " Password="
                + this.password + " E_mail=" + this.e_mail;
    }
}

