/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author fline
 */
public class ReadFromFile3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            Path fileIn = Paths.get("F:\\promotion1.log");
            BufferedReader reader = Files.newBufferedReader(fileIn, StandardCharsets.UTF_8);
            String line = null;
            String json = "[";
            while ((line = reader.readLine()) != null) {
                int count = 0;
                if (count > 4) {
                    count = 0;
                }
                for (String str : line.split("\\|")) { //ตัดข้อมูลแต่ละส่วนมา re-format ใหม่เป็นรูปแบบของ JSON
                    switch (count) {
                        case 0:
                            json += "{\"Date\":\"" + str + "\"";
                            break;
                        case 1:
                            json += "\"startTime\":\"" + str + "\"";
                            break;
                        case 2:
                            json += "\"endTime\":\"" + str + "\"";
                            break;
                        case 3:
                            json += "\"mobileNo\":\"" + str + "\"";
                            break;
                        case 4:
                            json += "\"Promotion\":\"" + str + "\"}";
                            break;
                    }
                    count++;
                    json += ", ";
                }
            }
            reader.close();

            json = json.substring(0, json.length() - 2) + "]"; //จัดFormat ให้เรียบร้อย

            JSONArray data = new JSONArray(json); //เอา log ที่จัดเป็น JSON แล้วมาทำ JSON obj array เพื่อเอามาใช้คำนวณหาค่าโทร
            CallingHistory phone = new CallingHistory();
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();       
            String outJson = new String();

            for (int i = 0; i < data.length(); i++) {

                JSONObject jsonObj = data.getJSONObject(i);

                phone.setDate(jsonObj.getString("Date"));
                phone.setStartTime(jsonObj.getString("startTime"));
                phone.setEndTime(jsonObj.getString("endTime"));
                phone.setMobileNo(jsonObj.getString("mobileNo"));
                phone.setCost(phone.CalcCost(phone));
                outJson += "," + "\n" + gson.toJson(phone); //แปลงObject กลับเป็น JSON ด้วย GSON รวมทั้งจัดFormat ให้แต่ละเบอร์เว้นบรรทัด
            }

            String output = outJson.substring(1, outJson.length()); //ตัด , ที่เกินมาตอนจัดFormat

            Path fileOut = Paths.get("F:\\PhoneCallingCost.json");
            BufferedWriter writer = Files.newBufferedWriter(fileOut,
                    StandardCharsets.UTF_8);

            writer.write("[" + output + "\n]"); //เขียนไฟล์ JSON 
            writer.close();

        } catch (Exception e) {
            System.out.print(e);
        }

    }
}