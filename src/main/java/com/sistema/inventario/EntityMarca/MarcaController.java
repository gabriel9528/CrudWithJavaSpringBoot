package com.sistema.inventario.EntityMarca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.inventario.EntityCategoria.Categoria;
import com.sistema.inventario.EntityCategoria.CategoriaRepository;

@Controller
public class MarcaController {

	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/marcas/nuevo")
	public String newMarca(Model modelo) {
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		Marca marca = new Marca();
		
		modelo.addAttribute( "marca" ,marca);
		modelo.addAttribute( "listaCategorias" ,listaCategorias);
		
		return "marca_formulario";
	}
	
	@PostMapping("marcas/guardar")
	public String marcaSave(Marca marca) {
		marcaRepository.save(marca);
		
		return "redirect:/";
	}
	
	@GetMapping("/marcas")
	public String getMarcas(Model modelo) {
		List<Marca> listaMarcas = marcaRepository.findAll();
		modelo.addAttribute( "listaMarcas" ,listaMarcas);
				
		return "marcas";
	}
	
	@GetMapping("/marcas/editar/{id}")
	public String editMarca(@PathVariable("id") Integer id, Model modelo) {
		Marca marcaEdit = marcaRepository.findById(id).get();
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		
		modelo.addAttribute( "listaCategorias" ,listaCategorias);
		modelo.addAttribute( "marca" ,marcaEdit);
		
		return "marca_formulario";
	}
	
	@GetMapping("marcas/eliminar/{id}")
	public String deleteMarca(@PathVariable("id") Integer id) {
		Marca deleteMarca = marcaRepository.findById(id).get();
		marcaRepository.delete(deleteMarca);
		
		return "redirect:/marcas";
		
	}
	
	
}
