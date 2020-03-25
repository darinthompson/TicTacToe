package labs;

import java.util.Scanner;

public class TicTacToe {

	static String[][] board = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
	static String[][] resetBoard = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		while (true) {
			CreateBoard();

			Player player1 = new Player();
			Player player2 = new Player();

			System.out.print("Player1 Choose a character: ");
			player1.symbol = sc.nextLine();

			System.out.print("Player2 Choose a Character: ");
			player2.symbol = sc.nextLine();

			while (true) {
				PlayerTurn(player1.symbol);
				if (GameOver()) {
					break;
				} else {
					PlayerTurn(player2.symbol);
					if (GameOver()) {
						break;
					}
				}
			}

			if (!PlayAgain()) {
				System.out.println("Good-Bye!");
				ResetBoard();
				break;
			}
		}
	}

	static void MakeMark(int posx, int posy, String symbol) {
		board[posx][posy] = symbol;
		UpdateBoard();
	}

	static void CreateBoard() {
		ResetBoard();

		for (int i = 0; i < resetBoard.length; i++) {
			for (int j = 0; j < resetBoard.length; j++) {
//				if(i == 0) {
//					System.out.println();
//				}
				System.out.print("| " + resetBoard[i][j] + " ");
			}
			System.out.println("|");
		}
		PrintSpacing();
	}

	static boolean PlayAgain() {
		sc.nextLine();
		System.out.println("Play Again? (y/n): ");
		String userChoice = sc.nextLine();
		if (!userChoice.toLowerCase().equals("y")) {
			return false;
		} else {
			return true;
		}
	}

	static boolean ValidatePlayerTurn(int num) {
		switch (num) {
		case 1:
			if (!board[0][0].equals(String.valueOf(num))) {
				System.err.println("******Can't do that!******");
				System.out.print("try again 0 - 9 (unused)");
				return false;
			} else {
				return true;
			}
		case 2:
			if (!board[0][1].equals(String.valueOf(num))) {
				System.err.println("******Can't do that!******");
				System.out.print("try again 0 - 9 (unused)");
				return false;
			} else {
				return true;
			}
		case 3:
			if (!board[0][2].equals(String.valueOf(num))) {
				System.err.println("******Can't do that!******");
				System.out.print("try again 0 - 9 (unused)");
				return false;
			} else {
				return true;
			}
		case 4:
			if (!board[1][0].equals(String.valueOf(num))) {
				System.err.println("******Can't do that!******");
				System.out.print("try again 0 - 9 (unused)");
				return false;
			} else {
				return true;
			}
		case 5:
			if (!board[1][1].equals(String.valueOf(num))) {
				System.err.println("******Can't do that!******");
				System.out.print("try again 0 - 9 (unused)");
				return false;
			} else {
				return true;
			}
		case 6:
			if (!board[1][2].equals(String.valueOf(num))) {
				System.err.println("******Can't do that!******");
				System.out.print("try again 0 - 9 (unused)");
				return false;
			} else {
				return true;
			}
		case 7:
			if (!board[2][0].equals(String.valueOf(num))) {
				System.err.println("******Can't do that!******");
				System.out.print("try again 0 - 9 (unused)");
				return false;
			} else {
				return true;
			}
		case 8:
			if (!board[2][1].equals(String.valueOf(num))) {
				System.err.println("******Can't do that!******");
				System.out.print("try again 0 - 9 (unused)");
				return false;
			} else {
				return true;
			}
		case 9:
			if (!board[2][2].equals(String.valueOf(num))) {
				System.err.println("******Can't do that!******");
				System.out.print("try again 0 - 9 (unused)");
				return false;
			} else {
				return true;
			}
		default:
			System.err.println("******Can't do that!******");
			System.out.print("try again 0 - 9 (unused)");
			return false;
		}
	}

	static boolean GameOver() {
		if (board[0][0].equals(board[0][1]) && board[0][1].equals((board)[0][2])) {
			return true;
		} else if (board[0][0].equals(board[0][1]) && board[0][1].equals((board)[0][2])) {
			return true;
		} else if (board[0][0].equals(board[1][1]) && board[1][1].equals((board)[2][2])) {
			return true;
		} else if (board[0][0].equals(board[1][0]) && board[1][0].equals((board)[2][0])) {
			return true;
		} else if (board[1][0].equals(board[1][1]) && board[1][1].equals((board)[1][2])) {
			return true;
		} else if (board[2][0].equals(board[2][1]) && board[0][1].equals((board)[2][2])) {
			return true;
		} else if (board[0][1].equals(board[1][1]) && board[1][1].equals((board)[2][1])) {
			return true;
		} else if (board[0][2].equals(board[1][2]) && board[1][2].equals((board)[2][2])) {
			return true;
		} else if (board[0][2].equals(board[1][1]) && board[1][1].equals((board)[0][2])) {
			return true;
		} else if (!board[0][0].equals("1") && !board[0][1].equals("2") && !board[0][2].equals("3")
				&& !board[1][0].equals("4") && !board[1][1].equals("5") && !board[1][2].equals("6")
				&& !board[2][0].equals("7") && !board[2][1].equals("8") && !board[2][2].equals("9")) {
			return true;
		} else {
			return false;
		}
	}

	static Boolean PlayerTurn(String symbol) {
		System.out.print("Where do wish to go? (1 - 9): ");
		int move;
		do {
			move = sc.nextInt();
		} while (!ValidatePlayerTurn(move));

		switch (move) {
		case 1:
			MakeMark(0, 0, symbol);
			break;
		case 2:
			MakeMark(0, 1, symbol);
			break;
		case 3:
			MakeMark(0, 2, symbol);
			break;
		case 4:
			MakeMark(1, 0, symbol);
			break;
		case 5:
			MakeMark(1, 1, symbol);
			break;
		case 6:
			MakeMark(1, 2, symbol);
			break;
		case 7:
			MakeMark(2, 0, symbol);
			break;
		case 8:
			MakeMark(2, 1, symbol);
			break;
		case 9:
			MakeMark(2, 2, symbol);
			break;
		}
		return GameOver();
	}

	static void UpdateBoard() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print("| " + board[i][j] + " ");
			}
			System.out.println("| ");
		}
		PrintSpacing();
	}

	static void PrintSpacing() {
		System.out.println("\n*********************\n");
	}

	static void ResetBoard() {
		for (int i = 0; i < resetBoard.length; i++) {
			for (int j = 0; j < resetBoard.length; j++) {
				board[i][j] = resetBoard[i][j];
			}
		}
	}
}
