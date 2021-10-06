package br.faasdorian.quickspringproject.repositories;

import br.faasdorian.quickspringproject.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
