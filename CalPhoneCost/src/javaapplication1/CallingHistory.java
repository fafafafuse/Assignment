/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import com.google.gson.annotations.Expose;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author fuse
 */
public class CallingHistory {

    private String date;
    private String startTime;
    private String endTime;

    @Expose
    private String mobileNo;
    @Expose
    private double cost;

    public CallingHistory() {

    }

    public String getDate() {
        return date;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCost() {
        return cost;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

}
