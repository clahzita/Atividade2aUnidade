package br.imd.entidade;

import java.util.ArrayList;

public class Arvore {
	private No raiz;

	public Arvore() {
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}

	public boolean isEmpty() {
		return (this.getRaiz() == null) ? true : false;
	}

	public void inserir(No no) {
		if (this.raiz == null) {
			this.raiz = no;
			if (this.raiz.getParent() != null
					&& this.raiz.getParent().getPessoa().getNome().compareTo(this.raiz.getPessoa().getNome()) > 0) {
				this.raiz.setValor(2 * this.raiz.getParent().getValor());
			} else if (this.raiz.getParent() != null
					&& this.raiz.getParent().getPessoa().getNome().compareTo(this.raiz.getPessoa().getNome()) < 0) {
				this.raiz.setValor(2 * this.raiz.getParent().getValor()+1);
			}else{
				this.raiz.setValor(1);
			}

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

	public void remover(No node) {
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
			System.out.println("Nó não existe na arvore");
		}
	}

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

	public Arvore getSubArvore(No no) {
		if (this.buscar(no) != null) {
			Arvore arvRetorno = new Arvore();
			arvRetorno.raiz = this.buscar(no);
			return arvRetorno;
		} else {
			// aqui poderia ter uma exception
			return null;
		}
	}

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

	public No menorNo() {
		No menor = this.getRaiz();
		if (menor == null) {
			return null;
		} else {
			return (this.raiz.getArvEsquerda().getRaiz() == null) ? menor : this.raiz.getArvEsquerda().menorNo();
		}
	}

	public No maiorNo() {
		No maior = this.getRaiz();
		if (maior == null) {
			return null;
		} else {
			return (this.raiz.getArvDireita().getRaiz() == null) ? maior : this.raiz.getArvDireita().maiorNo();
		}
	}

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
