package di;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ContainerServiceTest {

    @Test
    void getObject_BookRepository() {
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);

        assertNotNull(bookRepository);
    }

    @Test
    void getObject_BookService() {
        BookService bookService = ContainerService.getObject(BookService.class);

        assertNotNull(bookService);
        assertNotNull(bookService.bookRepository);
    }
}