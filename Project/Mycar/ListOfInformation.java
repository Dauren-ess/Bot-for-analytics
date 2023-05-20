package Project.Mycar;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListOfInformation {
    public List<String> list_price = new ArrayList<>();
    public List<String> list_name = new ArrayList<>();
    public List<String> list_description = new ArrayList<>();
    public List<String> list_year = new ArrayList<>();
    public List<String> list_power = new ArrayList<>();
    public List<String> list_distance = new ArrayList<>();
	public List<String> list_camry = new ArrayList<>();
	public List<String> list_prado = new ArrayList<>();
	public List<String> list_landCruiser = new ArrayList<>();
	public List<String> list_corolla = new ArrayList<>();
	public List<String> list_avalon = new ArrayList<>();
	public List<String> list_rav4 = new ArrayList<>();
	public List<String> list_hilux = new ArrayList<>();
	public List<String> list_fortuner = new ArrayList<>();
	public void list() throws IOException {
        JDBC jdbc = new JDBC();
		jdbc.SqlConnection();
        for(int i = 1; i<=50; i++) {
			jdbc.doc = Jsoup.connect("https://kolesa.kz/cars/toyota/almaty/?auto-custom=2&year[from]=2019" + "&page=" + i).get();
			Elements elements_name = jdbc.doc.select("h5.a-card__title");
			Elements elements_price = jdbc.doc.select("span.a-card__price");
			Elements elements_description = jdbc.doc.select("p.a-card__description");

			for (int j = 0; j<20; j++){

				list_price.add(i-1, String.valueOf(elements_price.eachText().get(j)));
				list_name.add(i-1, String.valueOf(elements_name.eachText().get(j)));
				list_description.add(i-1, String.valueOf(elements_description.eachText().get(j)));
			}
		}
        System.out.println();
    }

    public void ListOfPower(){
        for (int i = 0; i<list_description.size(); i++){
			int start = 0;
			int end = list_description.get(i).indexOf("л");
			if (list_description.get(i).contains("седан")){
				start = list_description.get(i).indexOf("седан")+7;
			} else if (list_description.get(i).contains("внедорожник")) {
				start = list_description.get(i).indexOf("внедорожник")+13;
			} else if (list_description.get(i).contains("кроссовер")) {
				start = list_description.get(i).indexOf("кроссовер")+11;
			} else if (list_description.get(i).contains("хэтчбек")) {
				start = list_description.get(i).indexOf("хэтчбек")+9;
			} else if (list_description.get(i).contains("пикап")) {
				start = list_description.get(i).indexOf("пикап")+7;
			} else if (list_description.get(i).contains("минивэн")) {
				start = list_description.get(i).indexOf("минивэн")+9;
			} else if (list_description.get(i).contains("микроавтобус")) {
				start = list_description.get(i).indexOf("микроавтобус")+4;
			} else {
				System.out.println("1");
			}
			list_power.add(list_description.get(i).substring(start,end));
		}
    }

    public void ListOfDistance(){
        for (int i = 0; i<list_description.size(); i++){
			int start = 0;
			int end = 0;
			if (list_description.get(i).contains("пробегом")) {
				start = list_description.get(i).indexOf("пробегом");
				end = list_description.get(i).indexOf("км,");
				list_distance.add(list_description.get(i).substring(start+9, end));
			} else {
				list_distance.add("0");
			}
		}
    }

    public void ListOfYear(){
        for (int i = 0; i<list_description.size(); i++){
			list_year.add(list_description.get(i).substring(0,4));
		}
    }

	public void info_car(){
		for (int i = 0; i<list_name.size(); i++){
			if (list_name.get(i).equals("Toyota Camry")){
				list_camry.add(list_description.get(i));
			}
		}
	}
}
