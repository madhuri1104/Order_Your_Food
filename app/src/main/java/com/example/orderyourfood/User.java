package com.example.orderyourfood;

public class User {
    public User(String name, String email, String pass, String village, String mobile) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.village = village;
        this.mobile = mobile;
    }

    private String name,email,pass,village,mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
