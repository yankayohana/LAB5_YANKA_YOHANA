package lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProdutoCRUD {
	
	private Set<Produto> produtos;
	
	public ProdutoCRUD() {
		this.produtos = new HashSet<>();
	}
	
	public void createProduto(String nome, double preco, String descricao) throws Exception {
		Produto produto = new Produto(nome, preco, descricao);
		if(!this.produtos.add(produto)) {
			throw new Exception("produto ja existe.");
		}
		
	}
	
	public Produto procuraProduto(String nome, String descricao) throws Exception {
		for(Produto produto : produtos) {
			if(produto.getNome().equals(nome) && produto.getDescricao().equals(descricao)) {
				return produto;
			}
		}
		throw new Exception("Produto não encontrado."); 
	}
	
	public String readProduto(String nome, String descricao) throws Exception {
		Produto produto = procuraProduto(nome, descricao);
		return produto.toString() + "|";
	}
	
	public String exibeProdutos() {
		String retorno = "";
		for(Produto produto : this.getProdutosOrdenados()) {
			retorno += produto;
		}
		return retorno;
	}
	
	public Produto getProduto(String nome) throws Exception {
		for(Produto produto : produtos) {
			if (produto.getNome().equals(nome)) {
				return produto;
			}
		}
		throw new Exception("produto nao existe.");
	}
	
	public String exibeProduto(String nome) throws Exception {
		return this.getProduto(nome).toString();
	}
	
	private List<Produto> getProdutosOrdenados() {
		List<Produto> produtosOrdenados = new ArrayList<>(this.produtos);
		Collections.sort(produtosOrdenados);
		return produtosOrdenados;
	}
	
	public void editaPreco(String nome,String descricao, double preco, String nomeFornecedor) throws Exception {
		Produto produto = this.procuraProduto(nome, descricao);
		produto.setPreco(preco);
	}
	
	public void removeProduto(String nome, String descricao) throws Exception {
		Produto produto = this.procuraProduto(nome, descricao);
		this.produtos.remove(produto);
	}
	
	public List<String> getToStringProdutos(){
		List<String> toStringProdutos = new ArrayList<>();
		for(Produto produto : this.getProdutosOrdenados()) {
			toStringProdutos.add(produto.toString()); 
		}
		return toStringProdutos;
	}
	
	
}
