package demo.order;

import demo.domain.Book;
import demo.domain.BookNotFoundException;
import demo.domain.BookOrder;
import demo.domain.BookOrderRepository;
import demo.domain.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookOrderService {

	private final BookRepository bookRepository;

	private final BookOrderRepository bookOrderRepository;

	@Autowired
	public BookOrderService(BookRepository bookRepository, BookOrderRepository bookOrderRepository) {
		this.bookRepository = bookRepository;
		this.bookOrderRepository = bookOrderRepository;
	}

	@Transactional
	public BookOrder order(Long bookId, Long customerId) {
		Book book = this.bookRepository.findOne(bookId);
		if (book == null) {
			throw new BookNotFoundException(bookId);
		}
		BookOrder order = new BookOrder(book.getIsbn(), customerId);
		this.bookOrderRepository.save(order);
		return order;
	}
}