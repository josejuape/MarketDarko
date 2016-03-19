package com.darko.dao;

import java.util.List;
import com.darko.model.Color;
import com.darko.model.Marca;

public interface DaoColor {
	public int registrar(Color color) throws Exception;
	public int actualizar(Color color) throws Exception;
	public int eliminar(Color color) throws Exception;
	public List<Color> listar() throws Exception;
	public List<Color> getColores(Marca marca) throws Exception;
}
