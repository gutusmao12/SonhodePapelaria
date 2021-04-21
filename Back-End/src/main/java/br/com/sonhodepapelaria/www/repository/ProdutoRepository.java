package br.com.sonhodepapelaria.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sonhodepapelaria.www.model.Categoria;
import br.com.sonhodepapelaria.www.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List<Produto> findByNomeContainingIgnoreCase(String nome);

	public List<Produto> findByCategoria(Categoria categoria);
}
