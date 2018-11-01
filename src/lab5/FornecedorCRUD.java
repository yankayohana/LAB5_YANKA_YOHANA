package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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
	
	public String readFornecedor(String nome) {
		return fornecedores.get(nome).toString();
	}
	
	public List<Fornecedor> getfornecedoresOrdenados() {
		List<Fornecedor> fornecedoresOrdenados = new ArrayList<>(this.fornecedores.values());
		Collections.sort(fornecedoresOrdenados);
		return fornecedoresOrdenados;
	}

	public void editaFornecedor(String nome, String parametro, String valor) {
		Fornecedor fornecedor = this.fornecedores.get(nome);
		fornecedor.editarParametro(parametro, valor);
	}

	public String exibeFornecedores() {
		String retorno = "";
		for (Fornecedor fornecedor : this.getfornecedoresOrdenados()) {
			retorno += fornecedor.toString() + "|";
		}
		return retorno;
	}
	
	public void removeFornecedor(String nome) {
		fornecedores.remove(nome);
	}
	
	public String exibeFornecedor(String nome) {
		return fornecedores.get(nome).toString();
	}

}
