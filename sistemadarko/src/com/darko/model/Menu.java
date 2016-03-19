package com.darko.model;

public class Menu {
	private int idmenu;
	private String desc_menu;
	private String url_menu;
	private String icon_menu;
	private int nodo;
	private int nodo_padre;
	public int getIdmenu() {
		return idmenu;
	}
	public void setIdmenu(int idmenu) {
		this.idmenu = idmenu;
	}
	public String getDesc_menu() {
		return desc_menu;
	}
	public void setDesc_menu(String desc_menu) {
		this.desc_menu = desc_menu;
	}
	public String getUrl_menu() {
		return url_menu;
	}
	public void setUrl_menu(String url_menu) {
		this.url_menu = url_menu;
	}	
	public String getIcon_menu() {
		return icon_menu;
	}
	public void setIcon_menu(String icon_menu) {
		this.icon_menu = icon_menu;
	}
	public int getNodo() {
		return nodo;
	}
	public void setNodo(int nodo) {
		this.nodo = nodo;
	}
	public int getNodo_padre() {
		return nodo_padre;
	}
	public void setNodo_padre(int nodo_padre) {
		this.nodo_padre = nodo_padre;
	}
	
	
}
