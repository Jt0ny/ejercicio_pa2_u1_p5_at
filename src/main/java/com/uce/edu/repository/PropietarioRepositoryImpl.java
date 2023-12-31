package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Propietario;

@Repository
public class PropietarioRepositoryImpl implements IPropietarioRepository {

	private static List<Propietario>base=new  ArrayList<Propietario>();

	@Override
	public Propietario seleccionar(String cedula) {
	
		for (Propietario propietario:base) {
			if(propietario.getCedula().equals(cedula)) {
				Propietario pro= new Propietario();
				pro.setApellido(propietario.getApellido());
				pro.setCedula(propietario.getCedula());
				pro.setGenero(propietario.getGenero());
				pro.setNombre(propietario.getNombre());
				return pro;
			}
		}
		return null;
	}
	
	public Propietario seleccionarEliminar (String cedula) {
		for (Propietario propietario:base) {
			if(propietario.getCedula().equals(cedula)) {
				return propietario;
			}
		}
		return null;
		
	}
	
	@Override
	public void insertar(Propietario propietario) {
		base.add(propietario);
	}

	@Override
	public void actualizar(Propietario propietario) {
		this.borrar(propietario.getCedula());
		this.insertar(propietario);
		
	}

	@Override
	public void borrar(String cedula) {
	 Propietario propietario = this.seleccionarEliminar(cedula);
	  base.remove(propietario);
		
	}	
	
	
	

}
