package initializr;

import ApiConfiguration.configuration;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import response.response;

public class getApi {

    private configuration confifuration;

    public getApi(configuration confifuration) {
        this.confifuration = confifuration;
    }

    public String replaceBadBord(String text) {
        if (text == null) {
            return "";
        }
        if (text.trim().isEmpty()) {
            return "";
        }
        try {

            if (confifuration.getMsg() == null) {
                confifuration.setMsg("");
            }
            if (confifuration.getMsg().isEmpty()) {
                confifuration.setMsg(text);
            }
            URL url = new URL(confifuration.getProtocol().concat(confifuration.getUrl())
                    .concat("exclude=")
                    .concat(confifuration.getExclude()).concat("&")
                    .concat("replace=").concat(confifuration.getReplace()).concat("&")
                    .concat("key=")
                    .concat(confifuration.getKey()).concat("&")
                    .concat("msg=").concat(confifuration.getMsg()));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setDoOutput(true);
            //Send request
            DataOutputStream wr = new DataOutputStream(
                    con.getOutputStream());
            wr.close();
            InputStream is = con.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();

            Object obj = JSONValue.parse(response.toString());
            JSONObject jsonObject = (JSONObject) obj;

            return (String) jsonObject.get("clean");

        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
            return "404";
        }

    }

    public response replaceBadBordFull(String text) {
        if (text == null) {
            return null;
        }
        if (text.trim().isEmpty()) {
            return null;
        }
        try {

            response outResponse = new response();
               if (confifuration.getMsg().isEmpty()) {
                confifuration.setMsg(text);
            }
            URL url = new URL(confifuration.getProtocol().concat(confifuration.getUrl())
                    .concat("exclude=")
                    .concat(confifuration.getExclude()).concat("&")
                    .concat("replace=").concat(confifuration.getReplace()).concat("&")
                    .concat("key=")
                    .concat(confifuration.getKey()).concat("&")
                    .concat("msg=").concat(confifuration.getMsg()));
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            con.setDoOutput(true);
            //Send request
            DataOutputStream wr = new DataOutputStream(
                    con.getOutputStream());
            wr.close();
            InputStream is = con.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();

            Object obj = JSONValue.parse(response.toString());
            JSONObject jsonObject = (JSONObject) obj;
            outResponse.setClean(String.valueOf( jsonObject.get("clean")));
            outResponse.setOrigional_msg(String.valueOf(jsonObject.get("origional_msg")));
            outResponse.setExclude(String.valueOf( jsonObject.get("exclude")));
            return outResponse;

        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
            return null;
        }

    }

}
