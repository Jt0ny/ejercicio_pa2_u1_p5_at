package com.uce.edu.repository;

import com.uce.edu.repository.modelo.Vehiculo;

public interface IVehiculoRepository {
	
	public Vehiculo seleccionar (String marca);
	
	public void insertar (Vehiculo vehiculo);
	
	public  void actualizar (Vehiculo vehiculo );
	
	public void borrar (String marca);

}
