package com.darko.dao;

import java.util.List;
import com.darko.model.TipoPago;

public interface DaoTipoPago {
	public int registrar(TipoPago comp) throws Exception;
	public int actualizar(TipoPago comp) throws Exception;
	public int eliminar(TipoPago comp) throws Exception;
	public List<TipoPago> listar() throws Exception;
}
