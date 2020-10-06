package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import chess.Color;

public class WinnerCont {

	private String nameWin;
	private Color colorWin;
	private int cont;
	
	private String path = "C:\\Users\\DELL\\Desktop\\NewAreaTrabalho\\ChessWinners\\ChessWinners.txt";
	String[] txt;
	
	public WinnerCont() {}
	
	public WinnerCont(String name, Color color) {
		this.nameWin = name;
		this.colorWin = color;
	}
	
	public Color getColor() {
		return colorWin;
	}
	
	public void setName(String name) {
		this.nameWin = name;
	}

	public void WinCont(int turn) {
		cont = turn;
	}

	public void WinColor(Color color) {
		this.colorWin = color;
	}
	
	public void txtGenerate() {
		String winName = "Winner: "+ nameWin +" thanks for playing";
		String winColor = "Color of Winner: "+ colorWin;
		String winCont = "Number of turns: "+ cont;
		txt = new String[] {winName,winColor,winCont,"",};
	}
		
	public void generateTxtFile() {
		txtGenerate();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){		//Adicionar parametro (.. ,true) para não recriar o arquivo
			for(String line : txt) {
				bw.write(line);
				bw.newLine();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
