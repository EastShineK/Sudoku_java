import java.util.Random;

public class Sudoku {

	private final static int width = 9;
	private final static int height = 9;
	
	private int[][] sudokuAnswer = new int[width][height];
	private int[][] sudokuPuzzle = new int[width][height];
	
	Sudoku() {
		initSudoku();
		generateAnswer();
		generatePuzzle();
	}
	
	void initSudoku() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				sudokuAnswer[i][j] = 0;
				sudokuPuzzle[i][j] = 0;
			}
		}
	}
	void generateAnswer() {
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		int check = 1, checkRow = 1, checkCol = 1, checkBox = 1;
		int count = 0, recountJ = 0, recountI = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				check = 1;
				count = 0;
				while(check == 1) {
					int val = rand.nextInt(9) + 1; 
					count++;
					if(count > 50) {
						count = 0;
						j = 0;
						for(int c = 0; c < j; c++) {
							sudokuAnswer[i][c] = 0;
						}
						if(recountJ == 1) {
							i = 0;
							
							for(int b = i; b < 9; b++) {
								for(int c = 0; c < 9; c++) {
									sudokuAnswer[b][c] = 0;
								}
							}
							recountJ = 0;
							recountI = 1;
							break;
						}
						recountJ = 1;
						continue;
					}
					
					for(int k = 0; k < i; k++) {
						if(val == sudokuAnswer[k][j]) {
							checkRow = 0;
							break;
						}
					}
					if(checkRow == 0) {
						checkRow = 1;
						continue;
					}
						
					
					for(int k = 0; k < j; k++) { 
						if(val == sudokuAnswer[i][k]) {
							checkCol = 0;
							break;
						}
					}	
					if(checkCol == 0) {
						checkCol = 1;
						continue;
					}
					
					if(i % 3 == 0) { 
						if(j % 3 == 0) { 
							for(int k = i; k < i + 3; k++) {
								for(int t = j; t < j + 3; t++) {
									if(val == sudokuAnswer[k][t]) {
										checkBox = 0;
										break;
									}
								}
								if(checkBox == 0) break;
							}
							if(checkBox == 0) {
								checkBox = 1;
								continue;
							}
						}//if if end
						else if(j % 3 == 1) { 
							for(int k = i; k < i + 3; k++) {
								for(int t = j - 1; t < j + 2; t++) {
									if(val == sudokuAnswer[k][t]) {
										checkBox = 0;
										break;
									}
								}
								if(checkBox == 0) break;
							}
							if(checkBox == 0) {
								checkBox = 1;
								continue;
							}
						}//if (else if) end
						else { 
							for(int k = i; k < i + 3; k++) {
								for(int t = j - 2; t < j + 1; t++) {
									if(val == sudokuAnswer[k][t]) {
										checkBox = 0;
										break;
									}
								}
								if(checkBox == 0) break;
							}
							if(checkBox == 0) {
								checkBox = 1;
								continue;
							}	
						}//if else end
					}//if end
					else if(i % 3 == 1) {
						if(j % 3 == 0) {
							for(int k = i - 1; k < i + 2; k++) {
								for(int t = j; t < j + 3; t++) {
									if(val == sudokuAnswer[k][t]) {
										checkBox = 0;
										break;
									}
								}
								if(checkBox == 0) break;
							}
							if(checkBox == 0) {
								checkBox = 1;
								continue;
							}	
						}
						else if(j % 3 == 1) {
							for(int k = i - 1; k < i + 2; k++) {
								for(int t = j - 1; t < j + 2; t++) {
									if(val == sudokuAnswer[k][t]) {
										checkBox = 0;
										break;
									}
								}
								if(checkBox == 0) break;
							}
							if(checkBox == 0) {
								checkBox = 1;
								continue;
							}	
						}
						else {
							for(int k = i - 1; k < i + 2; k++) {
								for(int t = j - 2; t < j + 1; t++) {
									if(val == sudokuAnswer[k][t]) {
										checkBox = 0;
										break;
									}
								}
								if(checkBox == 0) break;
							}
							if(checkBox == 0) {
								checkBox = 1;
								continue;
							}	
						}
					}//else if end
					else { 
						if(j % 3 == 0) {
							for(int k = i - 2; k < i + 1; k++) {
								for(int t = j; t < j + 3; t++) {
									if(val == sudokuAnswer[k][t]) {
										checkBox = 0;
										break;
									}
								}
								if(checkBox == 0) break;
							}
							if(checkBox == 0) {
								checkBox = 1;
								continue;
							}	
						}
						else if(j % 3 == 1) {
							for(int k = i - 2; k < i + 1; k++) {
								for(int t = j - 1; t < j + 2; t++) {
									if(val == sudokuAnswer[k][t]) {
										checkBox = 0;
										break;
									}
								}
								if(checkBox == 0) break;
							}
							if(checkBox == 0) {
								checkBox = 1;
								continue;
							}	
						}
						else { 
							for(int k = i - 2; k < i + 1; k++) {
								for(int t = j - 2; t < j + 1; t++) {
									if(val == sudokuAnswer[k][t]) {
										checkBox = 0;
										break;
									}
								}
								if(checkBox == 0) break;
							}
							if(checkBox == 0) {
								checkBox = 1;
								continue;
							}	
						}
					}//else end
					
					sudokuAnswer[i][j] = val;
					check = 0;
				}//while end
				if(recountI==1) {
					j = j - 1;
					recountI = 0;
				}
			} //for j(width) end
		} // for i(height) end
		
		
	} //generateAnswer end
	
	
	void generatePuzzle() {
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				sudokuPuzzle[i][j] = sudokuAnswer[i][j];
			}
		}
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		int theNumber = rand.nextInt(11) + 30;
		int subNumber = 81 - theNumber; 

		int[][] checkVisit = new int[width][height];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				checkVisit[i][j] = 0;
			}
		}
		int count = 0;
		if(subNumber % 2 == 1)
		{
			sudokuPuzzle[4][4] = 0;
			count++;
		}
		checkVisit[4][4] = 1;
		
		while(count != subNumber) {
			int xNum = rand.nextInt(9);
			int yNum = rand.nextInt(9);
			int symmetryXnum = 8 - xNum;
			int symmetryYnum = 8 - yNum;
			if(checkVisit[xNum][yNum] == 1 || checkVisit[symmetryXnum][symmetryYnum] == 1)
				continue;
			int origin = sudokuPuzzle[xNum][yNum];
			int originSymmetry = sudokuPuzzle[symmetryXnum][symmetryYnum];
			sudokuPuzzle[xNum][yNum] = 0;
			sudokuPuzzle[symmetryXnum][symmetryYnum] = 0;

			int can = 0;
			int checkRow = 1, checkCol = 1, checkBox = 1;
			for(int n = 1; n < 10; n++) { 

				for(int k = 0; k < 9; k++) {
					if(n == sudokuPuzzle[k][yNum]) {
						checkRow = 0;
						break;
					}
				}
				if(checkRow == 0) { 
					checkRow = 1;
					continue;
				}
				
				for(int k = 0; k < 9; k++) {
					if(n == sudokuPuzzle[xNum][k]) {
						checkCol = 0;
						break;
					}
				}
				if(checkCol == 0) {
					checkCol = 1;
					continue;
				}

				if(xNum % 3 == 0) { 
					if(yNum % 3 == 0) {
						for(int k = xNum; k < xNum + 3; k++) {
							for(int t = yNum; t < yNum + 3; t++) {
								if(n == sudokuPuzzle[k][t]) {
									checkBox = 0;
									break;
								}
							}
							if(checkBox == 0) break;
						}
						if(checkBox == 0) {
							checkBox = 1;
							continue;
						}
					}//if if end
					else if(yNum % 3 == 1) {
						for(int k = xNum; k < xNum + 3; k++) {
							for(int t = yNum - 1; t < yNum + 2; t++) {
								if(n == sudokuPuzzle[k][t]) {
									checkBox = 0;
									break;
								}
							}
							if(checkBox == 0) break;
						}
						if(checkBox == 0) {
							checkBox = 1;
							continue;
						}
					}//if (else if) end
					else {
						for(int k = xNum; k < xNum + 3; k++) {
							for(int t = yNum - 2; t < yNum + 1; t++) {
								if(n == sudokuPuzzle[k][t]) {
									checkBox = 0;
									break;
								}
							}
							if(checkBox == 0) break;
						}
						if(checkBox == 0) {
							checkBox = 1;
							continue;
						}	
					}//if else end
				}//if end
				else if(xNum % 3 == 1) {
					if(yNum % 3 == 0) {
						for(int k = xNum - 1; k < xNum + 2; k++) {
							for(int t = yNum; t < yNum + 3; t++) {
								if(n == sudokuPuzzle[k][t]) {
									checkBox = 0;
									break;
								}
							}
							if(checkBox == 0) break;
						}
						if(checkBox == 0) {
							checkBox = 1;
							continue;
						}	
					}
					else if(yNum % 3 == 1) {
						for(int k = xNum - 1; k < xNum + 2; k++) {
							for(int t = yNum - 1; t < yNum + 2; t++) {
								if(n == sudokuPuzzle[k][t]) {
									checkBox = 0;
									break;
								}
							}
							if(checkBox == 0) break;
						}
						if(checkBox == 0) {
							checkBox = 1;
							continue;
						}	
					}
					else {
						for(int k = xNum - 1; k < xNum + 2; k++) {
							for(int t = yNum - 2; t < yNum + 1; t++) {
								if(n == sudokuPuzzle[k][t]) {
									checkBox = 0;
									break;
								}
							}
							if(checkBox == 0) break;
						}
						if(checkBox == 0) {
							checkBox = 1;
							continue;
						}	
					}
				}//else if end
				else {
					if(yNum % 3 == 0) {
						for(int k = xNum - 2; k < xNum + 1; k++) {
							for(int t = yNum; t < yNum + 3; t++) {
								if(n == sudokuPuzzle[k][t]) {
									checkBox = 0;
									break;
								}
							}
							if(checkBox == 0) break;
						}
						if(checkBox == 0) {
							checkBox = 1;
							continue;
						}	
					}
					else if(yNum % 3 == 1) {
						for(int k = xNum - 2; k < xNum + 1; k++) {
							for(int t = yNum - 1; t < yNum + 2; t++) {
								if(n == sudokuPuzzle[k][t]) {
									checkBox = 0;
									break;
								}
							}
							if(checkBox == 0) break;
						}
						if(checkBox == 0) {
							checkBox = 1;
							continue;
						}	
					}
					else {
						for(int k = xNum - 2; k < xNum + 1; k++) {
							for(int t = yNum - 2; t < yNum + 1; t++) {
								if(n == sudokuPuzzle[k][t]) {
									checkBox = 0;
									break;
								}
							}
							if(checkBox == 0) break;
						}
						if(checkBox == 0) {
							checkBox = 1;
							continue;
						}	
					}
				}//else end
				can++;
			}
			if(can > 3)
			{
				sudokuPuzzle[xNum][yNum] = origin;
				sudokuPuzzle[symmetryXnum][symmetryYnum] = originSymmetry;
			}
			else
				count = count + 2;
			can = 0;
			checkVisit[xNum][yNum] = 1;
		}//while end
		
	}//generatePuzzle end
	
	void printSudoku(int[][] sudoku) {
		for (int i = 0; i < height; i++) {
			if (i % 3 == 0)
				System.out.print("+-----------------------+\n");
			for (int j = 0; j < width; j++) {
				if (j % 3 == 0)
					System.out.print("| ");
				System.out.print(sudoku[i][j] + " ");
			}
			System.out.print("|\n");
		}
		System.out.print("+-----------------------+\n");
	}
	int[][] getAnswer() {
		return sudokuAnswer;
	}
	int[][] getPuzzle() {
		return sudokuPuzzle;
	}
	
	public static void main(String[] args) {
		Sudoku sudoku = new Sudoku();
		
		System.out.println(" # Sudoku Puzzle #");
		sudoku.printSudoku(sudoku.getPuzzle());
		System.out.println("\n # Sudoku Answer #");
		sudoku.printSudoku(sudoku.getAnswer());
	}
}
