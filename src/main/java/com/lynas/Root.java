package main.java.com.lynas;

import java.util.List;
import java.util.Map;

/**
 * Created by LynAs on 11-Jan-16.
 */
public class Root {
    private String swagger;
    private info info;
    private String host;
    private String basePath;
    private List schemes;
    private List produces;
    private Map<String, Object> paths;

    public Root(String swagger, info info, String host, String basePath, List schemes, List produces, Map<String, Object> paths) {
        this.swagger = swagger;
        this.info = info;
        this.host = host;
        this.basePath = basePath;
        this.schemes = schemes;
        this.produces = produces;
        this.paths = paths;
    }
}