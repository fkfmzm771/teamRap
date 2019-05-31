import java.util.*;
import java.io.*;
 
import java.net.URL;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public class Sample {
    static final String TOKEN = "xxxxx";
    static final String BASE  = "https://runner.team-lab.com/";

    public static void main(String[] args)throws IOException{
        for (int i=0; i<2; i++) {
            String str = "ABCD";
            String url = BASE + "/q?token=" + TOKEN + "&str=" + str;




            String result = query(url);
            System.out.println(result);

            try {
                Thread.sleep(1000L);
            } catch(InterruptedException e){}
        }
    }

    public static String query(String _url) throws IOException {
        URL url = new URL(_url);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET"); 
        if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
            InputStreamReader isr = new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(isr);
            String res = "";
            String line = null;
 
            while((line = reader.readLine()) != null){
                res += line;
            }
            return res.trim();
        }
        return "";
    }
 }
