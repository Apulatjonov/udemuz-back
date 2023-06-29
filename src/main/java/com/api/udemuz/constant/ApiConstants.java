package com.api.udemuz.constant;

/**
 * Created by Abdulaziz Pulatjonov
 * Date: 06/29/2023 03:38
 */

public interface ApiConstants {
    String api = "/api";
    String admin = "/admin";
    String teacher = "/teacher";
    String student = "/student";
    String cabinet = "/cabinet";
    String version = "/v1";
    String user = "/user";
    String login = "/login";
    String logout = "/logout";

    String authentication = api + login;
    String deauthentication = api + logout;

    String adminRootApi = api + admin + version;
    String cabinetStudentRootApi = api + version + student + cabinet;
    String teacherCabinetRootApi = api + version + teacher + cabinet;


    String dashboard = "/dashboard";

}
