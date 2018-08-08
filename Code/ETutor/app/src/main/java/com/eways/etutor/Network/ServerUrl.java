package com.eways.etutor.Network;

/**
 * Created by zzzzz on 10/4/2017.
 *
 * Description: Lưu các link api của server.
 */

public class ServerUrl {

    //Link server
    public static final String ServerUrl = "http://ewayseducation.hostingerapp.com/";
    public static final String ServerAPIURL = ServerUrl + "api/";

    /** ACCOUNT */
    public static final String UserAPIRoot = ServerAPIURL + "user/";
    public static final String LOGIN_URL = UserAPIRoot + "tutor/tutorlogin.php";
    public static final String SIGN_UP_URL = UserAPIRoot + "addnewuser.php";
    public static final String GET_USER_INFO_URL = UserAPIRoot + "getuserbyid.php";
    public static final String CHECK_PHONE_NUMBER_URL = UserAPIRoot + "isuserexisted.php";
    public static final String SEND_REQUEST_URL = ServerAPIURL + "requisitioncourse/addrequisitioncourse.php";

    /** Subjects */
    public static final String GET_SUBJECT_LIST_URL = ServerAPIURL + "subject/getsubject.php";

    /** Course */
    public static final String CREATE_COURSE_URL = ServerAPIURL + "Course/AddNewCourse.php";
    public static final String GET_COURSE_LIST_BY_SUBJECT_URL = ServerAPIURL + "Course/GetCoursesBySubject.php";
    public static final String GET_COURSE_BY_ID_URL = ServerAPIURL + "Course/GetCourseByIdCourse.php";

}
