package com.uce.edu.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.repository.IMatriculaRepository;
import com.uce.edu.repository.IPropietarioRepository;
import com.uce.edu.repository.IVehiculoRepository;
import com.uce.edu.repository.modelo.Matricula;
import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;

@Service
public class MatriculaServiceImpl  implements IMatriculaService{
	
	@Autowired
	private IMatriculaRepository iMatriculaRepository;
	@Autowired
	private IVehiculoRepository iVehiculoRepository;
	@Autowired
	private IPropietarioRepository iPropietarioRepository;
	
	
	@Override
	public void matricular(String cedula, String placa) {
		
		Propietario propietario=this.iPropietarioRepository.seleccionar(cedula);
		Vehiculo vehiculo=this.iVehiculoRepository.seleccionar(placa);
		
		Matricula matricula= new Matricula();
		matricula.setPropietario(propietario);
		matricula.setVehiculo(vehiculo);
		matricula.setFechaMatricula(LocalDate.now());
		
		
		if(vehiculo.getTipo().equals("pesado")) {
			
			BigDecimal valorM= vehiculo.getPrecio().multiply(new BigDecimal(0.25));
			
			if(valorM.compareTo(new BigDecimal(2200))>0) {
				matricula.setValorMatricula(valorM.multiply(new BigDecimal(0.95)));
				System.out.println("Aplica descuento del 5%:");
				//this.iMatriculaRepository.insertar(matricula);;
				
			}
			
			this.iMatriculaRepository.insertar(matricula);
			System.out.println(matricula);
			
		}else {
			BigDecimal valorM=vehiculo.getPrecio().multiply(new BigDecimal(0.2));
			
			if(valorM.compareTo(new BigDecimal(2200))>0) {
				matricula.setValorMatricula(valorM.multiply(new BigDecimal(0.95)));
				System.out.println("Aplica descuento del 5%:");
				//this.iMatriculaRepository.insertar(matricula);
					
			}
			this.iMatriculaRepository.insertar(matricula);
			System.out.println(matricula);
		}
		
				
	}

}
