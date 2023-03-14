package br.com.senac.domain;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Estudante {

	@Getter
	@Setter
	private Long Id;
	
	private String nome;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private LocalDate dataNascimento;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String Nome) {
		this.nome = nome;
	}
	public Long getId() {
		// TODO Auto-generated method stub
		return Id;
	}
	public void setId() {
		this.Id = Id;
	}
}
