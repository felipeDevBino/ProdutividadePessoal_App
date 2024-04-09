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
			
			//OPÇÃO DE ESCOLHER OS ENTRETENIMENTOS E A QUANTIDADE DE TEMPO PARA CADA
			
			System.out.println("\nAdicione tempo disponível");
			Entretenimentos.getEntretenimento();

			int contador = 0;
			for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
				if (Entretenimentos.entretenimento.equals(entretenimento)) {

					int incrementaHora = 0, incrementaMinuto = 0, incrementaSegundo = 0;
					if (Entretenimentos.horas.isEmpty()) {
						Entretenimentos.horas.add(contador, incrementaHora);
					}
					if (Entretenimentos.minutos.isEmpty()) {
						Entretenimentos.minutos.add(contador, incrementaMinuto);
					}
					if (Entretenimentos.segundos.isEmpty()) {
						Entretenimentos.segundos.add(contador, incrementaSegundo);
					}
					if (hora > 0) {
						incrementaHora = Entretenimentos.horas.get(contador);
						incrementaHora += hora;
						Entretenimentos.horas.remove(contador);
						Entretenimentos.horas.add(contador, incrementaHora);
					}
					if (minuto > 0) {
						incrementaMinuto = Entretenimentos.minutos.get(contador);
						incrementaMinuto += minuto;
						Entretenimentos.minutos.remove(contador);
						Entretenimentos.minutos.add(contador, incrementaMinuto);
					}
					if (segundo > 0) {
						incrementaSegundo = Entretenimentos.segundos.get(contador);
						incrementaSegundo += segundo;
						Entretenimentos.segundos.remove(contador);
						Entretenimentos.segundos.add(contador, incrementaSegundo);
					}

					String atualizaTempo = (Entretenimentos.horas.get(contador) + "H : "
							+ Entretenimentos.minutos.get(contador) + "M : " + Entretenimentos.segundos.get(contador)
							+ "S.");
					Entretenimentos.entretenimentos.remove(entretenimento);
					Entretenimentos.entretenimentos.put(entretenimento, atualizaTempo);

					System.out.println("\nTempo adicionado/incrementado com sucesso!\nEntretenimento " + (contador + 1)
							+ ": " + entretenimento + ", Tempo Disponível: " + Entretenimentos.entretenimentos.get(entretenimento) + ".");
					
					//INSTRUÇÃO DE TEMPO GASTO PARA ATUALIZAR NO WINDOW BUILDER
					
					break;
				}
				contador++;
				if (contador == Entretenimentos.entretenimentos.size()) {
					// this
					System.out.println("\nErro! Entretenimento não encontrado.");
					incrementaTempo(hora, minuto, segundo);
				}
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

				if (hora > 0) {
					int decrementaHora = Entretenimentos.horas.get(contador);
					decrementaHora -= hora;
					Entretenimentos.horas.remove(contador);
					Entretenimentos.horas.add(contador, decrementaHora);
				}
				if (minuto > 0) {
					int decrementaMinuto = Entretenimentos.minutos.get(contador);
					decrementaMinuto -= minuto;
					Entretenimentos.minutos.remove(contador);
					Entretenimentos.minutos.add(contador, decrementaMinuto);
				}
				if (segundo > 0) {
					int decrementaSegundo = Entretenimentos.segundos.get(contador);
					decrementaSegundo -= segundo;
					Entretenimentos.segundos.remove(contador);
					Entretenimentos.segundos.add(contador, decrementaSegundo);
				}

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
