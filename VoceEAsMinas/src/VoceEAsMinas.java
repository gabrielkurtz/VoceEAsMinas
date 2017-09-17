import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
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
		
		Linha[] eixoX = new Linha[1];
		Linha[] eixoY = new Linha[1];

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
//			System.out.println("Consumo de Memória: " + Math.round(gbMemoria*100)/100.0 + "GB");
//			
			// Inicia matriz do tamanho do terreno com todos os pontos falsos			
			eixoX = new Linha[larguraTerreno];
			for(int i=0; i<eixoX.length; i++) {
				eixoX[i] = new Linha();
			}

			eixoY = new Linha[alturaTerreno];
			for(int i=0; i<eixoY.length; i++) {
				eixoY[i] = new Linha();
			}
			
			
			//Vetores para indicar se ha minas em uma determinada Linha ou Coluna			
			
			//Populando campo com as minas do arquivo e informações relevantes
			int minaX, minaY;
			while((linha = br.readLine()) != null) {
				sc = new Scanner(linha).useDelimiter(" ");
								
				minaX = sc.nextInt() - 1;
				minaY = sc.nextInt() - 1;
				
				eixoX[minaX].addMina(minaY);
				eixoY[minaY].addMina(minaX);
				
			}
				
		}
		catch (IOException x) {
			System.err.format("Erro de E/S: %s%n", x);
		}
		
		
		System.out.println("\n--- Matriz do Campo inicializada com sucesso ---"
				+ "\n\n--- Criando cópias dos eixos X e Y ---");
		
		Linha[] copiaEixoX = copiarEixo(eixoX);
		Linha[] copiaEixoY = copiarEixo(eixoY);
		
		System.out.println("\n--- Cópias criadas com sucesso ---");
		
	}
	
	public static Linha[] copiarEixo(Linha[] eixo) {
		Linha[] copia = new Linha[eixo.length];
		for(int i = 0; i<eixo.length; i++) {
			copia[i] = eixo[i].copiar();
		}
		return copia;
	}
}
