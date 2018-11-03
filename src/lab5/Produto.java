package lab5;

/**
 * Essa classe representa um produto.
 * 
 * @author yanka yohana,
 *
 */

import java.text.DecimalFormat;

public class Produto implements Comparable<Produto> {
	
	/**
	 * String que representa o nome de um produto
	 */
	private String nome;
	
	/**
	 * double que representa que representa o preço de um produto.
	 */
	private double preco;
	
	/**
	 * String que a descrição de um produto.
	 */
	private String descricao;
	
	/**
	 * Constrói um produto.
	 * @param nome uma string que representa o  
	 * @param preco
	 * @param descricao
	 * @throws Exception
	 */
	public Produto(String nome, double preco, String descricao) throws Exception {
		
		Validator.verificaString(nome, "nome nao pode ser vazio ou nulo.");
		Validator.verificaDouble(preco, "preco invalido.");
		Validator.verificaString(descricao, "descricao nao pode ser vazia ou nula.");
		
		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		
	}

	public String getNome() {
		return nome;
	}

	public double getPreco() {
		return preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	/**
	 * Compara o nome deste forncedor com outro alfabeticamente;
	 */
	public int compareTo(Produto other) {
		return this.nome.compareTo(other.nome);
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	/**
	 * Retorna uma string que representa um produto.
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return this.nome + " - " + this.descricao + " - " + "R$" + df.format(this.preco);
	}

}
