package br.com.api.exercicio1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.exercicio1.domain.Asks;
import br.com.api.exercicio1.services.Servicos;

@RestController
@RequestMapping("/pedido")
public class ExercicioController {

    @Autowired
    Servicos servicos;


    @GetMapping
    public List<Asks> listar() {

        return servicos.TodosPedidos();
    }

    @GetMapping("/{numdopedido}")
    public Asks buscarPedido(@PathVariable Long numdopedido) {
        return servicos.buscarPedido(numdopedido);
    }


    @GetMapping("/count")
    public int count() {
        return servicos.count();
    }

    @DeleteMapping("/{numdopedido}")
    public void deletarAluno(@PathVariable Long numdopedido) {
    	servicos.deletarPedido(numdopedido);
    }

    @PostMapping
    public Asks fazerPedido(@RequestBody Asks pedido) {
        return servicos.fazerpedido(pedido);
    }

    @PutMapping("/{numdopedido}") //@PatchMapping
    public Asks alterarPedido(@RequestBody Asks pedido, @PathVariable Long numdopedido) {
    return servicos.atualizarPedido(pedido, numdopedido);
    }
}
