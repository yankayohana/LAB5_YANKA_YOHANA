package lab5;

import java.util.ArrayList;
import java.util.List;

public class ContaCRUD {
	
	List<Conta> contas;
	
	public ContaCRUD() {
		this.contas = new ArrayList<>();
	}
	
	public void adicionaConta(String nome,String cpf, String nomeFornecedor, String dataCompra, String nomeProduto, String descricao, double preco) {
		Conta conta = new Conta(nome, cpf, nomeFornecedor, dataCompra, nomeProduto, descricao, preco);
		contas.add(conta);
	}
 
}
