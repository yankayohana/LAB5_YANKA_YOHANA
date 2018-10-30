package lab5;

import java.util.HashMap;
import java.util.Map;

public class FornecedorCRUD {
	
	Map<String, Fornecedor> fornecedores;
	
	public FornecedorCRUD() {
		this.fornecedores = new HashMap<>();
	}
	
	public void createFornecedor(String nome, String email, String telefone) {
		Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
		fornecedores.put(nome, fornecedor);
	}
	
	public String 
	
	
	

}
