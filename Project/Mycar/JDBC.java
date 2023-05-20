package Project.Mycar;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class JDBC extends Exception{
    public Document doc;
    public Connection connection;
    public Statement statement;
    public void SqlConnection(){

        String url = "jdbc:mysql://localhost:8889/mycar";
        String user = "a.dauren";
        String password = "265199";
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
