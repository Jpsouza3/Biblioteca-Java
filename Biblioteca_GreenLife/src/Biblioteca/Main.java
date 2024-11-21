package Biblioteca;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class Main {
	
	private static List<Leitor> leitores = new ArrayList<>();
	private static List<Livro> livros = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		boolean menu = true;
		
		
		System.out.println("|-------------------------------------------------------------|");
		System.out.println("|                                                             |");
		System.out.println("|******************* GLL 1.0 (Beta Test) *********************|");  // Interface apenas para beta test
		System.out.println("|                                                             |");
		System.out.println("|-------------------------------------------------------------|\n");
		//Thread.sleep(3000);
		
		while(menu) {
		System.out.println("---- MENU ----");
		System.out.println("1 - Cadastrar Livro");
		System.out.println("2 - Cadastrar Leitor");
		System.out.println("3 - Editar Livro");
		System.out.println("4 - Editar Leitor");
		System.out.println("5 - Deletar Livro");
		System.out.println("6 - Deletar Leitor");
		System.out.println("7 - Listar Livros");
		System.out.println("8 - Listar Leitores");
		System.out.println("9 - Sair");
		System.out.print("Escolha uma opção: ");
		
		int opcao;
		
		opcao = scanner.nextInt();
		
		switch(opcao) {
		case 1: cadastrarLivro();
			break;
		case 2: cadastrarLeitor();
			break;
		case 3: editarLivro();
			break;
		case 4: editarLeitor();
			break;
		case 5: deletarLivro();
			break;
		case 6: deletarLeitor();
			break;
		case 7: listarLivros();
			break;
		case 8: listarLeitores();
			break;
		case 9:
			System.out.println("Saíndo do sistema, obrigado por testar... :)");
			menu = false;
			break;
		default:
			System.out.println("Opção inválida, tente novamente !");
			Thread.sleep(3000);
			break;
			
    }
  }
}
		
////////////////////////////////////////////////////////////----MÉTODOS----///////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	
	
////////////////////////////////////////////////////////////----CADASTRAR LIVRO----///////////////////////////////////////////////////////////////////////
		
		
	 private static void cadastrarLivro() throws InterruptedException {
		 
		 System.out.println("Título do Livro: ");
		 scanner.nextLine();
		 String titulo = scanner.nextLine();
		 
		 System.out.println("Autor do Livro: ");
		 String autor = scanner.nextLine();
		 
		 while(true) {
		 System.out.println("Ano de Publicação: ");
		 int publicacao = scanner.nextInt();
		 scanner.nextLine();
		 if(publicacao>2024) {
			System.out.println("Erro ! Ano de publicação não pode ser superior a 2024 !!!.");
	}else {
		Livro livro = new Livro(titulo, autor, publicacao);
		 livros.add(livro);
		 
		 System.out.println("Livro cadastrado com sucesso !");
		 Thread.sleep(3000);
		 break;
    }
  }
}
		 

	
////////////////////////////////////////////////////////////----CADASTRAR LEITOR----////////////////////////////////////////////////////////////////////
	 
	 private static void cadastrarLeitor() throws InterruptedException {
		 
		 int opc2 = 0;
		 int token = 0;
	
		 while(true) {
			 
	 try {
		 System.out.println("Digite 1 para cadastrar Professor ou 2 para cadastrar Aluno");
		 opc2 = scanner.nextInt();
		 if(opc2== 1 || opc2==2) {
		 scanner.nextLine();
		 break;
	}else{
		System.out.println("Opção inválida !");
	}
	 } catch (InputMismatchException e) {
		 System.out.println("Opção inválida, insira apenas números !");
		 scanner.nextLine();
  }
}
	
		 
		 if(opc2==1) {
		
		  System.out.println("Nome: ");
		  String nome = scanner.nextLine();
		  
		  System.out.println("Email para contato: ");
		  String contato = scanner.nextLine();
		  
		  while(true) {
			  try {
                  System.out.println("Token de Segurança: ");
                  token = scanner.nextInt();
                  break;
                  
	   } catch(InputMismatchException e) {
		   		  System.out.println("Erro: Digite apenas números inteiros !");
		   		  scanner.nextLine();
	   }
}
          
          System.out.println("Professor cadastrado com sucesso !");
		leitores.add(new Professor(nome, contato, token));
          Thread.sleep(3000);
          
	} else if(opc2==2) {
			 
		  System.out.println("Nome: ");
		  String nome = scanner.nextLine();
		  
		  System.out.println("Registro (RA): ");
		  long registro = scanner.nextLong();
		  
		  System.out.println("Email para contato: ");
		  scanner.nextLine();
		  String contato = scanner.nextLine();
		  //scanner.nextLine();
		  
		  System.out.println("Aluno cadastrado com sucesso !");
		  leitores.add(new Aluno(nome, registro, contato));
		  Thread.sleep(3000);	  	 
  } 
}
	 
