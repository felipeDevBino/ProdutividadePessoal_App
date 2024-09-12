package diasconsecutivos;

import java.util.Map;
import utilizacaodetelas.UtilizarTelas;

import java.util.HashMap;

public class StatusDiasConsecutivos {

	private Map<Integer, String> dias;
	private UtilizarTelas tela;

	public StatusDiasConsecutivos() {
		dias = new HashMap<>();
		tela = new UtilizarTelas();
	}

	public void salvarDiaAtual(InformacoesDiarias informacoesDiarias) {
		//TODO SALVAR INFORMAÇÕES
	}

	public void getDeterminadoDia(int posicao) {
		tela.retornaTextoEmTela(dias.get(posicao));
	}

	public void getTodosOsDiasPassados() {
		StringBuilder todosOsDias = new StringBuilder();
		for (String dia : dias.values()) {
			todosOsDias.append(dia);
		}
		tela.retornaTextoEmTela(dias.toString());
	}

}
