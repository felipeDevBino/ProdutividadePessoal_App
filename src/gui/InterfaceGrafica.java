package gui;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import atividades.AtividadesObrigatorias;
import atividades.AtividadesOpcionais;
import atividades.Entretenimentos;
import atividades.SelecionaAtividades;
import atividades.TempoEmAtividades;
import atividades.TempoEmEntretenimentos;
import gui.funcoesgui.AplicarAtividade;
import gui.funcoesgui.FuncoesInterface;
import instancias.InstanceManager;
import logicadehorarios.cronometro.Cronometro;
import utilizacaodetelas.UtilizarTelas;

public class InterfaceGrafica {

	private JFrame frame;
	public JLabel conteudoAtividade01, horarioAtividade01;
	public JLabel conteudoAtividade02, horarioAtividade02;
	public JLabel conteudoAtividade03, horarioAtividade03;
	public JLabel conteudoAtividadeOp01, horarioAtividadeOp01;
	public JLabel conteudoAtividadeOp02, horarioAtividadeOp02;
	public JLabel variavelTempoAcumulado;
	public JLabel variavelCronometro;

	public boolean concluiu = false;
	public boolean cronometroEncerrou;
	public int atividadesOpcionaisConcluidas = 0;

	private AtividadesObrigatorias atividadesObrigatorias = InstanceManager.getAtividadesObrigatorias();
	private AtividadesOpcionais atividadesOpcionais = InstanceManager.getAtividadesOpcionais();
	private TempoEmAtividades tempoEmAtividades = InstanceManager.getTempoEmAtividades();
	private TempoEmEntretenimentos tempoEmEntretenimentos = InstanceManager.getTempoEmEntretenimentos();
	private SelecionaAtividades selecionaAtividades = InstanceManager.getSelecionaAtividades();
	private Entretenimentos entretenimentos = InstanceManager.getEntretenimentos();
	private Cronometro cronometro;
	private AplicarAtividade aplicar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfaceGrafica window = new InterfaceGrafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void cronometroEncerrado() throws InterruptedException {
		if (!cronometro.cronometroEncerrou) {
			frame.setVisible(true);
		} else {
			frame.setVisible(false);
		}
	}

