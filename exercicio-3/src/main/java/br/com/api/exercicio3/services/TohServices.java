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
	    TohRepositories tohRepositories;
	    
	    public List<TohDomain> findAll(){
	        return tohRepositories.findAll();
	    }

	    public Optional <TohDomain> findById(Integer id){
	        return tohRepositories.findById(id);

	    }
	    

	    public Long count() {
	        return tohRepositories.count();
	    }

	    public void deletarProduto(Integer id) {

	        Optional<TohDomain> opt = tohRepositories.findById(id);
	        if(opt.isPresent()) {
	        	TohDomain jogo = opt.get();
	        	jogo.setStatus(false);
	        	tohRepositories.save(jogo);

	        }
	    }

	    public TohDomain cadastrarProduto(TohDomain jogo) {
	       return tohRepositories.save(jogo);
	        }
	    
	    public TohDomain mudarproduto(TohDomain produtoAtualizado, Integer id) {
	    	TohDomain produtoAtual = tohRepositories.findById(id).get();
			if (produtoAtual != null) {
				produtoAtual.setNome(produtoAtualizado.getNome());
				produtoAtual.setCategorias(produtoAtualizado.getCategorias());
				produtoAtual.setPersonagem(produtoAtualizado.getPersonagem());
				produtoAtual.setStatus(produtoAtualizado.isStatus());
				produtoAtual.setValor(produtoAtualizado.getValor());
				
	    	return tohRepositories.save(produtoAtualizado);
			}
			else {
				throw new IllegalArgumentException("Produto não encontrado");
			}
	    }

	
}
