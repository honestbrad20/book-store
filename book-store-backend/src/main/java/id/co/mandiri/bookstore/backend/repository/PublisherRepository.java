package id.co.book.bookstore.backend.repository;

import id.co.book.bookstore.backend.model.Publisher;
import id.co.book.bookstore.backend.model.Publisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends PagingAndSortingRepository<Publisher,Long> {

    @Query("select a from Publisher a where a.publisherName like %:publisherName%")
    Page<Publisher> getByPublisherName(@Param("publisherName") String publisherName, Pageable pageable);

    @Query("select a from Publisher a where a.publisherName like %:param% or a.publisherCity like %:param%")
    Page<Publisher> getPaginatedList(@Param("param") String param, Pageable pageable);
}