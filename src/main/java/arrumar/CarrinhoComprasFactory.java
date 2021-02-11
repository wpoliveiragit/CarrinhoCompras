package arrumar;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Set;

/** responsável pela criação e recuperação dos carrinhos de compras. */
public class CarrinhoComprasFactory {

	/** A lista de carrinhos de compras. */
	private HashMap<String, CarrinhoCompras> listaCarrinhos = new HashMap<>();

	/**
	 * Cria e retorna um novo carrinho de compras para o cliente passado como
	 * parâmetro.
	 *
	 * Caso já exista um carrinho de compras para o cliente passado como parâmetro,
	 * este carrinho deverá ser retornado.
	 *
	 * @param identificacaoCliente
	 * @return CarrinhoCompras
	 */
	public CarrinhoCompras criar(String identificacaoCliente) {

		// Verifica se o carrinho ja foi criado
		identificacaoCliente = identificacaoCliente.toUpperCase();
		String codigo = identificacaoCliente;

		Set<String> keys = listaCarrinhos.keySet();

		for (String i : keys) {
			if (codigo == i) {
				return listaCarrinhos.get(codigo);
			}
		}

		// Cria um novo carrinho de compras
		CarrinhoCompras cc = new CarrinhoCompras();
		listaCarrinhos.put(codigo, cc);
		return cc;

	}

	/**
	 * Retorna o valor do ticket médio no momento da chamada ao método. O valor do
	 * ticket médio é a soma do valor total de todos os carrinhos de compra dividido
	 * pela quantidade de carrinhos de compra. O valor retornado deverá ser
	 * arredondado com duas casas decimais, seguindo a regra: 0-4 deve ser
	 * arredondado para baixo e 5-9 deve ser arredondado para cima.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTicketMedio() {

		BigDecimal media = new BigDecimal(0);

		Set<String> keys = listaCarrinhos.keySet();
		for (String i : keys) {// somatorio
			media = media.add(listaCarrinhos.get(i).getValorTotal());
		}

		return media.divide(new BigDecimal(listaCarrinhos.size()), 2, RoundingMode.HALF_UP);// media

	}

	/**
	 * Invalida um carrinho de compras quando o cliente faz um checkout ou sua
	 * sessão expirar. Deve ser efetuada a remoção do carrinho do cliente passado
	 * como parâmetro da listagem de carrinhos de compras.
	 *
	 * @param identificacaoCliente
	 * @return Retorna um boolean, tendo o valor true caso o cliente passado como
	 *         parämetro tenha um carrinho de compras e false caso o cliente não
	 *         possua um carrinho.
	 */
	public boolean invalidar(String identificacaoCliente) {
		return listaCarrinhos.remove(identificacaoCliente.toUpperCase()) == null ? false : true;
	}
}
