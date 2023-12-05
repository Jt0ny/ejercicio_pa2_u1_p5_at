package com.uce.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IVehiculoRepository;
import com.uce.edu.repository.modelo.Vehiculo;

@Service
public class VehiculoServiceImpl implements IVehiculoService {
	
	@Autowired
	private IVehiculoRepository iVehiculoRepository;

	@Override
	public Vehiculo buscar(String marca) {
	
		return this.iVehiculoRepository.seleccionar(marca);
	}

	@Override
	public void guardar(Vehiculo vehiculo) {
		this.iVehiculoRepository.insertar(vehiculo);
		
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.iVehiculoRepository.actualizar(vehiculo);
		
	}

	@Override
	public void eliminar(String marca) {
	this.iVehiculoRepository.borrar(marca);
		
	}

}
