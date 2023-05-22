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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.exercicio2.domain.DomainExercicio2;
import br.com.api.exercicio2.services.EmailService;
import br.com.api.exercicio2.services.JogoServices;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/jogos")
public class JogoControllers {
	

	    @Autowired
	    JogoServices jogoServices;
	    
	    @Autowired
	    EmailService emailService;

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
	    public DomainExercicio2 cadastrarJogo(@RequestParam String email, @RequestBody DomainExercicio2 jogo) throws MessagingException {
	    	emailService.envioEmailCadastro(email, jogo);
	    	return jogoServices.cadastrarJogo(jogo);
	        
	    }

	    @GetMapping("/count")
	    public Long count() {
	        return jogoServices.count();
	    }

	    @PutMapping("/alterar/{id}")
	    public DomainExercicio2 mudarjogo(@RequestBody DomainExercicio2 jogo, @PathVariable Integer id) {
	    return jogoServices.mudarjogo(jogo, id);
	    }


	
}
