package Project.Mycar;

import java.io.IOException;

public class RangePrice {
    public ListOfInformation listOfInformation = new ListOfInformation();
    public int getAverage() throws IOException {
        listOfInformation.list();
        int averagePrice = 0;
        for (int i = 0; i<listOfInformation.list_price.size(); i++) {
            averagePrice += Integer.parseInt(listOfInformation.list_price.get(i).substring(0,listOfInformation.list_price.get(i).length()-1).replaceAll("\\s",""));
        }
        return averagePrice/listOfInformation.list_price.size()+1;
    }
}
