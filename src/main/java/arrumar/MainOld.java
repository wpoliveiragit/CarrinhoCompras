package arrumar;

import java.math.BigDecimal;

public class MainOld {

	public static void main2(String[] args) {
		//testeProduto();
		 //testeItem();
		 testeCarrinhoCompras();
		//testeCarrinhoCompraFactory();
	}

	public static void testeProduto() {
		System.out.println("-Teste Produto ---------");
		long codigo = 100;
		String d = "Tesoura";
		Produto p = new Produto(codigo, d);
		System.out.println("Codigo: " + p.getCodigo());
		System.out.println("Descricao: " + p.getDescricao());
		System.out.println("------------------------");
	}

	public static void testeItem() {
		System.out.println("-Teste Item ------------");

		// item
		long cod = 100;
		String desc = "Colher";
		Produto p01 = new Produto(cod, desc);
		BigDecimal vu01 = new BigDecimal(3.53);
		int qtde01 = 5;
		Item item = new Item(p01, vu01, qtde01);

		// item diferente
		Produto pDif = new Produto(101l, "colher");
		BigDecimal vuDif = new BigDecimal(3.53);
		int qtdeDif = 5;
		Item iDif = new Item(pDif, vuDif, qtdeDif);

		// Item igual
		Produto pIgual = new Produto(cod, desc);
		BigDecimal vuIgual = new BigDecimal(4.53);
		int qtdeIgual = 7;
		Item iIgual = new Item(pIgual, vuIgual, qtdeIgual);

		// Teste Item
		System.out.println("Codigo: " + item.getProduto().getCodigo());
		System.out.println("Descricao: " + item.getProduto().getDescricao());
		System.out.println("Valor Unitario: " + item.getValorUnitario().doubleValue());
		System.out.println("Quantidade: " + item.getQuantidade());
		System.out.println("ValorTotal: " + item.getValorTotal().doubleValue());

		System.out.println("\nProduto diferente: " + item.comparaProduto(iDif.getProduto()));

		System.out.println("\nProduto igual: " + item.comparaProduto(iIgual.getProduto()));

		System.out.println("\nAtulizar item diferente: " + item.atualizaItem(iDif));
		System.out.println("Atulizar item igual: " + item.atualizaItem(iIgual));

		System.out.println("\nCodigo: " + item.getProduto().getCodigo());
		System.out.println("Descricao: " + item.getProduto().getDescricao());
		System.out.println("Valor Unitario: " + item.getValorUnitario().doubleValue());
		System.out.println("Quantidade: " + item.getQuantidade());
		System.out.println("ValorTotal: " + item.getValorTotal().doubleValue());

		System.out.println("------------------------");
	}

