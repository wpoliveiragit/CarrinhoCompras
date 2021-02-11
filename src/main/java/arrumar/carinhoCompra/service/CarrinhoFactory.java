package arrumar.carinhoCompra.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** responsável pela criação e recuperação dos carrinhos de compras. */
public class CarrinhoFactory {

	/** A lista de carrinhos de compras. */
	private Map<String, Carrinho> listaCarrinhos = new HashMap<>();

	/**
	 * Cria e retorna um novo carrinho de compras para o cliente passado como
	 * parâmetro.
	 *
	 * Caso já exista um carrinho de compras para o cliente passado como parâmetro,
	 * este carrinho deverá ser retornado.
	 *
	 * @param identificacaoCliente
	 * @return CarrinhoCompras null em caso de codigo invalido
	 */
	public Carrinho obterCarrinho(String codigo) {
		if (codigo == null) {// valida codigo
			return null;
		}
		Carrinho carrinho = listaCarrinhos.get(codigo);
		if (carrinho == null) {
			return listaCarrinhos.put(codigo, new Carrinho());
		}
		return carrinho;
	}

	/**
	 * Retorna o valor do ticket médio no momento da chamada ao método.
	 * 
	 * O valor do ticket médio é a soma do valor total de todos os carrinhos de
	 * compra dividido pela quantidade de carrinhos de compra.
	 * 
	 * O valor retornado deverá ser arredondado com duas casas decimais, seguindo a
	 * regra: 0-4 deve ser arredondado para baixo e 5-9 deve ser arredondado para
	 * cima.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal mediaTicketCarrinhos() {
		BigDecimal media = new BigDecimal(0);
		Set<String> keys = listaCarrinhos.keySet();
		for (String i : keys) {// somatorio
			media.add(listaCarrinhos.get(i).getCompra().getValorTotal());
		}
		return media.divide(new BigDecimal(listaCarrinhos.size()), 2, RoundingMode.HALF_UP);

	}

	public boolean invalidar(String codigo) {
		if (codigo == null) {
			return false;
		}
		return listaCarrinhos.remove(codigo) == null ? false : true;
	}

}
