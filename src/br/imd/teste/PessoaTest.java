package br.imd.teste;

import static org.junit.Assert.*;



import org.junit.Test;

import br.imd.entidade.Pessoa;

public class PessoaTest {
	Pessoa pessoa = new Pessoa("Laura", "20/11/1988", "06570453499", "3333-9090");
	@Test
	public void idadetest() {
		assertEquals(27,pessoa.getIdade(),0);
	}

}
