package io.github.kartiksethi;

public class NotificationRequest {
    private final String message;

    NotificationRequest(String message){
        this.message = message;
    }

    String getMessage(){
        return message;
    }
}