package dias_consecutivos;

import java.util.Map;

import interface_executar.Start;

import java.util.HashMap;

public class StatusDiasConsecutivos {

	private static Map<Integer, String> dias = new HashMap<>();
	
	public static void salvaDiaAtual() {
		dias.put(Start.diasConsecutivos, InformacoesDiarias.retornaInformacoes());
	}
	
	public static void getDeterminadoDia(int posicao) {
		System.out.println(dias.get(posicao));
	}
	
	public static void getTodosOsDiasPassados() {
		for(String dia : dias.values()) {
			System.out.println(dia);
		}
	}
	
}
