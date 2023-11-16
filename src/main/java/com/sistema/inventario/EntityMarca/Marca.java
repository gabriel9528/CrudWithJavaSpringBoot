package com.sistema.inventario.EntityMarca;

import java.util.ArrayList;
import java.util.List;

import com.sistema.inventario.EntityCategoria.Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String name;

	@OneToMany
	@JoinColumn(name = "marca_id")
	private List<Categoria> categorias = new ArrayList<>();

	// getters and setters

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	// Constructors

	public Marca() {
		super();
	}

	public Marca(Integer id, String name, List<Categoria> categorias) {
		super();
		this.id = id;
		this.name = name;
		this.categorias = categorias;
	}

	public Marca(Integer id) {
		super();
		this.id = id;
	}

	public Marca(String name, List<Categoria> categorias) {
		super();
		this.name = name;
		this.categorias = categorias;
	}

}
