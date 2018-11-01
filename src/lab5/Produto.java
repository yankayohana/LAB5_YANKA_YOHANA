package lab5;

/**
 * Essa classe representa um produto.
 * 
 * @author yanka yohana,
 *
 */
public class Produto implements Comparable<Produto> {

	String nome;
	double preco;
	String descricao;

	public Produto(String nome, double preco, String descricao) {
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
		long temp;
		temp = Double.doubleToLongBits(preco);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		if (Double.doubleToLongBits(preco) != Double.doubleToLongBits(other.preco))
			return false;
		return true;
	}

	public String toString() {
		return this.nome + " - " + this.descricao + " - " + "R$" + this.preco;
	}

}
