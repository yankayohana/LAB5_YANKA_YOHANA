package lab5;

import easyaccept.EasyAccept;

public class Facade {

	private ClienteCRUD cliente;
	private FornecedorCRUD fornecedor;
	
	public Facade() {
		this.cliente = new ClienteCRUD();
		this.fornecedor = new FornecedorCRUD();
	}

	public void adicionaCliente(String cpf, String nome, String email, String localizacao) {
		this.cliente.createCliente(cpf, nome, email, localizacao);
	}

	public void editaCliente(String cpf, String parametro, String valor) {
		this.cliente.editaCliente(cpf, parametro, valor);
	}

	public String exibeClientes() {
		return this.cliente.exibeClientes();

	}
	
	public String exibeCliente(String cpf) {
		return this.cliente.exibeCliente(cpf);
	}
	
	public void removeCliente(String cpf) {
		this.cliente.removeCliente(cpf);
	}
	
	public void cadastraFornecedor(String nome, String email, String telefone) {
		this.fornecedor.createFornecedor(nome, email, telefone);
	}
	
	public void editaFornecedor(String nome, String parametro, String valor) {
		this.fornecedor.editaFornecedor(nome, parametro, valor);
	}
	
	public String exibeFornecedores() {
		return this.fornecedor.exibeFornecedores();
	}
	
	public void removeFornecedor(String nome) {
		this.fornecedor.removeFornecedor(nome);
	}
	
	public String exibeFornecedor(String nome) {
		return this.fornecedor.exibeFornecedor(nome);
	}
	
	public static void main(String[] args) {
		args = new String[] {"lab5.Facade", "TesteDeAceitacao/use_case_1.txt"};
		EasyAccept.main(args);
	}

}
