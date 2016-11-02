package br.imd.entidade;

import br.imd.exceptions.ImprimePessoaException;
import br.imd.exceptions.RemovePessoaException;

/**
 * Classe para objetos do tipo Agenda, em que serão contidos valores e métodos.
 * @author Clarissa Soares / Paulo Henrique Lopes
 * @version 1.0
 * @since #20161026
 */

public class Agenda {
	public Arvore banco = new Arvore();
	
	
	/**
	 * Método adciona uma pessoa de contato na agenda.
	 * @param pessoa pessoa a ser adcionada na agenda
	 */
	public void armazenaPessoa(Pessoa pessoa){
		if(pessoa != null){
			banco.inserir(new No(pessoa));
			System.out.println("Salvo com sucesso!");
		}else{
			System.out.println("Dados nulos.");
		}
		
		
	}
	

	/**
	 * Método remove uma pessoa de contato na agenda.
	 * @param pessoa1 Nome da pessoa que deve ser excluída da agenda.
	 * @throws RemovePessoaException Ocorre quando o nome do contato a ser removido não foi encontrado na agenda.
	 */
	public void removePessoa(String pessoa){
		
		No aux1 = new No(new Pessoa(pessoa, "x", "x", "x"));
		
		banco.remover(aux1);
		
		
	}
	
	/**
	 * Método informa em que posição da agenda está a pessoa.
	 * @param nome Nome da pessoa que está sendo buscado.
	 * @return posição na árvore que se encontra os dados
	 */
	public int buscaPessoa(String nome){
		
		return 0;
	}
	
	/**
	 *  Método imprime os dados de todas as pessoas da agenda
	 */
	public void imprimeAgenda(Arvore arvore){	
		if (arvore.getRaiz() != null) {
			
			if(arvore.getRaiz().getArvEsquerda() != null){
				imprimeAgenda(arvore.getRaiz().getArvEsquerda());
			}
			
			System.out.println("#####################");
			Pessoa contato = arvore.getRaiz().getPessoa();
			System.out.println("Nome: "+contato.getNome()+" Idade: "+contato.getIdade()+"/nCPF: "
								+contato.getCpf()+"\nTel.: "+contato.getTelefone());
			System.out.println("#####################");
			
			if(arvore.getRaiz().getArvDireita() != null){
				imprimeAgenda(arvore.getRaiz().getArvDireita());
			}
		}
	}
	
	/**
	 * Método imprime os dados da pessoa com este nome.
	 * @param nome Nomeda pessoa que vai ser impresso os dados
	 * @throws ImprimePessoaException Ocorre quando o nome do contato a ser impresso não foi encontrado na agenda.
	 */
	public void imprimePessoa(String nome) throws ImprimePessoaException{
		
		No aux1 = new No(new Pessoa(nome, "x", "x", "x"));
		No aux = banco.buscar(aux1);
		if(aux != null){
			System.out.println("#####################");
			Pessoa contato = aux.getPessoa();
			System.out.println("Nome: "+contato.getNome()+" Idade: "+contato.getIdade()+"/nCPF: "
								+contato.getCpf()+"\nTel.: " + contato.getTelefone());
		}else{
			throw new ImprimePessoaException(nome + " não encontrado na agenda.");
		}
	} 
}
