package id.co.book.bookstore.backend.model;

import id.co.book.bookstore.common.model.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "author", uniqueConstraints = @UniqueConstraint(columnNames = {"author_name","author_city"}))
public class Author extends EntityBase {



    @Column(name = "author_name", length = 100, nullable = false)
    private String authorName;

    @Column(name = "author_age", length = 2, nullable = false)
    private Integer authorAge;

    @Column(name = "author_city", length = 75, nullable = false)
    private String authorCity;

    public Author() {
    }

    public Author(String authorName, Integer authorAge, String authorCity) {
        this.authorName = authorName;
        this.authorAge = authorAge;
        this.authorCity = authorCity;
    }


    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getAuthorAge() {
        return authorAge;
    }

    public void setAuthorAge(Integer authorAge) {
        this.authorAge = authorAge;
    }

    public String getAuthorCity() {
        return authorCity;
    }

    public void setAuthorCity(String authorCity) {
        this.authorCity = authorCity;
    }

    @Override
    public String toString() {
        return "Author{" +
                ", authorName='" + authorName + '\'' +
                ", authorAge=" + authorAge +
                ", authorCity='" + authorCity + '\'' +
                '}';
    }
}