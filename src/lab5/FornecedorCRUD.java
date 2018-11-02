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

	public void createFornecedor(String nome, String email, String telefone) throws Exception {
		if (fornecedores.containsKey(nome)) {
			throw new Exception("fornecedor ja existe.");
		} else {
			Fornecedor fornecedor = new Fornecedor(nome, email, telefone);
			fornecedores.put(nome, fornecedor);
		}

	}

	public String readFornecedor(String nome) {
		return fornecedores.get(nome).toString();
	}

	public List<Fornecedor> getfornecedoresOrdenados() {
		List<Fornecedor> fornecedoresOrdenados = new ArrayList<>(this.fornecedores.values());
		Collections.sort(fornecedoresOrdenados);
		return fornecedoresOrdenados;
	}

	public void editaFornecedor(String nome, String parametro, String valor) throws Exception {
		if(fornecedores.containsKey(nome)) {
			Fornecedor fornecedor = this.fornecedores.get(nome);
			fornecedor.editarParametro(parametro, valor);			
		} else {
			throw new Exception("fornecedor não existe.");
		}
	}

	public String exibeFornecedores() {
		String retorno = "";
		int contador = 0;
		for (Fornecedor fornecedor : this.getfornecedoresOrdenados()) {
			contador += 1;
			if(contador < this.getfornecedoresOrdenados().size()) {
				retorno += fornecedor.toString() + " | ";				
			}if(contador == this.getfornecedoresOrdenados().size()) {
				retorno += fornecedor.toString();
			}
		}
		return retorno;
	}

	public void removeFornecedor(String nome) throws Exception {
		if (nome.equals("")) {
			throw new Exception("nome do fornecedor nao pode ser vazio.");
		}else {
			fornecedores.remove(nome);
			
		}
	}

	public String exibeFornecedor(String nome) throws Exception {
		if(fornecedores.containsKey(nome)) {
			return fornecedores.get(nome).toString();
		}else {
			throw new Exception("fornecedor nao existe.");
		}
		
	}

}
