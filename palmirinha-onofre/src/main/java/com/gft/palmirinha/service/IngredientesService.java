package com.gft.palmirinha.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.palmirinha.entities.Ingredientes;
import com.gft.palmirinha.repositories.IngredientesRepository;

@Service
public class IngredientesService {

	@Autowired
	private IngredientesRepository ingredientesRepository;
	
	public Ingredientes salvarIngredientes(Ingredientes ingredientes) {
		
		return ingredientesRepository.save(ingredientes);
	}
	
   public List<Ingredientes> listarIngredientes(String nome) {
		
		if(nome!=null)
			return listarIngredientesPorNome(nome);
		
		return listarTodosIngredientes();
		
	}
	
	public List<Ingredientes> listarTodosIngredientes() {
		
		return ingredientesRepository.findAll();
		
	}
	
	private List<Ingredientes> listarIngredientesPorNome(String nome) {
		
		return ingredientesRepository.findByNomeContains(nome);
		
	}
	
	public Ingredientes obterIngredientes(Long id) throws Exception {
		
		Optional<Ingredientes> ingredientes = ingredientesRepository.findById(id);
		
		if(ingredientes.isEmpty()) {
			throw new Exception("Ingredientes não encontrado.");
		}
		
		return ingredientes.get();
		
	}

	public void excluirIngredientes(Long id) {
		ingredientesRepository.deleteById(id);
	}
	
}
