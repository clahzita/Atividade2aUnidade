/**
 * 
 */
package br.imd.exceptions;

/**
 * Essa classe trata as exceções lançadas pelo método imprimePessoa(String nome) da classe Agenda
 * 
 * @author clarissa
 *
 */
public class ImprimePessoaException extends Exception {
	
	public ImprimePessoaException(String msg){
		super(msg);
	}

}
