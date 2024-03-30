package tabelas;

import java.util.Scanner;

/*
 * PROGRAMA
 * 
 * Será capaz de realizar o registro de quanto tempo (CUMULATIVO) o usuário
 * terá 'direito' de aproveitar de seus entretenimentos de consciência limpa.
 * 
 * USUÁRIO
 * 
 * Terá a obrigação de enviar o tempo decorrido o entretenimento
 * que ele aproveitou, através de seu cronômetro, para que o programa
 * possa decrementar justamente o tempo disponível para entretenimentos.
 * 
 */

public class TempoEmEntretenimentos {

	static Scanner scanner = new Scanner(System.in);

	public static void incrementaTempo(Integer incremento, String tipoDeMinutagem) {
		if (incremento <= 0) {
			throw new IllegalArgumentException("Você precisa digitar ou fornecer um tempo válido! EX: 5, 10, 15...");
		}
		System.out.println("\nDigite o entretenimento para o qual você deseja adicionar tempo disponível: ");
		String entretenimentoEscolhido = scanner.nextLine();

		for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
			if (entretenimentoEscolhido.equals(entretenimento)) {
				// INCREMENTA O TEMPO DISPONÍVEL NA ATIVIDADE MENCIONADA EM
				// 'entretenimentoEscolhido'
				Entretenimentos.entretenimentos.put(entretenimentoEscolhido,
						Entretenimentos.entretenimentos.get(entretenimentoEscolhido) + incremento);
			} else {
				System.out.println("\nTempo adicionado/incrementado com sucesso.");
			}
		}
	}

	public static void tempoDecorridoEmPassatempos(String passatempo, Integer tempoDecorrido, String tipoDeMinutagem) {
		if (tempoDecorrido <= 0) {
			throw new IllegalArgumentException("Você precisa digitar ou fornecer um tempo válido! EX: 5, 10, 15...");
		}

		for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
			if (passatempo.equals(entretenimento)) {
				// DECREMENTA O TEMPO DISPONÍVEL NA ATIVIDADE MENCIONADA EM
				// 'entretenimentoEscolhido'
				Entretenimentos.entretenimentos.put(passatempo,
						Entretenimentos.entretenimentos.get(passatempo) - tempoDecorrido);
			} else {
				System.out.println("\nTempo passado/decrementado com sucesso.");
				if (Entretenimentos.entretenimentos.get(entretenimento) <= 0) {
					System.out.println("\nO tempo disponível para o entretenimento: " + entretenimento + " acabou!");
				}
			}
		}

	}

}
