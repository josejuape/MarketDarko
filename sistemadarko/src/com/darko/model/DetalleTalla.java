package com.darko.model;

public class DetalleTalla {
	private int iddetalletalla;
	private String nombre;
	private String estado;
	private Talla talla;
	private Inventario inventario;
	public int getIddetalletalla() {
		return iddetalletalla;
	}
	public void setIddetalletalla(int iddetalletalla) {
		this.iddetalletalla = iddetalletalla;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Talla getTalla() {
		return talla;
	}
	public void setTalla(Talla talla) {
		this.talla = talla;
	}
	public Inventario getInventario() {
		return inventario;
	}
	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}
	
	
}
