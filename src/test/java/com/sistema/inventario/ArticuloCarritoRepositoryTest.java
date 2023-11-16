package com.sistema.inventario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sistema.inventario.EntityProduct.Product;
import com.sistema.inventario.EntityUsuario.Usuario;
import com.sistema.inventario.carrito.shopping.cart.ArticuloCarrito;
import com.sistema.inventario.carrito.shopping.cart.ArticuloCarritoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class ArticuloCarritoRepositoryTest {
	
	
	@Autowired
	private ArticuloCarritoRepository repository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void TestCrearCategoria() {
		

		Product producto = entityManager.find(Product.class, 1);
		Usuario user = entityManager.find(Usuario.class, 7);
		
		ArticuloCarrito articuloCarrito = new ArticuloCarrito(1, producto, user);
		repository.save(articuloCarrito);
	}


}
