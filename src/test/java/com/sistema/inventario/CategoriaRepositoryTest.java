package com.sistema.inventario;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sistema.inventario.EntityCategoria.Categoria;
import com.sistema.inventario.EntityCategoria.CategoriaRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class CategoriaRepositoryTest {
	
	
	@Autowired
	private CategoriaRepository repository;
	
	@Test
	public void TestCrearCategoria() {
		Categoria saveCategory =  repository.save(new Categoria("Electronicos"));
		assertThat(saveCategory.getId()).isGreaterThan(0);
	}


}
