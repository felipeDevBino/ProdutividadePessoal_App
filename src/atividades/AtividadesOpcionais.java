package atividades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import executar.InterfaceGrafica;
import logica_horarios.SistemaDeTempo;

/*
 * Serão atividades opcionais que o usuário poderá realizar como bônus de tempo
 * em entretenimento e realização para o usuário, principalmente ao sentir-se ocioso
 * ou entediado, o sistema dessa atividade funcionará de forma que a atividade e o
 * tempo sejam escolhidos aleatóriamente pelo sistema.
 */

public class AtividadesOpcionais {

	static Scanner scanner = new Scanner(System.in);
	public static Map<String, String> atividadesAntiOciosidade = new HashMap<String, String>();
	private String[] atividades = new String[] { "Ler um livro", "Fazer uma caminhada", "Jogar um quebra cabeça",
			"Assista um vídeo info", "Estudar um tema", "Fazer um desenho", "Arrumar o quarto",
			"Resolva cálculos", "Medite", "Escute um podcast" };
	private int[] tempos = new int[] { 10, 15, 20, 25, 30 };
	// LÓGICA ALÉM DOS MINUTOS
	public static List<Integer> horas = new ArrayList<Integer>();
	public static List<Integer> minutos = new ArrayList<Integer>();
	public static List<Integer> segundos = new ArrayList<Integer>();
	public static String atividade;
	public static int contador = 0;

	public static String defineAtividadeAntiOciosidade() {
		AtividadesOpcionais atividadesOpcionais = new AtividadesOpcionais();
		String tempo;
		int minutos = atividadesOpcionais.randomizaMinutos();
		tempo = (0 + "H : " + atividadesOpcionais.tempos[minutos] + "M : " + 0 + "S.");
		
		AtividadesOpcionais.atividadesAntiOciosidade.put(atividadesOpcionais.randomizaAtividadeAntiOciosidade(),
				tempo);

		AtividadesOpcionais.horas.add(AtividadesOpcionais.contador, 0);
		AtividadesOpcionais.minutos.add(AtividadesOpcionais.contador, atividadesOpcionais.tempos[minutos]);
		AtividadesOpcionais.segundos.add(AtividadesOpcionais.contador, 0);
		
			//LÓGICA ALÉM DOS MINUTOS
			//VERIFICA SE JA EXISTE UMA TAREFA COM O MESMO NOME
		
		AtividadesOpcionais.contador++;
		return AtividadesOpcionais.atividade;
	}

	public String getAtividade() {
		boolean formatoInvalido = false;
		int numeroDaAtividade = 0;
		do {
			try {
				System.out.println("\nDigite o número da atividade:");
				numeroDaAtividade = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("\nNúmero inválido! Digite um número inteiro válido.");
				formatoInvalido = true;
			}
		} while (formatoInvalido || numeroDaAtividade <= 0
				|| numeroDaAtividade > AtividadesOpcionais.atividadesAntiOciosidade.size());
		int contador = 1;
		for (String buscaAtividade : AtividadesOpcionais.atividadesAntiOciosidade.keySet()) {
			if (contador == numeroDaAtividade) {
				System.out.println("\nAtividade encontrada! " + buscaAtividade);
				AtividadesOpcionais.atividade = buscaAtividade;
				break;
			}
			contador++;
		}
		return AtividadesOpcionais.atividade;

	}

	public static void getTodasAsAtividades() {
		int contador = 0;
		for (String atividade : AtividadesOpcionais.atividadesAntiOciosidade.keySet()) {
			for (String tempoDisponivel : AtividadesOpcionais.atividadesAntiOciosidade.values()) {
				System.out.println("\nAtividade (" + (contador + 1) + "): " + atividade + ", Tempo Restante: "
						+ tempoDisponivel + ".");
				contador++;
			}
		}
	}

	public String randomizaAtividadeAntiOciosidade() {
		Random random = new Random();
		int randomizaAtividade = random.nextInt(11) + 1;
		switch (randomizaAtividade) {
		case 1:
			AtividadesOpcionais.atividade = atividades[0];
			break;
		case 2:
			AtividadesOpcionais.atividade = atividades[1];
			break;
		case 3:
			AtividadesOpcionais.atividade = atividades[2];
			break;
		case 4:
			AtividadesOpcionais.atividade = atividades[3];
			break;
		case 5:
			AtividadesOpcionais.atividade = atividades[4];
			break;
		case 6:
			AtividadesOpcionais.atividade = atividades[5];
			break;
		case 7:
			AtividadesOpcionais.atividade = atividades[6];
			break;
		case 8:
			AtividadesOpcionais.atividade = atividades[7];
			break;
		case 10:
			AtividadesOpcionais.atividade = atividades[8];
			break;
		case 11:
			AtividadesOpcionais.atividade = atividades[9];
			break;
		}
		return AtividadesOpcionais.atividade;
	}

	public static void tempoDecorridoEmAtividadesAntiOciosidade(Integer hora, Integer minuto, Integer segundo) {
		if (hora <= 0 && minuto <= 0 && segundo <= 0) {
			throw new IllegalArgumentException(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
		}
		
		int contador = 0;
		String atualizaTempo = "";
		boolean igual = false;
		for (String atividadeOpcional : AtividadesOpcionais.atividadesAntiOciosidade.keySet()) {
			if (AtividadesOpcionais.atividade.equals(atividadeOpcional)) {
				igual = true;
				
				AtividadesOpcionais tempoEmAtividadesOpcionais = new AtividadesOpcionais();
				SistemaDeTempo sistemaDeTempo = new SistemaDeTempo();
				sistemaDeTempo.tempoDecrementadoEmAtividades(hora, minuto, segundo, contador, tempoEmAtividadesOpcionais);
				
				atualizaTempo = (AtividadesOpcionais.horas.get(contador) + "H : "
						+ AtividadesOpcionais.minutos.get(contador) + "M : " + AtividadesOpcionais.segundos.get(contador)
						+ "S.");
				
				System.out.println("\nTempo passado/decrementado com sucesso.");
				String condicaoParaAcabar;
				condicaoParaAcabar = (0 + "H : " + 0 + "M : " + 0 + "S.");
				if (AtividadesOpcionais.atividadesAntiOciosidade.get(atividadeOpcional) //ATUALIZAR DEPOIS
						.equals(condicaoParaAcabar) || AtividadesOpcionais.horas.get(contador) < 0 || AtividadesOpcionais.minutos.get(contador) < 0 || AtividadesOpcionais.segundos.get(contador) < 0) {
					System.out.println(
							"\nO tempo restante para concluir a atividade opcional: " + atividadeOpcional + " acabou!");
					InterfaceGrafica.concluiu = true;
					
					//TEMPO ACUMULADO++
					
				}

			}
			contador++;
		}
		if(igual) {
			AtividadesOpcionais.atividadesAntiOciosidade.remove(AtividadesOpcionais.atividade);
			AtividadesOpcionais.atividadesAntiOciosidade.put(AtividadesOpcionais.atividade, atualizaTempo);
		}

	}

	public int randomizaMinutos() {
		Random random = new Random();
		int tempoRandomizado = random.nextInt(5);
		return tempoRandomizado;
	}

}
