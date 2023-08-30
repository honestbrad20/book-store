package id.co.book.bookstore.backend.model;

import id.co.book.bookstore.common.model.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "publisher", uniqueConstraints = @UniqueConstraint(columnNames = {"publisher_name", "publisher_city"}))
public class Publisher extends EntityBase {

    @Column(name = "publisher_name", length = 100, nullable = false)
    private  String publisherName;

    @Column(name = "publisher_city", length = 75, nullable = false)
    private String publisherCity;

    public Publisher() {
        this.publisherName = publisherName;
        this.publisherCity = publisherCity;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherCity() {
        return publisherCity;
    }

    public void setPublisherCity(String publisherCity) {
        this.publisherCity = publisherCity;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                ", publisherName='" + publisherName + '\'' +
                ", publisherCity='" + publisherCity + '\'' +
                '}';
    }
}
