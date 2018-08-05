package com.eways.etutor.Model.Course;

/**
 * Created by ADMIN on 5/20/2018.
 */

import android.util.Log;

import com.eways.etutor.Interfaces.DataCallback.Course.CourseDetailsCallBack;
import com.eways.etutor.Interfaces.DataCallback.Course.CourseListCallBack;
import com.eways.etutor.Interfaces.DataCallback.CreateCourseCallBack;
import com.eways.etutor.Network.ApiUtils;
import com.eways.etutor.Network.Responses.BaseResponse;
import com.eways.etutor.Network.Responses.Course.CourseListResponse;
import com.eways.etutor.Network.Responses.Course.CourseRespsonse;
import com.eways.etutor.Utils.SupportKeys;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Course {

    @SerializedName("IdCourse")
    @Expose
    private String idCourse;
    @SerializedName("CourseName")
    @Expose
    private String courseName;
    @SerializedName("Uid")
    @Expose
    private String uid;
    @SerializedName("CourseType")
    @Expose
    private String courseType;
    @SerializedName("CreatedDate")
    @Expose
    private String createdDate;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("IdSubject")
    @Expose
    private String idSubject;
    @SerializedName("Tuition")
    @Expose
    private String tuition;
    @SerializedName("Address")
    @Expose
    private String address;
    @SerializedName("NumberOfSessions")
    @Expose
    private String numberOfSessions;
    @SerializedName("TimePerSession")
    @Expose
    private String timePerSession;
    @SerializedName("TimeStart")
    @Expose
    private String timeStart;
    @SerializedName("TimeEnd")
    @Expose
    private String timeEnd;
    @SerializedName("StudentNumber")
    @Expose
    private String studentNumber;
    @SerializedName("Schedule")
    @Expose
    private String schedule;
    @SerializedName("Description")
    @Expose
    private String description;
    @SerializedName("LastName")
    @Expose
    private String lastName;
    @SerializedName("FirstName")
    @Expose
    private String firstName;
    @SerializedName("Avatar")
    @Expose
    private String avatar;
    @SerializedName("SubjectName")
    @Expose
    private String subjectName;

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(String idSubject) {
        this.idSubject = idSubject;
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberOfSessions() {
        return numberOfSessions;
    }

    public void setNumberOfSessions(String numberOfSessions) {
        this.numberOfSessions = numberOfSessions;
    }

    public String getTimePerSession() {
        return timePerSession;
    }

    public void setTimePerSession(String timePerSession) {
        this.timePerSession = timePerSession;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    /** ----- METHODS ----- */

    /** Get course details */

    public static void createCourse(String jsonCourse, final CreateCourseCallBack createCourseCallBack) {

//        ELearningServicesImp eLearningServicesImp = ApiUtils.eLearningServices();
//        eLearningServicesImp.createCourse(jsonCourse).enqueue(new Callback<BaseResponse>() {
//            @Override
//            public void onResponse(Call<BaseResponse> call, Response<BaseResponse> response) {
//
//                Log.d("createCourse:", call.request().toString());
//
//                // handle errors
//
//                if (!response.isSuccessful()) {
//                    Log.d("createCourse:", "connect failed");
//                    createCourseCallBack.createCourseCallback(SupportKeys.FAILED_CODE, null);
//                    return;
//                }
//
//                // handle result
//                if (Integer.parseInt(response.body().getStatus()) == 0) {
//                    Log.d("createCourse:", "Create failed");
//                    createCourseCallBack.createCourseCallback(SupportKeys.FAILED_CODE, null);
//                    return;
//                }
//
//                // Sign up success
//                createCourseCallBack.createCourseCallback(SupportKeys.SUCCESS_CODE, null);
//            }
//
//            @Override
//            public void onFailure(Call<BaseResponse> call, Throwable t) {
//                Log.d("createCourse:", t.getLocalizedMessage());
//                createCourseCallBack.createCourseCallback(SupportKeys.FAILED_CODE, null);
//            }
//
//        });

    }

    //public static void getCourseDetails(String courseId, final CourseDetailsCallBack courseDetailsCallBack) {

//        ELearningServicesImp eLearningServicesImp = ApiUtils.eLearningServices();
//        eLearningServicesImp.getCourseById(courseId).enqueue(new Callback<CourseRespsonse>() {
//            @Override
//            public void onResponse(Call<CourseRespsonse> call, Response<CourseRespsonse> response) {
//                Log.d("CourseDetailsModel", call.request().toString());
//                // handle error
//                if (!response.isSuccessful()) {
//                    Log.d("CourseDetailsModel:", "connect failed");
//                    courseDetailsCallBack.courseDetailsCallBack(SupportKeys.FAILED_CODE, null);
//                    return;
//                }
//
//                // Prepare data
//                courseDetailsCallBack.courseDetailsCallBack(SupportKeys.SUCCESS_CODE, response.body().getCourse());
//            }
//
//            @Override
//            public void onFailure(Call<CourseRespsonse> call, Throwable t) {
//                Log.d("CourseDetailsModel", call.request().toString() + "--- Error msg: " + t.getLocalizedMessage());
//                courseDetailsCallBack.courseDetailsCallBack(SupportKeys.FAILED_CODE, null);
//            }
//        });

    //}

    /** Get course list */

   // public static void getCourseList(String subjectId, final CourseListCallBack courseCallBack) {

//        ELearningServicesImp eLearningServicesImp = ApiUtils.eLearningServices();
//        eLearningServicesImp.getCourseListBySubject(subjectId, SupportKeys.APP_AUTHENTICATION).enqueue(new Callback<CourseListResponse>() {
//            @Override
//            public void onResponse(Call<CourseListResponse> call, Response<CourseListResponse> response) {
//                // handle error
//                if (!response.isSuccessful()) {
//                    Log.d("CourseListModel:", "connect failed");
//                    courseCallBack.courseCallBack(SupportKeys.FAILED_CODE, null);
//                    return;
//                }
//
//                // Prepare data
//                courseCallBack.courseCallBack(SupportKeys.SUCCESS_CODE, response.body().getCourseList());
//            }
//
//            @Override
//            public void onFailure(Call<CourseListResponse> call, Throwable t) {
//                Log.d("CourseListModel:", t.getLocalizedMessage());
//                courseCallBack.courseCallBack(SupportKeys.FAILED_CODE, null);
//            }
//        });

    //}

}
