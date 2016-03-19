package com.darko.model;

public class Categoria {
	private int idcategoria;
	private String nombre;
	private String observacion;
	private double valor_flete;
	public int getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
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
	public double getValor_flete() {
		return valor_flete;
	}
	public void setValor_flete(double valor_flete) {
		this.valor_flete = valor_flete;
	}
	
	
}
