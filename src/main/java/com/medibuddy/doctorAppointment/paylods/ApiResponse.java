package com.medibuddy.doctorAppointment.paylods;

import com.medibuddy.doctorAppointment.utils.JSONMessage;

import java.io.Serializable;

public class ApiResponse<T> implements Serializable {
    JSONMessage message;
    T data;

    public ApiResponse() {
        super();
    }

    public ApiResponse(JSONMessage message, T data) {
        this.message = message;
        this.data = data;
    }

    public JSONMessage getMessage() {
        return message;
    }

    public void setMessage(JSONMessage message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
