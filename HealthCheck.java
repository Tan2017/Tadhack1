import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
public class HealthCheck extends JFrame{
  public int sysRate;
  public int diaRate;
  public int pulseRate;
  public  String result;






    public static void main(String[] args) {





       // SysCheck(150);
     //DiaCheck(100);
     //PulseCheck(200);
        String csvFile = "*.csv";
        String line = "";
        String cvsSplitBy = ",";


        try {
            try (BufferedReader br =
            new BufferedReader(new FileReader ("resources/testing.csv"))){
                while ((line=br.readLine())!=null){
                    List<String> items = Arrays.asList(line.split(","));
                    System.out.println(line);
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println(items.get(i));
                    }
                    SysCheck((Integer.parseInt(items.get(0))));
                    DiaCheck((Integer.parseInt(items.get(1))));
                    PulseCheck((Integer.parseInt(items.get(2))));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

     public static void sendTXT() {

        String url = "https://selfsolve.apple.com/wcResults.do";

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);

// add header
        post.setHeader("User-Agent", USER_AGENT);
                "to": "",
                "body": "",
                "from": "",
                "validity": 0,
                "scheduledDelivery": 0,
                "notifyURL": "",
                "replyRequest": false
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
        urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
        urlParameters.add(new BasicNameValuePair("cn", ""));
        urlParameters.add(new BasicNameValuePair("locale", ""));
        urlParameters.add(new BasicNameValuePair("caller", ""));
        urlParameters.add(new BasicNameValuePair("num", "12345"));
   try {
       post.setEntity(new UrlEncodedFormEntity(urlParameters));

       HttpResponse response = client.execute(post);
       System.out.println("Response Code : "
               + response.getStatusLine().getStatusCode());

       BufferedReader rd = new BufferedReader(
               new InputStreamReader(response.getEntity().getContent()));

       StringBuffer result = new StringBuffer();
       String line = "";
       while ((line = rd.readLine()) != null) {
           result.append(line);
       }
   }catch (Exception e){
       System.out.println(e);
   }
   }



    }
    public  static void SysCheck(int x){


        if(x>150)
        System.out.println("Trick");
        else
            System.out.println("Normal");
    }

    public  static void DiaCheck(int x){


        if(x>150)
            System.out.println("Trick");
        else
            System.out.println("Normal");
    }
    public  static void PulseCheck(int x){


        if(x>150)
            System.out.println("Trick");
        else
            System.out.println("Normal");
    }
}
