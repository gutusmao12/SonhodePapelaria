package br.com.sonhodepapelaria.www.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sonhodepapelaria.www.model.Categoria;
import br.com.sonhodepapelaria.www.model.Produto;
import br.com.sonhodepapelaria.www.repository.CategoriaRepository;
import br.com.sonhodepapelaria.www.repository.ProdutoRepository;



@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public List<Produto> findByName(String nome) {
		return produtoRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	public void deleteProduto(long id) {
		produtoRepository.deleteById(id);
	}

	public Optional<Produto> findById(Long id) {
		return produtoRepository.findById(id);
	}

	public Produto save(Produto produto) {
		return produtoRepository.save(produto);
	}

	public List<Produto> findByCategoria(Long id){
		Optional<Categoria> b = categoriaRepository.findById(id);
		
		if(b.isPresent()) {
			return produtoRepository.findByCategoria(b.get());
		}
		else {
			List<Produto> listEmpty = new ArrayList<>();
			return  listEmpty;
		}
	}
}
