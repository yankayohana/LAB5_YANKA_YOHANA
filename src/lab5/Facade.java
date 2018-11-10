package lab5;

import easyaccept.EasyAccept;

public class Facade {

	private ControllerSAGA controller;

	public Facade() {
		this.controller = new ControllerSAGA();
	}

	public static void main(String[] args) {
		args = new String[] { "lab5.Facade", "TesteDeAceitacao/use_case_1.txt", "TesteDeAceitacao/use_case_2.txt",
				"TesteDeAceitacao/use_case_3.txt", "TesteDeAceitacao/use_case_4.txt", "TesteDeAceitacao/use_case_5.txt", "TesteDeAceitacao/use_case_6.txt", "TesteDeAceitacao/use_case_7.txt" };
		EasyAccept.main(args);
	}

	public String adicionaCliente(String cpf, String nome, String email, String localizacao) throws Exception {
		try {
			controller.createCliente(cpf, nome, email, localizacao);
		} catch (Exception e) {
			throw new Exception("Erro no cadastro do cliente: " + e.getMessage());
		}
		return cpf;
	}

	public void editaCliente(String cpf, String parametro, String valor) throws Exception {
		try {
			this.controller.editaCliente(cpf, parametro, valor);
		} catch (Exception e) {
			throw new Exception("Erro na edicao do cliente: " + e.getMessage());
		}
	}

	public String exibeClientes() {
		return this.controller.exibeClientes();

	}

	public String exibeCliente(String cpf) throws Exception {
		return this.controller.exibeCliente(cpf);
	}

	public void removeCliente(String cpf) {
		this.controller.removeCliente(cpf);
	}

	public String adicionaFornecedor(String nome, String email, String telefone) throws Exception {
		try {
			this.controller.createFornecedor(nome, email, telefone);
		} catch (Exception e) {
			throw new Exception("Erro no cadastro do fornecedor: " + e.getMessage());
		}
		return nome;
	}

	public void editaFornecedor(String nome, String parametro, String valor) throws Exception {
		try {
			this.controller.editaFornecedor(nome, parametro, valor);
		} catch (Exception e) {
			throw new Exception("Erro na edicao do fornecedor: " + e.getMessage());
		}

	}

	public String exibeFornecedores() {
		return this.controller.exibeFornecedores();
	}

	public void removeFornecedor(String nome) throws Exception {
		try {
			this.controller.removeFornecedor(nome);
		} catch (Exception e) {
			throw new Exception("Erro na remocao do fornecedor: " + e.getMessage());
		}
	}

	public String exibeFornecedor(String nome) throws Exception {
		try {
			return this.controller.exibeFornecedor(nome);
		} catch (Exception e) {
			throw new Exception("Erro na exibicao do fornecedor: " + e.getMessage());
		}
	}
	
	public void adicionaProduto(String nome, String nomeProduto, String descricao, double preco) throws Exception {
		try {
			this.controller.cadastraProduto(nome, nomeProduto, descricao, preco);
		 } catch (Exception e) {
			throw new Exception("Erro no cadastro de produto: " + e.getMessage());
		}
	}
	
	public String exibeProduto(String nomeProduto, String descricao, String nome) throws Exception {
		try {
			return this.controller.exibeProduto(nomeProduto, descricao, nome);
			
		}catch (Exception e) {
			throw new Exception("Erro na exibicao de produto: " + e.getMessage());
		}
	}
	
	public String exibeProdutosFornecedor(String nome) throws Exception {
		try {
			return this.controller.exibeProdutos(nome);
		} catch (Exception e) {
			throw new Exception("Erro na exibição do produto: " + e.getMessage());
		}
	}
	
	public String exibeProdutos() throws Exception {
		try {
			return this.controller.exibeProdutosEFornecedores();
		} catch (Exception e) {
			throw new Exception("Erro na exibição de produto: " + e.getMessage());
		}
	}
	
	public void editaProduto(String nome,String descricao, String nomeFornecedor,  double precoNovo) throws Exception {
		try {
			this.controller.editaProduto(nome, descricao, nomeFornecedor, precoNovo);
		}catch (Exception e) {
			throw new Exception("Erro na edicao de produto: " + e.getMessage());
		}
	}
	
	public void removeProduto(String nome, String descricao, String nomeFornecedor) throws Exception {
		try {
			this.controller.removeProduto(nome, descricao, nomeFornecedor);
		}catch (Exception e) {
			throw new Exception("Erro na remocao de produto: " + e.getMessage());
		}
	}
	
	//////////////// teste de aceitacao case 5 //////////////////
	
	public void adicionaCombo(String fornecedor, String nome, String descricao, double fator, String produtos) throws Exception {
		try {
			this.controller.cadastraCombo(fornecedor, nome, descricao, fator, produtos);
		}catch (Exception e) {
			throw new Exception("Erro no cadastro de combo: " + e.getMessage());
		}
	}
	
	public void editaCombo(String nome, String descricao,String fornecedor, double novoFator) throws Exception {
		try {
			this.controller.editaCombo(fornecedor, nome, descricao, novoFator);
		}catch (Exception e) {
			throw new Exception("Erro na edicao de combo: " + e.getMessage());
		}
	}
	
	public void adicionaCompra(String cpf,String fornecedor, String data, String nomeProduto, String descricao) throws Exception {
		try {
			this.controller.adicionaConta(cpf, fornecedor, data, nomeProduto, descricao);
		}catch (Exception e) {
			throw new Exception("Erro ao cadastrar compra: " + e.getMessage());
		}
	}
	
	
}
