package com.example.oso.timmon.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginR {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("content")
    @Expose
    private ContentLoginR content;

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "LoginR{" +
                "message='" + message + '\'' +
                ", content=" + content.toString() +
                '}';
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ContentLoginR getContent() {
        return content;
    }

    public void setContent(ContentLoginR content) {
        this.content = content;
    }

}