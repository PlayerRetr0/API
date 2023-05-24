package br.com.api.exercicio3.controllers;

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

import br.com.api.exercicio3.domain.TohDomain;
import br.com.api.exercicio3.services.EmailService;
import br.com.api.exercicio3.services.TohServices;
import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/produtos")
public class TohControllers {
	

	    @Autowired
	    TohServices tohServices;
	    
	    @Autowired
	    EmailService emailService;

	    @GetMapping("/vertodos")
	    public List<TohDomain> findAll() {
	        return tohServices.findAll();
	    }

	    @GetMapping("/acharprod/{id}")
	    public ResponseEntity<TohDomain>  findById(@PathVariable Integer id){
	        Optional <TohDomain> opt = tohServices.findById(id);
	        if(opt.isPresent()) {
	            return ResponseEntity.ok(opt.get());

	        }
	        return ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/deletarprod/{id}")
	    public void deletarProduto(@PathVariable Integer id) {
	    	tohServices.deletarProduto(id);

	    }
	    @PostMapping
	    public TohDomain cadastrarProduto(@RequestParam String email, @RequestBody TohDomain produto) throws MessagingException {
	    	emailService.envioEmailCadastro(email, produto);
	    	return tohServices.cadastrarProduto(produto);
	        
	    }

	    @GetMapping("/count")
	    public Long count() {
	        return tohServices.count();
	    }

	    @PutMapping("/alterarprod/{id}")
	    public TohDomain mudarproduto(@RequestBody TohDomain produto, @PathVariable Integer id) {
	    return tohServices.mudarproduto(produto, id);
	    }


	
}
