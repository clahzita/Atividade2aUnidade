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
	public static Arvore banco = new Arvore();
	
	
	/**
	 * Método adciona uma pessoa de contato na agenda.
	 * @param pessoa pessoa a ser adcionada na agenda
	 */
	public void armazenaPessoa(Pessoa pessoa){
		banco.inserir(new No(pessoa));
	}
	

	/**
	 * Método remove uma pessoa de contato na agenda.
	 * @param nome Nome da pessoa que deve ser excluída da agenda.
	 * @throws RemovePessoaException Ocorre quando o nome do contato a ser removido não foi encontrado na agenda.
	 */
	public void removePessoa(String nome) throws RemovePessoaException{
		No aux = banco.busca(nome);
		if(aux != null){
			banco.remover(aux);
		}else{
			throw new RemovePessoaException(nome + " não encontrado na agenda. Remoção não pode ser relizada.");
		}
		
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
			imprimeAgenda(arvore.getArvoreEsquerda());
			System.out.println("#####################");
			Pessoa contato = arvore.getRaiz().getPessoa();
			System.out.println("Nome: "+contato.getNome()+" Idade: "+contato.getIdade()+"/nCPF: "
								+contato.getCpf()+"\nTel.: "+contato.getTelefone());
			System.out.println("#####################");
			imprimeAgenda(arvore.getArvoreDireita());
		}
	}
	
	/**
	 * Método imprime os dados da pessoa com este nome.
	 * @param nome Nomeda pessoa que vai ser impresso os dados
	 * @throws ImprimePessoaException Ocorre quando o nome do contato a ser impresso não foi encontrado na agenda.
	 */
	public void imprimePessoa(String nome) throws ImprimePessoaException{
		No aux = banco.busca(nome);
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
