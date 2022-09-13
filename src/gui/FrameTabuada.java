package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import br.senai.sp.jandira.Tabuada;

public class FrameTabuada {

	public String titulo;
	public int largura;
	public int altura;
	public Color corDeFundoDaTela;
	public Font fonteDosLabels;
	public Color corDoBotao;

	public void criarTela() {

		JFrame tela = new JFrame();
		tela.setTitle(titulo);
		tela.setSize(largura, altura);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setLayout(null);
		tela.getContentPane().setBackground(Color.WHITE);

		JLabel titulo = new JLabel();
		titulo.setText("TABUADA 1.0");
		titulo.setBounds(80, 20, 250, 40);
		titulo.setForeground(Color.RED);
		titulo.setFont(new Font("arial", Font.BOLD, 25));

		JLabel descricao = new JLabel();
		descricao.setText(
				"<html>Com a tabuada 1.0 os seus problemas acabaram. <br>Calcule a tabuada que desejar em segundos!</html>");
		descricao.setBounds(80, 50, 1000, 30);
		descricao.setForeground(Color.gray);

		// Multiplicando

		JTextField textFieldMultiplicando = new JTextField();
		textFieldMultiplicando.setBounds(200, 130, 130, 30);

		JLabel multiplicando = new JLabel();
		multiplicando.setText("Multiplicando:");
		multiplicando.setBounds(80, 130, 1000, 30);
		multiplicando.setFont(new Font("arial", Font.BOLD, 17));

		// Mínimo Multiplicador

		JLabel minimo = new JLabel();
		minimo.setText("Mínimo Multiplicador:");
		minimo.setBounds(18, 130, 1000, 150);
		minimo.setFont(new Font("arial", Font.BOLD, 17));

		JTextField textFieldminimo = new JTextField();
		textFieldminimo.setBounds(200, 190, 130, 30);

		// Máximo Multiplicador

		JLabel maximo = new JLabel();
		maximo.setText("Máximo Multiplicador:");
		maximo.setBounds(18, 130, 1000, 280);
		maximo.setFont(new Font("arial", Font.BOLD, 17));

		JTextField textFieldmaximo = new JTextField();
		textFieldmaximo.setBounds(200, 250, 130, 30);

		// Botão Calcular

		JButton buttonCalcular = new JButton();
		buttonCalcular.setText("Calcular");
		buttonCalcular.setBounds(30, 330, 150, 38);
		buttonCalcular.setForeground(Color.BLACK);
		buttonCalcular.setFont(new Font("arial", Font.BOLD, 15));
		buttonCalcular.setBackground(new Color(55, 194, 48));

		// Botão Limpar

		JButton buttonLimpar = new JButton();
		buttonLimpar.setText("Limpar");
		buttonLimpar.setBounds(200, 330, 150, 38);
		buttonLimpar.setForeground(Color.BLACK);
		buttonLimpar.setFont(new Font("arial", Font.BOLD, 15));
		buttonLimpar.setBackground(new Color(253, 230, 89));

		// Resultado

		JLabel mensagem1 = new JLabel();
		mensagem1.setText("Resultado:");
		mensagem1.setBounds(30, 380, 100, 30);
		mensagem1.setFont(new Font("arial", Font.BOLD, 15));

		// Caixa amarela

		JList<String> listLista1 = new JList<>();
		listLista1.setBorder(new LineBorder(Color.BLACK));
		listLista1.setBackground(new Color(252, 238, 188));
		
      //Scroll - barra de rolar
		JScrollPane scroll = new JScrollPane(listLista1);
		scroll.setBounds(30, 410, 320, 150);
		
		
		

		// imagem

		ImageIcon imagem = new ImageIcon("src/br/senai/sp/jandira/imagens/img.png");
		JLabel icon = new JLabel();
		icon.setIcon(imagem);
		icon.setBounds(10, 20, 150, 70);

		buttonCalcular.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Tabuada tabuada = new Tabuada();

				if (textFieldMultiplicando.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, digite o valor do multiplicando!");
				} else if (textFieldminimo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, digite o valor do mínimo multiplicador!!!");
				} else if (textFieldmaximo.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor, digite o valor do máximo multiplicador!!!");
				} else if
				(Integer.parseInt(textFieldminimo.getText()) <= Integer.parseInt(textFieldmaximo.getText())){
				} else {
					JOptionPane.showMessageDialog(null, "O mínimo multiplicando deve ser menor que o máximo multiplicador!");
				}
				
				
	
				
				

				tabuada.multiplicando = Integer.parseInt(textFieldMultiplicando.getText());
				tabuada.minimoMultiplicador = Integer.parseInt(textFieldminimo.getText());
				tabuada.maximoMultiplicador = Integer.parseInt(textFieldmaximo.getText());

				listLista1.setListData(tabuada.getTabuada());
	
			}
		});

		// Acão do botão Limpar
		buttonLimpar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == buttonLimpar)
					;

				textFieldMultiplicando.setText(null);
				textFieldminimo.setText(null);
				textFieldmaximo.setText(null);

				DefaultListModel<String> lista = new DefaultListModel<>();
				listLista1.setModel(lista);

			}
		});

		// Adicionar no Painel

		Container painel = tela.getContentPane();
		painel.add(titulo);
		painel.add(descricao);
		painel.add(textFieldMultiplicando);
		painel.add(multiplicando);
		painel.add(minimo);
		painel.add(textFieldminimo);
		painel.add(maximo);
		painel.add(textFieldmaximo);
		painel.add(buttonCalcular);
		painel.add(buttonLimpar);
		painel.add(mensagem1);
		painel.add(scroll);
		painel.add(icon);
	

		tela.setVisible(true);

	}

}
