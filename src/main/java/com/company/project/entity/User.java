package com.company.project.entity;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;
@Data
@Entity
public class User implements Serializable {


    /**
     *
     */
    private int id;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private String nick_name;

    /**
     *
     */
    private int sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
    @Override
    public String toString()
    {
        return "";
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }
}
