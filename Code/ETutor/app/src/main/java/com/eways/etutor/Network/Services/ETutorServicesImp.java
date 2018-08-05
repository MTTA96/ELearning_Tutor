package com.eways.etutor.Network.Services;

import com.eways.etutor.Model.Subject.Subject;
import com.eways.etutor.Network.Responses.BaseResponse;
import com.eways.etutor.Network.Responses.Course.CourseListResponse;
import com.eways.etutor.Network.Responses.Course.CourseRespsonse;
import com.eways.etutor.Network.Responses.User.TrendingSubjectResponse;
import com.eways.etutor.Network.Responses.User.UserListResponse;
import com.eways.etutor.Network.ServerUrl;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by zzzzz on 5/22/2018.
 */

public interface ETutorServicesImp {
    /** Get subject list */
    @GET(ServerUrl.GET_SUBJECT_LIST_URL)
    Call<ArrayList<Subject>> getSubjectList();

    /** ----- COURSE ----- */

    /** Get course by ID */
    @GET(ServerUrl.GET_COURSE_BY_ID_URL)
    Call<CourseRespsonse> getCourseById(@Query("IdCourse") String courseId);

    /** Get course list by subject */
    @GET(ServerUrl.GET_COURSE_LIST_BY_SUBJECT_URL)
    Call<CourseListResponse> getCourseListBySubject(@Query("IdSubject") String subjectId,
                                                    @Query("CourseType") String courseType);

    /** Create course */
    @POST(ServerUrl.CREATE_COURSE_URL)
    @FormUrlEncoded
    Call<BaseResponse> createCourse(@Field("mydata") String myData);
}
