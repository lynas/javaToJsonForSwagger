package main.java.com.lynas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LynAs on 12-Jan-16.
 */
public class ParameterMaker {
    public List<Parameter> makerParam(){
        List<String> list = new ArrayList<>();
        list.add("config_SortDir");
        list.add("config_SortBy");
        list.add("config_PageSize");
        list.add("config_StartPosition");
        Map<String, Object> map = new HashMap<>();
        List<Parameter> parameters = new ArrayList<>();
        for (String s : list) {
            parameters.add(new Parameter(s,"query",false,"string"));

        }


        return parameters;

    }
}
