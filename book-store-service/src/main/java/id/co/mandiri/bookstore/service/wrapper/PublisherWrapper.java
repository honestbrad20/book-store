package id.co.book.bookstore.service.wrapper;

public class PublisherWrapper {
    private Long id;
    private String publisherName;
    private String publisherCity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return "PublisherWrapper{" +
                "id=" + id +
                ", publisherName='" + publisherName + '\'' +
                ", publisherCity='" + publisherCity + '\'' +
                '}';
    }
}
