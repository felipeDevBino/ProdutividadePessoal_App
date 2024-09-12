package atividades;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JButton;

import logicadetempo.SistemaDeTempo;
import utilizacaodetelas.UtilizarTelas;

public class AtividadesObrigatorias {

	public final String[] niveisDeDificuldade = new String[] { "muito fácil", "fácil", "intermediário", "difícil",
			"muito dificil" };

	public Map<String, String> atividadesObrigatorias;
	public List<String> dificuldadeDeCadaAtividade;
	public List<Integer> horasOriginais;
	public List<Integer> horasMutaveis;
	public List<Integer> minutosOriginais;
	public List<Integer> minutosMutaveis;
	public List<Integer> segundosOriginais;
	public List<Integer> segundosMutaveis;

	private int horas;
	private int minutos;
	private int segundos;
	private int quantidadeDeAtividades;

	private String atividade;
	private String dificuldade;
	private UtilizarTelas tela;

	public AtividadesObrigatorias() {
		atividadesObrigatorias = new HashMap<>();
		dificuldadeDeCadaAtividade = new ArrayList<>();

		horasOriginais = new ArrayList<>();
		minutosOriginais = new ArrayList<>();
		segundosOriginais = new ArrayList<>();

		horasMutaveis = new ArrayList<>();
		minutosMutaveis = new ArrayList<>();
		segundosMutaveis = new ArrayList<>();

		tela = new UtilizarTelas();
	}

	private boolean seSaoValoresInvalidos(int horas, int minutos, int segundos) {
		if (horas < 0 || minutos < 0 || segundos < 0 || horas == 0 && minutos == 0 && segundos == 0) {
			tela.retornaTextoEmTela(
					"Você precisa digitar ou fornecer um tempo válido! EX: 1 (horas): 50 (minutos): 30 (segundos).");
			return true;
		}
		return false;
	}

	private void inserirQuantidadeDeAtividades() {
		do {
			quantidadeDeAtividades = tela
					.insereDadoInteiro("Digite a quantidade de atividades obrigatórias que você possui:");

			if (quantidadeDeAtividades <= 0 || quantidadeDeAtividades < 3) {
				tela.retornaTextoEmTela(
						"Quantidade inválida! Insira uma quantidade positiva / pelo menos 3 atividades.");
			} else {
				tela.retornaTextoEmTela("Quantidade registrada com sucesso.");
			}
		} while (quantidadeDeAtividades <= 0 || quantidadeDeAtividades < 3);
	}

	private void inserirAtividades(int posicao, boolean repetida) {
		boolean nula;
		do {
			nula = false;
			atividade = tela.insereDadoDeTexto("Digite a " + (posicao + 1) + " atividade:");
			atividade = atividade.trim();

			for (String atividadeExistente : atividadesObrigatorias.keySet()) {
				if (atividade.equals(atividadeExistente)) {
					tela.retornaTextoEmTela("Erro! Você já inseriu uma atividade com este nome");
					nula = true;
					break;
				}
			}
			if (atividade == null || atividade.isEmpty()) {
				nula = true;
				tela.retornaTextoEmTela("Erro! Insira um nome válido para sua atividade");
			}
		} while (nula);

	}

	private void inserirMinutagemEmAtividades(boolean repetida) {
		tela.retornaTextoEmTela("Digite o tempo que você leva para concluir esta atividade:\n");
		boolean tempoInvalido = false;
		do {
			try {
				horas = tela.insereDadoInteiro("(horas)\n");
				minutos = tela.insereDadoInteiro("(minutos)\n");
				segundos = tela.insereDadoInteiro("(segundos)\n");
				tempoInvalido = false;

			} catch (NumberFormatException e) {
				tempoInvalido = true;
				tela.retornaTextoEmTela("Erro! Valor inválido, insira um valor inteiro válido!");
			}
		} while (tempoInvalido || seSaoValoresInvalidos(horas, minutos, segundos));
		SistemaDeTempo sistemaDeTempo = new SistemaDeTempo();
		sistemaDeTempo.sistemaDeTempoOrganizado(horas, minutos, segundos);

		horas = sistemaDeTempo.getHorasOrganizadas();
		minutos = sistemaDeTempo.getMinutosOrganizados();
		segundos = sistemaDeTempo.getSegundosOrganizados();

		if (atividade == null) {
			tela.retornaTextoEmTela("ERRO! Não há nenhuma informação para a atividade!");
		}

	}

