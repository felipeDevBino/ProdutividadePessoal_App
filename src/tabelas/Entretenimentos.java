package tabelas;

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Entretenimentos {

	public static Map<String, StringBuilder> entretenimentos = new HashMap<String, StringBuilder>();
	static Scanner scanner = new Scanner(System.in);

	public static void defineOsEntretenimentos() {
		int quantidadeDeEntretenimentos;

		do {
			System.out.println("\nDigite a quantidade de entretenimentos que você possui: ");
			quantidadeDeEntretenimentos = Integer.parseInt(Entretenimentos.scanner.nextLine());

			String condicional = (quantidadeDeEntretenimentos <= 0)
					? "\nQuantidade inválida! Insira uma quantidade positiva."
					: "\nQuantidade registrada com sucesso.";
			System.out.println(condicional);
		} while (quantidadeDeEntretenimentos <= 0);

		StringBuilder tempos = new StringBuilder();
		tempos.append(0 + "H: " + 0 + "M: " + 0 + "S.");
		for (int i = 0; i < quantidadeDeEntretenimentos - 1; i++) {
			System.out.println("\nDigite o " + (i + 1) + " entretenimento: ");
			String atividade = Entretenimentos.scanner.nextLine();
			Entretenimentos.entretenimentos.put(atividade, tempos);
		}

	}

	public static void mostraTodosOsEntretenimentos() {
		int contador = 0;
		for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
			for (StringBuilder tempoDisponivel : Entretenimentos.entretenimentos.values()) {
				System.out.println("\nEntretenimento (" + (contador + 1) + "): " + entretenimento + ", Tempo Disponível: " + tempoDisponivel);
				contador++;
			}
		}
	}

}
