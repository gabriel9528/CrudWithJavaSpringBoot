package com.sistema.inventario.EntityProduct;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductoDetalles {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=45, nullable=false)
	private String name;
	
	@Column(length=45, nullable=false)
	private String value;
	
	@ManyToOne
	@JoinColumn(name="producto_id")
	private Product producto;

	
	//Getters and Setters
	
	

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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}
	
	
	
	//Constructors
	

	public ProductoDetalles() {
		super();
	}

	public ProductoDetalles(Integer id, String name, String value, Product producto) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.producto = producto;
	}

	public ProductoDetalles(String name, String value, Product producto) {
		super();
		this.name = name;
		this.value = value;
		this.producto = producto;
	}
	
	
	
	@Override
	public String toString() {
		return name + "-" + value;
	}
	
	
}
