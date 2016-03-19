package com.darko.service;

import java.util.List;

import com.darko.model.Comprobante;

public interface ServiceComprobante {
	public int registrar(Comprobante comp) throws Exception;
	public int actualizar(Comprobante comp) throws Exception;
	public int eliminar(Comprobante comp) throws Exception;
	public List<Comprobante> lista() throws Exception;
}
