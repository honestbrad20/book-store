package id.co.book.bookstore.webapp.controller.custom;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class CustomErrorController implements ErrorController {

     @GetMapping(value = "/error")
    public  String error(Map<String,Object> mapParam){
         return "errorPage";
     }
}
