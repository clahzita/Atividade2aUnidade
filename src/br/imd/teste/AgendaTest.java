package br.imd.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.imd.entidade.Pessoa;
import br.imd.exceptions.RemovePessoaException;
import br.imd.entidade.Agenda;
import br.imd.entidade.No;

/**
 * TestCase da Classe Agenda.
 * @author Clarissa Soares / Paulo Henrique Lopes
 * @version 1.0
 * @since #20161102
 */
public class AgendaTest {
	Pessoa pessoa1 = new Pessoa("Laura", "20/11/1988", "06570453499", "3333-9090");
	Pessoa pessoa2 = new Pessoa("Bruno", "20/11/1978", "06570453499", "3333-9090");
	Pessoa pessoa3 = new Pessoa("Gustavo", "20/11/1978", "06570453499", "3333-9090");
	Pessoa pessoa4 = new Pessoa("Maria", "20/11/1978", "06570453499", "3333-3030");
	Pessoa pessoa5 = new Pessoa("Julia", "20/11/1958", "06570453499", "3333-3030");
	Pessoa patinho = new Pessoa("Paulo", "20/11/1990", "06570453499", "3333-4545");
	Agenda agenda = new Agenda();
	
	@Test
	public void armazenaPessoaText(){
		agenda.armazenaPessoa(pessoa1);
		agenda.armazenaPessoa(null);
		System.out.println("ok");
		
	}
	
	
	
	@Test
	public void removePessoatest() {
		agenda.removePessoa(pessoa1.getNome());
		

	}

}
