package com.eways.etutor.Network.Responses.Course;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by zzzzz on 7/1/2018.
 */

public class CourseRespsonse {

    @SerializedName("errorCode")
    @Expose
    private Integer errorCode;
    @SerializedName("result")
    @Expose
    private com.eways.etutor.Model.Course.Course course = null;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public com.eways.etutor.Model.Course.Course getCourse() {
        return course;
    }

    public void setCourse(com.eways.etutor.Model.Course.Course course) {
        this.course = course;
    }

}
