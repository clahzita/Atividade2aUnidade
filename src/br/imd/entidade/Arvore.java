package br.imd.entidade;

import java.util.ArrayList;

import br.imd.exceptions.NodeNotFoundedException;

/**
 * Classe para objetos do tipo Pessoa, em que serão contidos valores e métodos.
 * 
 * @author Clarissa Soares / Paulo Henrique Lopes
 * @version 1.0
 * @since #20161025
 */
public class Arvore {
	private No raiz;

	public Arvore() {

	}

	/**
	 * Método que retorna a raiz de uma dada árvore
	 * 
	 * @return raiz da arvore
	 */
	public No getRaiz() {
		return raiz;
	}

	/**
	 * Método que valora a raiz de uma árvore.
	 * 
	 * @param raiz
	 */
	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	/**
	 * Método que verifica se a raiz tem Pessoa.
	 * 
	 * @return true caso a raiz esteja disponível.
	 * @return false caso a raiz esteja ocupada.
	 */
	public boolean isEmpty() {
		return (this.getRaiz() == null) ? true : false;
	}

	public void inserir(No no) {
		if (this.raiz == null) {
			this.raiz = no;
			// valorando os nós
			if (this.raiz.getParent() != null
					&& this.raiz.getParent().getPessoa().getNome().compareTo(this.raiz.getPessoa().getNome()) > 0) {
				this.raiz.setValor(2 * this.raiz.getParent().getValor());
			} else if (this.raiz.getParent() != null
					&& this.raiz.getParent().getPessoa().getNome().compareTo(this.raiz.getPessoa().getNome()) < 0) {
				this.raiz.setValor(2 * this.raiz.getParent().getValor() + 1);
			} else {
				this.raiz.setValor(1);
			}

		} else if (this.raiz.getPessoa().getNome().equals(no.getPessoa().getNome())) {
			this.raiz.setPessoa(no.getPessoa());

		} else {
			if (no.getPessoa().getNome().compareTo(this.raiz.getPessoa().getNome()) > 0) {
				if (this.raiz.getArvDireita() == null) {
					this.raiz.setArvDireita(new Arvore());
				}
				no.setParent(this.raiz);
				this.raiz.getArvDireita().inserir(no);
			} else if (no.getPessoa().getNome().compareTo(this.raiz.getPessoa().getNome()) < 0) {
				if (this.raiz.getArvEsquerda() == null) {
					this.raiz.setArvEsquerda(new Arvore());
				}
				no.setParent(this.raiz);

				this.raiz.getArvEsquerda().inserir(no);
			}
		}
	}

	/**
	 * Metodo usado para remover um Nó da árvore.
	 * 
	 * @param node
	 */
	public void remover(No node) throws NodeNotFoundedException {
		if (this.buscar(node) != null) {
			ArrayList<No> arvoreEmArray = new ArrayList<No>();
			this.inserirNoArray(arvoreEmArray);
			Arvore aux = new Arvore();
			System.out.println("Removendo: " + node.getPessoa().getNome());
			for (No no : arvoreEmArray) {
				if (no.getPessoa().getNome().compareTo(node.getPessoa().getNome()) != 0) {
					no.setArvDireita(new Arvore());
					no.setArvEsquerda(new Arvore());
					no.setParent(null);
					aux.inserir(no);
				}
			}
			this.setRaiz(aux.getRaiz());
		} else {
			throw new NodeNotFoundedException(node.getPessoa().getNome() + " não foi encontrado na arvore!");

		}
	}

	/**
	 * Metodo para buscar um No na arvore
	 * 
	 * @param no
	 * @return no encontrado na arvore
	 */
	public No buscar(No no) {
		if (this.raiz == null) {
			return null;
		} else {
			if (no.getPessoa().getNome().equals(this.raiz.getPessoa().getNome())) {
				return this.getRaiz();
			} else {
				if (no.getPessoa().getNome().compareTo(this.raiz.getPessoa().getNome()) < 0) {
					if (this.raiz.getArvEsquerda() == null) {
						return null;
					}
					return this.raiz.getArvEsquerda().buscar(no);
				} else {
					if (this.raiz.getArvDireita() == null) {
						return null;
					}
					return this.raiz.getArvDireita().buscar(no);
				}
			}
		}
	}

