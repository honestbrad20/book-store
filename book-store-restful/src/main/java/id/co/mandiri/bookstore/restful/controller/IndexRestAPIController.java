package id.co.book.bookstore.restful.controller;

import id.co.book.bookstore.backend.model.system.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRestAPIController {

    @GetMapping(value = "/index")
    public String getIndex(){
        return "Hello Book";
    }

    @GetMapping(value = "/welcome")
    public String getWelcome(){
        return "Welcome";
    }

}