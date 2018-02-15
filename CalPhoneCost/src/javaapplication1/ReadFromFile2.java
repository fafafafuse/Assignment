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
import org.json.JSONArray;
import org.json.JSONException;

/**
 *
 * @author fuse
 */
public class ReadFromFile2 {

    public static void main(String[] args) {
        try {
            Path file = Paths.get("F:\\promotion1.log");
            BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8);
            String line = null;
            String result = "";
            String json = "[";
            while ((line = reader.readLine()) != null) {
                result += line;
            }          
            int count=0;
            String use;
            for (String cut : result.split("\\|")) {               
                if (count>4)
                    count = 0;
                use = cut.substring(1,cut.length()-1);
                
                switch(count){
                    case 0:json += "{\"Date\":\""+use.substring(use.indexOf("(")+1,use.indexOf(")"))+"\"";                      
                    break;
                    case 1:json += "\"startTime\":\""+use.substring(use.indexOf("(")+1,use.indexOf(")"))+"\"";
                    break;
                    case 2:json += "\"endTime\":\""+use.substring(use.indexOf("(")+1,use.indexOf(")"))+"\"";
                    break;
                    case 3:json += "\"mobileNo\":\""+use+"\"";
                    break;
                    case 4:json += "\"Promotion\":\""+use+"\"}";
                    break;                          
                }
                json += ", ";
                count++;               
            }
            json = json.substring(0,json.length()-2)+"]";           
            reader.close();
            
            JSONArray data = new JSONArray(json);
            
                   
            
            
            
            
            
            

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
