package main.java.com.lynas;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LynAs on 11-Jan-16.
 */
public class Response {
    private String description;
    private Map<String,Object> headers;


    public Response(String description, Map<String, Object> headers) {
        this.description = "Empty";
        Map<String, Object> map2 = new HashMap<>();
        map2.put("type", "string");
        Map<String, Object> map = new HashMap<>();
        map.put("Access-Control-Allow-Origin", map2);
        this.headers = map;
    }

    public Object getResponse(){
        return null;
    }
}
