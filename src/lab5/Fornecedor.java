package lab5;

/**
 * Essa classe representa um fornecedor.
 * @author yanka yohana, laboratório de programação 2;
 */


public class Fornecedor implements Comparable<Fornecedor>  {
	

	private ProdutoCRUD produtos;
	/**
	 * String que representa o nome do fornecedor;
	 */
	String nome;
	
	/**
	 * String que representa o email do fornecedor;
	 */
	String email;
	
	/**
	 * String que representa o telefone do fornecedor;
	 */
	String telefone;
	
	/**
	 * Constrói um fornecedor a partir de nome, email e telefone.
	 * @param nome string que representa o nome do fornecedor.
	 * @param email string que representa o email do fornecedor.
	 * @param telefone string que representa o telefone do fornecedor.
	 */
	public Fornecedor(String nome, String email, String telefone) {
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
	 * @param parametro
	 * @param valor
	 */
	public void editarParametro(String parametro, String valor) {
		
		switch(parametro) {
		case "telefone": 
			this.setTelefone(valor);
			break;
		case "email": 
			this.setEmail(valor);
			break;
		}
	}
	
	public void adicionaProduto(String nome, double preco, String descricao) {
		this.produtos.createProduto(nome, preco, descricao);
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

}
