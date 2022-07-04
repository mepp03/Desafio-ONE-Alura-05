package br.com.alura.java.Conversor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaPrincipal extends JFrame implements ActionListener {

	private static final long serialVersionUID = -7966587819593915208L;
	JComboBox comboBox;
	JButton botao;
	Integer escolha;

	JanelaPrincipal() {

		JLabel label = new JLabel("Escolha uma opção:");
		String[] tipo = { "Conversor de Moeda", "Conversor de Temperatura", "Conversor de Velocidade" };
		comboBox = new JComboBox(tipo);
		botao = new JButton("OK");

		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setLayout((LayoutManager) new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
		JPanel painelTopo = new JPanel();
		JPanel painelFundo = new JPanel();
		painelTopo.setBorder(BorderFactory.createEmptyBorder(0, 60, 0, 60));
		painelTopo.setLayout(new GridLayout(0, 1));
		painelFundo.setBorder(BorderFactory.createEmptyBorder(10, 120, 10, 120));
		painelPrincipal.add(painelTopo);
		painelPrincipal.add(painelFundo);

		painelTopo.add(label);
		painelTopo.add(comboBox);
		painelFundo.add(botao);

		comboBox.addActionListener(this);
		botao.setSize(30, 10);
		botao.addActionListener(this);

		this.add(painelPrincipal, BorderLayout.CENTER);
		this.setTitle("Tipo de Conversão");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == botao) {
			switch (comboBox.getSelectedIndex()) {
			case 0: {
				this.dispose();
				new JanelaPegarValorMoeda();
				break;
			}
			case 1: {
				this.dispose();
				new JanelaPegarValorTemperatura();
				break;
			}
			case 2: {
				this.dispose();
				new JanelaPegarValorVelocidade();
				break;
			}
			}
		}
	}
}
