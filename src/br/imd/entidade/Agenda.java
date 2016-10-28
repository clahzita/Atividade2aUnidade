package br.imd.entidade;

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
	 */
	public void removePessoa(String nome){
		
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
	public void imprimeAgenda(){
		
	}
	
	/**
	 * Método imprime os dados da pessoa com este nome.
	 * @param nome Nomeda pessoa que vai ser impresso os dados
	 */
	public void imprimePessoa(String nome){
		
	} 
}
