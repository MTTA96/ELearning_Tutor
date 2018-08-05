package com.eways.etutor.Network.Responses.Course;

import com.eways.etutor.Model.Course.Course;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by zzzzz on 6/17/2018.
 */

public class CourseListResponse {

    @SerializedName("errorCode")
    @Expose
    private Integer errorCode;
    @SerializedName("results")
    @Expose
    private ArrayList<Course> courseList = null;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }
}
