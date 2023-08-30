package id.co.book.bookstore.service;

import id.co.book.bookstore.backend.model.Author;
import id.co.book.bookstore.backend.model.Publisher;
import id.co.book.bookstore.backend.repository.PublisherRepository;
import id.co.book.bookstore.service.wrapper.PublisherWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    private Publisher toEntity(PublisherWrapper wrapper){
        Publisher model = new Publisher();
        if(wrapper.getId() !=null){
            model = publisherRepository.findById(wrapper.getId()).get();
        }

        model.setPublisherName(wrapper.getPublisherName());
        model.setPublisherCity(wrapper.getPublisherCity());
        return model;
    }

    private PublisherWrapper toWrapper(Publisher entity){
        PublisherWrapper wrapper = new PublisherWrapper();
        wrapper.setId(entity.getId());
        wrapper.setPublisherName(entity.getPublisherName());
        wrapper.setPublisherCity(entity.getPublisherCity());
        return wrapper;
    }

    private List<PublisherWrapper> toWrapperList(List<Publisher> entityList){
        List<PublisherWrapper> rList = new ArrayList<>();
        if(entityList != null && !entityList.isEmpty()) {
            for (Publisher model : entityList) {
                rList.add(toWrapper(model));
            }
        }
        return rList;
    }

    public PublisherWrapper save(PublisherWrapper wrapper){
        return toWrapper(publisherRepository.save(toEntity(wrapper)));
    }

    public List<PublisherWrapper> getList(){
        return   toWrapperList((List<Publisher>) publisherRepository.findAll());
    }

    public PublisherWrapper getById(Long id){
        return toWrapper(publisherRepository.findById(id).get());
    }

    public Page<PublisherWrapper> getPaginatedWrapperList(String search, int page, int rowSize, Sort sort){
        List<PublisherWrapper> rList = new ArrayList<>();
        PageRequest pageable = PageRequest.of(page - 1, rowSize, sort);
        Page<Publisher> pageableModel = publisherRepository.getPaginatedList(search,pageable);
        if(pageableModel.getContent()!=null && !pageableModel.getContent().isEmpty()){
            //loope model here
            for(Publisher model : pageableModel.getContent()){
                rList.add(toWrapper(model));
            }
        }

        return new PageImpl<>(rList, pageable, pageableModel.getTotalElements());
    }
}