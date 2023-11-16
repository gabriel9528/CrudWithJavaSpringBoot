package com.sistema.inventario.EntityUsuario;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Rol {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=25, nullable = false, unique = true)
	private String name;

	
	//Getters and Setter
	
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
	
	
	//Constructors
	
	public Rol(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Rol(String name) {
		super();
		this.name = name;
	}

	public Rol() {
		super();
	}
	
	public Rol(Integer id) {
		super();
		this.id = id;
	}
	
	
	

	@Override
	public String toString() {
		return name;
	}

	
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	

}
