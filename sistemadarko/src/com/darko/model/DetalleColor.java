package com.darko.model;

public class DetalleColor {
		private int iddetallecolor;
		private String nombre;
		private String estado;
		private Color color;
		private Inventario inventario;
		
		public int getIddetallecolor() {
			return iddetallecolor;
		}
		public void setIddetallecolor(int iddetallecolor) {
			this.iddetallecolor = iddetallecolor;
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
		public Color getColor() {
			return color;
		}
		public void setColor(Color color) {
			this.color = color;
		}
		public Inventario getInventario() {
			return inventario;
		}
		public void setInventario(Inventario inventario) {
			this.inventario = inventario;
		}
		
		
}
