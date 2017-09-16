import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class VoceEAsMinas {

	public static void main(String args[]) {
	
		Scanner in = new Scanner(System.in);
		
		System.out.print("--- Pontificia Universidade Catolica do Rio Grande do Sul ---"
				+ "\n--- Bacharelado em Engenharia de Software ---"
				+ "\n--- Disciplina de Algoritmos e Estruturas de Dados II ---"
				+ "\n--- Prof. Joao Batista Oliveira ---"
				+ "\n--- Gabriel Ferreira Kurtz ---"
				+ "\n\n----------------------------------------------------------------"
				+ "\n--- ALGORITMO DE DETECÇÃO DE MAIOR RETANGULO EM CAMPO MINADO ---"
				+ "\n----------------------------------------------------------------"
				+ "\n\nInsira o nome do arquivo de dados a ser processado:"
				+ "\n> ");

		String arquivo = in.nextLine();
		Path input = Paths.get(arquivo);

		System.out.println("\n--- Inicializando Matriz de Minas para arquivo " + arquivo + " ---");
		

		
		System.out.println("\n--- Adaptacao concluida ---"
				+ "\n\n--- Realizando contagem de palavras para Lista Remissiva ---");
		
		Path pathFormatado = Paths.get("textoAdaptado.txt");
		
		contador = new ContadorDePalavras(pathFormatado, lista);
		contador.contar();
		
		System.out.println("\n--- Contagem finalizada com sucesso ---");
	
		
	}
	
}
