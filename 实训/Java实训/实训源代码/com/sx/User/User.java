package com.sx.User;

public class User {
    private String uid;
    private String upass;

    public User(String uid, String upass){
        this.uid = uid;
        this.upass=upass;
    }

    public User() {

    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }


}
