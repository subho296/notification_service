package com.subho.notificationservice.entities;

public enum Status {
    ENQUE,IN_PROGRESS, PROCESSED, FAILED;

    public String toString(){
        return super.toString().toUpperCase();
    }
}
