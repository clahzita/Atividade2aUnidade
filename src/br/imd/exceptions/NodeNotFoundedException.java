package br.imd.exceptions;

public class NodeNotFoundedException extends Exception {
	private String mensagem;
	
	public NodeNotFoundedException(String msg){
		super(msg);
		setMensagem(msg);
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
}



