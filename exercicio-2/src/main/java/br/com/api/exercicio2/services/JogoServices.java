package br.com.api.exercicio2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.exercicio2.domain.DomainExercicio2;
import br.com.api.exercicio2.repositories.RepositoriesExercicio2;

@Service
public class JogoServices {

	    @Autowired
	    RepositoriesExercicio2 repositoriesExercicio2;
	    
	    public List<DomainExercicio2> findAll(){
	        return repositoriesExercicio2.findAll();
	    }

	    public Optional <DomainExercicio2> findById(Integer id){
	        return repositoriesExercicio2.findById(id);

	    }
	    

	    public Long count() {
	        return repositoriesExercicio2.count();
	    }

	    public void deletarJogo(Integer id) {

	        Optional<DomainExercicio2> opt = repositoriesExercicio2.findById(id);
	        if(opt.isPresent()) {
	        	DomainExercicio2 jogo = opt.get();
	        	jogo.setStatus(false);
	        	repositoriesExercicio2.save(jogo);

	        }
	    }

	    public DomainExercicio2 cadastrarJogo(DomainExercicio2 jogo) {
	       return repositoriesExercicio2.save(jogo);
	        }
	    
	    public DomainExercicio2 mudarjogo(DomainExercicio2 jogoAtualizado, Integer id) {
	    	return repositoriesExercicio2.save(jogoAtualizado);
	    }

	
}
