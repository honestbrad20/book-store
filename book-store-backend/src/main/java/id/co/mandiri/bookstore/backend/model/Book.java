package id.co.book.bookstore.backend.model;

import id.co.book.bookstore.common.model.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book extends EntityBase {

    @Column(name = "book_title", length = 255, nullable = false)
    private String bookTitle;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                ", bookTitle='" + bookTitle + '\'' +
                ", author=" + author +
                '}';
    }
}