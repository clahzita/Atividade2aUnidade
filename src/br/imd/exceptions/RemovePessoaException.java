/**
 * 
 */
package br.imd.exceptions;

/**
 * Essa classe trata as exceções lançadas pelo método removePessoa(String nome) da classe Agenda
 * 
 * @author clarissa
 *
 */
public class RemovePessoaException extends Exception {
	public RemovePessoaException(String msg){
		super(msg);
	}
}
