package br.com.wellington.carrinhoCompras.utils;

import java.math.BigDecimal;

/** Controle de carrinhos carrinho de cinoras. */
public abstract class CarrinhoComprasFactory {

	/**
	 * Cria um novo carrinho de compras.
	 * 
	 * @param idCliente
	 *                      O id do cliente.
	 * @return CarrinhoCompras retorna o novo carrinho de compras, caso o idCliente ja esteja
	 *         atrelado um carrinho, este carrinho de compras deverá ser retornado.
	 */
	abstract public CarrinhoCompras criar(String idCliente);

	/**
	 * Retorna o valor médio das compras contidas nos carrinhos.
	 * 
	 * CALCULO: Somatório do valor total de cada carrinhos de compra dividido pela quantidade de
	 * carrinhos de compras.
	 *
	 * @return BigDecimal O valor médio das compras contidas nos carrinhos de compra. Este valor
	 *         será ajustado para duas casas decimais e segirá a regra de entre 0-4 arredonda para
	 *         baixo e entre 5-9 arredonda para cima.
	 */
	abstract public BigDecimal getmediaCompras();

	/**
	 * Invalida um carrinho de compras a partir do idCliente.
	 *
	 * @param idCliente
	 *                      Id do cliente
	 * @return false caso o cliente não possua um carrinho de compras.
	 */
	abstract public boolean invalidar(String idCliente);
}
