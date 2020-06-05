package com.example.model;

public class LoginBean {
    private String username,password;

    public LoginBean(){

    }
    public String getUsername() {return username;}
    public void setUsername(String username){ this.username = username;}
    public String getPassword() { return password;}
    public void setPassword(String password){ this.password = password;}
    public boolean checklogin(){
        if (username != null && !username.equals("user")){
            return true;
        }else{
            return false;
        }
    }
}
