package Biblioteca;

public class Aluno extends Leitor {
	
	public Aluno(String nome, long registro, String contato) {
		super(nome, registro, contato);
		
	}
	
	public String toString() {
		return "Aluno: " + getNome() + ", Registro (RA): " + getRegistro() + ", Contato: " + getContato();
	}
}