package main.java.com.lynas;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sazzad on 1/12/16.
 */
public class Main2 {
    public static void main(String[] args) throws Exception{
        Main2 main2 = new Main2();
        ClassLoader classLoader = main2.getClass().getClassLoader();
        File file = new File(classLoader.getResource("methodResources.json").getFile());
        HashMap<String,Object> result =
                new ObjectMapper().readValue(file, HashMap.class);

        Map map=(Map) result.get("200");
        map.put("description","NotEmpty");
        result.put("200", map);
        System.out.println(result);
    }
}
