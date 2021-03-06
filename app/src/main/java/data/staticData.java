package data;

import java.util.ArrayList;
import java.util.List;

import entity.Activity;
import entity.Sponsor;
import entity.Student;

/**
 * Created by ASUS on 2018/7/7.
 */

public class staticData {
    static String url = "http://42.159.153.247/HiWhuServer";//云服务器地址
    //static String url = "http://192.168.23.1:8080";//服务器地址
    //static String url = "http://192.168.191.1:8080";//服务器地址
    static String studentID = null;
    static String sponsorID = null;//登录用户id
    static String currentActivity = null;//当前所选活动
    static int userType = 0; //0-未登录; 1-学生; 2-发布方;
    public static final int TUIJIAN = 0;//推荐
    public static final int JINGSAI = 1;//竞赛
    public static final int TIYU = 2;//体育
    public static final int WENYI = 3;//文艺
    public static final int GONGYI = 4;//公益
    public static final int JIANGZUO = 5;//讲座
    public static final int QITA = 6;//其他
    public static List<Activity> activityList=null;//获取活动列表
    public static Sponsor sponsor=null;//获取当前主办方信息
    public static Student student=null;//获取当前学生信息
    public static Activity activity=null;//获取当前活动信息
    public static boolean sponsorCanOpera = false;

    public static boolean isSponsorCanOpera() {
        return sponsorCanOpera;
    }

    public static void setSponsorCanOpera(boolean sponsorCanOpera) {
        staticData.sponsorCanOpera = sponsorCanOpera;
    }

    public static String getCurrentActivity() {
        return currentActivity;
    }

    public static void setCurrentActivity(String currentActivity) {
        staticData.currentActivity = currentActivity;
    }

    public static String getUrl(){
        return url;
    }

    public static String getStudentID() {
        return studentID;
    }

    public static void setStudentID(String studentID) {
        staticData.studentID = studentID;
    }

    public static String getSponsorID() {
        return sponsorID;
    }

    public static void setSponsorID(String sponsorID) {
        staticData.sponsorID = sponsorID;
    }

    public static int getUserType() {
        return userType;
    }

    public static void setUserType(int userType) {
        staticData.userType = userType;
    }

}
