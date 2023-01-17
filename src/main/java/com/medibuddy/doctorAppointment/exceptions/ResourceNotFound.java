package com.medibuddy.doctorAppointment.exceptions;

public class ResourceNotFound extends RuntimeException{
    private String resourcName;
    private String fieldName;
    private String fieldValue;

    public ResourceNotFound(String resourcName, String fieldName, String fieldValue) {
        super(String.format("The %s : %s not found with value %s",resourcName,fieldName,fieldValue));
        this.resourcName = resourcName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
