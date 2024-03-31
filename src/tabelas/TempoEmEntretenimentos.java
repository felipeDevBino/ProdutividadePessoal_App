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
 * Terá a obrigação de enviar o tempo decorrido do entretenimento
 * que ele aproveitou, através de um cronômetro que o usuário possua, 
 * para que o programa possa decrementar justamente o tempo disponível
 * para entretenimentos.
 * 
 */

public class TempoEmEntretenimentos {

	static Scanner scanner = new Scanner(System.in);

	public static void incrementaTempo(Integer hora, Integer minuto, Integer segundo) {
		if (hora < 0 && minuto < 0 && segundo < 0) {
			throw new IllegalArgumentException(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
		}
		if (hora == 0 && minuto == 0 && segundo == 0) {
			System.out.println("\nVocê não possui tempo acumulado para distribuir!");
		}
		System.out.println("\nDigite o número do entretenimento para o qual você deseja adicionar tempo disponível: ");
		String entretenimentoEscolhido = scanner.nextLine();

		for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
			if (entretenimentoEscolhido.equals(entretenimento)) {
				// INCREMENTA O TEMPO DISPONÍVEL NA ATIVIDADE MENCIONADA EM
				// 'InterfaceGrafica'

			} else {
				System.out.println("\nTempo adicionado/incrementado com sucesso.");
			}
		}
	}

	public static void tempoDecorridoEmEntretenimentos(String passatempo, Integer hora, Integer minuto, Integer segundo) {
		if (hora <= 0 && minuto <= 0 && segundo <= 0) {
			throw new IllegalArgumentException(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
		}
		if (hora == 0 && minuto == 0 && segundo == 0) {
			System.out.println("\nTempo inválido!");
		}
		for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
			if (passatempo.equals(entretenimento)) {
				// DECREMENTA O TEMPO DISPONÍVEL NA ATIVIDADE MENCIONADA EM
				// 'entretenimentoEscolhido'

				//TODO
				
			} else {
				System.out.println("\nTempo passado/decrementado com sucesso.");
				StringBuilder condicaoParaAcabar = new StringBuilder();
				condicaoParaAcabar.append(0 + "H - " + 0 + "M - " + 0 + "S.");
				if (Entretenimentos.entretenimentos.get(entretenimento).equals(condicaoParaAcabar)) {
					System.out.println("\nO tempo disponível para o entretenimento: " + entretenimento + " acabou!");
				}
			}
		}

	}

}
