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

    public double CalcCost(CallingHistory phone) throws ParseException {
        double result = 0;
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date start = df.parse(phone.startTime);
        Date end = df.parse(phone.endTime);
        long diff = end.getTime() - start.getTime();
        int secondDiff = (int) (diff / 1000);
        result = 3 + ((secondDiff - 60) * 1.0 / 60.0);

        return result;
    }

    @Override
    public String toString() {
        String result = "MobileNo: " + mobileNo
                + "\nCost: " + cost;

        return result;
    }

}
