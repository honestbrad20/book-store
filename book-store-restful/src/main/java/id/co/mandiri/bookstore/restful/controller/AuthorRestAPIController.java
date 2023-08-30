package id.co.book.bookstore.restful.controller;

import id.co.book.bookstore.backend.model.Author;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/author/")
public class AuthorRestAPIController {

    @GetMapping(value = "get")
    public     @ResponseBody Author getAuthor(){
        Author author = new Author();
        author.setAuthorName("Wawan");
        author.setAuthorAge(25);
        author.setAuthorCity("Bekasi");
        return author;
    }

    @GetMapping(value = "getString")
    public String getAuthorString(){
        Author author = new Author();
        author.setAuthorName("Wawan");
        author.setAuthorAge(25);
        author.setAuthorCity("Bekasi");
        return author.toString();
    }
}
