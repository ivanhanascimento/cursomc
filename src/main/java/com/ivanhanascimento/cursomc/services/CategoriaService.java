package com.ivanhanascimento.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ivanhanascimento.cursomc.domain.Categoria;
import com.ivanhanascimento.cursomc.repositories.CategoriaRepository;
import com.ivanhanascimento.cursomc.services.exception.ObjectNotFoundException;

import java.util.Optional;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		
		 Optional<Categoria> obj = repo.findById(id);  
		 return obj.orElseThrow(() -> new ObjectNotFoundException(
				 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName())); 
		
	}
}
