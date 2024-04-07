package tabelas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/*
 * Serão atividades opcionais que o usuário poderá realizar como bônus de tempo
 * em entretenimento e realização para o usuário, principalmente ao sentir-se ocioso
 * ou entediado, o sistema dessa atividade funcionará de forma que a atividade e o
 * tempo sejam escolhidos aleatóriamente pelo sistema.
 */

public class AtividadesAntiOciosidade implements Runnable {

	static Scanner scanner = new Scanner(System.in);
	public static Map<String, String> atividadesAntiOciosidade = new HashMap<String, String>();
	private String[] atividades = new String[] { "Ler um livro", "Fazer uma caminhada", "Jogar um quebra cabeça",
			"Assistir a um documentário", "Estudar um tema de preferência", "Fazer um desenho", "Arrumar o quarto",
			"Resolva cálculos", "Medite", "Escute um podcast informativo" };
	private int[] tempos = new int[] { 10, 15, 20, 25, 30 };
	// LÓGICA ALÉM DOS MINUTOS
	public static List<Integer> horas = new ArrayList<Integer>();
	public static List<Integer> minutos = new ArrayList<Integer>();
	public static List<Integer> segundos = new ArrayList<Integer>();
	public static String atividade;
	public static int contador = 0;

	public static String defineAtividadeAntiOciosidade() {
		AtividadesAntiOciosidade atividadesOpcionais = new AtividadesAntiOciosidade();
		String tempo;
		tempo = (0 + "H : " + atividadesOpcionais.tempos[atividadesOpcionais.randomizaMinutos()] + "M : " + 0 + "S.");
		AtividadesAntiOciosidade.atividadesAntiOciosidade.put(atividadesOpcionais.randomizaAtividadeAntiOciosidade(),
				tempo);

		AtividadesAntiOciosidade.contador++;
		return AtividadesAntiOciosidade.atividade;
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
				|| numeroDaAtividade > AtividadesAntiOciosidade.atividadesAntiOciosidade.size());
		int contador = 1;
		for (String buscaAtividade : AtividadesAntiOciosidade.atividadesAntiOciosidade.keySet()) {
			if (contador == numeroDaAtividade) {
				System.out.println("\nAtividade encontrada! " + buscaAtividade);
				AtividadesAntiOciosidade.atividade = buscaAtividade;
				break;
			}
			contador++;
		}
		return AtividadesAntiOciosidade.atividade;

	}

	public static void getTodasAsAtividades() {
		int contador = 0;
		for (String atividade : AtividadesAntiOciosidade.atividadesAntiOciosidade.keySet()) {
			for (String tempoDisponivel : AtividadesAntiOciosidade.atividadesAntiOciosidade.values()) {
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
			AtividadesAntiOciosidade.atividade = atividades[0];
			break;
		case 2:
			AtividadesAntiOciosidade.atividade = atividades[1];
			break;
		case 3:
			AtividadesAntiOciosidade.atividade = atividades[2];
			break;
		case 4:
			AtividadesAntiOciosidade.atividade = atividades[3];
			break;
		case 5:
			AtividadesAntiOciosidade.atividade = atividades[4];
			break;
		case 6:
			AtividadesAntiOciosidade.atividade = atividades[5];
			break;
		case 7:
			AtividadesAntiOciosidade.atividade = atividades[6];
			break;
		case 8:
			AtividadesAntiOciosidade.atividade = atividades[7];
			break;
		case 10:
			AtividadesAntiOciosidade.atividade = atividades[8];
			break;
		case 11:
			AtividadesAntiOciosidade.atividade = atividades[9];
			break;
		}
		return AtividadesAntiOciosidade.atividade;
	}

	public static void tempoDecorridoEmAtividadesAntiOciosidade(Integer hora, Integer minuto, Integer segundo) {
		if (hora <= 0 && minuto <= 0 && segundo <= 0) {
			throw new IllegalArgumentException(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
		}
		int contador = 0;
		for (String atividadeOpcional : AtividadesAntiOciosidade.atividadesAntiOciosidade.keySet()) {
			if (AtividadesAntiOciosidade.atividade.equals(atividadeOpcional)) {

				int decrementaHora = AtividadesAntiOciosidade.horas.get(contador);
				decrementaHora -= minuto;

				int decrementaMinuto = AtividadesAntiOciosidade.minutos.get(contador);
				decrementaMinuto -= minuto;

				int decrementaSegundo = AtividadesAntiOciosidade.segundos.get(contador);
				decrementaSegundo -= segundo;

				AtividadesAntiOciosidade.horas.remove(contador);
				AtividadesAntiOciosidade.horas.add(contador, decrementaHora);

				AtividadesAntiOciosidade.minutos.remove(contador);
				AtividadesAntiOciosidade.minutos.add(contador, decrementaMinuto);

				AtividadesAntiOciosidade.segundos.remove(contador);
				AtividadesAntiOciosidade.segundos.add(contador, decrementaSegundo);

				String atualizaTempo = (Entretenimentos.horas.get(contador) + "H : "
						+ Entretenimentos.minutos.get(contador) + "M : " + Entretenimentos.segundos.get(contador)
						+ "S.");
				AtividadesAntiOciosidade.atividadesAntiOciosidade.remove(atividadeOpcional);
				AtividadesAntiOciosidade.atividadesAntiOciosidade.put(atividadeOpcional, atualizaTempo);

				System.out.println("\nTempo passado/decrementado com sucesso.");
				String condicaoParaAcabar;
				condicaoParaAcabar = (0 + "H : " + 0 + "M : " + 0 + "S.");
				if (AtividadesAntiOciosidade.atividadesAntiOciosidade.get(atividadeOpcional)
						.equals(condicaoParaAcabar)) {
					System.out.println(
							"\nO tempo restante para concluir a atividade opcional: " + atividadeOpcional + " acabou!");
				}

			}
			contador++;
		}

	}

	public int randomizaMinutos() {
		Random random = new Random();
		int tempoRandomizado = random.nextInt(5);
		AtividadesAntiOciosidade.minutos.add(tempoRandomizado);
		return tempoRandomizado;
	}

	@Override
	public void run() {
		try {
			System.out.println("\n...");
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
