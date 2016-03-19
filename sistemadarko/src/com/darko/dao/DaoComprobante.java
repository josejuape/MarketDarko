package com.darko.dao;

import java.util.List;
import com.darko.model.Comprobante;

public interface DaoComprobante {
	public int registrar(Comprobante comp) throws Exception;
	public int actualizar(Comprobante comp) throws Exception;
	public int eliminar(Comprobante comp) throws Exception;
	public List<Comprobante> listar() throws Exception;
}
