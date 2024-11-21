package Biblioteca;

public class Livro {
	
	private String titulo;
	private String autor;
	private int publicacao;
	private boolean disponivel = true;
	
	public Livro(String titulo, String autor, int publicacao) {
		this.titulo = titulo;
		this.autor = autor;
		this.publicacao = publicacao;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}
	
	public int getPublicacao() {
		return publicacao;
	}
	
	public void setPublicacao(int publicacao) {
		if(publicacao>2024) {
			System.out.println("Erro ! Ano de publicação não pode ser superior a 2024 !.");
			return;
		}
		this.publicacao = publicacao;
	}
	
	public boolean getDisponivel() {
		return disponivel;
	}
	
	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	
	@Override
	public String toString() {
		return "Titulo: " + this.titulo + ", Autor: " + this.autor + ", Ano de publicação: " + this.publicacao + ", Disponivel = " this.disponivel;
	}
}
