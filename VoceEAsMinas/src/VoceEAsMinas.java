import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
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
		
		boolean[][] campo = new boolean[1][1];
		boolean[] temMinaX;
		boolean[] temMinaY;
		
		try (BufferedReader br = Files.newBufferedReader(input, Charset.forName("utf8")))
		{
			String linha = br.readLine();
			Scanner sc = new Scanner(linha).useDelimiter(" ");
			
			System.out.println(linha);
			
			int larguraTerreno = sc.nextInt();
			System.out.println("Largura do Terreno: " + larguraTerreno);
			int alturaTerreno = sc.nextInt();
			System.out.println("Altura do Terreno: " + alturaTerreno);
			int numeroMinas = sc.nextInt();
			System.out.println("Número de Minas: " + numeroMinas);
			long totalCoord = Long.valueOf(larguraTerreno) * Long.valueOf(alturaTerreno);
			System.out.println("Total de Coordenadas no Terreno: " + totalCoord);
			double gbMemoria = totalCoord/1073741824.0;
			System.out.println("Consumo de Memória: " + Math.round(gbMemoria*100)/100.0 + "GB");
			
			// Inicia matriz do tamanho do terreno com todos os pontos falsos			
			campo = new boolean[larguraTerreno][alturaTerreno];
			
			//Vetores para indicar se ha minas em uma determinada Linha ou Coluna			
			temMinaX = new boolean[larguraTerreno];

			temMinaY = new boolean[alturaTerreno];
			
			
			//Populando campo com as minas do arquivo e informações relevantes
			int minaX, minaY;
			while((linha = br.readLine()) != null) {
				sc = new Scanner(linha).useDelimiter(" ");
								
				minaX = sc.nextInt() - 1;
				minaY = sc.nextInt() - 1;
				
				campo[minaX][minaY] = true;
				temMinaX[minaX] = true;
				temMinaY[minaY] = true;
				
			}
				
		}
		catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
		
		
		System.out.println("\n--- Matriz do Campo inicializada com sucesso ---");
	
	}
	
}
