package com.ccf.pojo;

public class User {

    private String id;

    private String name;

    private String password;

    private String isSignUp;

    private String identify;

    private String role;//角色，学生，老师，管理员

    public String getIsSignUp() {
        return isSignUp;
    }

    public void setIsSignUp(String isSignUp) {
        this.isSignUp = isSignUp;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsSginUp() {
        return isSignUp;
    }

    public void setIsSginUp(String isSginUp) {
        this.isSignUp = isSginUp;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }
}
