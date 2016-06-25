package com.android.entity;

import com.android.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private long userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userSurname")
    private String userSurname;
    @Column(name = "userNick")
    private String userNick;
    @Column(name = "userEmail")
    private String userEmail;
    @Column(name = "userBirthDate")
    private String userBirthDate;
    @Column(name = "userPassword")
    private String userPassword;
    @Column(name = "cihazBilgisi")
    private String cihazBilgisi;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(String userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getCihazBilgisi() {
        return cihazBilgisi;
    }

    public void setCihazBilgisi(String cihazBilgisi) {
        this.cihazBilgisi = cihazBilgisi;
    }

}
