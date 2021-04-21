package br.com.sonhodepapelaria.www.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.sonhodepapelaria.www.model.Categoria;
import br.com.sonhodepapelaria.www.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired CategoriaRepository repository;
	
	public List<Categoria> findAll(){
		return repository.findAll();
	}
	
	public Categoria findById(Long id){
		return repository.findById(id)
				.map(resp->(resp))
				.orElse(null);
	}
	
	public Categoria findByNome(String nome){
		return repository.findByNome(nome);
	}
	
	public Categoria save(@Validated @RequestBody Categoria categoria) {
		return repository.save(categoria);
	}
	
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
