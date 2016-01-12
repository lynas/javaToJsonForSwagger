package main.java.com.lynas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LynAs on 12-Jan-16.
 */
public class MethodGenerator {
    public GET get(List<Parameter> parameters,String requestTemplate, String uri){
        Map<String, Object> map = new HashMap<>();
        map.put("200", new Response("", null));
        map.put("400", new Response("", null));
        map.put("500", new Response("", null));

        Map<String, Object> x_amazon_apigateway_integration = new HashMap<>();
        x_amazon_apigateway_integration.put("requestTemplates", new RequestTemplate(requestTemplate));
        x_amazon_apigateway_integration.put("httpMethod", "POST");
        x_amazon_apigateway_integration.put("type", "HTTP");
        x_amazon_apigateway_integration.put("uri", uri);




        Map<String, Object> responseTemplates200 = new HashMap<>();
        responseTemplates200.put("application/json", "$input.json(\"$.Data\")");

        Map<String, Object> responseTemplates45 = new HashMap<>();
        responseTemplates45.put("application/json", "$input.json(\"$.Reasons\")");


        Map<String, Object> responseParameters = new HashMap<>();
        responseParameters.put("method.response.header.Access-Control-Allow-Origin", "'*'");


        Map<String, Object> responseFirstChild = new HashMap<>();
        responseFirstChild.put("statusCode", "200");
        responseFirstChild.put("responseTemplates", responseTemplates200);
        responseFirstChild.put("responseParameters", responseParameters);

        Map<String, Object> responseFirstChildFor400 = new HashMap<>();
        responseFirstChildFor400.put("statusCode", "400");
        responseFirstChildFor400.put("responseTemplates", responseTemplates45);
        responseFirstChildFor400.put("responseParameters", responseParameters);

        Map<String, Object> responseFirstChildFor500 = new HashMap<>();
        responseFirstChildFor500.put("statusCode", "500");
        responseFirstChildFor500.put("responseTemplates", responseTemplates45);
        responseFirstChildFor500.put("responseParameters", responseParameters);

        Map<String,Object> responses = new HashMap<>();
        responses.put("2\\d{2}", responseFirstChild);
        responses.put("4\\d{2}", responseFirstChildFor400);
        responses.put("5\\d{2}", responseFirstChildFor500);

        x_amazon_apigateway_integration.put("responses", responses);

        Map<String, Object> x_amazon_apigateway_auth = new HashMap<>();
        x_amazon_apigateway_auth.put("type", "NONE");



        return new GET(parameters, map, x_amazon_apigateway_integration,x_amazon_apigateway_auth);

    }
}
