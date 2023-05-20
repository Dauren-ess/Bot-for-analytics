package Project.Mycar;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.*;
import java.sql.*;

@SpringBootApplication
public class Main {

	public static void main(String[] args) throws SQLException, IOException {
		RangePrice rangePrice = new RangePrice();
		//System.out.println(rangePrice.getAverage());
		ListOfInformation listOfInformation = new ListOfInformation();
		listOfInformation.list();
		listOfInformation.info_car();
		for (int i= 0; i<listOfInformation.list_camry.size(); i++){
			System.out.println(listOfInformation.list_camry.get(i));
		}


		//SpringApplication.run(Main.class, args);



	}

}
