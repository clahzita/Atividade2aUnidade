package br.imd.teste;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;

import org.junit.Test;

import br.imd.entidade.*;
import br.imd.exceptions.NodeNotFoundedException;

/**
 * TestCase da Classe Arvore
 * @author Clarissa Soares / Paulo Henrique Lopes
 * @version 1.0
 * @since #20161102
 */

public class ArvoreTest {
	Pessoa pessoa = new Pessoa("Laura", "20/11/1988", "06570453499", "3333-9090");
	Pessoa pessoa1= new Pessoa("Laura", "20/09/1988", "06570453499", "3333-9090");
	Pessoa pessoa2 = new Pessoa("Bruno", "20/11/1978", "06570453499", "3333-9090");
	Pessoa pessoa3 = new Pessoa("Gustavo", "20/11/1978", "06570453499", "3333-9090");
	Pessoa pessoa4 = new Pessoa("Maria", "20/11/1978", "06570453499", "3333-9090");
	Pessoa pessoa5 = new Pessoa("Julia", "20/11/1978", "06570453499", "3333-9090");
	Pessoa patinho = new Pessoa("Paulo", "20/11/1978", "06570453499", "3333-9090");
	Arvore arvore = new Arvore();

	@Test
	public void test() throws NodeNotFoundedException {
		Arvore arv2 = new Arvore();
		System.out.println(arv2.getRaiz());
		assertEquals(true, arvore.isEmpty());
		
		arvore.inserir(new No(pessoa));
		assertEquals(false, arvore.isEmpty());
		arvore.remover(new No(pessoa));
		assertEquals(true, arvore.isEmpty());

		// Testando atualização na árvore
		arvore.inserir(new No(pessoa));
		assertEquals("20/11/1988", arvore.getRaiz().getPessoa().getDataNascimento());
		arvore.inserir(new No(pessoa1));
		assertEquals("20/09/1988", arvore.getRaiz().getPessoa().getDataNascimento());
		
		// inserindo mais valores na árvore;
		arvore.inserir(new No(pessoa2));
		arvore.inserir(new No(pessoa3));
		arvore.inserir(new No(pessoa4));
		arvore.inserir(new No(pessoa5));
		
		// Retorna null, exception tratada na Agenda
		arvore.buscar(new No(patinho));
		
		try {
			arvore.remover(new No(pessoa3));
		} catch (NodeNotFoundedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Verifica se removeu node da arvore
		assertEquals(null, arvore.buscar(new No(pessoa3)));
		try {
			arvore.listaProfundidade();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
