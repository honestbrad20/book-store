package id.co.book.bookstore.webapp.controller;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class IndexWebController {

    @GetMapping(value = "/index")
    public String getIndex(Map<String, Object> mapParam) {
        List<String> strList =  new ArrayList<>();
        for(int i=0; i < 20; i++){
            strList.add("String ke " + i);
        }
        mapParam.put("name", "Mojo");
        mapParam.put("age",17);
        mapParam.put("address","Jakarta");
        mapParam.put("daftar",strList);
        mapParam.put("isMarried",true);
        return "index";
    }

    @GetMapping(value = "/main")
    public String getMainSecured(Map<String,Object> mapParam){
        mapParam.put("authentication", SecurityContextHolder.getContext().getAuthentication());

        return "main";
    }
}