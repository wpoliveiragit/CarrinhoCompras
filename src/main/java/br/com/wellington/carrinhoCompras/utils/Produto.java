package br.com.wellington.carrinhoCompras.utils;

/** Representa um produto */
public abstract  class Produto {

	protected Long codigo;
	protected String descricao;

	/**
	 * Cria um novo produto.
	 *
	 * @param codigo O codigo do produto.
	 * @param descricao A descrição do produto.
	 */
	public Produto(Long codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	/**
	 * Retorna o código do produto.
	 *
	 * @return Long O codigo do produto.
	 */
	abstract public Long getCodigo();

	/**
	 * Retorna a descrição do produto.
	 *
	 * @return String A descrição do produto.
	 */
	abstract public String getDescricao();
}