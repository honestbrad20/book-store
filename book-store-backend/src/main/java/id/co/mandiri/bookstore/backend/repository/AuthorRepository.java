package id.co.book.bookstore.backend.repository;

import id.co.book.bookstore.backend.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends PagingAndSortingRepository<Author,Long> {

    @Query("select a from Author a where a.authorName like %:authorName%")
    Page<Author> getByAuthorName(@Param("authorName") String authorName, Pageable pageable);

    @Query("select a from Author a where a.authorName like %:param% or a.authorCity like %:param%")
    Page<Author> getPaginatedList(@Param("param") String param, Pageable pageable);
}