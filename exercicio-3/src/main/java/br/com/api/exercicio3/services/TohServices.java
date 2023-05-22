package br.com.api.exercicio3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.exercicio3.domain.TohDomain;
import br.com.api.exercicio3.repositories.TohRepositories;

@Service
public class TohServices {

	    @Autowired
	    TohRepositories repositoriesExercicio2;
	    
	    public List<TohDomain> findAll(){
	        return repositoriesExercicio2.findAll();
	    }

	    public Optional <TohDomain> findById(Integer id){
	        return repositoriesExercicio2.findById(id);

	    }
	    

	    public Long count() {
	        return repositoriesExercicio2.count();
	    }

	    public void deletarProduto(Integer id) {

	        Optional<TohDomain> opt = repositoriesExercicio2.findById(id);
	        if(opt.isPresent()) {
	        	TohDomain jogo = opt.get();
	        	jogo.setStatus(false);
	        	repositoriesExercicio2.save(jogo);

	        }
	    }

	    public TohDomain cadastrarProduto(TohDomain jogo) {
	       return repositoriesExercicio2.save(jogo);
	        }
	    
	    public TohDomain mudarproduto(TohDomain jogoAtualizado, Integer id) {
	    	return repositoriesExercicio2.save(jogoAtualizado);
	    }

	
}
