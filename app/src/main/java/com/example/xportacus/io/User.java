package com.example.xportacus.io;

public class User {

    private String name, lastname, address, email, password, token;
    private int age, trainingLevel;

    public User(String name, String lastname, String address, String email, String password, int age, int trainingLevel){
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.email = email;
        this.password = password;
        this.age = age;
        this.trainingLevel = trainingLevel;
    }

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }

    public String getLastname(){
        return this.lastname;
    }

    public String getAddress(){
        return this.address;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    public int getAge(){
        return this.age;
    }

    public int getTrainingLevel(){
        return this.trainingLevel;
    }

    public String setName(String name){
       return this.name = name;
    }

    public String setLastname(String lastname){
       return this.lastname = lastname;
    }

    public String getToken(){ return this.token; }

    public void setToken(String token) { this.token = token; }



}
