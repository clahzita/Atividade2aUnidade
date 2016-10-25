package br.imd.entidades;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * 
 * @author Clarissa Soares / Paulo Henrique Lopes
 * @version 1.0
 */
public class Pessoa {
	private String nome;
	private String dataNascimento;
	private String cpf;
	private String telefone;
	
	public Pessoa(String nome, String dataNascimento, String cpf, String telefone) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.telefone = telefone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public int getIdade(){
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate nascimento = LocalDate.parse(this.dataNascimento,formato);
		
		Period periodo = Period.between(nascimento, LocalDate.now());
		
		return periodo.getYears();
	}
	
}
