package id.co.book.bookstore.service.wrapper;

public class AuthorWrapper {
    private Long id;
    private String authorName;
    private Integer authorAge;
    private String authorAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAuthorAddress() {
        return authorAddress;
    }

    public void setAuthorAddress(String authorAddress) {
        this.authorAddress = authorAddress;
    }

    @Override
    public String toString() {
        return "AuthorWrapper{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", authorAge=" + authorAge +
                ", authorAddress='" + authorAddress + '\'' +
                '}';
    }
}
