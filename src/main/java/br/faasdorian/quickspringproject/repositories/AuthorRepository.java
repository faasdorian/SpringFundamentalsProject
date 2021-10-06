package br.faasdorian.quickspringproject.repositories;

import br.faasdorian.quickspringproject.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
