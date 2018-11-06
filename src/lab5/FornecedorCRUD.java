package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Essa classe representa um crud de fornecedor.
 * 
 * @author yanka yohana, laboratório de programação 2.
 *
 */

public class FornecedorCRUD {

	/**
	 * Um mapa de forncedores.
	 */
	Map<String, Fornecedor> fornecedores;

	/**
	 * cria um fornecedor CRUD
	 */
	public FornecedorCRUD() {
		this.fornecedores = new HashMap<>();
	}

	/**
	 * Cria um fornecedor.
	 * 
	 * @param nome     uma string que representa o nome de um fornecedor.
	 * @param email    uma string que representa o email de um forncedor.
	 * @param telefone uma string que representa o telefone de um forcenedor.
	 * @throws Exception
	 */
	public void createFornecedor(String nome, String email, String telefone) throws Exception {
		if (fornecedores.containsKey(nome)) {
			throw new Exception("fornecedor ja existe.");
		} else {
			Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
			fornecedores.put(nome, fornecedor);
		}

	}

	/**
	 * retorno o to string de um fornecedor.
	 * 
	 * @param nome
	 * @return
	 */
	public String readFornecedor(String nome) {
		return fornecedores.get(nome).toString();
	}

	/**
	 * retorna uma lisda de fornecedores ordenados.
	 * 
	 * @return
	 */
	public List<Fornecedor> getfornecedoresOrdenados() {
		List<Fornecedor> fornecedoresOrdenados = new ArrayList<>(this.fornecedores.values());
		Collections.sort(fornecedoresOrdenados);
		return fornecedoresOrdenados;
	}

	/**
	 * edita um fornecedor
	 * 
	 * @param nome
	 * @param parametro
	 * @param valor
	 * @throws Exception
	 */
	public void editaFornecedor(String nome, String parametro, String valor) throws Exception {
		if (fornecedores.containsKey(nome)) {
			Fornecedor fornecedor = this.fornecedores.get(nome);
			fornecedor.editarParametro(parametro, valor);
		} else {
			throw new Exception("fornecedor não existe.");
		}
	}

	/**
	 * exibe todos os fornecedores
	 * 
	 * @return
	 */
	public String exibeFornecedores() {
		String retorno = "";
		int contador = 0;
		for (Fornecedor fornecedor : this.getfornecedoresOrdenados()) {
			contador += 1;
			if (contador < this.getfornecedoresOrdenados().size()) {
				retorno += fornecedor.toString() + " | ";
			}
			if (contador == this.getfornecedoresOrdenados().size()) {
				retorno += fornecedor.toString();
			}
		}
		return retorno;
	}

	/**
	 * remove um fornecedor
	 * 
	 * @param nome
	 * @throws Exception
	 */
	public void removeFornecedor(String nome) throws Exception {
		if (nome.equals("")) {
			throw new Exception("nome do fornecedor nao pode ser vazio.");
		} else {
			fornecedores.remove(nome);

		}
	}

	/**
	 * retorna a representação de um fornecedor
	 * 
	 * @param nome string que representa o nome de um fornecedor
	 * @return
	 * @throws Exception
	 */
	public String exibeFornecedor(String nome) throws Exception {
		return getFornecedor(nome).toString();

	}

	public Fornecedor getFornecedor(String nome) throws Exception {
		if (this.fornecedores.containsKey(nome)) {
			return this.fornecedores.get(nome);
		} else {
			throw new Exception("fornecedor nao existe.");
		}
	}

	public void cadastraProduto(String nome, String nomeProduto, String descricao, double preco) throws Exception {
		Validator.verificaString(nome, "fornecedor nao pode ser vazio ou nulo.");
		this.getFornecedor(nome).adicionaProduto(nomeProduto, descricao, preco);

	}

	public String exibeProduto(String nomeProduto, String descricao, String nome) throws Exception {
		Validator.verificaString(nome, "fornecedor nao pode ser vazio ou nulo.");
		Validator.verificaString(nomeProduto, "nome nao pode ser vazio ou nulo.");
		Validator.verificaString(descricao, "descricao nao pode ser vazia ou nula.");
		return this.getFornecedor(nome).exibeProduto(nomeProduto, descricao);
	}

	public String exibeProdutos(String nome) throws Exception {
		Validator.verificaString(nome, "fornecedor nao pode ser vazio ou nulo");
		return this.getFornecedor(nome).listaProdutos();
	}

	public String exibeProdutosEFornecedores() {
		String retorno = "";
		int contador = 0;
		for (Fornecedor fornecedor : this.getfornecedoresOrdenados()) {
			if (contador < this.getfornecedoresOrdenados().size() - 1) {
				retorno += fornecedor.listaProdutos() + " | ";
			}
			if (contador == this.getfornecedoresOrdenados().size() - 1) {
				retorno += fornecedor.listaProdutos();
			}
			contador += 1;
		}
		return retorno;
	}

	public void editaProduto(String nome, String descricao, String nomeFornecedor, double precoNovo) throws Exception {
		Validator.verificaString(nome, "nome nao pode ser vazio ou nulo.");
		Validator.verificaString(nomeFornecedor, "fornecedor nao pode ser vazio ou nulo.");
		Validator.verificaDouble(precoNovo, "preco invalido.");
		Validator.verificaString(descricao, "descricao nao pode ser vazia ou nula.");
		this.getFornecedor(nomeFornecedor).editaPrecoProdutos(nome, descricao, nomeFornecedor, precoNovo);

	}
	
	public void removeProduto(String nome, String descricao, String nomeFornecedor) throws Exception {
		Validator.verificaString(nome, "nome nao pode ser vazio ou nulo.");
		Validator.verificaString(descricao, "descricao nao pode ser vazia ou nula.");
		Validator.verificaString(nomeFornecedor, "fornecedor nao pode ser vazio ou nulo.");
		this.getFornecedor(nomeFornecedor).removeProduto(nome, descricao);
	}

}
