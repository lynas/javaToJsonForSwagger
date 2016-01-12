package main.java.com.lynas;

/**
 * Created by LynAs on 11-Jan-16.
 */
public class Parameter {
    private String name;
    private String in;
    private boolean required;
    private String type;

    public Parameter(String name, String in, boolean required, String type) {
        this.name = name;
        this.in = in;
        this.required = required;
        this.type = type;
    }
}
