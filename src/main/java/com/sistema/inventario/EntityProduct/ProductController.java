package com.sistema.inventario.EntityProduct;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.inventario.EntityCategoria.Categoria;
import com.sistema.inventario.EntityCategoria.CategoriaRepository;
import com.sistema.inventario.EntityProduct.Product;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ProductController {
	
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/productos")
	public String getProducts(Model modelo) {
		List<Product> listProducts = productoRepository.findAll();
		modelo.addAttribute("listaProductos", listProducts);
		return "productos";
	}
	
	@GetMapping("/productos/nuevo")
	public String newProduct(Model modelo) {
		List<Categoria> listCategory = categoriaRepository.findAll();
		modelo.addAttribute("producto",new Product());
		modelo.addAttribute("listaCategorias", listCategory);
		return "producto_formulario";
	}
	
	@PostMapping("/productos/guardar")
	public String saveProduct(Product product, HttpServletRequest request) {
		
		String[] detailId = request.getParameterValues("detailsId");
		String[] detailNombre = request.getParameterValues("detailsName");
		String[] detailValue = request.getParameterValues("detailsValue");

		
		if(detailNombre != null ) {
			for(int i=0; i<detailNombre.length; i++) {
				if(detailId!= null && detailId.length >0) {
					product.SetDetalle(Integer.valueOf(detailId[i]), detailNombre[i], detailValue[i]);
				}else {
					product.añadirDetalles(detailNombre[i], detailValue[i]);
				}
			}
		}
		
		productoRepository.save(product);
		return "redirect:/productos";
	}
	
	
	@GetMapping("/productos/editar/{id}")
	public String editProduct(@PathVariable("id") Integer id, Model modelo) {
	    Product producto = productoRepository.findById(id).orElse(new Product());
	    List<Categoria> categoria = categoriaRepository.findAll();
	    modelo.addAttribute("producto", producto);
	    modelo.addAttribute("listaCategorias", categoria);
	    
	    return "producto_formulario";
	}
	
	
	@PostMapping("/productos/saveEdit")
	public String saveEditProduct(Product product) {

	    Optional<Product> existingProduct = productoRepository.findById(product.getId());

	    if (existingProduct.isPresent()) {

	        Product updatedProduct = existingProduct.get();
	        updatedProduct.setName(product.getName());
	        updatedProduct.setPrice(product.getPrice());
	        updatedProduct.setCategoria(product.getCategoria());

	        productoRepository.save(updatedProduct);
	    } else {

	    }

	    return "redirect:/productos";
	}
	
	
	@GetMapping("/productos/eliminar/{id}")
	public String deleteProduct(@PathVariable("id") Integer id) {
		Product producto = productoRepository.findById(id).get();
		productoRepository.delete(producto);

		return "redirect:/productos";
	}
	

}
