package com.darko.model;

public class Tracking {
	private int idtracking;
	private String serie;
	private String fecha;
	private Compra compra;
	public int getIdtracking() {
		return idtracking;
	}
	public void setIdtracking(int idtracking) {
		this.idtracking = idtracking;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	
	
}
