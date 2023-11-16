package com.sistema.inventario.carrito.shopping.cart;

import com.sistema.inventario.EntityProduct.Product;
import com.sistema.inventario.EntityUsuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="articulo_carrito")
public class ArticuloCarrito {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private int amount;
	
	@ManyToOne
	@JoinColumn(name="producto_id")
	private Product producto;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	//getters and setters
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Product getProducto() {
		return producto;
	}

	public void setProducto(Product producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	//constructors
	
	public ArticuloCarrito(Integer id, int amount, Product producto, Usuario usuario) {
		super();
		this.id = id;
		this.amount = amount;
		this.producto = producto;
		this.usuario = usuario;
	}

	public ArticuloCarrito(int amount, Product producto, Usuario usuario) {
		super();
		this.amount = amount;
		this.producto = producto;
		this.usuario = usuario;
	}

	public ArticuloCarrito() {
		super();
	}
	
	
	
}
