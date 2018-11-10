package lab5;

import java.util.List;

public class Combo extends Produto {

	private double fator;
	private List<Produto> produtos;

	public Combo(String nome, String descricao, double fator, List<Produto> produtos) throws Exception {

		super(nome, 0, descricao);
		super.setPreco(calculaPreco(produtos, fator));
		this.fator = fator;
		this.produtos = produtos;

	}

	private double calculaPreco(List<Produto> produtos, double fator) {
		double preco = 0;
		for (Produto produto : produtos) {
			preco += produto.getPreco();
		}

		return preco * (1 - fator);
	}
	
	public void setFator(double novoFator) throws Exception {
		Validator.verificaFator(novoFator, "fator invalido.");
		this.fator = novoFator;
		super.setPreco(calculaPreco(this.produtos, this.fator));
	}

}
