package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Vehiculo;

@Repository
public class VehiculoRepositoryImpl implements IVehiculoRepository {

	
	private static List<Vehiculo> base= new ArrayList<Vehiculo>();
	
	@Override
	public Vehiculo seleccionar(String marca) {
		
		for (Vehiculo vehiculo:base) {
			if(vehiculo.getMarca().equals(marca)) {
				Vehiculo vehi= new Vehiculo();
				vehi.setMarca(vehiculo.getMarca());
				vehi.setPlaca(vehiculo.getPlaca());
				vehi.setPrecio(vehiculo.getPrecio());
				vehi.setTipo(vehiculo.getTipo());
				return vehi;
			}
		}
		return null;
	}

	public Vehiculo seleccionarEliminar (String marca) {
		
		for (Vehiculo vehiculo:base) {
			if(vehiculo.getMarca().equals(marca)) {
				return vehiculo;
			}	
		}
		return null;
	}
	
	@Override
	public void insertar(Vehiculo vehiculo) {
		base.add(vehiculo);
		
	}

	@Override
	public void actualizar(Vehiculo vehiculo) {
		this.borrar(vehiculo.getMarca());
		this.insertar(vehiculo);
		
	}

	@Override
	public void borrar(String marca) {
		Vehiculo vehiculo = this.seleccionarEliminar(marca);
		base.remove(vehiculo);
		
	}

}
