package proxy;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;



import util.UtilJson;

public class Consumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			UtilJson util = new UtilJson();
            URL url = new URL("http://127.0.0.1:8080/periodos/api");//your url i.e fetch data from .
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            String msg ="";
            while ((output = br.readLine()) != null) {         
                msg = msg+output;
            }
            util.process(msg);
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }

	}

}
