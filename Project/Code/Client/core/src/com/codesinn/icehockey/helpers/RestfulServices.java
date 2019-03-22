package com.codesinn.icehockey.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class RestfulServices {

    public static String endpoint="http://192.168.43.45";


    public static String LoginStep1(String mno) throws IOException {

        final String POST_PARAMS = "{\"mobile\":\""+mno+"\"}";
        //System.out.println(POST_PARAMS);
        //URL obj = new URL("https://jsonplaceholder.typicode.com/posts");http://localhost/Workspace/apis/a.php

        URL obj = new URL(endpoint+"/Workspace/apis/a.php");
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("userId", "a1bcdefgh");
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        int responseCode = postConnection.getResponseCode();
        //System.out.println("POST Response Code :  " + responseCode);
        //System.out.println("POST Response Message : " + postConnection.getResponseMessage());
        if (responseCode ==200) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            //return response.toString();
            return "1";
        } else {

            return "0";
        }
    }




    public static String LoginStep2(String mno,String otp) throws IOException {

        final String POST_PARAMS = "{\"mobile\":\""+mno+"\",\"mobile\":\""+otp+"\"}";
        //System.out.println(POST_PARAMS);
        //URL obj = new URL("https://jsonplaceholder.typicode.com/posts");http://localhost/Workspace/apis/a.php

        URL obj = new URL(endpoint+"/Workspace/apis/a.php");
        HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
        postConnection.setRequestMethod("POST");
        postConnection.setRequestProperty("userId", "a1bcdefgh");
        postConnection.setRequestProperty("Content-Type", "application/json");
        postConnection.setDoOutput(true);
        OutputStream os = postConnection.getOutputStream();
        os.write(POST_PARAMS.getBytes());
        os.flush();
        os.close();
        int responseCode = postConnection.getResponseCode();
        //System.out.println("POST Response Code :  " + responseCode);
        //System.out.println("POST Response Message : " + postConnection.getResponseMessage());
        if (responseCode ==200) { //success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    postConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            //return response.toString();
            return "1";
        } else {

            return "0";
        }
    }



}
