package Biblioteca;

public class Leitor {

	private String nome;
	private long registro;
	private String contato;
	
	public Leitor(String nome, long registro, String contato) {
		this.nome = nome;
		this.registro = registro;
		this.contato = contato;
		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getRegistro() {
		return registro;
	}
	
	public void setRegistro(long registro) {
		this.registro = 0;
	}
	
	public String getContato() {
		return contato;
	}
	
	public void setContato(String contato) {
		this.contato = contato;
	}
	

	@Override
	public String toString() {
		return "Aluno: " + this.nome + ", Registro: " + this.registro + ", Contato: " + this.contato;
	}
	
	
}

