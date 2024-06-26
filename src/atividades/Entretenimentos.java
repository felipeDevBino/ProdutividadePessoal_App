package atividades;

import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Entretenimentos {

	public static Scanner scanner = new Scanner(System.in);
	public static Map<String, String> entretenimentos = new HashMap<>();
	public static List<Integer> horas = new ArrayList<>();
	public static List<Integer> minutos = new ArrayList<>();
	public static List<Integer> segundos = new ArrayList<>();
	public static String entretenimento;

	public static void defineOsEntretenimentos() {
		int quantidadeDeEntretenimentos;

		do {
			System.out.println("\nDigite a quantidade de entretenimentos que você possui (máximo = 9): ");
			quantidadeDeEntretenimentos = Integer.parseInt(Entretenimentos.scanner.nextLine());

			if (quantidadeDeEntretenimentos > 9) {
				System.out.println("\nQuantidade inválida, excedendo os limites estabelecidos!");
				continue;
			}

			String condicional = (quantidadeDeEntretenimentos <= 0)
					? "\nQuantidade inválida! Insira uma quantidade positiva."
					: "\nQuantidade registrada com sucesso.";
			System.out.println(condicional);
		} while (quantidadeDeEntretenimentos <= 0 || quantidadeDeEntretenimentos > 9);

		String tempos;
		tempos = (0 + "H : " + 0 + "M : " + 0 + "S.");
		for (int i = 0; i < quantidadeDeEntretenimentos; i++) {
			System.out.println("\nDigite o " + (i + 1) + " entretenimento: ");
			String atividade = Entretenimentos.scanner.nextLine();
			Entretenimentos.entretenimentos.put(atividade, tempos);
			Entretenimentos.horas.add(i, 0);
			Entretenimentos.minutos.add(i, 0);
			Entretenimentos.segundos.add(i, 0);
		}

	}

	public static void getEntretenimento() {
		int numeroDoEntretenimento;
		do {
			System.out.println("\nDigite o número do entretenimento:");
			numeroDoEntretenimento = Integer.parseInt(scanner.nextLine());

			if (numeroDoEntretenimento <= 0 || numeroDoEntretenimento > 9) {
				System.out.println("\nErro! Número de entretenimento inválido!");
				continue;
			}
			int contador = 1;
			for (String buscaAtividade : Entretenimentos.entretenimentos.keySet()) {
				if (contador == numeroDoEntretenimento) {
					System.out.println("\nEntretenimento encontrado! (" + (contador) + "): " + buscaAtividade
							+ ", Tempo Disponível: " + Entretenimentos.entretenimentos.get(buscaAtividade));
					Entretenimentos.entretenimento = buscaAtividade;
					break;
				}
				contador++;
			}
		} while (numeroDoEntretenimento <= 0 || numeroDoEntretenimento > 9);
	}

	public static void getTodosOsEntretenimentos() {
		int contador = 0;
		for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
			System.out.println("\nEntretenimento (" + (contador + 1) + "): " + entretenimento + ", Tempo Disponível: "
					+ Entretenimentos.entretenimentos.get(entretenimento));

			contador++;
		}
	}

}
