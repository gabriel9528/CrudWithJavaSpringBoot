package com.sistema.inventario.EntityProduct;

import java.util.ArrayList;
import java.util.List;

import com.sistema.inventario.EntityCategoria.Categoria;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 128, nullable = false, unique = true)
	private String name;
	
	private float price;
	
	
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	
	@OneToMany(mappedBy ="producto", cascade=CascadeType.ALL)
	private List<ProductoDetalles> detalles = new ArrayList<>();
	

	//getters and setters
	
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


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	public List<ProductoDetalles> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<ProductoDetalles> detalles) {
		this.detalles = detalles;
	}
	
	
	//Constructors


	public Product() {
		super();
	}


	public Product(Integer id, String name, float price, Categoria categoria) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.categoria = categoria;
	}


	public Product(String name, float price, Categoria categoria) {
		super();
		this.name = name;
		this.price = price;
		this.categoria = categoria;
	}


	public Product(String name) {
		super();
		this.name = name;
	}
	
	
	public void añadirDetalles(String name, String value) {
		this.detalles.add(new ProductoDetalles(name, value, this));
	}
	
	
	public void SetDetalle(Integer id, String name, String value) {
		this.detalles.add(new ProductoDetalles(id, name, value, this));
		
	}
	
	
	
	

}
