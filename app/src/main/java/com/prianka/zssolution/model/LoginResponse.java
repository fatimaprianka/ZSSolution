package com.prianka.zssolution.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LoginResponse {

    @SerializedName("action")
    private String action;

    @SerializedName("message")
    private String message;

    @SerializedName("dataArray")
    private ArrayList dataArray;

    @SerializedName("userid")
    private String userId;

    public LoginResponse() {
    }

    public String getAction() {
        return action;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList getDataArray() {
        return dataArray;
    }

    public String getUserId() {
        return userId;
    }
}
