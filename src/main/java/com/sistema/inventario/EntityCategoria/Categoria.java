package com.sistema.inventario.EntityCategoria;

import com.sistema.inventario.EntityMarca.Marca;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=45, nullable=false, unique=true)
	private String name;
	
	@ManyToOne
	@JoinColumn(name="marca_id")
	private Marca marca;

	
	//Getters and setters
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
	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	
	//Constructor
	
	
	public Categoria() {
		super();
	}

	public Categoria(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Categoria(Integer id) {
		super();
		this.id = id;
	}

	public Categoria(String name) {
		super();
		this.name = name;
	}

	public Categoria(Integer id, String name, Marca marca) {
		super();
		this.id = id;
		this.name = name;
		this.marca = marca;
	}

	public Categoria(String name, Marca marca) {
		super();
		this.name = name;
		this.marca = marca;
	}
	
	@Override
	public String toString() {
	    return name;
	}
	
	

}
