package com.uce.edu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.repository.modelo.Propietario;
import com.uce.edu.repository.modelo.Vehiculo;
import com.uce.edu.service.IMatriculaService;
import com.uce.edu.service.IPropietarioService;
import com.uce.edu.service.IVehiculoService;

@SpringBootApplication
public class EjercicioPa2U1P5AtApplication implements CommandLineRunner {

	@Autowired
	private IPropietarioService iPropietarioService;
	@Autowired
	private IVehiculoService iVehiculoService;
	@Autowired
	private IMatriculaService iMatriculaService;
	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioPa2U1P5AtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//1.Crear Vehiculo
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setMarca("KIA");
		vehiculo.setPlaca("PTW420");
		vehiculo.setPrecio(new BigDecimal(5000));
		vehiculo.setTipo("pesado");
		this.iVehiculoService.guardar(vehiculo);
		
		//2.Crear Propietario
		Propietario propietario = new Propietario();
		propietario.setApellido("Tipan");
		propietario.setCedula("1726787425");
		propietario.setGenero("Masculino");
		propietario.setNombre("Anthony");
		this.iPropietarioService.guardar(propietario);
		
		//3.Actualizar 2 atributos de propietario
		 System.out.println("Propieatario sin Actualizar");
		 System.out.println(propietario);
		 System.out.println("Propieatario  Actualizado");
		 propietario.setApellido("Aguas");
		 propietario.setNombre("Luis");
		 this.iPropietarioService.actualizar(propietario);
		 System.out.println(propietario);
		 
		 //4.Realizar Matricula
		 
		 //this.iMatriculaService.matricular("1726787425", "PTW420");

		 
		
		
		
		
		
		
		
	}

}
