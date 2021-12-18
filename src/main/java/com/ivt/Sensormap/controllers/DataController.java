package com.ivt.Sensormap.controllers;

import java.sql.*;

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
        PreparedStatement stmt = con.prepareStatement("INSERT INTO SENSOR (SENSOR_ID, LATITUDE, LONGITUDE, DATE, TIME) VALUES (?, ?, ?, ?, ?);");
        stmt.setLong(1, (latitude.intValue() % 100 + longitude.intValue() % 100));
        stmt.setDouble(2, latitude);
        stmt.setDouble(3, longitude);
        stmt.setString(4, date);
        stmt.setString(5, time);
        stmt.executeUpdate();
        stmt.close();
    }
    public void select() throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM SENSOR");
        while (rs.next()) {
            String str = rs.getString(1)
                    + "| LATITUDE:"  + rs.getString(2)
                    + "| LONGITUDE:" + rs.getString(3)
                    + "| DATE:"      + rs.getString(4)
                    + "| TIME:"      + rs.getString(5);
            System.out.println("sensor:" + str);
        }
        rs.close();
        stmt.close();
    }
    public Connection getCon(){
        return this.con;
    }
}
