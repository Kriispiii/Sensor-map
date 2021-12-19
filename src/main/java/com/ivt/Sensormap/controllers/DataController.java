package com.ivt.Sensormap.controllers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
//JSON
import org.json.JSONObject;
//JSON

public class DataController extends Thread{

    private String url;
    private String login;
    private String password;
    private Connection con;

    public DataController(String url, String login, String password){
        this.url = url;
        this.login = login;
        this.password = password;
        //ConnectTo();
    }

    public void ConnectTo(){
        try {
            //Class.forName("org.postgresql.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, login, password);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void insert(Double latitude, Double longitude , String date, String time) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO SENSOR (SENSOR_ID, LATITUDE, LONGITUDE, WET, DATE, TIME) VALUES (?, ?, ?, ?, ?, ?);");
        stmt.setLong(1, (latitude.intValue() % 100 + longitude.intValue() % 100));
        stmt.setDouble(2, latitude);
        stmt.setDouble(3, longitude);
        stmt.setDouble(4, 36.6);// нужна влажность!!!!!!!!!!!!!!!!!!!
        stmt.setString(5, date);
        stmt.setString(6, time);
        stmt.executeUpdate();
        stmt.close();
    }
    public void select() throws Exception {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM SENSOR");
        while (rs.next()) {

            String str = rs.getString(1)
                    + "| LATITUDE:"  + rs.getString("LATITUDE")
                    + "| LONGITUDE:" + rs.getString("LONGITUDE")
                    + "| WET:"       + rs.getString("WET")
                    + "| DATE:"      + rs.getString("DATE")
                    + "| TIME:"      + rs.getString("TIME");
            System.out.println("sensor:" + str);
            //нужен массив!!!!!!!!!!!!!!!!!!!!
            toJSON(rs.getInt("SENSOR_ID"),
                    rs.getDouble("LATITUDE"),
                    rs.getDouble("LONGITUDE"),
                    rs.getDouble("WET"),
                    rs.getString("DATE"),
                    rs.getString("TIME"));
        }
        rs.close();
        stmt.close();
    }
    public Connection getCon(){
        return this.con;
    }
    public void toJSON(int SENSOR_ID, double LATITUDE, double LONGITUDE, double WET, String DATE, String TIME) throws  Exception{
        JSONObject sampleObject = new JSONObject();
        sampleObject.put("SENSOR_ID", SENSOR_ID);
        sampleObject.put("LATITUDE", LATITUDE);
        sampleObject.put("LONGITUDE", LONGITUDE);
        sampleObject.put("WET", WET);
        sampleObject.put("DATE", DATE);
        sampleObject.put("TIME", TIME);
        Files.write(Paths.get("D:\\test.json"), sampleObject.toString().getBytes());
    }
}
