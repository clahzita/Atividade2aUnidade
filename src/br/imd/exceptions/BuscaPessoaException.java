/**
 * 
 */
package br.imd.exceptions;

/**
 * Essa classe trata as exceções lançadas pelo método imprimePessoa(String nome) da classe Agenda
 * @author Clarissa Soares / Paulo Henrique Lopes
 * @version 1.2
 * @since #20161026
 */
public class BuscaPessoaException extends Exception {
	private String mensagem;
	/**
	 * Constroi uma exceção.
	 * @param msg Mensagem enviada pelo metodo que lança a exceção.
	 */
	public BuscaPessoaException(String msg){
		super(msg);
		this.mensagem = msg;
	}
	
	/**
	 * Retorna a mensagem que o metodo enviou ao lançar exceção.
	 */
	public String getMessage(){
		return mensagem;
	}

}
