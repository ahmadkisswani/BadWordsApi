
package ApiConfiguration;

import java.util.logging.Logger;


public class configuration {
 private String protocol;
 private String url;
 private String exclude;
 private String replace;
 private String key;
 private String msg;

    public String getProtocol() {
        return protocol;
    }

    public String getUrl() {
        return url;
    }

    public String getExclude() {
        return exclude;
    }

    public String getReplace() {
        return replace;
    }

    public String getKey() {
        return key;
    }

    public String getMsg() {
        return msg;
    }
    

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    public void setReplace(String replace) {
        this.replace = replace;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    

    public configuration(String protocol, String url, String exclude, String replace, String key, String msg) {
        this.protocol = protocol;
        this.url = url;
        this.exclude = exclude;
        this.replace = replace;
        this.key = key;
         this.msg = msg;
    }

    public configuration() {
      protocol="https://";
      url="api.moderatecontent.com/text/?";
      replace="***";
      key="your_api_key";
      exclude="oops";
      msg="";
      
      
    }
    

   
    private static final Logger LOG = Logger.getLogger(configuration.class.getName());

    public static Logger getLOG() {
        return LOG;
    }
    
    
 
    
}