	/**
	 * Metodo para gerar uma subárvore
	 * @param no
	 * @return arvRetorno
	 */
	public Arvore getSubArvore(No no) {
		if (this.buscar(no) != null) {
			Arvore arvRetorno = new Arvore();
			arvRetorno.raiz = this.buscar(no);
			return arvRetorno;
		} else {
			
			return null;
		}
	}

	/**
	 * Retorna a altura da árvore
	 * 
	 * @return hd+1
	 * @return he +1
	 */
	public int altura() {
		if (this.getRaiz() == null) {
			return -1; // altura da árvore vazia
		} else {
			int he = this.raiz.getArvEsquerda().altura();
			int hd = this.raiz.getArvDireita().altura();

			if (he < hd) {
				return hd + 1;
			} else {
				return he + 1;
			}
		}
	}

	/**
	 * Metodo para calcular a profundidade de um nó em uma arvore
	 * 
	 * @param no
	 * @return contador
	 */
	public int profundidade(No no) {
		int contador = 0;
		if (this.buscar(no) != null) {
			no = this.buscar(no);
			while (no.getParent() != null) {
				contador += 1;
				no = no.getParent();
			}
		}
		return contador;
	}

	/**
	 * Método que retorna o menor valor na arvore
	 * 
	 * @return menor
	 */
	public No menorNo() {
		No menor = this.getRaiz();
		if (menor == null) {
			return null;
		} else {
			return (this.raiz.getArvEsquerda().getRaiz() == null) ? menor : this.raiz.getArvEsquerda().menorNo();
		}
	}

	/**
	 * Método que retorna o maior valor na árvore.
	 * 
	 * @return maior
	 */
	public No maiorNo() {
		No maior = this.getRaiz();
		if (maior == null) {
			return null;
		} else {
			return (this.raiz.getArvDireita().getRaiz() == null) ? maior : this.raiz.getArvDireita().maiorNo();
		}
	}

	/**
	 * Método que transforma a árvore em array.
	 * 
	 * @param arvoreEmArray
	 */
	public void inserirNoArray(ArrayList<No> arvoreEmArray) {
		if (this.raiz == null) {

		}
		arvoreEmArray.add(this.getRaiz());
		if (this.raiz.getArvEsquerda() != null) {
			this.raiz.getArvEsquerda().inserirNoArray(arvoreEmArray);
		}
		if (this.raiz.getArvDireita() != null) {
			this.raiz.getArvDireita().inserirNoArray(arvoreEmArray);
		}

	}

	/**
	 * Método para imprimir a árvore em preordem dos elementos
	 */
	public void preOrder() {
		if (this.raiz == null) {
			return;
		}
		System.out.println("Nome: " + this.raiz.getPessoa().getNome());
		if (this.raiz.getArvEsquerda() != null) {
			this.raiz.getArvEsquerda().preOrder();
		}
		if (this.raiz.getArvDireita() != null) {
			this.raiz.getArvDireita().preOrder();
		}
	}

	/**
	 * Método para imprimir a árvore em ordem dos elementos.
	 */
	public void inOrder() {
		if (this.raiz == null) {
			return;
		}

		if (this.raiz.getArvEsquerda() != null) {
			this.raiz.getArvEsquerda().inOrder();
		}
		System.out.println("Nome: " + this.raiz.getPessoa().getNome());
		if (this.raiz.getArvDireita() != null) {
			this.raiz.getArvDireita().inOrder();
		}
	}

	/**
	 * Método para imprimir a árvore em pós ordem dos elementos.
	 */
	public void posOrder() {
		if (this.raiz == null) {
			return;
		}

		if (this.raiz.getArvEsquerda() != null) {
			this.raiz.getArvEsquerda().inOrder();
		}
		if (this.raiz.getArvDireita() != null) {
			this.raiz.getArvDireita().inOrder();
		}
		System.out.println("Nome: " + this.raiz.getPessoa().getNome());
	}

}
