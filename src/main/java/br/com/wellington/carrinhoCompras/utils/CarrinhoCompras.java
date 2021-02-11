package br.com.wellington.carrinhoCompras.utils;

import java.math.BigDecimal;
import java.util.Collection;

/** Assinatura do carrinho de compras. */
public interface CarrinhoCompras {

	/**
	 * Adiciona um item ao carrinho de compras.
	 * 
	 * = CASO JÁ EXISTA O ITEM NO CARRINHO DE COMPRAS =
	 * -> Desevá ser adicionamo a quantidade passada por parâmetro.
	 * -> Se o valorUnitario do parametro for diferente do valorUnitario, o valorUnitario deverá
	 * ser substituido pelo do parâmetro.
	 * -> Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao
	 * carrinho de compras.
	 *
	 * @param produto O produto.
	 * @param valorUnitario O valor unitário do produto
	 * @param quantidade a quantidade deste produto adicionado no carrinho.
	 */
	public void addItens(Produto produto, BigDecimal valorUnitario, int quantidade) ;

	/**
	 * Permite a remoção do item que representa este produto do carrinho de compras.
	 *
	 * @param produto O item a ser removido.
	 * @return false caso o produto nao exista no carrinho de compras.
	 */
	public boolean removerItem(Produto produto);

	/**
	 * Permite a remoção do item de acordo com a posição. Essa posição deve ser determinada pela
	 * ordem de inclusão do produto na coleção, em que zero representa o primeiro item.
	 *
	 * @param indice Indice do produto.
	 * @return false caso o item não exista no carrinho de compras.
	 */
	public boolean removerItem(int indice);

	/**
	 * Retorna o valor total do carrinho de compras.
	 *
	 * @return BigDecimal O valor total do carrinho de compras.
	 */
	public BigDecimal getValorTotal();

	/**
	 * Retorna a lista de itens do carrinho de compras.
	 *
	 * @return itens Uma lista contendo os itens inseridos no carrinho de compras.
	 */
	public Collection<Item> getItens();
}