	/**
	 * Create the application.
	 */
	public InterfaceGrafica() {
		aplicar = new AplicarAtividade();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		FuncoesInterface funcao = new FuncoesInterface();
		UtilizarTelas tela = new UtilizarTelas();

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 7));
		frame.setBounds(100, 100, 452, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JLabel lblNewLabel = new JLabel("ProdutividadePessoal_App");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(99, 11, 233, 23);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("@author: felipeDevBino (GitHub)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_1.setBounds(135, 0, 136, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("ATIVIDADE 01");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(49, 42, 105, 23);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("ATIVIDADE 02");
		lblNewLabel_2_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2_1.setBounds(173, 46, 105, 14);
		frame.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("ATIVIDADE 03");
		lblNewLabel_2_2.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2_2.setBounds(299, 46, 105, 14);
		frame.getContentPane().add(lblNewLabel_2_2);

		String tempoAcumulado = String.format("%dH : %dM : %dS.", tempoEmAtividades.horasAcumuladas,
				tempoEmAtividades.minutosAcumulados, tempoEmAtividades.segundosAcumulados);

		variavelTempoAcumulado = new JLabel(tempoAcumulado);
		variavelTempoAcumulado.setBounds(186, 252, 80, 14);
		frame.getContentPane().add(variavelTempoAcumulado);

		conteudoAtividade01 = new JLabel(selecionaAtividades.getAtividade01());
		conteudoAtividade01.setFont(new Font("Tahoma", Font.PLAIN, 10));
		conteudoAtividade01.setBounds(49, 76, 89, 39);
		frame.getContentPane().add(conteudoAtividade01);

		horarioAtividade01 = new JLabel(
				atividadesObrigatorias.atividadesObrigatorias.get(selecionaAtividades.getAtividade01()));
		horarioAtividade01.setBounds(49, 112, 89, 14);
		frame.getContentPane().add(horarioAtividade01);

		horarioAtividade02 = new JLabel(
				atividadesObrigatorias.atividadesObrigatorias.get(selecionaAtividades.getAtividade02()));
		horarioAtividade02.setBounds(173, 112, 89, 14);
		frame.getContentPane().add(horarioAtividade02);

		horarioAtividade03 = new JLabel(
				atividadesObrigatorias.atividadesObrigatorias.get(selecionaAtividades.getAtividade03()));
		horarioAtividade03.setBounds(299, 112, 89, 14);
		frame.getContentPane().add(horarioAtividade03);

		conteudoAtividade02 = new JLabel(selecionaAtividades.getAtividade02());
		conteudoAtividade02.setFont(new Font("Tahoma", Font.PLAIN, 10));
		conteudoAtividade02.setBounds(173, 76, 89, 39);
		frame.getContentPane().add(conteudoAtividade02);

		conteudoAtividade03 = new JLabel(selecionaAtividades.getAtividade03());
		conteudoAtividade03.setFont(new Font("Tahoma", Font.PLAIN, 10));
		conteudoAtividade03.setBounds(299, 76, 89, 39);
		frame.getContentPane().add(conteudoAtividade03);

		JLabel lblNewLabel_2_3 = new JLabel("ATIVIDADE OPCIONAL 01");
		lblNewLabel_2_3.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2_3.setBounds(49, 192, 160, 14);
		frame.getContentPane().add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_3_1 = new JLabel("ATIVIDADE OPCIONAL 02");
		lblNewLabel_2_3_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_2_3_1.setBounds(234, 192, 160, 14);
		frame.getContentPane().add(lblNewLabel_2_3_1);

		conteudoAtividadeOp01 = new JLabel(selecionaAtividades.getAtividadeOpcional01());
		conteudoAtividadeOp01.setFont(new Font("Tahoma", Font.PLAIN, 10));
		conteudoAtividadeOp01.setBounds(49, 217, 116, 39);
		frame.getContentPane().add(conteudoAtividadeOp01);

		conteudoAtividadeOp02 = new JLabel(selecionaAtividades.getAtividadeOpcional02());
		conteudoAtividadeOp02.setFont(new Font("Tahoma", Font.PLAIN, 10));
		conteudoAtividadeOp02.setBounds(299, 217, 127, 39);
		frame.getContentPane().add(conteudoAtividadeOp02);

		horarioAtividadeOp01 = new JLabel(
				atividadesOpcionais.atividadesOpcionais.get(selecionaAtividades.getAtividadeOpcional01()));
		horarioAtividadeOp01.setBounds(49, 252, 89, 14);
		frame.getContentPane().add(horarioAtividadeOp01);

		horarioAtividadeOp02 = new JLabel(
				atividadesOpcionais.atividadesOpcionais.get(selecionaAtividades.getAtividadeOpcional02()));
		horarioAtividadeOp02.setBounds(299, 252, 89, 14);
		frame.getContentPane().add(horarioAtividadeOp02);

		JButton distribuir = new JButton("Distribuir");
		distribuir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		distribuir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcao.distribuirTempoEmEntretenimento(entretenimentos, tempoEmAtividades, tempoEmEntretenimentos, tela,
						variavelTempoAcumulado);
			}
		});
		distribuir.setBounds(173, 277, 105, 31);
		frame.getContentPane().add(distribuir);

		JButton diminuir = new JButton("Diminuir");
		diminuir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		diminuir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entretenimentos.getTodosOsEntretenimentos();
				funcao.diminuirTempoEmEntretenimento(tempoEmEntretenimentos);
			}
		});
		diminuir.setBounds(173, 336, 103, 31);
		frame.getContentPane().add(diminuir);

		JLabel lblNewLabel_4 = new JLabel("Tempo Acumulado");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(166, 224, 116, 23);
		frame.getContentPane().add(lblNewLabel_4);

		JButton opcoes = new JButton("OPÇÕES");
//		opcoes.addActionListener(new ActionListener() {
				// TODO	
//		});
		opcoes.setBounds(49, 341, 89, 23);
		frame.getContentPane().add(opcoes);

		JLabel lblNewLabel_3 = new JLabel("^");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_3.setBounds(211, 327, 35, 0);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("v");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel_3_1.setBounds(221, 319, 0, 31);
		frame.getContentPane().add(lblNewLabel_3_1);

		JLabel lblNewLabel_5 = new JLabel("Para");
		lblNewLabel_5.setBounds(211, 308, 35, 14);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Entretenimentos");
		lblNewLabel_6.setBounds(173, 319, 105, 14);
		frame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Cronômetro");
		lblNewLabel_7.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblNewLabel_7.setBounds(310, 320, 116, 14);
		frame.getContentPane().add(lblNewLabel_7);

		aplicar.aplicarAtividade01(this, conteudoAtividade01, horarioAtividade01);
		aplicar.aplicarAtividade02(this, conteudoAtividade02, horarioAtividade02);
		aplicar.aplicarAtividade03(this, conteudoAtividade03, horarioAtividade03);
		aplicar.aplicarAtividadeOpcional01(this, conteudoAtividadeOp01, horarioAtividadeOp01);
		aplicar.aplicarAtividadeOpcional02(this, conteudoAtividadeOp02, horarioAtividadeOp02);

		variavelCronometro = new JLabel("");
		variavelCronometro.setBounds(308, 345, 103, 14);
		frame.getContentPane().add(variavelCronometro);

		cronometro = new Cronometro(this);
		new Thread(cronometro).start();

	}

	public JFrame getFrame() {
		return frame;
	}

	public void addConteudoFrame(Component conteudo) {
		frame.getContentPane().add(conteudo);
	}

	public boolean getConclusao() {
		return concluiu;
	}

	public void setVariavelTempoAcumulado(String tempo) {
		variavelTempoAcumulado.setText(tempo);
	}
	
	public void setTempo(int horas, int minutos, int segundos, JLabel jlabel) {
		jlabel.setText(String.format("%dH: %dM: %dS.", horas, minutos, segundos));
	}
	
}
