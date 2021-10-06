package br.faasdorian.quickspringproject.bootstrap;

import br.faasdorian.quickspringproject.domain.Author;
import br.faasdorian.quickspringproject.domain.Book;
import br.faasdorian.quickspringproject.domain.Publisher;
import br.faasdorian.quickspringproject.repositories.AuthorRepository;
import br.faasdorian.quickspringproject.repositories.BookRepository;
import br.faasdorian.quickspringproject.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher1 = new Publisher("Rua João Zangrandi", "São Paulo", "SP", "123121222");

        publisherRepository.save(publisher1);

        Author author1 = new Author("Robert", "C. Martin");
        Book book1 = new Book("Clean Code", "123123123");

        author1.getBooks().add(book1);
        book1.getAuthors().add(author1);
        book1.setPublisher(publisher1);

        authorRepository.save(author1);
        bookRepository.save(book1);

        Author author2 = new Author("Stephen", "King");
        Book book2 = new Book("The Shining", "456456456");

        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        book2.setPublisher(publisher1);

        authorRepository.save(author2);
        bookRepository.save(book2);

        publisher1.getBooks().add(book1);
        publisher1.getBooks().add(book2);

        publisherRepository.save(publisher1);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Number of books in publisher: " + publisher1.getBooks().size());
    }
}
