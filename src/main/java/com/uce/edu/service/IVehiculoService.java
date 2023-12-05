package com.uce.edu.service;

import com.uce.edu.repository.modelo.Vehiculo;

public interface IVehiculoService {
	
	public Vehiculo buscar (String marca);
	
	public void guardar (Vehiculo vehiculo);
	
	public  void actualizar (Vehiculo vehiculo );
	
	public void eliminar (String marca);


}