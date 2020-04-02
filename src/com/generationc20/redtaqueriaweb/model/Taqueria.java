package com.generationc20.redtaqueriaweb.model;

import java.util.Date;

public class Taqueria {

	private int id;
	private String nombre;
	private int popularidad;
	private int nivelLimpieza;
	private String ubicacion;
	private int olor;
	private Date fechaCreacion;
	
	public Taqueria() {}
	
	public Taqueria(int id, String nombre, int popularidad, int nivelLimpieza, 
			String ubicacion, int olor, Date fechaCreacion) {
		this.id = id;
		this.nombre = nombre;
		this.popularidad = popularidad;
		this.nivelLimpieza = nivelLimpieza;
		this.ubicacion = ubicacion;
		this.olor = olor;
		this.fechaCreacion = fechaCreacion;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPopularidad() {
		return popularidad;
	}

	public void setPopularidad(int popularidad) {
		this.popularidad = popularidad;
	}

	public int getNivelLimpieza() {
		return nivelLimpieza;
	}

	public void setNivelLimpieza(int nivelLimpieza) {
		this.nivelLimpieza = nivelLimpieza;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getOlor() {
		return olor;
	}

	public void setOlor(int olor) {
		this.olor = olor;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
	
}
