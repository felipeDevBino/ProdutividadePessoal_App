package atividades;

import java.util.Scanner;

import logica_horarios.SistemaDeTempo;

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

	public static Scanner scanner = new Scanner(System.in);

	public static void incrementaTempo(int hora, int minuto, int segundo) {
		if (hora < 0 && minuto < 0 && segundo < 0) {
			throw new IllegalArgumentException(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
		}
		if (hora == 0 && minuto == 0 && segundo == 0) {
			System.out.println("\nVocê não possui tempo acumulado para distribuir!");

		} else {

			System.out.println("\nAdicione tempo disponível para o entretenimento:");
			Entretenimentos.getEntretenimento();

			String atualizaTempo = "";
			boolean igual = false;
			int contador = 0;
			for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
				if (Entretenimentos.entretenimento.equals(entretenimento)) {
					igual = true;

					if (hora >= TempoEmAtividades.horasAcumuladas) {
						hora = TempoEmAtividades.horasAcumuladas;
					}
					if (minuto >= TempoEmAtividades.minutosAcumulados) {
						minuto = TempoEmAtividades.minutosAcumulados;
					}
					if (segundo >= TempoEmAtividades.segundosAcumulados) {
						segundo = TempoEmAtividades.segundosAcumulados;
					}

					SistemaDeTempo sistemaDeTempo = new SistemaDeTempo();
					sistemaDeTempo.sistemaDeTempoOrganizado(hora, minuto, segundo);

					int diminuiHorasAcumuladas = (TempoEmAtividades.horasAcumuladas
							- sistemaDeTempo.horasOrganizadas);
					int diminuiMinutosAcumulados = (TempoEmAtividades.minutosAcumulados
							- sistemaDeTempo.minutosOrganizados);
					int diminuiSegundosAcumulados = (TempoEmAtividades.segundosAcumulados
							- sistemaDeTempo.segundosOrganizados);

					if (diminuiHorasAcumuladas < 0) {
						diminuiHorasAcumuladas = 0;
					}
					if (diminuiMinutosAcumulados < 0) {
						diminuiMinutosAcumulados = 0;
					}
					if (diminuiSegundosAcumulados < 0) {
						diminuiSegundosAcumulados = 0;
					}

					if (hora >= 0 || Entretenimentos.horas.isEmpty() && hora >= 0) {
						if (Entretenimentos.horas.isEmpty()) {
							Entretenimentos.horas.add(contador, 0);
						}

						int instrucaoDeSomaDeHoras = (Entretenimentos.horas.get(contador)
								+ sistemaDeTempo.horasOrganizadas);

						Entretenimentos.horas.remove(contador);
						Entretenimentos.horas.add(contador, instrucaoDeSomaDeHoras);
					}
					if (minuto >= 0 || Entretenimentos.minutos.isEmpty() && minuto >= 0) {
						if (Entretenimentos.minutos.isEmpty()) {
							Entretenimentos.minutos.add(contador, 0);
						}

						int instrucaoDeSomaDeMinutos = (Entretenimentos.minutos.get(contador)
								+ sistemaDeTempo.minutosOrganizados);

						Entretenimentos.minutos.remove(contador);
						Entretenimentos.minutos.add(contador, instrucaoDeSomaDeMinutos);
					}
					if (segundo >= 0 || Entretenimentos.segundos.isEmpty() && segundo >= 0) {

						if (Entretenimentos.segundos.isEmpty()) {
							Entretenimentos.segundos.add(contador, 0);
						}

						int instrucaoDeSomaDeSegundos = (Entretenimentos.segundos.get(contador)
								+ sistemaDeTempo.segundosOrganizados);

						Entretenimentos.segundos.remove(contador);
						Entretenimentos.segundos.add(contador, instrucaoDeSomaDeSegundos);
					}

					sistemaDeTempo.sistemaDeTempoOrganizado(Entretenimentos.horas.get(contador),
							Entretenimentos.minutos.get(contador), Entretenimentos.segundos.get(contador));

					Entretenimentos.horas.remove(contador);
					Entretenimentos.horas.add(contador, sistemaDeTempo.horasOrganizadas);

					Entretenimentos.minutos.remove(contador);
					Entretenimentos.minutos.add(contador, sistemaDeTempo.minutosOrganizados);

					Entretenimentos.segundos.remove(contador);
					Entretenimentos.segundos.add(contador, sistemaDeTempo.segundosOrganizados);

					atualizaTempo = (Entretenimentos.horas.get(contador) + "H : "
							+ Entretenimentos.minutos.get(contador) + "M : " + Entretenimentos.segundos.get(contador)
							+ "S.");

					System.out.println("\nTempo adicionado/incrementado com sucesso!\nEntretenimento " + (contador + 1)
							+ ": " + entretenimento + ", Tempo Disponível: " + atualizaTempo + ".");

					TempoEmAtividades.horasAcumuladas = diminuiHorasAcumuladas;
					TempoEmAtividades.minutosAcumulados = diminuiMinutosAcumulados;
					TempoEmAtividades.segundosAcumulados = diminuiSegundosAcumulados;

					break;
				}
				contador++;
				if (contador == Entretenimentos.entretenimentos.size()) {
					// this
					System.out.println("\nErro! Entretenimento não encontrado.");
					incrementaTempo(hora, minuto, segundo);
				}

			}
			if (igual) {
				Entretenimentos.entretenimentos.remove(Entretenimentos.entretenimento);
				Entretenimentos.entretenimentos.put(Entretenimentos.entretenimento, atualizaTempo);
			}
		}

	}

	public static void tempoDecorridoEmEntretenimentos(int hora, int minuto, int segundo) {
		if (hora <= 0 && minuto <= 0 && segundo <= 0) {
			throw new IllegalArgumentException(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
		}

		System.out.println("\nDiminua tempo disponível do entretenimento:");
		Entretenimentos.getEntretenimento();

		int contador = 0;
		String condicaoParaAcabar = "";
		String atualizaTempo = "";
		boolean igual = false;
		for (String entretenimento : Entretenimentos.entretenimentos.keySet()) {
			if (Entretenimentos.entretenimento.equals(entretenimento)) {
				igual = true;

				TempoEmEntretenimentos tempoEmEntretenimentos = new TempoEmEntretenimentos();
				SistemaDeTempo sistemaDeTempo = new SistemaDeTempo();
				sistemaDeTempo.tempoDecrementadoEmAtividades(hora, minuto, segundo, contador, tempoEmEntretenimentos);

				atualizaTempo = (Entretenimentos.horas.get(contador) + "H : " + Entretenimentos.minutos.get(contador)
						+ "M : " + Entretenimentos.segundos.get(contador) + "S.");

				System.out.println("\nO tempo do entretenimento " + entretenimento + " foi decrementado.");
				condicaoParaAcabar = (0 + "H : " + 0 + "M : " + 0 + "S.");

			}
			contador++;
		}
		if (igual) {
			Entretenimentos.entretenimentos.remove(Entretenimentos.entretenimento);
			Entretenimentos.entretenimentos.put(Entretenimentos.entretenimento, atualizaTempo);

			System.out.println(atualizaTempo);

			if (Entretenimentos.entretenimentos.get(Entretenimentos.entretenimento).equals(condicaoParaAcabar)) {
				System.out.println(
						"\nO tempo disponível para o entretenimento: " + Entretenimentos.entretenimento + " acabou!");
			}
		}
	}

}
