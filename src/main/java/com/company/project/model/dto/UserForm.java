package com.company.project.model.dto;

/**
 * 存放数据传输对象定义
 * 新增用户类型
 */
public class UserForm {

    private Integer id;


    private String username;

    private String password;

    private String nickName;


    private Integer sex;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }


    @Override
    public String toString(){

        return "UserFrom:{id="+id+";username="+username+";password="+password+";nickName="+nickName+";sex="+sex;
    }

}
