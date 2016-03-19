package com.darko.service;

import java.util.List;

import com.darko.model.TipoPago;


public interface ServiceTipoPago {
	public int registrar(TipoPago tipo) throws Exception;
	public int actualizar(TipoPago tipo) throws Exception;
	public int eliminar(TipoPago tipo) throws Exception;
	public List<TipoPago> lista() throws Exception;
}
