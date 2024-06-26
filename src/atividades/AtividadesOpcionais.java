package atividades;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import interface_executar.InterfaceGrafica;
import interface_executar.SelecionaAtividades;
import logica_horarios.SistemaDeTempo;

/*
 * Serão atividades opcionais que o usuário poderá realizar como bônus de tempo
 * em entretenimento e realização para o usuário, principalmente ao sentir-se ocioso
 * ou entediado, o sistema dessa atividade funcionará de forma que a atividade e o
 * tempo sejam escolhidos aleatóriamente pelo sistema.
 */

public class AtividadesOpcionais {

	public static Scanner scanner = new Scanner(System.in);
	public static Map<String, String> atividadesAntiOciosidade = new HashMap<>();
	private String[] atividades = new String[] { "Ler um livro", "Fazer uma caminhada", "Jogar um quebra cabeça",
			"Assista um vídeo info", "Estudar um tema", "Fazer um desenho", "Arrumar o quarto", "Resolva cálculos",
			"Medite", "Escute um podcast" };
	private int[] tempos = new int[] { 10, 15, 20, 25, 30 };
	public static int horas[] = new int[2];
	public static int minutos[] = new int[2];
	public static int segundos[] = new int[2];
	public static boolean primeiraAtividade = false;
	public static boolean segundaAtividade = false;
	public static String atividade;

	public static void defineAtividadeAntiOciosidade(int posicao) {
		AtividadesOpcionais atividadesOpcionais = new AtividadesOpcionais();
		int minutos = atividadesOpcionais.randomizaMinutos();
		String tempo;
		tempo = (0 + "H : " + atividadesOpcionais.tempos[minutos] + "M : " + 0 + "S.");

		if (!AtividadesOpcionais.primeiraAtividade) {
			AtividadesOpcionais.horas[0] = 0;
			AtividadesOpcionais.minutos[0] = 0;
			AtividadesOpcionais.segundos[0] = 0;

		} else if (!AtividadesOpcionais.segundaAtividade) {
			AtividadesOpcionais.horas[1] = 0;
			AtividadesOpcionais.minutos[1] = 0;
			AtividadesOpcionais.segundos[1] = 0;

		}

		AtividadesOpcionais.horas[posicao] = 0;
		AtividadesOpcionais.minutos[posicao] = atividadesOpcionais.tempos[minutos];
		AtividadesOpcionais.segundos[posicao] = 0;

		boolean igual = true;
		String atividade = atividadesOpcionais.randomizaAtividadeAntiOciosidade();
		if (AtividadesOpcionais.atividadesAntiOciosidade.size() > 0) {
			do {
				for (String atividades : AtividadesOpcionais.atividadesAntiOciosidade.keySet()) {
					System.out.println(atividades);
					if (atividade.equals(atividades)) {
						atividade = atividadesOpcionais.randomizaAtividadeAntiOciosidade();
						break;
					} else {
						igual = false;
					}
				}
			} while (igual);
		}
		AtividadesOpcionais.atividadesAntiOciosidade.put(atividade, tempo);
		AtividadesOpcionais.atividade = atividade;

		// LÓGICA ALÉM DOS MINUTOS
		// VERIFICA SE JA EXISTE UMA TAREFA COM O MESMO NOME

		AtividadesOpcionais.primeiraAtividade = true;
		AtividadesOpcionais.segundaAtividade = true;
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

	public int randomizaMinutos() {
		Random random = new Random();
		int tempoRandomizado = random.nextInt(5);
		return tempoRandomizado;
	}

	public static void tempoDecorridoEmAtividadesAntiOciosidade(int hora, int minuto, int segundo) {
		if (hora <= 0 && minuto <= 0 && segundo <= 0) {
			throw new IllegalArgumentException(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
		}

		String atualizaTempo = "";
		boolean igual = false;
		String condicaoParaAcabar = (0 + "H : " + 0 + "M : " + 0 + "S.");
		SistemaDeTempo sistemaDeTempo = new SistemaDeTempo();
		AtividadesOpcionais instancia = new AtividadesOpcionais();

		if (AtividadesOpcionais.atividade.equals(SelecionaAtividades.atividadeOpcional01)) {
			igual = true;

			sistemaDeTempo.tempoDecrementadoEmAtividades(hora, minuto, segundo, 0, instancia);

			atualizaTempo = (AtividadesOpcionais.horas[0] + "H : " + AtividadesOpcionais.minutos[0] + "M : "
					+ AtividadesOpcionais.segundos[0] + "S.");

			System.out.println("\nTempo passado/decrementado com sucesso.");
			System.out.println(atualizaTempo);

		} else if (AtividadesOpcionais.atividade.equals(SelecionaAtividades.atividadeOpcional02)) {
			igual = true;

			sistemaDeTempo.tempoDecrementadoEmAtividades(hora, minuto, segundo, 1, instancia);

			atualizaTempo = (AtividadesOpcionais.horas[1] + "H : " + AtividadesOpcionais.minutos[1] + "M : "
					+ AtividadesOpcionais.segundos[1] + "S.");

			System.out.println("\nTempo passado/decrementado com sucesso.");
			System.out.println(atualizaTempo);

		}

		if (igual) {
			AtividadesOpcionais.atividadesAntiOciosidade.remove(AtividadesOpcionais.atividade);
			AtividadesOpcionais.atividadesAntiOciosidade.put(AtividadesOpcionais.atividade, atualizaTempo);
		}

		for (String atividadeOpcional : AtividadesOpcionais.atividadesAntiOciosidade.keySet()) {
			if (AtividadesOpcionais.atividadesAntiOciosidade.get(atividadeOpcional).equals(condicaoParaAcabar)) {
				System.out.println("\nO tempo restante para concluir a atividade opcional: "
						+ AtividadesOpcionais.atividade + " acabou!");

				System.out.println("\nVocê recebeu +5 minutos adicionais em tempo acumulado!");
				TempoEmAtividades.minutosAcumulados += 5;

				sistemaDeTempo.sistemaDeTempoOrganizado(TempoEmAtividades.horasAcumuladas,
						TempoEmAtividades.minutosAcumulados, TempoEmAtividades.segundosAcumulados);

				TempoEmAtividades.horasAcumuladas = sistemaDeTempo.horasOrganizadas;
				TempoEmAtividades.minutosAcumulados = sistemaDeTempo.minutosOrganizados;
				TempoEmAtividades.segundosAcumulados = sistemaDeTempo.segundosOrganizados;

				AtividadesOpcionais.atividadesAntiOciosidade.remove(AtividadesOpcionais.atividade);
				AtividadesOpcionais.atividade = atividadeOpcional;
				InterfaceGrafica.concluiu = true;

				if (AtividadesOpcionais.atividade.equals(SelecionaAtividades.atividadeOpcional01)) {
					AtividadesOpcionais.primeiraAtividade = false;
					SelecionaAtividades.atividadeOpcional01 = "";

				} else if (AtividadesOpcionais.atividade.equals(SelecionaAtividades.atividadeOpcional02)) {
					AtividadesOpcionais.segundaAtividade = false;
					SelecionaAtividades.atividadeOpcional02 = "";

				}

				break;
			}
		}
	}

}
