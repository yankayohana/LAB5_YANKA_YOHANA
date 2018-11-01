package lab5;

/**
 * Essa classe representa um cliente.
 * @author yanka yohana, laboratório de programaçao 2;
 *
 */

public class Cliente implements Comparable<Cliente> {

	/**
	 * String que representa o cpf do cliente;
	 */
	private String cpf;
	
	/**
	 * String que representa o nome do cliente;
	 */
	private String nome;
	
	/**
	 * String que representa o email do cliente;
	 */
	private String email;
	
	/**
	 * String que representa a localização do cliente;
	 */
	private String localizacao;
	
	/**
	 * Constrói um cliente a partir do cpf, nome, email e localização;
	 * @param cpf uma string que representa o cpf do cliente;
	 * @param nome uma string que representa o nome de um cliente;
	 * @param email uma string que representa o email de um cliente;
	 * @param localizacao uma string que representa a localização do cliente;
	 * @throws Exception 
	 */
	
	public Cliente(String cpf, String nome, String email, String localizacao) throws Exception {
		
		Validator.verificaString(cpf, "cpf invalido.");
		Validator.verificaString(nome, "nome nao pode ser vazio ou nulo.");
		Validator.verificaString(email, "nome nao pode ser vazio ou nulo");
		
		
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.localizacao = localizacao;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getLocalizacao() {
		return localizacao;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	/**
	 * Compara o nome deste cliente com outro alfabeticamente; 
	 */
	public int compareTo(Cliente other) { 
		return this.nome.compareTo(other.nome); 
	}
	
	/**
	 * Edita os atributos do cliente;
	 * @param parametro
	 * @param valor
	 */
	public void editarParametro(String parametro, String valor) {
		
		switch(parametro) {
		case "nome": 
			this.setNome(valor);
			break;
		case "email": 
			this.setEmail(valor);
			break;
		case "localizacao":
			this.setLocalizacao(valor);
			break;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((localizacao == null) ? 0 : localizacao.hashCode());
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
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (localizacao == null) {
			if (other.localizacao != null)
				return false;
		} else if (!localizacao.equals(other.localizacao))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	/**
	 * Retorna uma string que representa um cliente.
	 */
	public String toString() {
		return this.nome + " - " + this.localizacao + " - " + this.email;
	}

}
