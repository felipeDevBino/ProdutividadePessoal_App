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
	protected static String[] niveisDeDificuldade = new String[] { "muito fácil", "fácil", "intermediário", "difícil",
			"muito dificil" };
	public static List<String> dificuldadeDeCadaAtividade = new ArrayList<String>();
	private double[] tempos = new double[] { 10, 15, 20, 25, 30 };
	protected static String atividade;

	public void defineAtividadeAntiOciosidade() {
		String tempo;
		tempo = (0 + "H : " + tempos[randomizaTempos()] + "M : " + 0 + "S.");
		AtividadesAntiOciosidade.atividadesAntiOciosidade.put(randomizaAtividadeAntiOciosidade(), tempo);
		AtividadesAntiOciosidade.dificuldadeDeCadaAtividade
				.add(AtividadesAntiOciosidade.niveisDeDificuldade[randomizaDificuldade()]);

	}

	public String getAtividade() {
		System.out.println("\nDigite o número da atividade:");
		int numeroDaAtividade = Integer.parseInt(scanner.nextLine());
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
				System.out.println(
						"\nAtividade (" + (contador + 1) + "): " + atividade + ", Tempo Restante: " + tempoDisponivel
								+ ", Dificuldade: " + AtividadesNecessarias.dificuldadeDeCadaAtividade.get(contador));
				contador++;
			}
		}
	}

	public String randomizaAtividadeAntiOciosidade() {
		Random random = new Random();
		int randomizaAtividade = random.nextInt(AtividadesAntiOciosidade.atividadesAntiOciosidade.size());
		switch (randomizaAtividade) {
		case 0:
			AtividadesAntiOciosidade.atividade = atividades[0];
			break;
		case 1:
			AtividadesAntiOciosidade.atividade = atividades[1];
			break;
		case 2:
			AtividadesAntiOciosidade.atividade = atividades[2];
			break;
		case 3:
			AtividadesAntiOciosidade.atividade = atividades[3];
			break;
		case 4:
			AtividadesAntiOciosidade.atividade = atividades[4];
			break;
		case 5:
			AtividadesAntiOciosidade.atividade = atividades[5];
			break;
		case 6:
			AtividadesAntiOciosidade.atividade = atividades[6];
			break;
		case 7:
			AtividadesAntiOciosidade.atividade = atividades[7];
			break;
		case 8:
			AtividadesAntiOciosidade.atividade = atividades[8];
			break;
		case 9:
			AtividadesAntiOciosidade.atividade = atividades[9];
			break;
		}
		return AtividadesAntiOciosidade.atividade;
	}

	public void tempoDecorridoEmAtividadesAntiOciosidade(Integer hora, Integer minuto, Integer segundo) {
		if (hora <= 0 && minuto <= 0 && segundo <= 0) {
			throw new IllegalArgumentException(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
		}
		if (hora == 0 && minuto == 0 && segundo == 0) {
			System.out.println("\nTempo inválido!");
		}

		for (String atividadeOpcional : AtividadesAntiOciosidade.atividadesAntiOciosidade.keySet()) {
			if (AtividadesAntiOciosidade.atividade.equals(atividadeOpcional)) {
				// TODO
			}
		}

	}

	// Hora, Minuto e Segundo do array tempos
	public int randomizaTempos() {
		Random random = new Random();
		int tempoRandomizado = random.nextInt(5);
		return tempoRandomizado;
	}

	public int randomizaDificuldade() {
		Random random = new Random();
		int dificuldadeRandomizada = random.nextInt(5);
		return dificuldadeRandomizada;
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
