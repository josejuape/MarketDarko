package com.darko.model;

public class Talla {
	private int idtalla;
	private String nombre;
	private String observacion;
	private int defecto;
	private Categoria categoria;
	
	public int getIdtalla() {
		return idtalla;
	}
	public void setIdtalla(int idtalla) {
		this.idtalla = idtalla;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public int getDefecto() {
		return defecto;
	}
	public void setDefecto(int defecto) {
		this.defecto = defecto;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
