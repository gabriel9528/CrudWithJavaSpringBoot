package com.sistema.inventario.EntityUsuario;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=45, nullable=false, unique=true)
	private String email;
	
	@Column(length=45, nullable = false, unique = true)
	private String password;
	
	@ManyToMany(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(
			name="usuario_rol",
			joinColumns = @JoinColumn(name="usuario_id"),
			inverseJoinColumns = @JoinColumn(name="rol_id"
			))
	private Set<Rol> roles = new HashSet<>();


	
	//Getters and Setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
	
	//Constructors
	
	public Usuario(Integer id, String email, String password, Set<Rol> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Usuario(String email, String password, Set<Rol> roles) {
		super();
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Usuario() {
		super();
	}
	
	public Usuario(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	
	
	public void añadirRol(Rol rol) {
		this.roles.add(rol);
	}
	
	public void eliminarRol(Rol rol) {
		this.roles.remove(rol);
	}
	
	
}
