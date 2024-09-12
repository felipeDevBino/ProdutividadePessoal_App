package atividades;

import instancias.InstanceManager;
import logicadetempo.SistemaDeTempo;
import utilizacaodetelas.UtilizarTelas;

public class TempoEmEntretenimentos {

	private UtilizarTelas tela;
	private SistemaDeTempo sistemaDeTempo;
	private Entretenimentos entretenimentos = InstanceManager.getEntretenimentos();
	private TempoEmAtividades tempoEmAtividades = InstanceManager.getTempoEmAtividades();
	private int horasADiminuir;
	private int minutosADiminuir;
	private int segundosADiminuir;
	private int diminuiHorasAcumuladas;
	private int diminuiMinutosAcumulados;
	private int diminuiSegundosAcumulados;

	public TempoEmEntretenimentos() {
		tela = new UtilizarTelas();
		sistemaDeTempo = new SistemaDeTempo();
	}

	private void verificarSeEMaiorQueTempoAcumulado() {
		if (horasADiminuir > tempoEmAtividades.horasAcumuladas) {
			horasADiminuir = tempoEmAtividades.horasAcumuladas;
		}
		if (minutosADiminuir > tempoEmAtividades.minutosAcumulados) {
			minutosADiminuir = tempoEmAtividades.minutosAcumulados;
		}
		if (segundosADiminuir > tempoEmAtividades.segundosAcumulados) {
			segundosADiminuir = tempoEmAtividades.segundosAcumulados;
		}
	}

	private void diminuirTempoAcumulado() {
		diminuiHorasAcumuladas = (tempoEmAtividades.horasAcumuladas - sistemaDeTempo.getHorasOrganizadas());
		diminuiMinutosAcumulados = (tempoEmAtividades.minutosAcumulados - sistemaDeTempo.getMinutosOrganizados());
		diminuiSegundosAcumulados = (tempoEmAtividades.segundosAcumulados - sistemaDeTempo.getSegundosOrganizados());

		if (diminuiHorasAcumuladas < 0) {
			diminuiHorasAcumuladas = 0;
		}
		if (diminuiMinutosAcumulados < 0) {
			diminuiMinutosAcumulados = 0;
		}
		if (diminuiSegundosAcumulados < 0) {
			diminuiSegundosAcumulados = 0;
		}
	}

	private void incrementarHoras(int posicao) {
		if (posicao != 0) {
			posicao -= 1;
		}
		if (posicao > entretenimentos.horas.size()) {
			posicao = entretenimentos.horas.size() - 1;
		}
		if (horasADiminuir >= 0 || entretenimentos.horas.isEmpty()) {
			if (entretenimentos.horas.isEmpty()) {
				entretenimentos.horas.add(posicao, 0);
			}
			int instrucaoDeSomaDeHoras = (entretenimentos.horas.get(posicao) + sistemaDeTempo.getHorasOrganizadas());

			entretenimentos.horas.remove(posicao);
			entretenimentos.horas.add(posicao, instrucaoDeSomaDeHoras);
		}

	}

	private void incrementarMinutos(int posicao) {
		if (posicao != 0) {
			posicao -= 1;
		}
		if (posicao > entretenimentos.minutos.size()) {
			posicao = entretenimentos.minutos.size() - 1;
		}
		if (minutosADiminuir != 0 || entretenimentos.minutos.isEmpty()) {
			if (entretenimentos.minutos.isEmpty()) {
				entretenimentos.minutos.remove(posicao);
				entretenimentos.minutos.add(posicao, 0);
			}
			int instrucaoDeSomaDeMinutos = (entretenimentos.minutos.get(posicao)
					+ sistemaDeTempo.getMinutosOrganizados());

			entretenimentos.minutos.remove(posicao);
			entretenimentos.minutos.add(posicao, instrucaoDeSomaDeMinutos);
		}

	}

	private void incrementarSegundos(int posicao) {
		if (posicao != 0) {
			posicao -= 1;
		}
		if (posicao > entretenimentos.segundos.size()) {
			posicao = entretenimentos.segundos.size() - 1;
		}
		if (segundosADiminuir != 0 || entretenimentos.segundos.isEmpty()) {
			if (entretenimentos.segundos.isEmpty()) {
				entretenimentos.segundos.remove(posicao);
				entretenimentos.segundos.add(posicao, 0);
			}
			int instrucaoDeSomaDeSegundos = (entretenimentos.segundos.get(posicao)
					+ sistemaDeTempo.getSegundosOrganizados());

			entretenimentos.segundos.remove(posicao);
			entretenimentos.segundos.add(posicao, instrucaoDeSomaDeSegundos);
		}

	}

