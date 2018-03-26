package com.ivanhanascimento.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ivanhanascimento.cursomc.domain.Categoria;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResources {

	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		Categoria Cat1 = new Categoria(1,"Informática");
		Categoria Cat2 = new Categoria(2,"Financeiro");
		
		List<Categoria> lista = new ArrayList<>();
		lista.add(Cat1);
		lista.add(Cat2);
		
		return lista;
	}
	
}
