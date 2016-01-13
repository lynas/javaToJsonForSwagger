package main.java.com.lynas;

import java.util.List;

/**
 * Created by lynas on 1/13/16.
 */
public class MethodWrapper {
    private List<String> params;
    private String requestTemplate;
    private String uri;

    public MethodWrapper(List<String> params, String requestTemplate, String uri) {
        this.params = params;
        this.requestTemplate = requestTemplate;
        this.uri = uri;
    }
}
