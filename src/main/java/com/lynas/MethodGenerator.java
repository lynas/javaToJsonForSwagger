package main.java.com.lynas;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LynAs on 12-Jan-16.
 */
public class MethodGenerator {
    public GET get(List<Parameter> parameters, String requestTemplate, String uri) {

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


        Map<String, Object> responseFirstChildFor200 = new HashMap<>();
        responseFirstChildFor200.put("statusCode", "200");
        responseFirstChildFor200.put("responseTemplates", responseTemplates200);
        responseFirstChildFor200.put("responseParameters", responseParameters);

        Map<String, Object> responseFirstChildFor400 = new HashMap<>();
        responseFirstChildFor400.put("statusCode", "400");
        responseFirstChildFor400.put("responseTemplates", responseTemplates45);
        responseFirstChildFor400.put("responseParameters", responseParameters);

        Map<String, Object> responseFirstChildFor500 = new HashMap<>();
        responseFirstChildFor500.put("statusCode", "500");
        responseFirstChildFor500.put("responseTemplates", responseTemplates45);
        responseFirstChildFor500.put("responseParameters", responseParameters);

        Map<String, Object> responses = new HashMap<>();
        responses.put("2\\d{2}", responseFirstChildFor200);
        responses.put("4\\d{2}", responseFirstChildFor400);
        responses.put("5\\d{2}", responseFirstChildFor500);

        x_amazon_apigateway_integration.put("responses", responses);



        return new GET(parameters, getResponse(), x_amazon_apigateway_integration, getX_amazon_apigateway_auth());

    }

    public Map<String, Object> options(List<Parameter> parameters) {
        Map<String, Object> Access_Control_Allow_Origin = new HashMap<>();
        Access_Control_Allow_Origin.put("type", "string");
        Map<String, Object> Access_Control_Allow_Methods = new HashMap<>();
        Access_Control_Allow_Methods.put("type", "string");
        Map<String, Object> Access_Control_Allow_Headers = new HashMap<>();
        Access_Control_Allow_Headers.put("type", "string");
        Map<String, Object> headers = new HashMap<>();
        headers.put("Access-Control-Allow-Origin",Access_Control_Allow_Origin);
        headers.put("Access-Control-Allow-Methods",Access_Control_Allow_Methods);
        headers.put("Access-Control-Allow-Headers",Access_Control_Allow_Headers);


        Map<String, Object> responsesFor200 = new HashMap<>();
        responsesFor200.put("description", "Empty");
        responsesFor200.put("headers", headers);


        Map<String, Object> responsesRootForCollection = new HashMap<>();
        responsesRootForCollection.put("200", responsesFor200);

        Map<String, Object> responseTemplates200 = new HashMap<>();
        responseTemplates200.put("application/json", "$input.json(\"$.Data\")");

        Map<String, Object> responseTemplates45 = new HashMap<>();
        responseTemplates45.put("application/json", "$input.json(\"$.Reasons\")");


        Map<String, Object> responseParameters = new HashMap<>();
        responseParameters.put("method.response.header.Access-Control-Allow-Origin", "'*'");


        Map<String, Object> responseFirstChildFor200 = new HashMap<>();
        responseFirstChildFor200.put("statusCode", "200");
        responseFirstChildFor200.put("responseTemplates", responseTemplates200);
        responseFirstChildFor200.put("responseParameters", responseParameters);

        Map<String, Object> responseFirstChildFor400 = new HashMap<>();
        responseFirstChildFor400.put("statusCode", "400");
        responseFirstChildFor400.put("responseTemplates", responseTemplates45);
        responseFirstChildFor400.put("responseParameters", responseParameters);

        Map<String, Object> responseFirstChildFor500 = new HashMap<>();
        responseFirstChildFor500.put("statusCode", "500");
        responseFirstChildFor500.put("responseTemplates", responseTemplates45);
        responseFirstChildFor500.put("responseParameters", responseParameters);

        Map<String, Object> responses = new HashMap<>();
        responses.put("2\\d{2}", responseFirstChildFor200);
        responses.put("4\\d{2}", responseFirstChildFor400);
        responses.put("5\\d{2}", responseFirstChildFor500);

        Map<String, Object> optionRoot = new HashMap<>();
        optionRoot.put("parameters", parameters);
        optionRoot.put("responses", responsesRootForCollection);
        optionRoot.put("x-amazon-apigateway-integration", getX_amazon_apigateway_integrationForCollection());
        optionRoot.put("x-amazon-apigateway-auth", getX_amazon_apigateway_auth());

        return optionRoot;

    }

    private Map<String, Object> getX_amazon_apigateway_auth() {
        Map<String, Object> x_amazon_apigateway_auth = new HashMap<>();
        x_amazon_apigateway_auth.put("type", "NONE");
        return x_amazon_apigateway_auth;
    }

    private Map<String, Object> getResponse() {
        Map<String, Object> responsesRoot = new HashMap<>();
        responsesRoot.put("200", new Response("", null));
        responsesRoot.put("400", new Response("", null));
        responsesRoot.put("500", new Response("", null));
        return responsesRoot;
    }

    public Map<String, Object> getX_amazon_apigateway_integrationForCollection() {

        Map<String, Object> application_json = new HashMap<>();
        application_json.put("application/json", "{\"statusCode\": 200}");
        application_json.put("application/json", "{\"statusCode\": 200}");


        Map<String, Object> responses = new HashMap<>();

        Map<String, Object> defaultBlock = new HashMap<>();
        defaultBlock.put("statusCode", "200");
        Map<String, Object> responseTemplates = new HashMap<>();
        responseTemplates.put("application/json", "");
        defaultBlock.put("responseTemplates", responseTemplates);
        Map<String, Object> responseParameters = new HashMap<>();
        responseParameters.put("method.response.header.Access-Control-Allow-Origin", "'*'");
        responseParameters.put("method.response.header.Access-Control-Allow-Headers", "'Content-Type,X-Amz-Date,Authorization,X-Api-Key'");
        responseParameters.put("method.response.header.Access-Control-Allow-Methods", "'POST,GET,OPTIONS,PATCH'");
        defaultBlock.put("responseParameters", responseParameters);


        responses.put("default", defaultBlock);


        Map<String, Object> root = new HashMap<>();
        root.put("requestTemplates", application_json);
        root.put("type", "MOCK");
        root.put("responses", responses);

        return root;

    }
}























