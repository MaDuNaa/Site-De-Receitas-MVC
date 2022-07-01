package com.gft.palmirinha.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gft.palmirinha.entities.Ingredientes;

@Repository
public interface IngredientesRepository extends JpaRepository <Ingredientes, Long> {

	List<Ingredientes> findByNomeContains(String nome);

}
