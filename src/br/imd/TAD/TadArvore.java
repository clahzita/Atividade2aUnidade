package br.imd.TAD;

import br.imd.entidade.No;

public interface TadArvore<C> {
	int size(C a);
	boolean isEmpty(C a);
	
	No root(C a);
	No parent(C a, No no);
	No children(C a, No no);
	boolean isInternal(C a,No no);
	boolean isExternal(C a,No no);
	boolean isRoot(C a,No no);
	
	void swap(C a, No p, No q);
	void replace(C a,No p, No q);
	
	
}
