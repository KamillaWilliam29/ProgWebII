package br.com.senac.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import br.com.senac.domain.Estudante;

@Service
public class EstudanteService {

	private static Map <Long,Estudante> ListaEstudantes = new HashMap<>();
	
	public ResponseEntity <Estudante> buscarEstudantePorId(Long Id){
		Estudante estudante = ListaEstudantes.get(Id);
		
		if (estudante == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(estudante);
	}

	public ResponseEntity<List <Estudante>> buscarTodosEstudantes(){
		List ListaEstudante = new ArrayList <Estudante>(ListaEstudantes.values());
	
		if (ListaEstudante.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(ListaEstudante);
	}
	
	
	
	}
