package arrumar;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CarrinhoCompras {

	private static final String BASE_ERRO_ADD_ITEM = "Problemas ao adicionar o item";
	private List<Item> listaItens;	

	public CarrinhoCompras() {
		listaItens = new ArrayList<Item>();
	}

	/**
	 * Permite a adição de um novo item no carrinho de compras.
	 *
	 * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser
	 * seguidas:
	 * 
	 * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como
	 * parâmetro.
	 * 
	 * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor
	 * unitário do item deverá ser o passado como parâmetro.
	 *
	 * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao
	 * carrinho de compras.
	 *
	 * @param produto
	 * @param valorUnitario
	 * @param quantidade
	 */
	public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade)
			throws RuntimeException {

		// O profuto não pode ser nulo
		if (produto == null) {
			throw new ItemProdutoException(BASE_ERRO_ADD_ITEM + "-Produto invalido");
		}

		// O valor unitario não pode ser nulo e menor que zero
		if (valorUnitario == null || valorUnitario.doubleValue() < 0) {
			throw new ItemValorUnitarioException(BASE_ERRO_ADD_ITEM + "-Valor Unitário inválido");
		}

		// O item adicionado não pode ter uma quantidade negativa
		if (quantidade < 1) {
			throw new ItemQuantidadeException(BASE_ERRO_ADD_ITEM + "-Quantidade Inválida");
		}

		Item item = new Item(produto, valorUnitario, quantidade);

		// Verifica se o item já existe no carrinho.
		for (Item i : listaItens) {
			if (i.atualizaItem(item)) {
				return; // item atualizado
			}
		}

		// O novo item foi adicionado no carrinho
		listaItens.add(new Item(produto, valorUnitario, quantidade));
	}

	/**
	 * Permite a remoção do item que representa este produto do carrinho de compras.
	 *
	 * @param produto
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e
	 *         false caso o produto não exista no carrinho.
	 */
	public boolean removerItem(Produto produto) {

		if (produto == null) {
			return false;// produto invalido
		}

		for (int i = 0; i < listaItens.size(); i++) {
			Item item = listaItens.get(i);
			if (item.comparaProduto(produto)) {
				listaItens.remove(i);
				return true;// item removido com sucesso
			}
		}
		// item não encontrado
		return false;
	}

	/**
	 * Permite a remoção do item de acordo com a posição. Essa posição deve ser determinada pela
	 * ordem de inclusão do produto na coleção, em que zero representa o primeiro item.
	 *
	 * @param posicaoItem
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e
	 *         false caso o produto não exista no carrinho.
	 */
	public boolean removerItem(int posicaoItem) {
		try {
			listaItens.remove(posicaoItem);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	/**
	 * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais de todos
	 * os itens que compõem o carrinho.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTotal() {
		BigDecimal total = new BigDecimal(0);
		for (Item i : listaItens) {
			total = total.add(i.getValorTotal());
		}
		return total;
	}

	/**
	 * Retorna a lista de itens do carrinho de compras.
	 *
	 * @return itens
	 */
	public Collection<Item> getItens() {
		return listaItens;
	}
}