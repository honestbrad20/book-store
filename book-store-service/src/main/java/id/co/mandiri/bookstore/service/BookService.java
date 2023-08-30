package id.co.book.bookstore.service;

import id.co.book.bookstore.backend.model.Author;
import id.co.book.bookstore.backend.model.Book;
import id.co.book.bookstore.backend.model.Publisher;
import id.co.book.bookstore.backend.repository.AuthorRepository;
import id.co.book.bookstore.backend.repository.BookRepository;
import id.co.book.bookstore.backend.repository.PublisherRepository;
import id.co.book.bookstore.service.wrapper.BookWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    private Book toEntity(BookWrapper wrapper) {
        Book entity = new Book();
        if(wrapper.getId() !=null){
            entity = bookRepository.findById(wrapper.getId()).get();
        }
        entity.setBookTitle(wrapper.getBookTitle());
        Optional<Author> optAuthor = authorRepository.findById(wrapper.getAuthorId());
        Optional<Publisher> optPublisher = publisherRepository.findById(wrapper.getPublisherId());
        entity.setAuthor(optAuthor.get());
        entity.setPublisher(optPublisher.get());
        return entity;
    }

    private BookWrapper toWrapper(Book dataModel) {
        BookWrapper wrapper = new BookWrapper();
        wrapper.setId(dataModel.getId());
        wrapper.setBookTitle(dataModel.getBookTitle());
        wrapper.setAuthorName(dataModel.getAuthor().getAuthorName());
        wrapper.setAuthorId(dataModel.getAuthor().getId());
        wrapper.setPublisherName(dataModel.getPublisher().getPublisherName());
        wrapper.setPublisherId(dataModel.getPublisher().getId());

        return wrapper;
    }

    private List<BookWrapper> toWrapperList(List<Book> modelList) {
        List<BookWrapper> rList = new ArrayList<>();
        if (modelList != null && !modelList.isEmpty()) {
            for (Book model : modelList) {
                rList.add(toWrapper(model));
            }
        }
        return rList;
    }

    public BookWrapper save(BookWrapper wrapper) {
        return toWrapper(bookRepository.save(toEntity(wrapper)));

    }

    public BookWrapper getById(Long bookId) {
        Optional<Book> optBook = bookRepository.findById(bookId);
        return optBook.map(this::toWrapper).orElse(null);
    }

    public List<BookWrapper> getList() {
        return toWrapperList((List) bookRepository.findAll());
    }
}