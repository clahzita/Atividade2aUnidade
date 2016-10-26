package br.imd.entidade;

public class Arvore {

	private No raiz;
	private Arvore arvoreEsquerda;
	private Arvore arvoreDireita;

	public Arvore() {

	}

	public boolean isEmpty() {
		return (this.getRaiz() == null) ? true : false;
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz, No pai) {
		this.raiz.setPai(pai);
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

	public void inserir(No no) {
		if (this.raiz == null) {
			this.raiz = no;
		} else {
			// "a".compareTo("b"); retorna um numero negativo, exemplo -1
			// "a".compareTo("a"); retorna 0
			// "b".compareTo("a"); retorna um numero positivo, exemplo 1
			if (no.getPessoa().getNome().compareTo(this.raiz.getPessoa().getNome()) < 0) {
				if (this.getArvoreEsquerda() == null) {
					this.setArvoreEsquerda(new Arvore());
				}
				no.setPai(this.raiz);
				this.getArvoreEsquerda().inserir(no);
			} else if (no.getPessoa().getNome().compareTo(this.raiz.getPessoa().getNome()) > 0) {
				if (this.getArvoreDireita() == null) {
					this.setArvoreDireita(new Arvore());
				}
				no.setPai(this.raiz);
				this.getArvoreDireita().inserir(no);
			} else {
				No raiz_aux = this.getRaiz().getPai();
				this.setRaiz(no, raiz_aux);
			}
		}
	}
	//TODO remover o nozinho
	public void remover(No no) {
		if (this.raiz == null) {
			System.out.println("Nó não existe"); // aqui pode ter Exceptions
		} else {
			if (no.getPessoa().getNome().compareTo(this.getRaiz().getPessoa().getNome()) < 0) {
				this.getArvoreEsquerda().remover(no);
			} else if (no.getPessoa().getNome().compareTo(this.getRaiz().getPessoa().getNome()) > 0) {
				this.getArvoreDireita().remover(no);
			} else {
				// Aqui a mágica deve acontecer
			}
		}
	}

	// Testar isso urgente ;)
	public int altura(Arvore a) {
		if (a.isEmpty()) {
			return -1;
		} else {
			int alturaEsq = altura(a.arvoreEsquerda);
			int alturaDir = altura(a.arvoreDireita);
			return (alturaEsq < alturaDir) ? alturaDir + 1 : alturaEsq + 1;
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
				} else {
					if (this.arvoreEsquerda == null) {
						return null;
					}
					return this.arvoreEsquerda.busca(nome);
				}
			}
		}
	}

	public No menorNo(Arvore a) {
		No menor = this.getRaiz();
		if (menor == null) {
			return null;
		} else {
			return (a.arvoreEsquerda.getRaiz() == null) ? menor : this.menorNo(a.getArvoreEsquerda());
		}
	}

	public No maiorNo(Arvore a) {
		No maior = this.getRaiz();
		if (maior == null) {
			return null;
		} else {
			return (a.arvoreDireita.getRaiz() == null) ? maior : this.maiorNo(a.getArvoreDireita());
		}
	}

	public void preOrder(Arvore arv) {
		if (arv.getRaiz() != null) {
			System.out.print(arv.getRaiz().getPessoa().getNome() + " ");
			preOrder(arv.arvoreEsquerda);
			preOrder(arv.arvoreDireita);
		}
	}

	public void posOrder(Arvore arv) {
		if (arv.getRaiz() != null) {
			posOrder(arv.getArvoreEsquerda());
			posOrder(arv.getArvoreDireita());
			System.out.println(arv.getRaiz().getPessoa().getNome() + " ");
		}
	}

	public void inOrder(Arvore arv) {
		if (arv.getRaiz() != null) {
			inOrder(arv.getArvoreEsquerda());
			System.out.println(arv.getRaiz().getPessoa().getNome() + " ");
			inOrder(arv.getArvoreDireita());
		}
	}

}