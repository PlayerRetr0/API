	package br.com.api.exercicio1.services;
	
	import java.util.ArrayList;
	import java.util.List;
	import org.springframework.stereotype.Service;
	import br.com.api.exercicio1.domain.Asks;
@Service
public class Servicos {

	private static List<Asks> lista = new ArrayList<>();

    public List<Asks> TodosPedidos() {
    if(lista.isEmpty()) {
        lista.add(new Asks(1000L, "Lanche Feliz", "hamburguer e batata firta pequena"));
        lista.add(new Asks(1100L, "Double Meat", "hamburguer duplo e refrigerante"));
        lista.add(new Asks(1110L, "Vegetarian", "porção de salada"));
        lista.add(new Asks(1111L, "Sorverte", "casquinha de choolate"));
    }
    return lista;
    }
	    

	    public Asks buscarPedido(Long numdopedido) {
	        for(int i = 0; i < lista.size(); i++ ) {
	            if(lista.get(i).getNumdopedido().equals(numdopedido)) {
	                return lista.get(i);
	            }
	        }
	        return null;
	    }
	    public void deletarPedido(Long numdopedido) {
	        lista.remove(buscarPedido(numdopedido));
	    }

	    public int count() {
	        return lista.size();
	    }

	    public Asks fazerpedido(Asks pedido) {
	        if(buscarPedido(pedido.getNumdopedido()) == null ) {
	            lista.add(pedido);
	            return pedido;
	        }
	        return null;
	    }
	    public Asks atualizarPedido(Asks pedidoAtualizado, Long numdopedido) {
	    	Asks pedidoAntigo = buscarPedido(numdopedido);
	        if(pedidoAntigo != null  ) {
	        	pedidoAntigo.setNumdopedido(pedidoAtualizado.getNumdopedido());
	        	pedidoAntigo.setPedido(pedidoAtualizado.getPedido());
	        	pedidoAntigo.setConteudo(pedidoAtualizado.getConteudo());

	            return pedidoAntigo;
	        }
	        return null;
	    }
	
}
