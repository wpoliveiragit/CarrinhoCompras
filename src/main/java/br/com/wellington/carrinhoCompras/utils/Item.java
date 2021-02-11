package br.com.wellington.carrinhoCompras.utils;

import java.math.BigDecimal;

/** Classe que representa um item no carrinho de compras. */
public abstract class Item {

	protected Produto produto;
	protected BigDecimal valorUnitario;
	protected int quantidade;

	/**
	 * Cria um novo item.
	 * 
	 * @param produto O produto.
	 * @param valorUnitario O valor unitario do item.
	 * @param quantidade A quantidade de itens .
	 */
	public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}

	/**
	 * Retorna o produto.
	 *
	 * @return Produto o produto.
	 */
	abstract public Produto getProduto();

	/**
	 * Retorna o valor unitário do item.
	 *
	 * @return BigDecimal O valor unitário do item.
	 */
	abstract public BigDecimal getValorUnitario();

	/**
	 * Retorna a quantidade de itens do produto.
	 *
	 * @return int A quantidade de itens do produto.
	 */
	abstract public int getQuantidade();

	/**
	 * Retorna o valor total do item.
	 *
	 * @return BigDecimal
	 */
	abstract public BigDecimal getValorTotal();
}
