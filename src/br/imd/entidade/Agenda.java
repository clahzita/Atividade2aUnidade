package br.imd.entidade;

import br.imd.exceptions.BuscaPessoaException;
import br.imd.exceptions.NodeNotFoundedException;
import br.imd.exceptions.ValoresNulosException;

/**
 * Classe para objetos do tipo Agenda, em que serão contidos valores e métodos.
 * @author Clarissa Soares / Paulo Henrique Lopes
 * @version 1.0
 * @since #20161026
 */

public class Agenda {
	private Arvore banco = new Arvore();
	
	public Agenda() {
		
	}
	
	/**
	 * Devolve a árvore em que são cadastrados os contatos da agenda.
	 * @return banco Árvore em que são cadastrados os contatos da agenda
	 */
	public Arvore getBanco() {
		return banco;
	}

	/**
	 * Método adciona uma pessoa de contato na agenda.
	 * @param pessoa pessoa a ser adcionada na agenda
	 * @throws ValoresNulosException Ocorre quando tenta armazenar uma pessoa não instanciada. 
	 */
	public void armazenaPessoa(Pessoa pessoa) throws ValoresNulosException{
		if(pessoa != null){
			banco.inserir(new No(pessoa));
			System.out.println("Salvo com sucesso!");
		}else{
			throw new ValoresNulosException("Não é possivel salvar dados nulos.");
		}
		
		
	}
	

	/**
	 * Método remove uma pessoa de contato na agenda.
	 * @param pessoa1 Nome da pessoa que deve ser excluída da agenda.
	 * 
	 */
	public void removePessoa(String pessoa){
		
		No aux1 = new No(new Pessoa(pessoa, "x", "x", "x"));
		try {
			banco.remover(aux1);
		} catch (NodeNotFoundedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Método informa em que posição da agenda está a pessoa.
	 * @param nome Nome da pessoa que está sendo buscado.
	 */
	public void buscaPessoa(String nome) throws NodeNotFoundedException{
		No aux1 = new No(new Pessoa(nome, "x", "x", "x"));
		
		No encontrado = banco.buscar(aux1);
		if(encontrado != null){
			
			System.out.println(nome + " encontrado!");
		}else{
			System.out.println(nome+" não foi encontrado na agenda!");
			throw new NodeNotFoundedException(nome+" não foi encontrado na agenda");
			
		}
		
		
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
			
			
			if(arvore.getRaiz().getArvDireita() != null){
				imprimeAgenda(arvore.getRaiz().getArvDireita());
			}
		}
	}
	
	/**
	 * Método imprime os dados da pessoa com o nome que deseja exibir dados.
	 * @param nome Nomeda pessoa que vai ser impresso os dados
	 * @throws BuscaPessoaException Ocorre quando o nome do contato a ser impresso não foi encontrado na agenda.
	 */
	public void imprimePessoa(String nome) throws BuscaPessoaException{
		
		No aux1 = new No(new Pessoa(nome, "x", "x", "x"));
		No aux = banco.buscar(aux1);
		if(aux != null){
			System.out.println("#####################");
			Pessoa contato = aux.getPessoa();
			System.out.println("Nome: "+contato.getNome()+" Idade: "+contato.getIdade()+"/nCPF: "
								+contato.getCpf()+"\nTel.: " + contato.getTelefone());
		}else{
			throw new BuscaPessoaException(nome + " não encontrado na agenda.");
		}
	} 
}
