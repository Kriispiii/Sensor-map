package com.ivt.Sensormap;

import com.ivt.Sensormap.controllers.DataController;
import com.ivt.Sensormap.models.DataReceiver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SensorMapApplication {

	public static void main(String[] args) {
		SpringApplication.run(SensorMapApplication.class, args);
		try {
			// Процедура вставки
                /*
                DataController dt = new DataController("jdbc:postgresql://localhost:5432/sensorsdb",
                        "postgres", "1147");

                 */
			DataController dt = new DataController("jdbc:mysql://localhost:3306/sensor",
					"root", "");
			dt.ConnectTo();
			//DataReceiver rs = new DataReceiver(8183);
			DataReceiver rs = new DataReceiver(8186);
			String[] matches = rs.waitConnection();
                /*
                dt.insert((Integer.parseInt(matches[0])+ Integer.parseInt (matches[1]) * 0.1),
                          (Integer.parseInt (matches[2])+ Integer.parseInt (matches[3]) * 0.1),
                        (matches[4] +"/" + matches[5] + "/" + matches[6]),
                        (matches[7] +"/" + matches[8] + "/" + matches[9]));
                 */
			///to JSON
			dt.insert(Double.parseDouble(matches[0]+"."+ matches[1]),
					Double.parseDouble(matches[2]+"."+ matches[3]),
					(matches[4] +"/" + matches[5] + "/" + matches[6]),
					(matches[7] +"/" + matches[8] + "/" + matches[9]));
			// нужна влажность!!!!!!!!!!!!!!!!!!!
			//dt.insert(53.99,36.11,"2021/12/16","20/23/16");
			// Процедура выборки
			dt.select();
			dt.getCon().close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
