/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.io.BufferedReader;
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
public class ReadFromFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        try {
            Path file = Paths.get("F:\\promotion1.log");
            BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
            String line = null;
            String json = "[";
            while ((line = reader.readLine()) != null) {
                int count = 0;
                if (count > 4) {
                    count = 0;
                }
                for (String str : line.split("\\|")) {
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

            json = json.substring(0, json.length() - 2) + "]";
            
            JSONArray data = new JSONArray(json);
            ArrayList<HashMap<String, String>> myArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);
                map = new HashMap<String, String>();
                map.put("Date", c.getString("Date"));
                map.put("startTime", c.getString("startTime"));
                map.put("endTime", c.getString("endTime"));
                map.put("mobileNo", c.getString("mobileNo"));
                myArrList.add(map);
            }                         
        } catch (Exception e) {
            System.out.print(e);
        }

    }
}
