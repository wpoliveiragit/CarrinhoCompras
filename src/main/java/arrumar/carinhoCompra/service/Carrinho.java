package arrumar.carinhoCompra.service;

import arrumar.ItemProdutoException;
import arrumar.ItemQuantidadeException;
import arrumar.ItemValorUnitarioException;
import arrumar.model.Compra;
import arrumar.model.Item;
import arrumar.model.Produto;

//@Service
public class Carrinho {

	private static final String MSG_ERRO_BASE = "[ERRO] Item nao adicionado: ";

	private Compra compra;

	public Carrinho() {
		compra = new Compra();
	}

	private void validaProduto(Produto produto) {
		if (produto == null)
			throw new ItemProdutoException(MSG_ERRO_BASE + "Produto invalido");
		if (produto.getValor().doubleValue() <= 0)
			throw new ItemValorUnitarioException(MSG_ERRO_BASE + "Valor invalido");
	}

	/** Adiciona um item ao carrinho */
	public void addProduto(Produto produto) {
		validaProduto(produto);
		atualizaItem(produto, 1);
	}

	/** Adiciona um item ao carrinho */
	public void addProduto(Produto produto, int quantidade) {
		validaProduto(produto);
		atualizaItem(produto, quantidade);
	}

	/**
	 * Adiciona um produto no carrinho de compras.
	 * 
	 * - Na existencia do produto na lista, será adicionado o valor de +1 a
	 * quantidade do item.
	 * 
	 * - Se o valor do produto adicionado for diferente do valor do produto na
	 * lista, ele devera ser atualizado
	 * 
	 * - Se algum parametro for invalido sera lançada uma subclasse RuntimeException
	 * referente ao tipo da Exception
	 * 
	 * @param produto    O produto n pode ser nulo, em ter o valor menor igual a
	 *                   zero.
	 * @param quantidade A quantidade nao pode ser < 1.
	 */
	private void atualizaItem(Produto produto, int quantidade) {
		if (quantidade < 1) {
			throw new ItemQuantidadeException(MSG_ERRO_BASE + "Quantidade de itens invalida");
		}

		compra.getLista().forEach(n -> {
			if (n.equals((Object) produto)) {
				if (n.getProduto().getValor().doubleValue() != produto.getValor().doubleValue()) {
					n.getProduto().setValor(produto.getValor());
				}
				n.setQuantidade(n.getQuantidade() + quantidade);
				return;
			}
		});

		var item = new Item();
		item.setProduto(produto);
		item.setQuantidade(quantidade);
	}

	/**
	 * Permite a remoção do item do produto no carrinho.
	 *
	 * @param produto
	 * @return false em caso de erro ou falha.
	 */
	public boolean deleteProduto(Produto produto) {
		if (produto == null) {
			return false;
		}
		return compra.getLista().remove((Object) produto);
	}

	/**
	 * Permite a remoção do item de acordo com a posição. Essa posição deve ser
	 * determinada pela ordem de inclusão do produto na coleção, em que zero
	 * representa o primeiro item.
	 *
	 * @param posicaoItem
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no
	 *         carrinho de compras e false caso o produto não exista no carrinho.
	 */
	public boolean deleteItem(int indice) {
		try {
			compra.getLista().remove(indice);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	public Compra getCompra() {
		return compra;
	}

}
