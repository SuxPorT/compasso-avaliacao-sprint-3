package br.com.compasso.avaliacaosprint3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.compasso.avaliacaosprint3.model.Carro;

public interface CarroRepository extends PagingAndSortingRepository<Carro, String>, JpaSpecificationExecutor<Carro> {

	@Query("SELECT c FROM Carro c WHERE UPPER(c.chassi) = :chassi")
	Optional<Carro> findByChassi(@Param("chassi") String chassi);

}
