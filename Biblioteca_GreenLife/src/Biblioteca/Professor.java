package Biblioteca;

public class Professor extends Leitor {
	private int token;
	
	public Professor(String nome, String contato, int token) {
		super(nome, 0, contato);
		this.token = token;
	}
	
	public int getToken() {
		return token;
	}
	
	public void setToken(int token) {
		this.token = token;
	}
	
	@Override
	public String toString() {
		return "Professor: " + getNome() + ", Contato: " + getContato() + ", Token: " + getToken();
	}
}
