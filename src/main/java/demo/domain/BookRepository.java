package demo.domain;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository<Book, Long> {

	Book findByIsbn(@Param("id") String isbn);

	Collection<Book> findByAuthorContainsIgnoreCase(@Param("name") String author);

}
