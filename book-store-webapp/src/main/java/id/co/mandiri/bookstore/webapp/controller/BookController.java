package id.co.book.bookstore.webapp.controller;

import id.co.book.bookstore.backend.model.Book;
import id.co.book.bookstore.backend.repository.AuthorRepository;
import id.co.book.bookstore.backend.repository.PublisherRepository;
import id.co.book.bookstore.service.BookService;
import id.co.book.bookstore.service.wrapper.BookWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/book")
public class BookController {


    final AuthorRepository authorRepository;

    final PublisherRepository publisherRepository;

    final BookService bookService;

    public BookController(AuthorRepository authorRepository, PublisherRepository publisherRepository, BookService bookService) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.bookService = bookService;
    }

    @GetMapping(value = "/new")
    public String newBook(Map<String, Object> mapParam) {
        mapParam.put("authorList", authorRepository.findAll());
        mapParam.put("publisherList", publisherRepository.findAll());


        mapParam.put("model", new Book());
        return "web/book/new";
    }

    @GetMapping(value = "/list")
    public String getList(Map<String,Object> mapParam){
        mapParam.put("bookList", bookService.getList());
        return "web/book/list";
    }
    @PostMapping(value = "/save")
    public String saveBook(Map<String, Object> param, BookWrapper wrapper) {
        BookWrapper savedWrapper = bookService.save(wrapper);
        if (savedWrapper.getId() != null) {
            param.put("crudAction", "Data Berhasil Disimpan");
        } else {
            param.put("crudAction", "Data Gagal Disimpan!");
        }
        return "dao/crudResult";

    }

    @GetMapping(value = "/edit") //form data
    public String edit(@RequestParam Long id, Map<String, Object> mapParam) {
        BookWrapper rModel = bookService.getById(id);
        mapParam.put("model", rModel);
        mapParam.put("authorList", authorRepository.findAll());
        mapParam.put("publisherList", publisherRepository.findAll());
        return "web/book/edit";
    }

    @PostMapping(value = "/update")
    public @ResponseBody Map<String, Object> update(BookWrapper wrapper) {
        Map<String, Object> rMap = new HashMap<>();
        rMap.put("action", "update");

        wrapper = bookService.save(wrapper);
        if (wrapper.getId() != null) {
            rMap.put("result", "success");
            rMap.put("message", "Data has been updated successfully");
        } else {
            rMap.put("result", "failed");
            rMap.put("message", "Data failed to update");
        }
        return rMap;
    }
}