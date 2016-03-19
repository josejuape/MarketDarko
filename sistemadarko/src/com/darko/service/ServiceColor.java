package com.darko.service;

import java.util.List;

import com.darko.model.Color;
import com.darko.model.Marca;

public interface ServiceColor {
	public int registrar(Color color) throws Exception;
	public int actualizar(Color color) throws Exception;
	public int eliminar(Color color) throws Exception;
	public List<Color> lista() throws Exception;
	public List<Color> getColores(Marca marca) throws Exception;
}
