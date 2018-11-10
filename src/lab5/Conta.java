package lab5;

public class Conta {
	
	private String cpf;
	private String nomeFornecedor;
	private String dataCompra;
	private String nomeProduto;
	private String descricao;
	private double preco;
	private String nome;

	public Conta(String nome,String cpf, String nomeFornecedor, String dataCompra, String nomeProduto, String descricao, double preco) {
		this.cpf = cpf;
		this.nomeFornecedor = nomeFornecedor;
		this.dataCompra = dataCompra;
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.preco = preco;
		this.nome = nome;
	}
	
	public String getCPF() {
		return cpf;
	}
	
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	
	public String getDataCompra() {
		return dataCompra;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public double getPreco() {
		return preco;
	}
	
	public String toString() {
		return this.nome + ", " + this.nomeFornecedor + ", " + this.nomeProduto + ", " + this.dataCompra; 
	}
}
