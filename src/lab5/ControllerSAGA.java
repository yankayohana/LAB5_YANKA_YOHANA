package lab5;

public class ControllerSAGA {
	
	private ClienteCRUD cliente;
	private FornecedorCRUD fornecedor;
	private ContaCRUD conta;
	
	public ControllerSAGA() {
		this.cliente = new ClienteCRUD();
		this.fornecedor = new FornecedorCRUD();
	}
	
	public void createCliente(String cpf, String nome, String email, String localizacao) throws Exception {
		cliente.createCliente(cpf, nome, email, localizacao);
	}
	public String readCliente(String cpf) {
		return cliente.readCliente(cpf);
	}
	public String exibeClientes() {
		return cliente.exibeClientes();
	}
	public void editaCliente(String cpf, String parametro, String valor) throws Exception {
		cliente.editaCliente(cpf, parametro, valor);
	}
	public void removeCliente(String cpf) {
		cliente.removeCliente(cpf);
	}
	public String exibeCliente(String cpf) throws Exception {
		return cliente.exibeCliente(cpf);
	}
	public void createFornecedor(String nome, String email, String telefone) throws Exception {
		fornecedor.createFornecedor(nome, email, telefone);
	}
	public String readFornecedor(String nome) {
		return fornecedor.readFornecedor(nome);
	}
	public void editaFornecedor(String nome, String parametro, String valor) throws Exception {
		fornecedor.editaFornecedor(nome, parametro, valor);
	}
	public String exibeFornecedores() {
		return fornecedor.exibeFornecedores();
	}
	public void removeFornecedor(String nome) throws Exception {
		fornecedor.removeFornecedor(nome);
	}
	public String exibeFornecedor(String nome) throws Exception {
		return fornecedor.exibeFornecedor(nome);
	}
	public void cadastraProduto(String nome, String nomeProduto, String descricao, double preco) throws Exception {
		fornecedor.cadastraProduto(nome, nomeProduto, descricao, preco);
	}
	public String exibeProduto(String nomeProduto, String descricao, String nome) throws Exception {
		return fornecedor.exibeProduto(nomeProduto, descricao, nome);
	}
	public String exibeProdutos(String nome) throws Exception {
		return fornecedor.exibeProdutos(nome);
	}
	public String exibeProdutosEFornecedores() {
		return fornecedor.exibeProdutosEFornecedores();
	}
	public void editaProduto(String nome, String descricao, String nomeFornecedor, double precoNovo) throws Exception {
		fornecedor.editaProduto(nome, descricao, nomeFornecedor, precoNovo);
	}
	public void removeProduto(String nome, String descricao, String nomeFornecedor) throws Exception {
		fornecedor.removeProduto(nome, descricao, nomeFornecedor);
	}
	public void cadastraCombo(String fornecedorNome, String nome, String descricao, double fator, String produtos)
			throws Exception {
		fornecedor.cadastraCombo(fornecedorNome, nome, descricao, fator, produtos);
	}
	public void editaCombo(String fornecedorNome, String nome, String descricao, double novoFator) throws Exception {
		fornecedor.editaCombo(fornecedorNome, nome, descricao, novoFator);
	}
	
	public void adicionaConta(String cpf, String nomeFornecedor, String dataCompra, String nomeProduto, String descricao) throws Exception {
		String nome = cliente.getNomeCliente(cpf); 
		conta.adicionaConta(nome,cpf, nomeFornecedor, dataCompra, nomeProduto, descricao);
	}
	
	
	

}
