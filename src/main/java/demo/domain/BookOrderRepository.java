package demo.domain;

import org.springframework.data.repository.CrudRepository;

public interface BookOrderRepository extends CrudRepository<BookOrder, Long> {
}
