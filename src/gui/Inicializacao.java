package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import atividades.AtividadesObrigatorias;
import atividades.Entretenimentos;
import instancias.InstanceManager;
import utilizacaodetelas.UtilizarTelas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Inicializacao {

	private JFrame frame;
	private JTextField textField;
	private AtividadesObrigatorias atividadesObrigatorias = InstanceManager.getAtividadesObrigatorias(); 
	private Entretenimentos entretenimentos = InstanceManager.getEntretenimentos();

	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicializacao window = new Inicializacao();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}	
		});
	}

	/**
	 * Create the application.
	 */
	public Inicializacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		UtilizarTelas tela = new UtilizarTelas();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 476, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton botaoAtividadesObrigatorias = new JButton("Adicionar");
		botaoAtividadesObrigatorias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				atividadesObrigatorias.definirAtividades(botaoAtividadesObrigatorias);
			}
		});
		botaoAtividadesObrigatorias.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botaoAtividadesObrigatorias.setBounds(279, 159, 142, 56);
		frame.getContentPane().add(botaoAtividadesObrigatorias);
		
		JLabel lblNewLabel = new JLabel("Atividades obrigatórias:");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 150, 450, 39);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Entretenimentos:");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(35, 233, 178, 14);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Bem Vindo(a):");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(161, 11, 170, 46);
		frame.getContentPane().add(lblNewLabel_2);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(103, 84, 304, 32);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("(ao menos 3)");
		lblNewLabel_3.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(56, 190, 288, 25);
		frame.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("User:");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(41, 91, 52, 14);
		frame.getContentPane().add(lblNewLabel_4);

		JButton botaoEntretenimentos = new JButton("Adicionar");
		botaoEntretenimentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				entretenimentos.definirEntretenimentos(botaoEntretenimentos);
			}
		});
		botaoEntretenimentos.setFont(new Font("Arial Black", Font.PLAIN, 15));
		botaoEntretenimentos.setBounds(279, 233, 142, 56);
		frame.getContentPane().add(botaoEntretenimentos);

		JLabel lblNewLabel_5 = new JLabel("@felipeDevBino");
		lblNewLabel_5.setBounds(201, 0, 130, 25);
		frame.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_3_1 = new JLabel("(máximo de 9)");
		lblNewLabel_3_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		lblNewLabel_3_1.setBounds(56, 258, 288, 23);
		frame.getContentPane().add(lblNewLabel_3_1);

		JButton btnNewButton_2 = new JButton("SALVAR");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(201, 116, 89, 23);
		frame.getContentPane().add(btnNewButton_2);

		JButton btnNewButton = new JButton("CONCLUIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (atividadesObrigatorias.atividadesObrigatorias.size() >= 3
						&& entretenimentos.entretenimentos.size() >= 1) {
					tela.retornaTextoEmTela("ATIVIDADES REGISTRADAS COM SUCESSO!");
					frame.setVisible(false);
					if (!frame.isActive()) {
						InterfaceGrafica gui = InstanceManager.getInterfaceGrafica();
						gui.getFrame().setVisible(true);
					}
				} else {
					tela.retornaTextoEmTela("ATIVIDADES INSUFICIENTES PARA INICIAR O PROGRAMA");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 346, 440, 48);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_6 = new JLabel("Registrado");
		lblNewLabel_6.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(304, 166, 105, 37);
		frame.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_6_1 = new JLabel("Registrado");
		lblNewLabel_6_1.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_6_1.setBounds(302, 244, 105, 37);
		frame.getContentPane().add(lblNewLabel_6_1);
	}

	public JFrame getFrame() {
		return frame;
	}

}
