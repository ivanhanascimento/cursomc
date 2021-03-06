package com.ivanhanascimento.cursomc;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ivanhanascimento.cursomc.domain.Categoria;
import com.ivanhanascimento.cursomc.domain.Produto;
import com.ivanhanascimento.cursomc.repositories.CategoriaRepository;
import com.ivanhanascimento.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired 
	private ProdutoRepository produtoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null,"Informática");
		Categoria cat2 = new Categoria(null,"Administrativo");
		Categoria cat3 = new Categoria(null,"Financeiro");
		
		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Impressora",500.00);
		Produto p3 = new Produto(null,"Mouse",15.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));	
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));	
		p3.getCategorias().addAll(Arrays.asList(cat3));	
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3));
		
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
	}
	
	
}
