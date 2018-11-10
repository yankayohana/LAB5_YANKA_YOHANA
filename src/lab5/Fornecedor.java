package lab5;

import java.util.List;

/**
 * Essa classe representa um fornecedor.
 * 
 * @author yanka yohana, laboratório de programação 2;
 */

public class Fornecedor implements Comparable<Fornecedor> {

	private ProdutoCRUD produtos;
	/**
	 * String que representa o nome do fornecedor;
	 */
	private String nome;

	/**
	 * String que representa o email do fornecedor;
	 */
	private String email;

	/**
	 * String que representa o telefone do fornecedor;
	 */
	private String telefone;

	/**
	 * Constrói um fornecedor a partir de nome, email e telefone.
	 * 
	 * @param nome     string que representa o nome do fornecedor.
	 * @param email    string que representa o email do fornecedor.
	 * @param telefone string que representa o telefone do fornecedor.
	 * @throws Exception
	 */
	public Fornecedor(String nome, String email, String telefone) throws Exception {

		Validator.verificaString(nome, "nome nao pode ser vazio ou nulo.");
		Validator.verificaString(email, "email nao pode ser vazio ou nulo.");
		Validator.verificaString(telefone, "telefone nao pode ser vazio ou nulo");

		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.produtos = new ProdutoCRUD();

	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Compara o nome deste forncedor com outro alfabeticamente;
	 */
	public int compareTo(Fornecedor other) {
		return this.nome.compareTo(other.nome);
	}

	/**
	 * Edita os atributos do fornecedor;
	 * 
	 * @param parametro
	 * @param valor
	 * @throws Exception
	 */
	public void editarParametro(String parametro, String valor) throws Exception {

		Validator.verificaString(parametro, "atributo nao pode ser vazio ou nulo.");
		Validator.verificaString(valor, "novo valor nao pode ser vazio ou nulo.");

		switch (parametro) {
		case "telefone":
			this.setTelefone(valor);
			break;
		case "email":
			this.setEmail(valor);
			break;
		case "nome":
			throw new Exception("nome nao pode ser editado.");
		default:
			throw new Exception("atributo nao existe.");
		}
	}

	/**
	 * adiciona um produto.
	 * 
	 * @param nome      string que representa o nome de um produto.
	 * @param descricao string que representa a descrição.
	 * @param preco     double que representa o preço do produto.
	 * @throws Exception
	 */
	public void adicionaProduto(String nome, String descricao, double preco) throws Exception {
		this.produtos.createProduto(nome, preco, descricao);
	}

	/**
	 * exibe um produto
	 * 
	 * @return retorna a string de um produto.
	 */
	public String exibeProdutos() {
		return this.produtos.exibeProdutos();
	}

	/**
	 * edita o preco de um produto
	 * 
	 * @param nome  string que representa o nome de um produto
	 * @param preco double que representa o preco de um produto
	 * @throws Exception
	 */
	public void editaPrecoProdutos(String nome, String descricao, String nomeFornecedor,  double precoNovo) throws Exception {
		this.produtos.editaPreco(nome, descricao, nomeFornecedor, precoNovo);
	}

	public String exibeProduto(String nome, String descricao) throws Exception {
		return this.produtos.exibeProduto(nome);
	}

	public void removeProduto(String nome, String descricao) throws Exception {
		this.produtos.removeProduto(nome, descricao);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	/**
	 * Retorna uma string que representa um fornecedor.
	 */
	public String toString() {
		return this.nome + " - " + this.email + " - " + this.telefone;
	}

	public String listaProdutos() {
		String retorno = "";
		int contador = 0;
		List<String> lista = this.produtos.getToStringProdutos();
		for (String toStringProduto : this.produtos.getToStringProdutos()) {
			if (contador < lista.size()-1) {
				retorno += this.nome + " - " + toStringProduto + " | ";
			}
			if (contador == lista.size()-1) {
				retorno +=  this.nome + " - " + toStringProduto;
			}
			contador += 1;
		}
		return retorno;
	}
	
	/////////////// combo ////////////////
	
	public void cadastraCombo(String nome, String descricao, double fator, String produtos) throws Exception {
		this.produtos.cadastraCombo(nome, descricao, fator, produtos);
	}
	
	public void editaCombo(String nome, String descricao, double novoFator) throws Exception {
		this.produtos.editaCombo(nome, descricao, novoFator);
	}
	
	public double calculaPrecoConta(String nome, String descricao) throws Exception {
		return this.produtos.calculaPreco(nome, descricao);
	}

}
