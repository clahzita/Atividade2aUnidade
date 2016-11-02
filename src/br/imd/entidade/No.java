package br.imd.entidade;

public class No {

	private Pessoa pessoa;
	private Arvore arvDireita;
	private Arvore arvEsquerda;
	


	public No() {

	}

	public No(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void verPessoa() {
		System.out.println(pessoa.getNome());
	}

	public Arvore getArvDireita() {
		return arvDireita;
	}

	public void setArvDireita(Arvore arvDireita) {
		this.arvDireita = arvDireita;
	}

	public Arvore getArvEsquerda() {
		return arvEsquerda;
	}

	public void setArvEsquerda(Arvore arvEsquerda) {
		this.arvEsquerda = arvEsquerda;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	

}
