package id.co.book.bookstore.backend.model.system;

import id.co.book.bookstore.common.model.EntityBase;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends EntityBase {

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {
    }

    public Role(ERole name) {
        this.name = name;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
