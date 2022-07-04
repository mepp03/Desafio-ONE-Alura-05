package br.com.alura.java.Conversor;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaMostrarConversaoTemperatura extends JFrame implements ActionListener {

	private static final long serialVersionUID = 88046469905914160L;
	JButton botaoNovaConversao, botaoNovaTemperatura, botaoFechar;
	
	JanelaMostrarConversaoTemperatura(String valorConvertido){
		
		JLabel label = new JLabel("O valor da conversão é : " + valorConvertido);
		botaoNovaConversao = new JButton("Escolher outro tipo de conversão");
		botaoNovaConversao.addActionListener(this);
		botaoNovaTemperatura = new JButton("Escolher outra Temperatura");
		botaoNovaTemperatura.addActionListener(this);
		botaoFechar = new JButton("Encerrar");
		botaoFechar.addActionListener(this);		
		
		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setLayout((LayoutManager) new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
		JPanel painelTopo = new JPanel();
		JPanel painelFundo = new JPanel();
		painelTopo.setBorder(BorderFactory.createEmptyBorder(20, 150 , 10, 0));
		painelTopo.setLayout(new GridLayout(0, 1));
		painelFundo.setBorder(BorderFactory.createEmptyBorder(0, 10 , 10, 10));
		painelPrincipal.add(painelTopo);
		painelPrincipal.add(painelFundo);
		
		painelTopo.add(label);
		painelFundo.add(botaoNovaConversao);
		painelFundo.add(botaoNovaTemperatura);
		painelFundo.add(botaoFechar);
		
		this.add(painelPrincipal, BorderLayout.CENTER);
		this.setTitle("Resultado");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
        this.setLocationRelativeTo( null );
		this.setVisible(true);						
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == botaoNovaConversao) {
			this.dispose();
			new JanelaPrincipal();		
		}
		
		if (e.getSource() == botaoNovaTemperatura) {
			this.dispose();
			new JanelaPegarValorTemperatura();		
		}
		
		if (e.getSource() == botaoFechar) {
			System.exit(0);	
		}
		
	}

	
}
