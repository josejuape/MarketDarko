package com.darko.model;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
	private int idinventario;
	private String nombre;
	private double costoUnitario;
	private double costoTotal;
	private int cantidad;
	private String estado;
	private int stock;
	private Producto producto;
	private Tracking tracking;
	private List<Talla> tallas;
	private List<Color> colores;
	private String fechaRegistro;
	private String fechaActualizacion;
	
	public Inventario(){
		this.tallas = new ArrayList<Talla>();
		this.colores = new ArrayList<Color>();
	}
	
	
	public int getIdinventario() {
		return idinventario;
	}
	public void setIdinventario(int idinventario) {
		this.idinventario = idinventario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	public double getCostoTotal() {
		return costoTotal;
	}
	public void setCostoTotal(double costoTotal) {
		this.costoTotal = costoTotal;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Tracking getTracking() {
		return tracking;
	}
	public void setTracking(Tracking tracking) {
		this.tracking = tracking;
	}	
	public List<Talla> getTallas() {
		return tallas;
	}
	public void setTallas(List<Talla> tallas) {
		this.tallas = tallas;
	}
	public List<Color> getColores() {
		return colores;
	}
	public void setColores(List<Color> colores) {
		this.colores = colores;
	}
	public String getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public String getFechaActualizacion() {
		return fechaActualizacion;
	}
	public void setFechaActualizacion(String fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}
	
	
}
