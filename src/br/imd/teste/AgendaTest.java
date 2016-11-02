package br.imd.teste;

import static org.junit.Assert.*;

import org.junit.Test;

import br.imd.entidade.Pessoa;
import br.imd.exceptions.BuscaPessoaException;
import br.imd.exceptions.ValoresNulosException;
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
	Pessoa pessoa2 = new Pessoa("Laura", "20/11/1978", "06570453488", "3333-9050");
	Pessoa pessoa3 = new Pessoa("Gustavo", "20/11/1978", "06570453499", "3333-9090");
	Pessoa pessoa4 = new Pessoa("Maria", "20/11/1978", "06570453499", "3333-3030");
	
	Agenda agenda = new Agenda();
	
	
	
	@Test
	public void armazenaPessoaText(){
		System.out.println("Inicio teste armazenaPessoa");
		try {
			agenda.armazenaPessoa(pessoa1);
			agenda.armazenaPessoa(pessoa2);
			agenda.armazenaPessoa(pessoa3);
			agenda.armazenaPessoa(pessoa4);
		} catch (ValoresNulosException e) {
			
			System.out.println(e.getMessage());
		}
		try {
			agenda.armazenaPessoa(null);
		} catch (ValoresNulosException e) {

			System.out.println(e.getMessage());
		}
		
		agenda.imprimeAgenda(agenda.getBanco());
	
		try {
			agenda.armazenaPessoa(pessoa2);
		} catch (ValoresNulosException e) {

			System.out.println(e.getMessage());
		}
		
		agenda.imprimeAgenda(agenda.getBanco());
		
		System.out.println("Fim teste armazenaPessoa");
		
		agenda.getBanco().posOrder();
		
	}
	
	
	
	@Test
	public void removePessoatest() {
		System.out.println("Inicio teste removePessoa");
		try {
			agenda.armazenaPessoa(pessoa1);
		} catch (ValoresNulosException e) {

			System.out.println(e.getMessage());
		}
		agenda.removePessoa(pessoa1.getNome());
		agenda.removePessoa(pessoa1.getNome());
		System.out.println("Fim teste removePessoa");
		

	}

}