	private void aplicarTempoIncrementado(int posicao) {
		entretenimentos.horas.remove(posicao);
		entretenimentos.horas.add(posicao, sistemaDeTempo.getHorasOrganizadas());

		entretenimentos.minutos.remove(posicao);
		entretenimentos.minutos.add(posicao, sistemaDeTempo.getMinutosOrganizados());

		entretenimentos.segundos.remove(posicao);
		entretenimentos.segundos.add(posicao, sistemaDeTempo.getSegundosOrganizados());

	}

	private void retornaSeOTempoEInvalido(int horas, int minutos, int segundos) {
		if (horas < 0 || minutos < 0 || segundos < 0 || horas == 0 && minutos == 0 && segundos == 0) {
			tela.retornaTextoEmTela(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos) caso possua tempo acumulado disponível.");
			return;
		}
	}

	public void incrementarTempo(int horas, int minutos, int segundos) {
		retornaSeOTempoEInvalido(horas, minutos, segundos);

		horasADiminuir = horas;
		minutosADiminuir = minutos;
		segundosADiminuir = segundos;

		entretenimentos.getEntretenimento();

		String atualizaTempo = null;
		boolean igual = false;
		int contador = 0;
		for (String entretenimento : entretenimentos.entretenimentos.keySet()) {
			if (entretenimentos.getEntretenimentoSelecionado().equals(entretenimento)) {
				igual = true;

				verificarSeEMaiorQueTempoAcumulado();

				sistemaDeTempo.sistemaDeTempoOrganizado(horasADiminuir, minutosADiminuir, segundosADiminuir);

				horasADiminuir = sistemaDeTempo.getHorasOrganizadas();
				minutosADiminuir = sistemaDeTempo.getMinutosOrganizados();
				segundosADiminuir = sistemaDeTempo.getSegundosOrganizados();

				diminuirTempoAcumulado();

				incrementarHoras(contador);
				incrementarMinutos(contador);
				incrementarSegundos(contador);

				sistemaDeTempo.sistemaDeTempoOrganizado(entretenimentos.horas.get(contador),
						entretenimentos.minutos.get(contador), entretenimentos.segundos.get(contador));

				aplicarTempoIncrementado(contador);

				atualizaTempo = String.format("%dH: %dM: %dS.", entretenimentos.horas.get(contador),
						entretenimentos.minutos.get(contador), entretenimentos.segundos.get(contador));

				tela.retornaTextoEmTela(String.format(
						"Tempo adicionado/incrementado com sucesso!\nEntretenimento %d: %s, tempo disponível: %s.",
						(contador + 1), entretenimento, atualizaTempo));

				tempoEmAtividades.horasAcumuladas = diminuiHorasAcumuladas;
				tempoEmAtividades.minutosAcumulados = diminuiMinutosAcumulados;
				tempoEmAtividades.segundosAcumulados = diminuiSegundosAcumulados;

				break;
			}
			contador++;
			if (contador == entretenimentos.entretenimentos.size()) {
				tela.retornaTextoEmTela("Erro! Entretenimento não encontrado.");
				incrementarTempo(horas, minutos, segundos);
			}

		}
		if (igual) {
			entretenimentos.entretenimentos.remove(entretenimentos.getEntretenimentoSelecionado());
			entretenimentos.entretenimentos.put(entretenimentos.getEntretenimentoSelecionado(), atualizaTempo);
		}

	}

	public void decrementarTempoEmEntretenimentos(int horas, int minutos, int segundos) {
		retornaSeOTempoEInvalido(horas, minutos, segundos);

		entretenimentos.getEntretenimento();

		int contador = 0;
		String condicaoParaAcabar = "0H: 0M: 0S.";
		String atualizaTempo = null;
		boolean igual = false;
		for (String entretenimento : entretenimentos.entretenimentos.keySet()) {
			if (entretenimentos.getEntretenimentoSelecionado().equals(entretenimento)) {
				igual = true;

				TempoEmEntretenimentos tempoEmEntretenimentos = new TempoEmEntretenimentos();
				sistemaDeTempo.tempoDecrementadoEmAtividades(horas, minutos, segundos, contador, tempoEmEntretenimentos);

				atualizaTempo = String.format("%dH: %dM: %dS.", entretenimentos.horas.get(contador),
						entretenimentos.minutos.get(contador), entretenimentos.segundos.get(contador));

				tela.retornaTextoEmTela(String.format("O tempo do entretenimento %s foi decrementado.\n%s",
						entretenimento, atualizaTempo));

			}
			contador++;
		}
		if (igual) {
			entretenimentos.entretenimentos.remove(entretenimentos.getEntretenimentoSelecionado());
			entretenimentos.entretenimentos.put(entretenimentos.getEntretenimentoSelecionado(), atualizaTempo);

			if (entretenimentos.entretenimentos.get(entretenimentos.getEntretenimentoSelecionado())
					.equals(condicaoParaAcabar)) {
				tela.retornaTextoEmTela("O tempo disponível para o entretenimento: "
						+ entretenimentos.getEntretenimentoSelecionado() + " acabou!");

			}
		}
	}

}
