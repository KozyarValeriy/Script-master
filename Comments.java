/**
Добавьте комментарии в код, поясняющие действия на каждом этапе, от начала до конца.
*/

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class HttpURLConnectionExample {
        /** Class for testing GET and POST request
        */
        private final String USER_AGENT = "Mozilla/5.0";

        public static void main(String[] args) throws Exception {
                // create sample HttpURLConnectionExample 
                HttpURLConnectionExample http = new HttpURLConnectionExample();
                // GET request test
                System.out.println("Testing 1 - Send Http GET request");
                http.sendGet();
                // POST request test
                System.out.println("\nTesting 2 - Send Http POST request");
                http.sendPost();
        }

        private void sendGet() throws Exception {
                /** Method for test GET request.
                
                Method send GET request and get response.
                Print some request information and full response.
                */
                // setting url
                String url = "http://www.google.com/search?q=mkyong";
                // create URL sample
                URL obj = new URL(url);
                
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                // setting HTTP request parameters
                con.setRequestMethod("GET");
                con.setRequestProperty("User-Agent", USER_AGENT);
                // getting response code
                int responseCode = con.getResponseCode();
                System.out.println("\nSending 'GET' request to URL : " + url);
                System.out.println("Response Code : " + responseCode);
                // reading response
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                // appending rows from GET response to variable "response"
                while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                }
                // closing buffer
                in.close();
                // output response
                System.out.println(response.toString());
        }
              
        private void sendPost() throws Exception {
                /** Method for test POST request.
                
                Method send POST request and get response.
                Print some request information and full response.
                */      
                // setting url
                String url = "https://selfsolve.apple.com/wcResults.do";
                // create URL sample
                URL obj = new URL(url);
                
                HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
                // setting HTTP request parameters
                con.setRequestMethod("POST");
                con.setRequestProperty("User-Agent", USER_AGENT);
                con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
                // setting body of request
                String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
                // sending body of request 
                con.setDoOutput(true);
                DataOutputStream wr = new DataOutputStream(con.getOutputStream());
                wr.writeBytes(urlParameters);.
                // closing  and clearing buffer
                wr.flush();
                wr.close();
                // getting response code
                int responseCode = con.getResponseCode();
                System.out.println("\nSending 'POST' request to URL : " + url);
                System.out.println("Post parameters : " + urlParameters);
                System.out.println("Response Code : " + responseCode);
                // reading response
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                // appending rows from POST response to variable "response"
                while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                }
                // closing buffer
                in.close();
                // output response
                System.out.println(response.toString());
        }
}
