package br.com.api.exercicio1.domain;

public class Asks {
	    private Long numdopedido;
	    private String pedido;
	    private String conteudo;
	    
	    public Asks(Long numdopedido, String pedido, String conteudo) {
	        super();
	        this.numdopedido = numdopedido;
	        this.pedido = pedido;
	        this.conteudo = conteudo;
	    }


	    public Long getNumdopedido() {
	        return numdopedido;
	    }


	    public void setNumdopedido(Long numdopedido) {
	        this.numdopedido = numdopedido;
	    }


	    public String getPedido() {
	        return pedido;
	    }


	    public void setPedido(String pedido) {
	        this.pedido = pedido;
	    }


	    public String getConteudo() {
	        return conteudo;
	    }


	    public void setConteudo(String conteudo) {
	        this.conteudo = conteudo;
	    }

	
}
