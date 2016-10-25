package br.imd.entidade;

public class No {
	
	private Pessoa pessoa;
	
	public No(Pessoa pessoa){
		this.pessoa = pessoa;
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
