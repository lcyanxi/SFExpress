package cn.coolbhu.sfexpress.model;

import java.util.Date;

public class User {
    private String userid;

    private String username;

    private String password;

    private String email;

    private String phone;

    private Integer slead;

    private Date usercreatetime;

    private Integer usermark;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getSlead() {
        return slead;
    }

    public void setSlead(Integer slead) {
        this.slead = slead;
    }

    public Date getUsercreatetime() {
        return usercreatetime;
    }

    public void setUsercreatetime(Date usercreatetime) {
        this.usercreatetime = usercreatetime;
    }

    public Integer getUsermark() {
        return usermark;
    }

    public void setUsermark(Integer usermark) {
        this.usermark = usermark;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid='" + userid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", slead=" + slead +
                ", usercreatetime=" + usercreatetime +
                ", usermark=" + usermark +
                '}';
    }
}