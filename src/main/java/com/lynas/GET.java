package main.java.com.lynas;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

/**
 * Created by LynAs on 11-Jan-16.
 */
public class GET {
    private List<Parameter> parameters;
    private Map<String, Object> responses;
    @SerializedName("x-amazon-apigateway-integration")
    private Map<String, Object> x_amazon_apigateway_integration;
    @SerializedName("x-amazon-apigateway-auth")
    private Map<String, Object> x_amazon_apigateway_auth;

    public GET(List<Parameter> parameters, Map<String, Object> responses, Map<String, Object> x_amazon_apigateway_integration, Map<String, Object> x_amazon_apigateway_auth) {
        this.parameters = parameters;
        this.responses = responses;
        this.x_amazon_apigateway_integration = x_amazon_apigateway_integration;
        this.x_amazon_apigateway_auth = x_amazon_apigateway_auth;
    }
}
