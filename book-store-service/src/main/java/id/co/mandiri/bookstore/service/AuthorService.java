package id.co.book.bookstore.service;

import id.co.book.bookstore.backend.model.Author;
import id.co.book.bookstore.backend.repository.AuthorRepository;
import id.co.book.bookstore.service.wrapper.AuthorWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    private Author toEntity(AuthorWrapper wrapper){
        Author model = new Author();
        if(wrapper.getId() !=null){
            model = authorRepository.findById(wrapper.getId()).get();
        }

        model.setAuthorName(wrapper.getAuthorName());
        model.setAuthorAge(wrapper.getAuthorAge());
        model.setAuthorCity(wrapper.getAuthorAddress());
        return model;
    }

    private AuthorWrapper toWrapper(Author entity){
        AuthorWrapper wrapper = new AuthorWrapper();
        wrapper.setId(entity.getId());
        wrapper.setAuthorName(entity.getAuthorName());
        wrapper.setAuthorAge(entity.getAuthorAge());
        wrapper.setAuthorAddress(entity.getAuthorCity());
        return wrapper;
    }

    private List<AuthorWrapper> toWrapperList(List<Author> entityList){
        List<AuthorWrapper> rList = new ArrayList<>();
        if(entityList != null && !entityList.isEmpty()) {
            for (Author model : entityList) {
                rList.add(toWrapper(model));
            }
        }
        return rList;
    }

    public AuthorWrapper save(AuthorWrapper wrapper){
        return toWrapper(authorRepository.save(toEntity(wrapper)));
    }

    public List<AuthorWrapper> getList(){
        return   toWrapperList((List<Author>) authorRepository.findAll());
    }

    public AuthorWrapper getById(Long id){
        return toWrapper(authorRepository.findById(id).get());
    }

    public Page<AuthorWrapper> getPaginatedWrapperList(String search, int page, int rowSize, Sort sort){
        List<AuthorWrapper> rList = new ArrayList<>();
        PageRequest pageable = PageRequest.of(page - 1, rowSize, sort);
        Page<Author> pageableModel = authorRepository.getPaginatedList(search,pageable);
        if(pageableModel.getContent()!=null && !pageableModel.getContent().isEmpty()){
            //loope model here
            for(Author model : pageableModel.getContent()){
                rList.add(toWrapper(model));
            }
        }

        return new PageImpl<>(rList, pageable, pageableModel.getTotalElements());
    }
}
