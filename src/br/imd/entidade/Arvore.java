package br.imd.entidade;

import br.imd.TAD.TadArvore;

public class Arvore{
	
	private No raiz;
	private Arvore arvoreEsquerda;
	private Arvore arvoreDireita;
	
	public Arvore(){
		
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public Arvore getArvoreEsquerda() {
		return arvoreEsquerda;
	}

	public void setArvoreEsquerda(Arvore arvoreEsquerda) {
		this.arvoreEsquerda = arvoreEsquerda;
	}

	public Arvore getArvoreDireita() {
		return arvoreDireita;
	}

	public void setArvoreDireita(Arvore arvoreDireita) {
		this.arvoreDireita = arvoreDireita;
	}
	
	
	public void inserir(No no){
		if(this.raiz == null){
			this.raiz = no;
		}else{
			//"a".compareTo("b");  returns a negative number, here -1
			//"a".compareTo("a");  returns  0
			//"b".compareTo("a");  returns a positive number, here 1
			if(no.getPessoa().getNome().compareTo(this.raiz.getPessoa().getNome()) < 0){
				if(this.getArvoreEsquerda() == null){
					this.setArvoreEsquerda(new Arvore());
				}
				this.getArvoreEsquerda().inserir(no);
			}else if(no.getPessoa().getNome().compareTo(this.raiz.getPessoa().getNome()) > 0){
				if(this.getArvoreDireita() == null){
					this.setArvoreDireita(new Arvore());
				}
				this.getArvoreDireita().inserir(no);
			}else{
				this.setRaiz(no);
			}
		}		
	}
	
	 public No busca(String nome) {
	        if (this.raiz == null) {
	            return null;
	        } else {
	            if (nome.equals(this.raiz.getPessoa().getNome())) {
	                return this.getRaiz();
	            } else {
	                if (nome.compareTo(this.raiz.getPessoa().getNome()) > 0) {
	                    if (this.arvoreDireita == null) {
	                        return null;
	                    }
	                    return this.arvoreDireita.busca(nome);
	                }else{
	                    if (this.arvoreEsquerda == null) {
	                        return null;
	                    }
	                    return this.arvoreEsquerda.busca(nome);
	                	}
	            	}
	                
	            }
	        }
	        
}
	
	


