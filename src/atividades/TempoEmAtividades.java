package atividades;

import java.util.List;

import javax.swing.JLabel;

import java.util.ArrayList;
import gui.InterfaceGrafica;
import instancias.InstanceManager;
import gui.funcoesgui.DiminuirTempo;
import logicadetempo.SistemaDeTempo;
import utilizacaodetelas.UtilizarTelas;

public class TempoEmAtividades {

	private boolean igual;
	private String decremento;
	public int horasAcumuladas;
	public int minutosAcumulados;
	public int segundosAcumulados;
	private int atividadesConcluidasNoDia;

	private AtividadesObrigatorias atividadesObrigatorias = InstanceManager.getAtividadesObrigatorias();;
	private final String condicaoParaAcabar = "0H: 0M: 0S.";
	private UtilizarTelas tela;
	private SistemaDeTempo sistemaDeTempo;

	public TempoEmAtividades() {
		tela = new UtilizarTelas();
		sistemaDeTempo = new SistemaDeTempo();
	}

	private void restaurarTempos(List<String> atividades, List<String> horariosCompletos) {
		int contador = 0;

		for (String atividade : atividadesObrigatorias.atividadesObrigatorias.keySet()) {
			atividades.add(contador, atividade);
			horariosCompletos.add(contador,
					String.format("%dH: %dM: %dS.", atividadesObrigatorias.horasOriginais.get(contador),
							atividadesObrigatorias.minutosOriginais.get(contador),
							atividadesObrigatorias.segundosOriginais.get(contador)));
			contador++;
		}
		contador = 0;
		for (String atividade : atividades) {
			atividadesObrigatorias.atividadesObrigatorias.remove(atividade);
			atividadesObrigatorias.atividadesObrigatorias.put(atividade, horariosCompletos.get(contador));
			contador++;
		}
		atividadesObrigatorias.restaurarTempoMutavel();

		tela.retornaTextoEmTela("Atividades reiniciadas com sucesso.");
	}

	public void restaurarTempoOriginal() {
		List<String> atividades = new ArrayList<String>();
		List<String> horariosCompletos = new ArrayList<String>();

		restaurarTempos(atividades, horariosCompletos);

	}

	private boolean seOSlotEstaOcupado(InterfaceGrafica gui, JLabel jlabel, int posicao) {
		if (jlabel.getText() != null) {
			for (String atividade : atividadesObrigatorias.atividadesObrigatorias.keySet()) {
				if (jlabel.getText().equals(atividade)) {
					return true;
				}
			}
		}
		return false;
	}

	public void mostrarTempoRestaurado(InterfaceGrafica gui) {
		if (seOSlotEstaOcupado(gui, gui.conteudoAtividade01, 0)) {
			gui.setTempo(atividadesObrigatorias.horasOriginais.get(0), atividadesObrigatorias.minutosOriginais.get(0),
					atividadesObrigatorias.segundosOriginais.get(0), gui.horarioAtividade01);
		}
		if (seOSlotEstaOcupado(gui, gui.conteudoAtividade02, 1)) {
			gui.setTempo(atividadesObrigatorias.horasOriginais.get(1), atividadesObrigatorias.minutosOriginais.get(1),
					atividadesObrigatorias.segundosOriginais.get(1), gui.horarioAtividade02);
		}
		if (seOSlotEstaOcupado(gui, gui.conteudoAtividade03, 2)) {
			gui.setTempo(atividadesObrigatorias.horasOriginais.get(2), atividadesObrigatorias.minutosOriginais.get(2),
					atividadesObrigatorias.segundosOriginais.get(2), gui.horarioAtividade03);
		}

	}

	private void decrementarTempo(int horas, int minutos, int segundos) {
		int contador = 0;

		for (String atividadeAtual : atividadesObrigatorias.atividadesObrigatorias.keySet()) {
			if (atividadesObrigatorias.getAtividadeSelecionada().equals(atividadeAtual)) {
				igual = true;

				TempoEmAtividades tempoEmAtividades = new TempoEmAtividades();
				sistemaDeTempo.tempoDecrementadoEmAtividades(horas, minutos, segundos, contador, tempoEmAtividades);

				decremento = String.format("%dH: %dM: %dS.", atividadesObrigatorias.horasMutaveis.get(contador),
						atividadesObrigatorias.minutosMutaveis.get(contador),
						atividadesObrigatorias.segundosMutaveis.get(contador));

				tela.retornaTextoEmTela("Tempo passado/decrementado com sucesso.");
				break;
			}
			contador++;
		}
	}

