package atividades;

import java.util.Map;
import java.util.HashMap;
import javax.swing.JButton;
import utilizacaodetelas.UtilizarTelas;
import java.util.List;
import java.util.ArrayList;

public class Entretenimentos {

	public Map<String, String> entretenimentos;
	public List<Integer> horas;
	public List<Integer> minutos;
	public List<Integer> segundos;
	private String entretenimento;
	private UtilizarTelas tela;
	private int quantidadeDeEntretenimentos;

	public Entretenimentos() {
		tela = new UtilizarTelas();
		horas = new ArrayList<>();
		minutos = new ArrayList<>();
		segundos = new ArrayList<>();
		entretenimentos = new HashMap<>();
	}

	private void inserirQuantidadeDeEntretenimentos() {
		do {
			quantidadeDeEntretenimentos = tela
					.insereDadoInteiro("Digite a quantidade de entretenimentos que você possui (máximo = 9):");

			if (quantidadeDeEntretenimentos > 9) {
				tela.retornaTextoEmTela("Quantidade inválida, excedendo os limites estabelecidos!");
				continue;
			}

			tela.retornaTextoEmTela((quantidadeDeEntretenimentos <= 0)
					? "Quantidade inválida! Insira uma quantidade positiva."
					: "Quantidade registrada com sucesso.");
		} while (quantidadeDeEntretenimentos <= 0 || quantidadeDeEntretenimentos > 9);

	}

	private void inserirEntretenimentos(String tempos, int posicao) {
		String atividade;
		boolean nula;
		do {
			nula = false;
			atividade = tela.insereDadoDeTexto("Digite o " + (posicao + 1) + " entretenimento:");
			atividade = atividade.trim();

			if (atividade == null || atividade.isEmpty()) {
				nula = true;
				tela.retornaTextoEmTela("Erro! Insira um nome válido para seu entretenimento");
			}
		} while (nula);
		
		entretenimentos.put(atividade, tempos);

		horas.add(posicao, 0);
		minutos.add(posicao, 0);
		segundos.add(posicao, 0);

		tela.retornaTextoEmTela("Entretenimento registrado no sistema com sucesso!");

	}

	public void definirEntretenimentos(JButton botaoDeRegistro) {

		inserirQuantidadeDeEntretenimentos();

		String tempos = String.format("%dH: %dM: %dS.", 0, 0, 0);

		for (int i = 0; i < quantidadeDeEntretenimentos; i++) {
			inserirEntretenimentos(tempos, i);

			if (botaoDeRegistro != null) {
				botaoDeRegistro.setVisible(false);
			}
		}

	}

	public void getEntretenimento() {
		int numeroDoEntretenimento;
		do {
			numeroDoEntretenimento = tela.insereDadoInteiro("Digite o número do entretenimento:");

			if (numeroDoEntretenimento <= 0 || numeroDoEntretenimento > 9) {
				tela.retornaTextoEmTela("Erro! Entretenimento inválido.");
				continue;
			}

			int contador = 1;
			for (String buscaAtividade : entretenimentos.keySet()) {
				if (contador == numeroDoEntretenimento) {
					String texto = String.format("Entretenimento encontrado! (%d): %s, Tempo Disponível: %s", contador,
							buscaAtividade, entretenimentos.get(buscaAtividade));
					tela.retornaTextoEmTela(texto);
					entretenimento = buscaAtividade;
					break;
				}
				contador++;
			}
		} while (numeroDoEntretenimento <= 0 || numeroDoEntretenimento > 9);
	}

	public void getTodosOsEntretenimentos() {
		int contador = 0;
		for (String entretenimento : entretenimentos.keySet()) {
			tela.retornaTextoEmTela(String.format("Entretenimento %d:\n%s, Tempo Disponível: %s", (contador + 1), entretenimento,
					entretenimentos.get(entretenimento) + "\n"));
			contador++;
		}
	}

	public String getEntretenimentoSelecionado() {
		return entretenimento;
	}

}
