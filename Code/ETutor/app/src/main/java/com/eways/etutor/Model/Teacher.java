package com.eways.etutor.Model;

/**
 * Created by ADMIN on 3/18/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Teacher {

    @SerializedName("errorCode")
    @Expose
    private Integer errorCode;
    @SerializedName("teacher")
    @Expose
    private Teacher_ teacher;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Teacher_ getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher_ teacher) {
        this.teacher = teacher;
    }

}

