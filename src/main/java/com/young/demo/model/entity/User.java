package com.young.demo.model.entity;


public class User extends AuditedEntity{
    private Long number;
    private String email;
    private String password;

    public User(Long number, String email, String password) {
        this.number = number;
        this.email = email;
        this.password = password;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
