package id.co.book.bookstore.backend.repository.system;

import id.co.book.bookstore.backend.model.system.ERole;
import id.co.book.bookstore.backend.model.system.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}