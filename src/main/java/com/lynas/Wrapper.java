package main.java.com.lynas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lynas on 1/13/16.
 */
public class Wrapper {
    public void test(){
        Map<String, Object> map = new HashMap<>();
        map.put("get", new MethodWrapper(
                new ArrayList<String>(),
                "requestTemplate",
                "uri"));
    }
}
