package instancias;

import atividades.AtividadesObrigatorias;
import atividades.AtividadesOpcionais;
import atividades.Entretenimentos;
import atividades.SelecionaAtividades;
import atividades.TempoEmAtividades;
import atividades.TempoEmEntretenimentos;
import gui.funcoesgui.DiminuirTempo;
import gui.InterfaceGrafica;

public class InstanceManager {

	private static AtividadesObrigatorias atividadesObrigatorias = new AtividadesObrigatorias();
	private static AtividadesOpcionais atividadesOpcionais = new AtividadesOpcionais();
	private static Entretenimentos entretenimentos = new Entretenimentos();
	private static SelecionaAtividades selecionaAtividades = new SelecionaAtividades();
	private static TempoEmAtividades tempoEmAtividades = new TempoEmAtividades();
	private static TempoEmEntretenimentos tempoEmEntretenimentos = new TempoEmEntretenimentos();
	private static DiminuirTempo diminuirTempo = new DiminuirTempo();
	private static InterfaceGrafica gui;	
	
	public static AtividadesObrigatorias getAtividadesObrigatorias() {
		if(atividadesObrigatorias == null) {
			atividadesObrigatorias = new AtividadesObrigatorias();
		}
		return atividadesObrigatorias;
	}
	
	public static AtividadesOpcionais getAtividadesOpcionais() {
		if(atividadesOpcionais == null) {
			atividadesOpcionais = new AtividadesOpcionais();
		}
		return atividadesOpcionais;
	}
	
	public static Entretenimentos getEntretenimentos() {
		if(entretenimentos == null) {
			entretenimentos = new Entretenimentos();
		}
		return entretenimentos;
	}
	
	public static SelecionaAtividades getSelecionaAtividades() {
		if(selecionaAtividades == null) {
			selecionaAtividades = new SelecionaAtividades();
		}
		return selecionaAtividades;
	}
	
	public static TempoEmAtividades getTempoEmAtividades() {
		if(tempoEmAtividades == null) {
			tempoEmAtividades = new TempoEmAtividades();
		}
		return tempoEmAtividades;
	}
	
	public static TempoEmEntretenimentos getTempoEmEntretenimentos() {
		if(tempoEmEntretenimentos == null) {
			tempoEmEntretenimentos = new TempoEmEntretenimentos();
		}
		return tempoEmEntretenimentos;
	}
	
	public static InterfaceGrafica getInterfaceGrafica() {
		if(gui == null) {
			gui = new InterfaceGrafica();
		}
		return gui;
	}
	
	public static DiminuirTempo getDiminuirTempo() {
		if(diminuirTempo == null) {
			diminuirTempo = new DiminuirTempo();
		}
		return diminuirTempo;
	}
	
}
