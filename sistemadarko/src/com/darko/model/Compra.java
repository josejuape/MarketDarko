package com.darko.model;

public class Compra {
	private int idcompra;
	private String numguia;
	private double flete;
	private double utilidad;
	private double impuesto;
	private double costoTotal;
	public int getIdcompra() {
		return idcompra;
	}
	public void setIdcompra(int idcompra) {
		this.idcompra = idcompra;
	}
	public String getNumguia() {
		return numguia;
	}
	public void setNumguia(String numguia) {
		this.numguia = numguia;
	}
	public double getFlete() {
		return flete;
	}
	public void setFlete(double flete) {
		this.flete = flete;
	}
	public double getUtilidad() {
		return utilidad;
	}
	public void setUtilidad(double utilidad) {
		this.utilidad = utilidad;
	}
	public double getImpuesto() {
		return impuesto;
	}
	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}
	public double getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}
	
	
}
