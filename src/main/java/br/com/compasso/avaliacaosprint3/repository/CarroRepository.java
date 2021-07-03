package br.com.compasso.avaliacaosprint3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.compasso.avaliacaosprint3.model.Carro;

public interface CarroRepository extends PagingAndSortingRepository<Carro, String>, JpaSpecificationExecutor<Carro> {

	// Ignora letras maiúsculas/minúsculas do chassi registrado no banco
	@Query("SELECT c FROM Carro c WHERE UPPER(c.chassi) = :chassi")
	Optional<Carro> findByChassi(@Param("chassi") String chassi);
	
	@Query("SELECT c FROM Carro c where c.valor = (SELECT MIN(valor) FROM Carro)")
	List<Carro> findByMinValor();

	@Query("SELECT c FROM Carro c where c.valor = (SELECT MAX(valor) FROM Carro)")
	List<Carro> findByMaxValor();
	
}
