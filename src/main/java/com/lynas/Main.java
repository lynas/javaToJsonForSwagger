package main.java.com.lynas;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LynAs on 11-Jan-16.
 */
public class Main {
    public static void main(String[] args) {
        List<String> schemes = new ArrayList<>();
        schemes.add("https");
        List<String> produces = new ArrayList<>();
        produces.add("application/json");
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new Parameter("config_SortDir", "query", false, "string"));
        parameters.add(new Parameter("config_SortBy", "query", false, "string"));
        parameters.add(new Parameter("AccountIDs", "query", false, "string"));
        parameters.add(new Parameter("PaymentTerm", "query", false, "string"));
        parameters.add(new Parameter("config_PageSize", "query", false, "string"));
        parameters.add(new Parameter("IsActive", "query", false, "string"));
        parameters.add(new Parameter("config_StartPosition", "query", false, "string"));
        parameters.add(new Parameter("AccountTypeIDs", "query", false, "string"));
        parameters.add(new Parameter("Name", "query", false, "string"));
        parameters.add(new Parameter("AccountTypeName", "query", false, "string"));

        Map paths = new HashMap<>();
        Map<String, Object> pathRoot = new HashMap<>();
        pathRoot.put("get",new MethodGenerator().get(
                parameters,
                "{\n  \"Header\":{\n     #if($!input.params(\"config_PageSize\") != \"\")\n        \"PageSize\" : $input.params(\"config_PageSize\"),\n     #end\n     #if($!input.params(\"config_StartPosition\") != \"\")\n        \"StartPosition\" : $input.params(\"config_StartPosition\"),\n     #end    \n     #if($!input.params(\"config_SortBy\") != \"\")\n        \"SortBy\" : $input.params(\"config_SortBy\"),\n     #end    \n     #if($!input.params(\"config_SortDir\") != \"\")\n        \"SortDir\" : $input.params(\"config_SortDir\"),\n     #end    \n  }\n  \"Params\":{\n      #if($!input.params(\"AccountIDs\") != \"\")\n        \"AccountIDs\" : [$input.params(\"AccountIDs\"))],\n      #end    \n      #if($!input.params(\"Name\") != \"\")\n        \"Name\" : \"$input.params('Name')\",\n      #end   \n      #if($!input.params(\"AccountTypeIDs\") != \"\")\n        \"AccountTypeIDs\" : [$input.params(\"AccountTypeIDs\")],\n      #end   \n      #if($!input.params(\"AccountTypeName\") != \"\")\n        \"AccountTypeName\" : \"$input.params('AccountTypeName')\",\n      #end   \n      #if($!input.params(\"PaymentTerm\") != \"\")\n        \"PaymentTerm\" : \"$input.params('PaymentTerm')\",\n      #end   \n      #if($!input.params(\"IsActive\") != \"\")\n        \"IsActive\" : $input.params(\"IsActive\"),\n      #end  \n    }\n}",
                "https://${stageVariables.host_base_url}/web-corporate/api/submit/corporate/account/getCollection"
        ));
        pathRoot.put("options", new MethodGenerator().options(new ArrayList<>()));









        paths.put("/accounts", pathRoot);
        Root root = new Root("2.0",
                new info("CTM2", "API for CTM", "1.0.0"),
                "pt6joc38v8.execute-api.us-east-1.amazonaws.com",
                "/v1",
                schemes,
                produces,
                paths
        );
        try {
            Gson gson = new Gson();
            String json = gson.toJson(root);
            FileWriter writer = new FileWriter("file.json");
            writer.write(json);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Problem List");
        System.out.println(" ' becomes \\u0027");
        System.out.println(" =  becomes \\u003d");
    }
}
