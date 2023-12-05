package com.uce.edu.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Matricula;

@Repository
public class MatriculaRepositoryImpl implements IMatriculaRepository {

	private static List<Matricula> base= new ArrayList<Matricula>();
	
	@Override
	public void insertar(Matricula matricula) {
		base.add(matricula);
		
	}

}
