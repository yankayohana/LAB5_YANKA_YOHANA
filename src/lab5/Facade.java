package lab5;

import easyaccept.EasyAccept;

public class Facade {

	private ClienteCRUD cliente;
	private FornecedorCRUD fornecedor;

	public Facade() {
		this.cliente = new ClienteCRUD();
		this.fornecedor = new FornecedorCRUD();
	}

	public static void main(String[] args) {
		args = new String[] { "lab5.Facade", "TesteDeAceitacao/use_case_1.txt", "TesteDeAceitacao/use_case_2.txt",
				"TesteDeAceitacao/use_case_3.txt" };
		EasyAccept.main(args);
	}

	public String adicionaCliente(String cpf, String nome, String email, String localizacao) throws Exception {
		try {
			cliente.createCliente(cpf, nome, email, localizacao);
		} catch (Exception e) {
			throw new Exception("Erro no cadastro do cliente: " + e.getMessage());
		}
		return cpf;
	}

	public void editaCliente(String cpf, String parametro, String valor) throws Exception {
		try {
			this.cliente.editaCliente(cpf, parametro, valor);
		} catch (Exception e) {
			throw new Exception("Erro na edicao do cliente: " + e.getMessage());
		}
	}

	public String exibeClientes() {
		return this.cliente.exibeClientes();

	}

	public String exibeCliente(String cpf) throws Exception {
		return this.cliente.exibeCliente(cpf);
	}

	public void removeCliente(String cpf) {
		this.cliente.removeCliente(cpf);
	}

	public String adicionaFornecedor(String nome, String email, String telefone) throws Exception {
		try {
			this.fornecedor.createFornecedor(nome, email, telefone);
		} catch (Exception e) {
			throw new Exception("Erro no cadastro do fornecedor: " + e.getMessage());
		}
		return nome;
	}

	public void editaFornecedor(String nome, String parametro, String valor) throws Exception {
		try {
			this.fornecedor.editaFornecedor(nome, parametro, valor);
		} catch (Exception e) {
			throw new Exception("Erro na edicao do fornecedor: " + e.getMessage());
		}

	}

	public String exibeFornecedores() {
		return this.fornecedor.exibeFornecedores();
	}

	public void removeFornecedor(String nome) throws Exception {
		try {
			this.fornecedor.removeFornecedor(nome);
		} catch (Exception e) {
			throw new Exception("Erro na remocao do fornecedor: " + e.getMessage());
		}
	}

	public String exibeFornecedor(String nome) throws Exception {
		try {
			return this.fornecedor.exibeFornecedor(nome);
		} catch (Exception e) {
			throw new Exception("Erro na exibicao do fornecedor: " + e.getMessage());
		}
	}
	
	public void adicionaProduto(String nome, String nomeProduto, String descricao, double preco) throws Exception {
		try {
			this.fornecedor.cadastraProduto(nome, nomeProduto, descricao, preco);
		 } catch (Exception e) {
			throw new Exception("Erro no cadastro de produto: " + e.getMessage());
		}
	}
	
	public String exibeProduto(String nomeProduto, String descricao, String nome) throws Exception {
		try {
			return this.fornecedor.exibeProduto(nomeProduto, descricao, nome);
			
		}catch (Exception e) {
			throw new Exception("Erro na exibicao de produto: " + e.getMessage());
		}
	}
	
	public String exibeProdutosFornecedor(String nome) throws Exception {
		try {
			return this.fornecedor.exibeProdutos(nome);
		} catch (Exception e) {
			throw new Exception("Erro na exibição do produto: " + e.getMessage());
		}
	}
	
	public String exibeProdutos() throws Exception {
		try {
			return this.fornecedor.exibeProdutosEFornecedores();
		} catch (Exception e) {
			throw new Exception("Erro na exibição de produto: " + e.getMessage());
		}
	}
	
	public void editaProduto(String nome,String descricao, double precoNovo) throws Exception {
		try {
			this.fornecedor.editaProduto(nome, descricao, precoNovo);
		}catch (Exception e) {
			throw new Exception("Erro na edicao do produto: " + e.getMessage());
		}
	}
	
}
