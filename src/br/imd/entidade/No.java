package br.imd.entidade;

public class No {
	
	private Pessoa pessoa;
	private No pai;
	
	

	public No(Pessoa pessoa){
		this.pessoa = pessoa;
	}
	
	public No getPai() {
		return pai;
	}

	public void setPai(No pai) {
		this.pai = pai;
	}
	
	public void verPessoa(){
		System.out.println(pessoa.getNome());
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
