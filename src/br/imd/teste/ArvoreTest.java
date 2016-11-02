package br.imd.teste;

import static org.junit.Assert.*;

import org.junit.Test;


import br.imd.entidade.*;

public class ArvoreTest {
	Pessoa pessoa = new Pessoa("Laura", "20/11/1988", "06570555499", "3333-9090");
	Pessoa pessoa2 = new Pessoa("Bruno", "20/11/1978", "06570555499", "3333-9090");
	Pessoa pessoa3 = new Pessoa("Gustavo", "20/11/1978", "06570555499", "3333-9090");
	Pessoa pessoa4 = new Pessoa("Maria", "20/11/1978", "06570555499", "3333-9090");
	Pessoa pessoa5 = new Pessoa("Julia", "20/11/1978", "06570555499", "3333-9090");
	Pessoa patinho = new Pessoa("Paulo", "20/11/1978", "06570555499", "3333-9090");
	Arvore arvore = new Arvore();
	

	@Test
	public void test() {
		Arvore arv2 = new Arvore();
		System.out.println(arv2.getRaiz());
		//assertEquals(true, arvore.isEmpty());
		arvore.inserir(new No(pessoa));
		arvore.preOrder();
		arvore.inserir(new No(pessoa2));
		arvore.preOrder();
		arvore.inserir(new No(pessoa3));
		arvore.inserir(new No(pessoa4));
		arvore.inserir(new No(pessoa5));
		System.out.println("Pre");
		arvore.preOrder();
		System.out.println("em ordem:");
		arvore.inOrder();
		System.out.println("Pos");
		arvore.posOrder();
		if(arvore.buscar(new No(patinho)) !=null){
			System.out.println("Achou: " +arvore.buscar(new No(patinho)).getPessoa().getNome());
		}else{
			System.out.println("Não tem");
		}
		
		
		System.out.println("Arvore teste");
		 
			if(arvore.remover(new No(pessoa3)).buscar(new No(pessoa3)) !=null){
				System.out.println("Achou: " +arvore.buscar(new No(pessoa3)).getPessoa().getNome());
			}else{
				System.out.println("Não tem");
			}
		 
		 
	}

}
