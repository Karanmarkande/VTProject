package com.upu.vtproject.api.response.commonResponse;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * base pojo class for all incoming responses
 * contains only message and code
 * change key if needed.
 */

public class BaseResponse {

    @SerializedName("results")
    @Expose
    private String results;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("code")
    @Expose
    private String code;

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "results='" + results + '\'' +
                ", message='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}