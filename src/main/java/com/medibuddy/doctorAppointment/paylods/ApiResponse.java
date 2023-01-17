package com.medibuddy.doctorAppointment.paylods;

import com.medibuddy.doctorAppointment.utils.JsonMessage;

import java.io.Serializable;

public class ApiResponse<T> implements Serializable {
    JsonMessage message;
    T data;

    public ApiResponse() {
        super();
    }

    public ApiResponse(JsonMessage message, T data) {
        this.message = message;
        this.data = data;
    }

    public JsonMessage getMessage() {
        return message;
    }

    public void setMessage(JsonMessage message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
