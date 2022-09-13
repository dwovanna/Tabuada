package br.senai.sp.jandira;

import java.awt.Color;
import java.awt.Font;

import gui.FrameTabuada;

public class AppTabuada {

	public static void main(String[] args) {
	
		FrameTabuada tela = new FrameTabuada();
		tela.titulo = "Tabuada";
		tela.altura = 620;
		tela.largura = 400;
		tela.criarTela();
		
		Tabuada tabuada = new Tabuada();
		tabuada.multiplicando = 2;
		tabuada.minimoMultiplicador = 17;
		tabuada.maximoMultiplicador = 20 ;
		
		String[] resultado = tabuada.getTabuada();
		
		int i = 0;
		while (i < resultado.length) {
			System.out.println(resultado[i]);
			i++;
		}
		
		System.out.println("------------Fim---------------");
		
		
		

	}

}
