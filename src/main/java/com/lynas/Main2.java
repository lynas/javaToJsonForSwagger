package main.java.com.lynas;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sazzad on 1/12/16.
 */
public class Main2 {
    public static void main(String[] args) throws Exception{
        Main2 main2 = new Main2();
        ClassLoader classLoader = main2.getClass().getClassLoader();
        HashMap<String,Object> result =
                new ObjectMapper()
                        .readValue(new File(classLoader.getResource("methodResources.json").getFile()), HashMap.class);


        HashMap<String,Object> result2 =
                new ObjectMapper()
                        .readValue(new File(classLoader.getResource("x_amazon_apigateway_integration.json").getFile()), HashMap.class);

        HashMap<String,Object> result3 =
                new ObjectMapper()
                        .readValue(new File(classLoader.getResource("x_amazon_apigateway_auth.json").getFile()), HashMap.class);

        Map map=(Map) result.get("200");
        map.put("description","NotEmpty");
        result.put("200", map);
        System.out.println(result);


        Map<String, Object> post = new HashMap<>();
        post.put("parameters", new ParameterMaker().makerParam());
        post.put("responses", result);
        post.put("x-amazon-apigateway-integration", result2);
        post.put("x-amazon-apigateway-auth", result3);

        try {
            Gson gson = new Gson();
            String json = gson.toJson(post);
            FileWriter writer = new FileWriter("test.json");
            writer.write(json);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
