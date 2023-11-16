package com.sistema.inventario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sistema.inventario.EntityUsuario.Rol;
import com.sistema.inventario.EntityUsuario.Usuario;
import com.sistema.inventario.EntityUsuario.UsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	
	@Test
	public void TestCrearRoles() {
		Rol rolAdmin = new Rol("Administrator");
		Rol rolEditor = new Rol("Edit");
		Rol rolVisitor = new Rol("Visitor");
		
		entityManager.persist(rolAdmin);
		entityManager.persist(rolEditor);
		entityManager.persist(rolVisitor);
	}
	
	@Test
	public void TestCrearNuevoUsuario() {
		Rol rolAdmin = entityManager.find(Rol.class, 1);
		Usuario usuario = new Usuario("gabrielsxf@gmail.com", "123456");
		
		usuario.añadirRol(rolAdmin);
		usuarioRepository.save(usuario);
	}
	
	@Test
	public void TestCrearNuevoUsuarioConDosRoles() {
		Rol rolEditor = entityManager.find(Rol.class, 2);
		Rol rolVisitor = entityManager.find(Rol.class, 3);
		
		Usuario user = new Usuario("fernando@gmail.com", "gabriel111");
		user.añadirRol(rolEditor);
		user.añadirRol(rolVisitor);
		
		usuarioRepository.save(user);
	}
	
	@Test
	public void TestAsignarRolAUsuarioExistente() {
		Usuario usuario = usuarioRepository.findById(1).get();
		Rol rolEditor = entityManager.find(Rol.class, 2);
		
		usuario.añadirRol(rolEditor);
		usuarioRepository.save(usuario);
	}
	
	@Test
	public void TestEliminarRolDeUsuarioExistente() {
		Usuario usuario = usuarioRepository.findById(1).get();
		Rol rol = new Rol(2);
		
		usuario.eliminarRol(rol);
	}
	
	
	@Test
	public void TestCrearNuevoUsuarioConNuevoRol() {
		Rol rol = new Rol("Seller");
		Usuario user = new Usuario("gabrielferv95@gmail.com", "tecsup8107#");
		
		user.añadirRol(rol);
		usuarioRepository.save(user);
	}
	
	@Test
	public void TestObtenerUsuario() {
		Usuario user = usuarioRepository.findById(1).get();
		entityManager.detach(user);
		
		System.out.println(user.getEmail());
		System.out.println(user.getRoles());
	}
	
	@Test
	public void TestUsuarioEliminar() {
		usuarioRepository.deleteById(4);
	}
	
	
}
