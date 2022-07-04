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

public class JanelaMostrarConversaoMoeda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 8855759718267827574L;
	JButton botaoNovaConversao, botaoNovaMoeda, botaoFechar;
	
	JanelaMostrarConversaoMoeda(String valorConvertido){
			
		JLabel label = new JLabel("O valor da conversão é de: " + valorConvertido);
		botaoNovaConversao = new JButton("Escolher outro tipo de conversão");
		botaoNovaConversao.addActionListener(this);
		botaoNovaMoeda = new JButton("Escolher outra moeda");
		botaoNovaMoeda.addActionListener(this);
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
		painelFundo.add(botaoNovaMoeda);
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
		
		if (e.getSource() == botaoNovaMoeda) {
			this.dispose();
			new JanelaPegarValorMoeda();		
		}
		
		if (e.getSource() == botaoFechar) {
			System.exit(0);	
		}
		
	}

	
}
