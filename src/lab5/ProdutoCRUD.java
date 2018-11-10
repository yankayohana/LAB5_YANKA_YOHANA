package lab5;

import java.util.ArrayList;
import java.util.Arrays;
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
		throw new Exception("produto nao existe."); 
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
	
	public void editaPreco(String nome,String descricao, String nomeFornecedor,  double precoNovo) throws Exception {
		Produto produto = this.procuraProduto(nome, descricao);
		produto.setPreco(precoNovo);
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
	
	//////////// combo ///////////////
	
	public void cadastraCombo(String nome, String descricao, double fator, String produtos) throws Exception {
		
		Validator.verificaString(nome, "nome nao pode ser vazio ou nulo.");
		Validator.verificaString(descricao, "descricao nao pode ser vazia ou nula.");
		Validator.verificaFator(fator, "fator invalido.");
		Validator.verificaString(produtos, "combo deve ter produtos.");
		
		String[] produtosSeparados = produtos.split(",");
		
		List<Produto> produtosCombo = new ArrayList<>();
		for (String nomeEDescricaoProduto : produtosSeparados) {
			String[] nomeEDescricao = nomeEDescricaoProduto.split(" - ");
			String nomeProduto = nomeEDescricao[0].trim();
			String descricaoProduto = nomeEDescricao[1].trim();
			Produto produto = procuraProduto(nomeProduto, descricaoProduto);
			if (produto instanceof Combo) {
				throw new Exception("um combo nao pode possuir combos na lista de produtos.");
			}
			
			produtosCombo.add(produto);
		}
		Combo combo = new Combo(nome, descricao, fator, produtosCombo);
		if (!this.produtos.add(combo)) {
			throw new Exception("combo ja existe.");
		}
	}
	
	public void editaCombo(String nome, String descricao, double novoFator) throws Exception {
		Validator.verificaString(nome, "nome nao pode ser vazio ou nulo.");
		Validator.verificaString(descricao, "descricao nao pode ser vazia ou nula.");
		Produto produto = procuraProduto(nome, descricao);
		if (produto instanceof Combo) {
			((Combo) produto).setFator(novoFator);
		}
	}
	
	public double calculaPreco(String nomeProduto, String descricao) throws Exception {
		Produto produto = procuraProduto(nomeProduto, descricao);
		return  produto.getPreco();
	}
	
	
}
