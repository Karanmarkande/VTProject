package com.upu.vtproject.api.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.upu.vtproject.model.StudentModel;

import java.util.List;

public class StudentResponse {
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("results")
    @Expose
    private List<StudentModel> results;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<StudentModel> getResults() {
        return results;
    }

    public void setResults(List<StudentModel> results) {
        this.results = results;
    }
}
