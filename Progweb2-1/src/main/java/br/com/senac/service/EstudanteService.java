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
		List <Estudante> ListaEstudante = new ArrayList <Estudante>(ListaEstudantes.values());
	
		if (ListaEstudante.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(ListaEstudante);
	}
	
	public ResponseEntity<Estudante> cadastrarEstudante(Estudante estudante) {
		ListaEstudantes.put(estudante.getId(), estudante);
		return ResponseEntity.status(HttpStatus.CREATED).body(estudante);
	}
	
	public ResponseEntity<Estudante> atualizarEStudante(Estudante estudante){
		Estudante estudanteEncontrado = ListaEstudantes.get(estudante.getId());
		if (estudanteEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
			
		}
		
		ListaEstudantes.put(estudante.getId(), estudante);
		return ResponseEntity.status(HttpStatus.OK).body(estudante);
	}
	
	public ResponseEntity<String> removerUsuario(long Id){
		Estudante estudanteEncontrado = ListaEstudantes.get(Id);
		if(estudanteEncontrado == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		
		ListaEstudantes.remove(Id);
		return ResponseEntity.status(HttpStatus.OK).body("Estudante removido com louvor");
	}
	
	}
