package br.com.api.exercicio2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.exercicio2.domain.DomainExercicio2;
import br.com.api.exercicio2.services.JogoServices;

@RestController
@RequestMapping("/jogos")
public class JogoControllers {
	

	    @Autowired
	    JogoServices jogoServices;

	    @GetMapping
	    public List<DomainExercicio2> findAll() {
	        return jogoServices.findAll();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<DomainExercicio2>  findById(@PathVariable Integer id){
	        Optional <DomainExercicio2> opt = jogoServices.findById(id);
	        if(opt.isPresent()) {
	            return ResponseEntity.ok(opt.get());

	        }
	        return ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public void deletarJogo(@PathVariable Integer id) {
	    	jogoServices.deletarJogo(id);

	    }
	    @PostMapping
	    public DomainExercicio2 cadastrarJogo(@RequestBody DomainExercicio2 jogo) {
	        return jogoServices.cadastrarJogo(jogo);
	    }

	    @GetMapping("/count")
	    public Long count() {
	        return jogoServices.count();
	    }

	    @PutMapping("/{id}")
	    public DomainExercicio2 mudarjogo(@RequestBody DomainExercicio2 jogo, @PathVariable Integer id) {
	    return jogoServices.mudarjogo(jogo, id);
	    }


	
}