	public static void testeCarrinhoCompras() {
		CarrinhoCompras carrinho = new CarrinhoCompras();

		// item 00
		long cod = 100;
		String desc = "Colher";
		Produto p = new Produto(cod, desc);
		BigDecimal vUnit = new BigDecimal(0.55);
		int qtde = 10;
		carrinho.adicionarItem(p, vUnit, qtde);

		// Item 1
		cod = 101;
		desc = "cadeira";
		p = new Produto(cod, desc);
		vUnit = new BigDecimal(1.55);
		qtde = 11;
		carrinho.adicionarItem(p, vUnit, qtde);

		// item 2
		cod = 102;
		desc = "mesa";
		p = new Produto(cod, desc);
		vUnit = new BigDecimal(2.55);
		qtde = 12;
		carrinho.adicionarItem(p, vUnit, qtde);

		// item 3
		cod = 103;
		desc = "palito";
		p = new Produto(cod, desc);
		vUnit = new BigDecimal(3.55);
		qtde = 13;
		carrinho.adicionarItem(p, vUnit, qtde);

		// item 3
		cod = 103;
		desc = "palito";
		p = new Produto(cod, desc);
		vUnit = new BigDecimal(4.56);
		qtde = 3;
		carrinho.adicionarItem(p, vUnit, qtde);

		for (Item i : carrinho.getItens()) {
			String txt = "Codigo: " + i.getProduto().getCodigo();
			txt += "\n-Descricao: " + i.getProduto().getDescricao();
			txt += "\n-Valor Unitario: " + i.getValorUnitario().doubleValue();
			txt += "\n-Quantidade: " + i.getQuantidade();
			txt += "\n-ValorTotal: " + i.getValorTotal().doubleValue();
			txt += "\n";
			System.out.println(txt);
		}

		System.out.println("Valor total Carrinho: " + carrinho.getValorTotal().doubleValue());

		System.out.println("\n Removendo item posicao 8: " + carrinho.removerItem(8));

		System.out.println("\n Removendo item posicao 3: " + carrinho.removerItem(3));

		for (Item i : carrinho.getItens()) {
			String txt = "Codigo: " + i.getProduto().getCodigo();
			txt += "\n-Descricao: " + i.getProduto().getDescricao();
			txt += "\n-Valor Unitario: " + i.getValorUnitario().doubleValue();
			txt += "\n-Quantidade: " + i.getQuantidade();
			txt += "\n-ValorTotal: " + i.getValorTotal().doubleValue();
			txt += "\n";
			System.out.println(txt);
		}
		System.out.println("Valor total Carrinho: " + carrinho.getValorTotal().doubleValue());

		cod = 100;
		desc = "Colher";
		p = new Produto(cod, desc);

		System.out.println("\n Removendo item produto: " + carrinho.removerItem(p) + "\n");
		for (Item i : carrinho.getItens()) {
			String txt = "Codigo: " + i.getProduto().getCodigo();
			txt += "\n-Descricao: " + i.getProduto().getDescricao();
			txt += "\n-Valor Unitario: " + i.getValorUnitario().doubleValue();
			txt += "\n-Quantidade: " + i.getQuantidade();
			txt += "\n-ValorTotal: " + i.getValorTotal().doubleValue();
			txt += "\n";
			System.out.println(txt);
		}
		System.out.println("Valor total Carrinho: " + carrinho.getValorTotal().doubleValue());
	}

	public static void testeCarrinhoCompraFactory() {
		CarrinhoComprasFactory ccf = new CarrinhoComprasFactory();

		String idCliente = "Maria";

		CarrinhoCompras carrinho01 = ccf.criar(idCliente);

		// item 00
		long cod = 100;
		String desc = "Colher";
		Produto p = new Produto(cod, desc);
		BigDecimal vUnit = new BigDecimal(0.55);
		int qtde = 10;
		carrinho01.adicionarItem(p, vUnit, qtde);

		// Item 1
		cod = 101;
		desc = "cadeira";
		p = new Produto(cod, desc);
		vUnit = new BigDecimal(1.55);
		qtde = 11;
		carrinho01.adicionarItem(p, vUnit, qtde);

		idCliente = "Pedro";
		CarrinhoCompras carrinho02 = ccf.criar(idCliente);

		// item 3
		cod = 103;
		desc = "palito";
		p = new Produto(cod, desc);
		vUnit = new BigDecimal(3.55);
		qtde = 13;
		carrinho02.adicionarItem(p, vUnit, qtde);

		// item 3
		cod = 103;
		desc = "palito";
		p = new Produto(cod, desc);
		vUnit = new BigDecimal(4.56);
		qtde = 3;
		carrinho02.adicionarItem(p, vUnit, qtde);

		System.out.println("ValorTicket: " + ccf.getValorTicketMedio().doubleValue());

		System.out.println("Escluindo invalido" + "bela" + ": " + ccf.invalidar("bela"));
		System.out.println("Escluindo invalido" + idCliente + ": " + ccf.invalidar(idCliente));
		System.out.println("ValorTicket: " + ccf.getValorTicketMedio().doubleValue());
	}

}
