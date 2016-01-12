package main.java.com.lynas;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LynAs on 12-Jan-16.
 */
public class RequestTemplate {
    @SerializedName("application/json")
    private String  application_json;

    public RequestTemplate(String application_json) {
        this.application_json = application_json;
    }
}
