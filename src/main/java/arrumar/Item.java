package arrumar;

import java.math.BigDecimal;

public class Item {

	private Produto produto;
	private BigDecimal valorUnitario;
	private int quantidade;

	public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValorTotal() {
		return valorUnitario.multiply(new BigDecimal(quantidade));
	}

	public boolean comparaProduto(Produto produto) {
		return this.produto.getCodigo() == produto.getCodigo();
	}

	public boolean atualizaItem(Item item) {
		if (comparaProduto(item.getProduto())) {
			quantidade += item.getQuantidade();
			valorUnitario = item.getValorUnitario();
			return true;
		}
		return false;
	}

}
