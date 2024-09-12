package atividades;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import gui.funcoesgui.DiminuirTempo;
import gui.InterfaceGrafica;
import instancias.InstanceManager;
import logicadetempo.SistemaDeTempo;
import utilizacaodetelas.UtilizarTelas;

public class AtividadesOpcionais {

	private final String[] atividades = new String[] { "Ler um livro", "Fazer uma caminhada", "Jogar um quebra cabeça",
			"Assista um vídeo info", "Estudar um tema", "Fazer um desenho", "Arrumar o quarto", "Resolva cálculos",
			"Medite", "Escute um podcast" };

	public Map<String, String> atividadesOpcionais;
	private final int[] tempos = { 10, 15, 20, 25, 30 };
	public int horas[] = new int[2];
	public int minutos[] = new int[2];
	public int segundos[] = new int[2];

	private SelecionaAtividades atividadesSelecionadas = InstanceManager.getSelecionaAtividades();
	private SistemaDeTempo sistemaDeTempo;
	private UtilizarTelas tela;
	private Random random;

	private boolean igual;
	private String atualizaTempo;
	private String tempoAcumulado;
	private String atividadeOpcional01;
	private String atividadeOpcional02;
	private String atividadeSelecionada;

	public AtividadesOpcionais() {
		random = new Random();
		tela = new UtilizarTelas();
		sistemaDeTempo = new SistemaDeTempo();
		atividadesOpcionais = new HashMap<>();
		atividadeSelecionada = "";

	}

	public String getNovaAtividadeOpcional(boolean eAtividadeOpcional01, boolean eAtividadeOpcional02) {
		String atividade = randomizaAtividadeOpcional();
		setAtividadeOpcionalSelecionada(atividade);
		salvarAtividade(atividade, eAtividadeOpcional01, eAtividadeOpcional02);
		atividadesOpcionais.put(atividade, retornarMinutagem());
		return atividade;
	}

	public void salvarAtividade(String atividade, boolean eAtividadeOpcional01, boolean eAtividadeOpcional02) {
		if (eAtividadeOpcional01) {
			setAtividadeOpcional01(atividade);
			atividadesSelecionadas.setAtividadeOpcional01(atividade);
		} else if (eAtividadeOpcional02) {
			setAtividadeOpcional02(atividade);
			atividadesSelecionadas.setAtividadeOpcional02(atividade);
		}
	}

	private String retornarMinutagem() {
		int minutosAleatorios = randomizaMinutos();
		String minutagem = String.format("%dH: %dM: %dS.", 0, minutosAleatorios, 0);
		salvarMinutagem(0, minutosAleatorios, 0);
		return minutagem;
	}

	private void salvarMinutagem(int pHoras, int pMinutos, int pSegundos) {
		if (atividadeSelecionada.equals(atividadesSelecionadas.getAtividadeOpcional01())) {
			horas[0] = pHoras;
			minutos[0] = pMinutos;
			segundos[0] = pSegundos;

		} else if (atividadeSelecionada.equals(atividadesSelecionadas.getAtividadeOpcional02())) {
			horas[1] = pHoras;
			minutos[1] = pMinutos;
			segundos[1] = pSegundos;
		}
	}

	public void getAtividade() {
		boolean formatoInvalido = false;
		int numeroDaAtividade = 0;
		do {
			try {
				numeroDaAtividade = tela.insereDadoInteiro("Digite o número da atividade:");
			} catch (NumberFormatException e) {
				tela.retornaTextoEmTela("Número inválido! Digite um número inteiro válido.");
				formatoInvalido = true;
			}
		} while (formatoInvalido || numeroDaAtividade <= 0 || numeroDaAtividade > atividadesOpcionais.size());

		int contador = 1;
		for (String buscaAtividade : atividadesOpcionais.keySet()) {
			if (contador == numeroDaAtividade) {
				tela.retornaTextoEmTela("Atividade encontrada! " + buscaAtividade);
				atividadeSelecionada = buscaAtividade;
				break;
			}
			contador++;
		}

	}

	public void getTodasAsAtividades() {
		int contador = 0;
		StringBuilder atividades = new StringBuilder();
		for (String atividade : atividadesOpcionais.keySet()) {
			for (String tempoDisponivel : atividadesOpcionais.values()) {
				atividades.append(String.format("Atividade (%d): %s, Tempo Restante: %s.", (contador + 1), atividade,
						tempoDisponivel));
				contador++;
			}
		}
	}

	private String randomizaAtividadeOpcional() {
		do {
			switch (random.nextInt(11) + 1) {
			case 1:
				atividadeSelecionada = atividades[0];
				break;
			case 2:
				atividadeSelecionada = atividades[1];
				break;
			case 3:
				atividadeSelecionada = atividades[2];
				break;
			case 4:
				atividadeSelecionada = atividades[3];
				break;
			case 5:
				atividadeSelecionada = atividades[4];
				break;
			case 6:
				atividadeSelecionada = atividades[5];
				break;
			case 7:
				atividadeSelecionada = atividades[6];
				break;
			case 8:
				atividadeSelecionada = atividades[7];
				break;
			case 9:
				atividadeSelecionada = atividades[8];
				break;
			case 10:
				atividadeSelecionada = atividades[9];
				break;
			}
		} while (seJaExisteAtividadeIgual(atividadeSelecionada));
		return atividadeSelecionada;
	}