	private void concluirAtividade(InterfaceGrafica gui, SelecionaAtividades selecionaAtividades, int posicao) {
		if (atividadesObrigatorias.atividadesObrigatorias.get(atividadesObrigatorias.getAtividadeSelecionada())
				.equals(condicaoParaAcabar)) {
			tela.retornaTextoEmTela(
					"Atividade: " + atividadesObrigatorias.getAtividadeSelecionada() + " concluída com sucesso.");

			if (atividadesObrigatorias.getDificuldadeDeCadaAtividades().get(posicao).equals("muito fácil")) {
				minutosAcumulados += 3;

			} else if (atividadesObrigatorias.getDificuldadeDeCadaAtividades().get(posicao).equals("fácil")) {
				minutosAcumulados += 5;

			} else if (atividadesObrigatorias.getDificuldadeDeCadaAtividades().get(posicao).equals("intermediário")) {
				minutosAcumulados += 10;

			} else if (atividadesObrigatorias.getDificuldadeDeCadaAtividades().get(posicao).equals("difícil")) {
				minutosAcumulados += 15;

			} else if (atividadesObrigatorias.getDificuldadeDeCadaAtividades().get(posicao).equals("muito difícil")) {
				minutosAcumulados += 30;

			}
			salvarTempoAcumulado();
			String recebido = String.format("%dH: %dM: %dS.", horasAcumuladas, minutosAcumulados, segundosAcumulados);
			tela.retornaTextoEmTela(
					String.format("Você recebeu algum tempo pela conclusão da atividade! %s", recebido));
			verificarQualAtividadeFoiTerminada(selecionaAtividades);
			gui.setVariavelTempoAcumulado(recebido);
		}

	}

	private void salvarTempoAcumulado() {
		sistemaDeTempo.sistemaDeTempoOrganizado(horasAcumuladas, minutosAcumulados, segundosAcumulados);

		horasAcumuladas = sistemaDeTempo.getHorasOrganizadas();
		minutosAcumulados = sistemaDeTempo.getMinutosOrganizados();
		segundosAcumulados = sistemaDeTempo.getSegundosOrganizados();

	}

	public void decrementarTempoEmAtividades(InterfaceGrafica gui, SelecionaAtividades selecionaAtividades, int horas,
			int minutos, int segundos) {
		if (horas < 0 || minutos < 0 || segundos < 0 || horas == 0 && minutos == 0 && segundos == 0) {
			tela.retornaTextoEmTela(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
			return;
		}

		int contador = 0;

		decrementarTempo(horas, minutos, segundos);

		if (igual) {
			atividadesObrigatorias.atividadesObrigatorias.remove(atividadesObrigatorias.getAtividadeSelecionada());
			atividadesObrigatorias.atividadesObrigatorias.put(atividadesObrigatorias.getAtividadeSelecionada(),
					decremento);
		}

		concluirAtividade(gui, selecionaAtividades, contador);

	}

	private void verificarQualAtividadeFoiTerminada(SelecionaAtividades selecionaAtividades) {
		DiminuirTempo diminuir = InstanceManager.getDiminuirTempo();

		String atividade01 = selecionaAtividades.getAtividade01();
		String atividade02 = selecionaAtividades.getAtividade02();
		String atividade03 = selecionaAtividades.getAtividade03();

		if (atividadesObrigatorias.getAtividadeSelecionada().equals(atividade01)) {
			diminuir.setSeTerminouAtividade01(true);
		} else if (atividadesObrigatorias.getAtividadeSelecionada().equals(atividade02)) {
			diminuir.setSeTerminouAtividade02(true);
		} else if (atividadesObrigatorias.getAtividadeSelecionada().equals(atividade03)) {
			diminuir.setSeTerminouAtividade03(true);
		}

	}

	public void verificaAtividadesPendentes() {
		if (atividadesConcluidasNoDia == 0) {
			tela.retornaTextoEmTela("Todas as atividades foram concluídas! Parabéns por essa conquista!");
		}
	}

}
