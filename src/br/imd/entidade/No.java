package br.imd.entidade;

public class No {

	private Pessoa pessoa;
	private Arvore arvDireita;
	private Arvore arvEsquerda;
	private No parent;
	private int valor;
	
	
	/**
	* Metodo que retorna o valor(posição) de um nó em uma arvore
	* @return valor int
	**/
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	/**
	* Metodo que retorna o nó pai do nó atual
	* @return parent
	**/
	public No getParent() {
		return parent;
	}

	public void setParent(No parent) {
		this.parent = parent;
	}

	public No() {

	}

	public No(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void verPessoa() {
		System.out.println(pessoa.getNome());
	}
	
	/**
	* Metodo que retorna a subárvore a direita de um nó
	* @return arvDireita Arvore
	**/
	public Arvore getArvDireita() {
		return arvDireita;
	}

	public void setArvDireita(Arvore arvDireita) {
		this.arvDireita = arvDireita;
	}

	/**
	* Metodo que retorna a subárvore a esquerda de um nó
	* @return arvEsquerda Arvore
	**/
	public Arvore getArvEsquerda() {
		return arvEsquerda;
	}

	public void setArvEsquerda(Arvore arvEsquerda) {
		this.arvEsquerda = arvEsquerda;
	}
	
	/**
	* Metodo que retorna o conteudo de um No
	* @return pessoa Pessoa
	**/
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	

}