	private void salvarTempo() {
		horasOriginais.add(horas);
		minutosOriginais.add(minutos);
		segundosOriginais.add(segundos);

		horasMutaveis.add(horas);
		minutosMutaveis.add(minutos);
		segundosMutaveis.add(segundos);
	}

	public void restaurarTempoMutavel() {
		horasMutaveis.clear();
		minutosMutaveis.clear();
		segundosMutaveis.clear();
		for (int i = 0; i < atividadesObrigatorias.size(); i++) {
			horasMutaveis.add(horasOriginais.get(i));
			minutosMutaveis.add(minutosOriginais.get(i));
			segundosMutaveis.add(segundosOriginais.get(i));
		}
	}

	private void inserirDificuldade() {
		boolean dificuldadeInvalida;
		do {
			dificuldadeInvalida = false;
			dificuldade = tela.insereDadoDeTexto(
					"Digite o nível de dificuldade que você classifica essa atividade: (muito fácil, fácil, intermediário, difícil, muito difícil)");
			dificuldade = dificuldade.trim();

			if (!dificuldade.equals("muito fácil") && !dificuldade.equals("fácil")
					&& !dificuldade.equals("intermediário") && !dificuldade.equals("difícil")
					&& !dificuldade.equals("muito difícil")) {
				tela.retornaTextoEmTela("Nível de dificuldade inválido! Insira alguma das dificuldades disponíveis.");
				dificuldadeInvalida = true;
			}
		} while (dificuldadeInvalida);
	}

	public void definirAtividades(JButton botaoDeRegistro) {

		inserirQuantidadeDeAtividades();

		String minutagem;
		boolean repetida = false;
		for (int i = 0; i < quantidadeDeAtividades; i++) {
			do {
				repetida = false;
				inserirAtividades(i, repetida);

				if (!repetida) {
					inserirMinutagemEmAtividades(repetida);
				}
			} while (atividade == null || atividade.isEmpty() || repetida);

			salvarTempo();

			minutagem = String.format("%dH: %dM: %dS.", horasMutaveis.get(i), minutosMutaveis.get(i),
					segundosMutaveis.get(i));

			inserirDificuldade();

			atividadesObrigatorias.put(atividade, minutagem);
			dificuldadeDeCadaAtividade.add(dificuldade);
			tela.retornaTextoEmTela("Atividade registrada no sistema com sucesso!");

			if (botaoDeRegistro != null) {
				if (atividadesObrigatorias.size() >= 3) {
					botaoDeRegistro.setVisible(false);
				}
			}

		}

	}

	public void getAtividade() {
		int numeroDaAtividade = tela.insereDadoInteiro("Digite o número da atividade:");

		int contador = 0;
		String atividadeEncontrada;
		for (String buscaAtividade : atividadesObrigatorias.keySet()) {
			if (contador == (numeroDaAtividade - 1)) {
				atividadeEncontrada = String.format(
						"Atividade encontrada! (%d): %s, Tempo Restante: %s, Dificuldade: %s", (contador + 1),
						buscaAtividade, atividadesObrigatorias.get(buscaAtividade),
						dificuldadeDeCadaAtividade.get(contador));
				tela.retornaTextoEmTela(atividadeEncontrada);
				atividade = buscaAtividade;
				break;
			}
			contador++;
		}
	}

	public void getTodasAsAtividades() {
		int contador = 0;
		StringBuilder atividades = new StringBuilder();
		for (String atividade : atividadesObrigatorias.keySet()) {
			String atividadeFormatada = String.format("Atividade (%d): %s, Tempo Restante: %s, Dificuldade: %s",
					(contador + 1), atividade, atividadesObrigatorias.get(atividade),
					dificuldadeDeCadaAtividade.get(contador) + "\n");
			atividades.append(atividadeFormatada);
			contador++;
		}
		tela.retornaTextoEmTela(atividades.toString());
	}

	public void setAtividadeSelecionada(String atividade) {
		this.atividade = atividade;
	}

	public String getAtividadeSelecionada() {
		return atividade;
	}

	public List<String> getDificuldadeDeCadaAtividades() {
		return dificuldadeDeCadaAtividade;
	}

}