	private boolean seJaExisteAtividadeIgual(String atividade) {
		if (atividade.equals(atividadeOpcional01) || atividade.equals(atividadeOpcional02)) {
			return true;
		}
		return false;
	}

	public int randomizaMinutos() {
		return tempos[random.nextInt(5)];
	}

	private void decrementarTempo(int hora, int minuto, int segundo) {
		if (atividadeSelecionada.equals(atividadesSelecionadas.getAtividadeOpcional01())) {
			igual = true;
			sistemaDeTempo.tempoDecrementadoEmAtividades(hora, minuto, segundo, 0, this);
			atualizaTempo = String.format("%dH: %dM: %sS.", horas[0], minutos[0], segundos[0]);
			tela.retornaTextoEmTela("Tempo passado/decrementado com sucesso\n" + atualizaTempo);

		} else if (atividadeSelecionada.equals(atividadesSelecionadas.getAtividadeOpcional02())) {
			igual = true;
			sistemaDeTempo.tempoDecrementadoEmAtividades(hora, minuto, segundo, 1, this);
			atualizaTempo = String.format("%dH: %dM: %sS.", horas[1], minutos[1], segundos[1]);
			tela.retornaTextoEmTela("Tempo passado/decrementado com sucesso\n" + atualizaTempo);

		}

	}

	private void reiniciarAtividadesOpcionais(InterfaceGrafica gui, DiminuirTempo diminuir, String tempoAcumulado) {
		if (atividadeSelecionada.equals(atividadesSelecionadas.getAtividadeOpcional01())) {
			atividadesSelecionadas.setAtividadeOpcional01("");
			gui.conteudoAtividadeOp01.setText("");
			diminuir.setSeTerminouAtividadeOp01(true);

		} else if (atividadeSelecionada.equals(atividadesSelecionadas.getAtividadeOpcional02())) {
			atividadesSelecionadas.setAtividadeOpcional02("");
			gui.conteudoAtividadeOp02.setText("");
			diminuir.setSeTerminouAtividadeOp02(true);
		}
		gui.setVariavelTempoAcumulado(tempoAcumulado);
	}

	private void mostrarMensagemEAtualizarTempo(TempoEmAtividades tempoEmAtividades) {
		tela.retornaTextoEmTela("O tempo restante para concluir a atividade opcional: " + atividadeSelecionada
				+ " acabou!\nVocê recebeu +5 minutos adicionais em tempo acumulado!");
		tempoEmAtividades.minutosAcumulados += 5;

		sistemaDeTempo.sistemaDeTempoOrganizado(tempoEmAtividades.horasAcumuladas, tempoEmAtividades.minutosAcumulados,
				tempoEmAtividades.segundosAcumulados);

		tempoEmAtividades.horasAcumuladas = sistemaDeTempo.getHorasOrganizadas();
		tempoEmAtividades.minutosAcumulados = sistemaDeTempo.getMinutosOrganizados();
		tempoEmAtividades.segundosAcumulados = sistemaDeTempo.getSegundosOrganizados();

	}

	private void concluirAtividade(InterfaceGrafica gui, TempoEmAtividades tempoEmAtividades, DiminuirTempo diminuir,
			String condicaoParaAcabar) {
		for (String atividadeOpcional : atividadesOpcionais.keySet()) {
			if (atividadesOpcionais.get(atividadeOpcional) != null
					&& atividadesOpcionais.get(atividadeOpcional).equals(condicaoParaAcabar)) {
				mostrarMensagemEAtualizarTempo(tempoEmAtividades);

				tempoAcumulado = String.format("%dH: %dM: %dS.", tempoEmAtividades.horasAcumuladas,
						tempoEmAtividades.minutosAcumulados, tempoEmAtividades.segundosAcumulados);

				atividadesOpcionais.remove(atividadeSelecionada);
				atividadeSelecionada = atividadeOpcional;

				reiniciarAtividadesOpcionais(gui, diminuir, tempoAcumulado);
				break;
			}
		}

	}

	public void decrementarTempo(InterfaceGrafica gui, TempoEmAtividades tempoEmAtividades, DiminuirTempo diminuir,
			int horas, int minutos, int segundos) {
		if (horas < 0 || minutos < 0 || segundos < 0 || horas == 0 && minutos == 0 && segundos == 0) {
			tela.retornaTextoEmTela(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
			return;
		}

		String condicaoParaAcabar = "0H: 0M: 0S.";
		sistemaDeTempo = new SistemaDeTempo();

		decrementarTempo(horas, minutos, segundos);

		if (igual) {
			atividadesOpcionais.remove(atividadeSelecionada);
			atividadesOpcionais.put(atividadeSelecionada, atualizaTempo);
		}

		concluirAtividade(gui, tempoEmAtividades, diminuir, condicaoParaAcabar);
	}

	public void setAtividadeOpcionalSelecionada(String atividade) {
		this.atividadeSelecionada = atividade;
	}

	public void setAtividadeOpcional01(String atividadeOpcional01) {
		this.atividadeOpcional01 = atividadeOpcional01;
	}

	public void setAtividadeOpcional02(String atividadeOpcional02) {
		this.atividadeOpcional02 = atividadeOpcional02;
	}

	public String getAtividadeOpcionalSelecionada() {
		return atividadeSelecionada;
	}

	public String getAtividadeOpcional01() {
		return atividadeOpcional01;
	}

	public String getAtividadeOpcional02() {
		return atividadeOpcional02;
	}

}