////////////////////////////////////////////////////////////----EDITAR LIVRO----////////////////////////////////////////////////////////////////////
	 
	 public static void editarLivro() throws InterruptedException {
		    if (livros.isEmpty()) {
		        System.out.println("Nenhum livro cadastrado.");
		        return;
		    }

		    System.out.println("Lista de livros: ");
		    for (int i = 0; i < livros.size(); i++) { 
		        System.out.println((i + 1) + " - " + livros.get(i));
		    }

		    System.out.println("Selecione qual livro deseja editar: ");
		    int idc2 = scanner.nextInt();
		    scanner.nextLine(); 

		    int idc1 = idc2 - 1;

		    if (idc1 >= 0 && idc1 < livros.size()) {
		        Livro livro = livros.get(idc1);

		    System.out.println("Novo título: ");
		    String novoTitulo = scanner.nextLine();
		    livro.setTitulo(novoTitulo);

		    System.out.println("Novo autor: ");
		    String novoAutor = scanner.nextLine();
		    livro.setAutor(novoAutor);

		    while (true) {
		    	System.out.println("Nova data de publicação: ");
		        int novaPublicacao = scanner.nextInt();
		        scanner.nextLine();

		        if (novaPublicacao > 2024) {
		        	System.out.println("Erro! Ano de publicação não pode ser superior a 2024!");
	}else {
		livro.setPublicacao(novaPublicacao);
		System.out.println("Livro editado com sucesso!");
		Thread.sleep(2000);
		break; 
	}
}
	}else {
		        System.out.println("Livro não encontrado ou não listado.");
		        Thread.sleep(3000);
 }
}

	
////////////////////////////////////////////////////////////----EDITAR LEITOR----////////////////////////////////////////////////////////////////////
	 
	 public static void editarLeitor() throws InterruptedException {
		 if(leitores.isEmpty()) {
			 System.out.println("Nenhum leitor cadastrado.");
			 Thread.sleep(3000);
			 return;
		 }
		 
		 System.out.println("Lista de leitores: ");
		 for(int i=0; i<leitores.size(); i++) {
			 System.out.println((i + 1) + " - " + leitores.get(i));
		 }
		 
		 System.out.println("Selecione qual leitor deseja editar: ");
		 int idc = scanner.nextInt();
		 scanner.nextLine();
		 
		 int idc3 = idc - 1;
		 
		 if(idc3>=0 && idc3<= leitores.size()) {
			 Leitor leitor = leitores.get(idc3);
			 
		 try {
			 
			 System.out.println("Novo nome: ");
			 leitor.setNome(scanner.nextLine());
			 
			 System.out.println("Novo contato: ");
			 leitor.setContato(scanner.nextLine());
			 
			 if(leitor instanceof Aluno) {
			 
			 System.out.println("Novo registro (RA): ");
			 ((Aluno) leitor).setRegistro(scanner.nextLong());
			 scanner.nextLine();
			 
			 System.out.println("Leitor editado com sucesso");
			 Thread.sleep(3000);
			 
	 }else if (leitor instanceof Professor) {
		 
		     System.out.println("Novo token de segurança: ");
		     ((Professor) leitor).setToken(scanner.nextInt());
		     scanner.nextLine();
	 }
		 } catch (InputMismatchException e) {
			 System.out.println("Erro na inserção dos dados. Insira os dados corretamente.");
			 scanner.nextLine();
		 }
			 
			 
	 }else {
		 System.out.println("Índice inválido !");
  }	 
}
	 
