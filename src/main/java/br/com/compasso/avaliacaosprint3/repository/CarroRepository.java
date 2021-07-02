package br.com.compasso.avaliacaosprint3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.compasso.avaliacaosprint3.model.Carro;

public interface CarroRepository extends JpaRepository<Carro, String> {

//	Optional<Carro> findByChassi(String chassi);
//
//	List<Carro> findByMarca(String marca);
//
//	List<Carro> findByNome(String nome);
//	
//	List<Carro> findByCor(String cor);
	
	@Query("SELECT c FROM Carro c WHERE UPPER(c.chassi) = :chassi")
	Optional<Carro> findByChassi(@Param("chassi") String chassi);

	@Query("SELECT c FROM Carro c WHERE UPPER(c.marca) = :marca")
	List<Carro> findByMarca(@Param("marca") String marca);

	@Query("SELECT c FROM Carro c WHERE UPPER(c.nome) = :nome")
	List<Carro> findByNome(@Param("nome") String nome);
	
	@Query("SELECT c FROM Carro c WHERE UPPER(c.cor) = :cor")
	List<Carro> findByCor(@Param("cor") String cor);
	
	void deleteByChassi(String chassi);

}
