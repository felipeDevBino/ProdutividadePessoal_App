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
		} else {
			System.out.println(
					"\nDigite o número do entretenimento para o qual você deseja adicionar tempo disponível: ");
			int entretenimentoEscolhido = Integer.parseInt(scanner.nextLine());

			int contador = 0;
			for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
				if (contador == entretenimentoEscolhido) {

					int incrementaHora = Entretenimentos.horas.get(contador);
					incrementaHora += hora;
					int incrementaMinuto = Entretenimentos.minutos.get(contador);
					incrementaMinuto += minuto;
					int incrementaSegundo = Entretenimentos.segundos.get(contador);
					incrementaSegundo += segundo;

					Entretenimentos.horas.remove(contador);
					Entretenimentos.horas.add(contador, incrementaHora);

					Entretenimentos.minutos.remove(contador);
					Entretenimentos.minutos.add(contador, incrementaMinuto);

					Entretenimentos.segundos.remove(contador);
					Entretenimentos.segundos.add(contador, incrementaSegundo);

					String atualizaTempo = (Entretenimentos.horas.get(contador) + "H : "
							+ Entretenimentos.minutos.get(contador) + "M : " + Entretenimentos.segundos.get(contador)
							+ "S.");
					Entretenimentos.entretenimentos.remove(entretenimento);
					Entretenimentos.entretenimentos.put(entretenimento, atualizaTempo);

					System.out.println("\nTempo adicionado/incrementado com sucesso.");
				}
				contador++;
			}
		}
	}

	public static void tempoDecorridoEmEntretenimentos(Integer hora, Integer minuto, Integer segundo) {
		if (hora <= 0 && minuto <= 0 && segundo <= 0) {
			throw new IllegalArgumentException(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
		}
		if (hora == 0 && minuto == 0 && segundo == 0) {
			System.out.println("\nTempo inválido!");
		}
		int contador = 0;
		for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
			if (Entretenimentos.entretenimento.equals(entretenimento)) {

				int decrementaHora = Entretenimentos.horas.get(contador);
				decrementaHora -= hora;
				int decrementaMinuto = Entretenimentos.minutos.get(contador);
				decrementaMinuto -= minuto;
				int decrementaSegundo = Entretenimentos.segundos.get(contador);
				decrementaSegundo -= segundo;

				Entretenimentos.horas.remove(contador);
				Entretenimentos.horas.add(contador, decrementaHora);
	
				Entretenimentos.minutos.remove(contador);
				Entretenimentos.minutos.add(contador, decrementaMinuto);

				Entretenimentos.segundos.remove(contador);
				Entretenimentos.segundos.add(contador, decrementaSegundo);

				String atualizaTempo = (Entretenimentos.horas.get(contador) + "H : "
						+ Entretenimentos.minutos.get(contador) + "M : " + Entretenimentos.segundos.get(contador)
						+ "S.");
				Entretenimentos.entretenimentos.remove(entretenimento);
				Entretenimentos.entretenimentos.put(entretenimento, atualizaTempo);

				System.out.println("\nTempo passado/decrementado com sucesso.");
				String condicaoParaAcabar;
				condicaoParaAcabar = (0 + "H : " + 0 + "M : " + 0 + "S.");
				if (Entretenimentos.entretenimentos.get(entretenimento).equals(condicaoParaAcabar)) {
					System.out.println("\nO tempo disponível para o entretenimento: " + entretenimento + " acabou!");
				}

			}
			contador++;
		}

	}

}
