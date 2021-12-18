package com.ivt.Sensormap.models;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataReceiver extends Thread{
    int port;

    public DataReceiver(int port){
        this.port = port;
    }
    private static String[] getInfo(String desc) {
        int count = 0;
        final String[] allMatches = new String[11];
        //Matcher m = Pattern.compile("([0-9][0-9][0-9][0-9]|[0-9][0-9][0-9]|[0-9][0-9]|[0-9])").matcher(desc);
        Matcher m = Pattern.compile("[0-9][0-9][0-9][0-9][0-9][0-9]|[0-9][0-9][0-9][0-9][0-9]|[0-9][0-9][0-9][0-9]|[0-9][0-9][0-9]|[0-9][0-9]|[0-9]").matcher(desc);
        while (m.find()) {
            allMatches[count] = m.group();
            count++;
        }
        /*
        for(int i = 0; i < allMatches.length; i++){
            System.out.println(allMatches[i]);
        }
         */
        return allMatches;
    }
    public String[] waitConnection() throws IOException{
            try(ServerSocket s_sock = new ServerSocket(port)){
                while (true) {
                    Socket incoming = s_sock.accept();
                    System.out.println("Client connected!");
                    final String[] answer_d = new String[1];
                    BufferedReader in_incoming = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
                    DataOutputStream out_incoming = new DataOutputStream(incoming.getOutputStream());
                    while ((answer_d[0] = in_incoming.readLine()) != null) {
                        System.out.println("Recieved from sensor> " + answer_d[0]);
                        if(answer_d[0].contains("Sensor")){ //"Sensor 53.99233 36.11443 2021/12/16 20/23/16"
                            return getInfo(answer_d[0]);
                        }
                    }
                    incoming.close();
                    break;
                }

            }
        return new String[0];
    }

}
