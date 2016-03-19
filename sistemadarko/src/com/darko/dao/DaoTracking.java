package com.darko.dao;

import java.util.List;

import com.darko.model.Tracking;

public interface DaoTracking {
	public int registrar(Tracking tracking) throws Exception;
	public int actualizar(Tracking tracking) throws Exception;
	public int eliminar(Tracking tracking) throws Exception;
	public List<Tracking> listar() throws Exception;
	public List<Tracking> getTracking(Tracking tracking) throws Exception;
}
