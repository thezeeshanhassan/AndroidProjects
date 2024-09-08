package com.example.twitter;


public class User {
    private String userName;
    private String password;
    private String email;

    // Constructor
    public User() {
        this.userName="";
        this.email="";
        this.password="";
    }

    // Parameterized constructor
    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email=email;
    }

    // Getter and setter for userName
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail(){return email;};

    public  void setEmail(String email){
        this.email=email;
    }
    // Override the toString method for easier debugging and logging
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
