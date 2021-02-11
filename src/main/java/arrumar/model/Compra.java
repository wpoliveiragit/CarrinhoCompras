package arrumar.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Compra {

	private List<Item> lista;

	public Compra() {
		lista = new ArrayList<>();
	}

	/**
	 * Retorna o valor total do carrinho de compras que deve ser a soma dos valores
	 * totais de todos os itens que compõem o carrinho.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTotal() {
		BigDecimal total = new BigDecimal(0);
		for (Item i : lista) {
			total.add(new BigDecimal(i.getQuantidade() * i.getProduto().getValor().doubleValue()));
		}
		return total;
	}

	public List<Item> getLista() {
		return lista;
	}

	public void setLista(List<Item> lista) {
		this.lista = lista;
	}

}
