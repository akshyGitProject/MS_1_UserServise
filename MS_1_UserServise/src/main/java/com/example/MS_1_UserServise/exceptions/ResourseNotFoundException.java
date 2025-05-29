package com.example.MS_1_UserServise.exceptions;

public class ResourseNotFoundException extends RuntimeException{

    public ResourseNotFoundException(){
        super("Resourse Not Found on Server!!");
    }

    public ResourseNotFoundException(String message){
        super(message);
    }

}
