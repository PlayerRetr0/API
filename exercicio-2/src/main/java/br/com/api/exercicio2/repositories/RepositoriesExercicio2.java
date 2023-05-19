package br.com.api.exercicio2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.exercicio2.domain.DomainExercicio2;

@Repository
public interface RepositoriesExercicio2 extends JpaRepository<DomainExercicio2, Integer> {
	
	
}
