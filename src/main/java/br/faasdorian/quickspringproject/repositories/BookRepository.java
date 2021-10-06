package br.faasdorian.quickspringproject.repositories;

import br.faasdorian.quickspringproject.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
