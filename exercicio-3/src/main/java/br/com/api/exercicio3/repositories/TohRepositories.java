package br.com.api.exercicio3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.exercicio3.domain.TohDomain;

@Repository("jogo")
public interface TohRepositories extends JpaRepository<TohDomain, Integer> {
	
	
}
