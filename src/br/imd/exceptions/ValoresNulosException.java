/**
 * 
 */
package br.imd.exceptions;

/**
 * Essa classe trata as exceções lançadas pelo método removePessoa(String nome) da classe Agenda
 * @author Clarissa Soares / Paulo Henrique Lopes
 * @version 1.2
 * @since #20161027
 */
public class ValoresNulosException extends Exception {
	private String mensagem;
	/**
	 * Constroi uma exceção.
	 * @param msg Mensagem enviada pelo metodo que lança a exceção.
	 */
	public ValoresNulosException(String msg){
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