////////////////////////////////////////////////////////////----DELETAR LIVRO----////////////////////////////////////////////////////////////////////
	 
	 private static void deletarLivro() throws InterruptedException {		 
		 if(livros.isEmpty()) {
			 System.out.println("Nenhum livro cadastrado.");
			 Thread.sleep(2000);
			 return;
		 }
		 
		 while(true) {
		 System.out.println("Lista de livros: ");
		 for(int i=0; i<livros.size(); i++) {                         //mostrando livros da lista
			 System.out.println((i + 1) + " - " + livros.get(i));
		 }
		 
		 System.out.println("Selecione livro deseja remover da lista: ");
		 int idc = scanner.nextInt();
		 scanner.nextLine();
		 
		 int idc4 = idc - 1;
		 
		 if(idc4>=0 && idc4<= livros.size()) {
		 livros.remove(idc4);
		 System.out.println("Livro removido com sucesso !");
		 Thread.sleep(1000);
		 if(livros.isEmpty()) {
			 System.out.println("Todos os livros foram removidos.");
			 Thread.sleep(3000);
			 return;
		}
	  }
	}
  }
	 
////////////////////////////////////////////////////////////----DELETAR LIVRO----////////////////////////////////////////////////////////////////////
	 
	 private static void deletarLeitor() throws InterruptedException {
		 
		 if(leitores.isEmpty()) {
			 System.out.println("Nenhum leitor cadastrado.");
			 Thread.sleep(2000);
			 return;
		 }
		 
		 while(true) {
		 System.out.println("Lista de leitores: ");
		 for(int i=0; i<leitores.size(); i++) {                         
			 System.out.println((i + 1) + " - " + leitores.get(i));
		 }
		 
		 System.out.println("Selecione o leitor que deseja remover da lista: ");
		 int idc = scanner.nextInt();
		 scanner.nextLine();
		 
		 int idc5 = idc - 1;
		 
		 if(idc5>=0 && idc5<= leitores.size()) {
		 leitores.remove(idc5);
		 System.out.println("Leitor removido com sucesso !");
		 Thread.sleep(1000);
		 if(leitores.isEmpty()) {
			 System.out.println("Todos os leitores foram removidos.");
			 Thread.sleep(3000);
			 return;
	  }
	}
  }
}
	 
////////////////////////////////////////////////////////////----LISTAR LIVROS----////////////////////////////////////////////////////////////////////
	 
	 public static void listarLivros() throws InterruptedException {
		 
		 if(livros.isEmpty()) {
			 System.out.println("Nenhum livro cadastrado até o momento.");
			 Thread.sleep(2000);
			 return;
		 }
		 
		 scanner.nextLine();
		 
		 while(true) {
		 System.out.println("Lista de livros: ");
		 for(int i=0; i<livros.size(); i++) {                         //mostrando livros da lista
			 System.out.println((i + 1) + " - " + livros.get(i));
		 }
		 
		 System.out.println("Pressione qualquer tecla para sair.");
		 String saida = scanner.nextLine();
		 
		 if(!saida.isEmpty()) {
			 break;
    } 
  }	 
}
	 
////////////////////////////////////////////////////////////----LISTAR LEITORES----////////////////////////////////////////////////////////////////////
	 
	 public static void listarLeitores() throws InterruptedException {
		 
		 if(leitores.isEmpty()) {
			 System.out.println("Nenhum leitor cadastrado.");
			 Thread.sleep(2000);
			 return;
		 }
		 
		 while(true) {
		 System.out.println("Lista de leitores: ");
		 for(int i=0; i<leitores.size(); i++) {                         //mostrando livros da lista
			 System.out.println((i + 1) + " - " + leitores.get(i));
	} 
		 System.out.println("Pressione qualquer tecla para sair.");
		 scanner.nextLine();
		 String saida = scanner.nextLine();
		 
		 if(!saida.isEmpty()) {
			 break;
   }
  }
 }
}
	 
////////////////////////////////////////////////////////////---INTEGRANTES DO GRUPO----////////////////////////////////////////////////////////////////////


// João Vitor de Oliveira Melo 322100895
// Joao Pedro Souza 924113116
// Gabriel Tavares Costa Chaves 924118680
// Henrique Stamczak Gonçalves 924101537
// Vinicius Ribeiro Moraes 924109608
// Márcio Henrique Guimarães 924102215
// Camila da Silva Centelo 924108133
// Nicolas de Andrade da Silva 924205464
// Guilherme José da Silva 924101580
