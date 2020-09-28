package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch cm = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		while (!cm.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(cm, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = cm.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(cm.getPieces(), possibleMoves);
				
				System.out.println("");
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = cm.performChessMove(source,target);
			
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				if(cm.getPromoted() != null) {
					System.out.print("Enter piece for promotion (B/N/R/Q): ");
					String type = sc.nextLine().toUpperCase();
					while (!type.equals("B") && !type.equals("N") && !type.equals("R") && !type.equals("Q")) {
						System.out.println("Valor invalido! Enter piece for promotion (B/N/R/Q): ");
						type = sc.nextLine().toUpperCase();
					}
					cm.replacePromotedPiece(type);
				}
			}
			catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		UI.clearScreen();
		UI.printMatch(cm, captured);
	}
	
}





