package id.co.book.bookstore.webapp.controller;

import id.co.book.bookstore.backend.model.Publisher;
import id.co.book.bookstore.backend.repository.PublisherRepository;
import id.co.book.bookstore.service.PublisherService;
import id.co.book.bookstore.service.wrapper.PublisherWrapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/publisher")
public class PublisherWebController {

    private PublisherRepository publisherRepository;
    private final PublisherService publisherService;

    public PublisherWebController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping(value = "/list") //table view
    public String getList(Map<String, Object> mapParam, @RequestParam("search") String search, @RequestParam("page") int page, @RequestParam("rowSize") int rowSize) {
        Sort toPass = Sort.by("id");
        Page<PublisherWrapper> publisherPage = publisherService.getPaginatedWrapperList(search, page, rowSize, toPass);
        mapParam.put("dataList", publisherPage);
        return "web/publisher/list";
    }

    @GetMapping(value = "/new") //form new
    public String addNew(Map<String,Object> mapParam){
        mapParam.put("model", new Publisher());
        return "web/publisher/new";
    }

    @GetMapping(value = "/edit") //form data
    public String edit(@RequestParam Long id, Map<String, Object> mapParam) {
        PublisherWrapper rModel = publisherService.getById(id);
        mapParam.put("model", rModel);
        return "web/publisher/edit";
    }

    @PostMapping(value = "/add")
    public @ResponseBody Map<String, Object> add(PublisherWrapper wrapper) {
        Map<String, Object> rMap = new HashMap<>();
        rMap.put("action", "add");

        wrapper = publisherService.save(wrapper);
        if (wrapper.getId() != null) {
            rMap.put("result", "success");
            rMap.put("message", "Data has been saved successfully");
        } else {
            rMap.put("result", "failed");
            rMap.put("message", "Data failed to save");
        }
        return rMap;
    }

    @PostMapping(value = "/update")
    public @ResponseBody Map<String, Object> update(PublisherWrapper wrapper) {
        Map<String, Object> rMap = new HashMap<>();
        rMap.put("action", "update");

        wrapper = publisherService.save(wrapper);
        if (wrapper.getId() != null) {
            rMap.put("result", "success");
            rMap.put("message", "Data has been updated successfully");
        } else {
            rMap.put("result", "failed");
            rMap.put("message", "Data failed to update");
        }
        return rMap;
    }

//    @PostMapping(value = "/save")
//    public String savePublisher(Map<String,Object> mapParam, Author author) {
//        Author rModel = authorService.save(author);
//        if (rModel.getId() != null) {
//            mapParam.put("crudAction", "Data Berhasil Disimpan");
//        } else {
//            mapParam.put("crudAction", false);
//        }
//        return "dao/crudResult";
//    }

    @GetMapping(value = "/delete")
    public String deleteAuthor(@RequestParam Long id,Map<String,Object> mapParam) {
        publisherRepository.deleteById(id);
        if (publisherRepository.findById(id) != null) {
            mapParam.put("crudAction", "Data Berhasil Dihapus");
        } else {
            mapParam.put("crudAction", "Data Gagal Dihapus!");
        }
        return "dao/crudResult";
    }
}