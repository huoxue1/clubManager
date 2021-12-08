package com.gjs.anotion;

public enum  AuthEumn {

    PUBLIC("public"),
    User("user"),
    Manager("manager");


    public String grade;

    AuthEumn(String grade) {
        this.grade = grade;
    }
}
