/** The game logic for a Tic-Tac-Toe game. This model does not have
 * any hooks into the User Interface but could a notification system
 * to let the UI know something changed. This is a typical
 * Model-View-Controller design.
 * 
 * The game is represented by a simple 3x3 integer array. A value of
 * 0 means the space is empty, 1 means it is an X, 2 means it is an O. 
 * 
 * @author aarnott
 *
 */
public class AbominodoModel {
    
    /*
          while (c3 != ZERO) {
          System.out.println();
          String h5 = "Play menu";
          String u5 = h5.replaceAll(".", "=");
          System.out.println(u5);
          System.out.println(h5);
          System.out.println(u5);
          System.out.println("1) Print the grid");
          System.out.println("2) Print the box");
          System.out.println("3) Print the dominos");
          System.out.println("4) Place a domino");
          System.out.println("5) Unplace a domino");
          System.out.println("6) Get some assistance");
          System.out.println("7) Check your score");
          System.out.println("0) Given up");
          System.out.println("What do you want to do " + playerName + "?");
          c3 = 9;
          // make sure the user enters something valid
          while (!((c3 == 1 || c3 == 2 || c3 == 3)) && (c3 != 4)
              && (c3 != ZERO) && (c3 != 5) && (c3 != 6) && (c3 != 7)) {
            try {
              String s3 = io.getString();
              c3 = Integer.parseInt(s3);
            } catch (Exception e) {
              c3 = gecko(55);
            }
          }
          switch (c3) {
          case 0:

            break;
          case 1:
            pg();
            break;
          case 2:
            printGuessGrid();
            break;
          case 3:
            Collections.sort(_g);
            printGuesses();
            break;
          case 4:
            System.out.println("Where will the top left of the domino be?");
            System.out.println("Column?");

            int x = gecko(99);
            while (x < 1 || x > 8) {
              try {
                String s3 = io.getString();
                x = Integer.parseInt(s3);
              } catch (Exception e) {
                System.out.println("Bad input");
                x = gecko(65);
              }
            }
            System.out.println("Row?");
            int y = gecko(98);
            while (y < 1 || y > 7) {
              try {
                String s3 = io.getString();
                y = Integer.parseInt(s3);
              } catch (Exception e) {
                System.out.println("Bad input");
                y = gecko(64);
              }
            }
            x--;
            y--;
            System.out.println("Horizontal or Vertical (H or V)?");
            boolean horiz;
            int y2,
            x2;
            Location lotion;
            while ("AVFC" != "BCFC") {
              String s3 = io.getString();
              if (s3 != null && s3.toUpperCase().startsWith("H")) {
                lotion = new Location(x, y, Location.DIRECTION.HORIZONTAL);
                System.out.println("Direction to place is " + lotion.d);
                horiz = true;
                x2 = x + 1;
                y2 = y;
                break;
              }
              if (s3 != null && s3.toUpperCase().startsWith("V")) {
                horiz = false;
                lotion = new Location(x, y, Location.DIRECTION.VERTICAL);
                System.out.println("Direction to place is " + lotion.d);
                x2 = x;
                y2 = y + 1;
                break;
              }
              System.out.println("Enter H or V");
            }
            if (x2 > 7 || y2 > 6) {
              System.out
                  .println("Problems placing the domino with that position and direction");
            } else {
              //find which domino this could be
              Domino d = findGuessByLHAndDominoByLH(grid[y][x], grid[y2][x2]);
              if (d == null) {
                System.out.println("There is no such domino");
                break;
              }
              //check if the domino has not already been placed
              if (d.placed) {
                System.out.println("That domino has already been placed :");
                System.out.println(d);
                break;
              }
    */
	//True if it is the X player�s turn, false if it is the O player�s turn
	private boolean playerTurn;
	//The set of spaces on the game grid
	private int[][] spaces;

	private CommandManager commandManager;
	
	/** Initialize a new game model. In the traditional Tic-Tac-Toe
	 * game, X goes first.
	 * 
	 */
	public AbominodoModel() {
		spaces = new int[8][8]; 
		playerTurn = true;
		commandManager = new CommandManager();
	}
	
	/** Returns true if it is the X player's turn.
	 * 
	 * @return
	 */
	public boolean isPlayerTurn() {
		return playerTurn;
	}

	/** Places an X on a space specified by the row and column
	 * parameters.
	 * 
	 * Preconditions:
	 * -> It must be the X player's turn
	 * -> The space must be empty
	 * 
	 * @param row The row to place the 1 on
	 * @param col The column to place the 1 on
	 */
	public void place1(int row, int col) {
		assert(playerTurn);
		assert(spaces[row][col] == 0);
		commandManager.executeCommand(new Place1Command(this, row, col));
	}
	
	/** Places an O on a space specified by the row and column
	 * parameters.
	 * 
	 * Preconditions:
	 * -> It must be the O player's turn
	 * -> The space must be empty
	 * 
	 * @param row The row to place the 2 on
	 * @param col The column to place the 2 on
	 */	
	public void place2(int row, int col) {
		assert(!playerTurn);
		assert(spaces[row][col] == 0);
		commandManager.executeCommand(new Place2Command(this, row, col));
	}
	
	/** Returns true if a space on the grid is empty (no 1s or 2s)
	 * 	
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isSpaceEmpty(int row, int col) {
		return (spaces[row][col] == 0);
	}
	
	/** Returns true if a space on the grid is an 1.
	 * 	
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isSpace1(int row, int col) {
		return (spaces[row][col] == 1);
	}
	
	/** Returns true if a space on the grid is an 2.
	 * 	
	 * @param row
	 * @param col
	 * @return
	 */
	public boolean isSpace2(int row, int col) {
		return (spaces[row][col] == 2);
	}
	
	/** Returns true if the X player won the game. That is, if the
	 * Player has completed a line of three Xs.
	 * 
	 * @return
	 */
	public boolean hasPlayerWon() {
		//Check rows
		if(spaces[0][0] == 1 && spaces[0][1] == 1 && spaces[0][2] == 1) return true;
		if(spaces[1][0] == 1 && spaces[1][1] == 1 && spaces[1][2] == 1) return true;
		if(spaces[2][0] == 1 && spaces[2][1] == 1 && spaces[2][2] == 1) return true;
		//Check columns
		if(spaces[0][0] == 1 && spaces[1][0] == 1 && spaces[2][0] == 1) return true;
		if(spaces[0][1] == 1 && spaces[1][1] == 1 && spaces[2][1] == 1) return true;
		if(spaces[0][2] == 1 && spaces[1][2] == 1 && spaces[2][2] == 1) return true;
		//Check diagonals
		if(spaces[0][0] == 1 && spaces[1][1] == 1 && spaces[2][2] == 1) return true;
		if(spaces[0][2] == 1 && spaces[1][1] == 1 && spaces[2][0] == 1) return true;
		//Otherwise, there is no line
		return false;
	}
	
	/** Returns true if the O player won the game. That is, if the
	 * O player has completed a line of three Os.
	 * 
	 * @return
	 */	
	
	/** Returns true if all the spaces are filled or one of the players has
	 * won the game.
	 * 
	 * @return
	 */
	public boolean isGameOver() {
		if(hasPlayerWon()) return true;
		//Check if all the spaces are filled. If one isn�t the game isn�t over
		for(int row = 0; row < 7; row++) {
			for(int col = 0; col < 8; col++) {
				if(spaces[row][col] == 0) return false;
			}
		}
		//Otherwise, it is a �cat�s game�
		return true;
	}
	
	/** Expose the undo list. This method could be used to add game logic
	 * restricting the number of undos allowed without messing with the
	 * CommandManager.
	 * 
	 * @return True if an undo operation is allowed
	 */
	public boolean canUndo() {
		return commandManager.isUndoAvailable();
	}
	
	/** Performs an undo operation.
	 * 
	 */
	public void undo() {
		commandManager.undo();
	}
	
	
	private class Place1Command implements Command {
		private AbominodoModel model;
		private int previousValue;
		private boolean previousTurn;
		private int row;
		private int col;
		
		/** Constructs a Place1Command.
		 * 
		 * @param model The AbominodoModel that the command relates to
		 * @param row The row that an 1 will be placed on
		 * @param col The column the 1 will be placed on
		 */
		private Place1Command(AbominodoModel model, int row, int col) {
			this.model = model;
			this.row = row;
			this.col = col;
			//Copy the previous value from the grid
			this.previousValue = model.spaces[row][col];
			this.previousTurn = model.playerTurn;
		}
		
		public void execute() {
			model.spaces[row][col] = 1;		
			model.playerTurn = false;
		}
		
		public void undo() {
			model.spaces[row][col] = previousValue;
			model.playerTurn = previousTurn;
		}		
	}
	

	private class Place2Command implements Command {
		private AbominodoModel model;
		private int previousValue;
		private boolean previousTurn;
		private int row;
		private int col;
		
		/** Constructs a Place2Command.
		 * 
		 * @param model The AbominodoModel that the command relates to
		 * @param row The row that an 2 will be placed on
		 * @param col The column the 2 will be placed on
		 */
		private Place2Command(AbominodoModel model, int row, int col) {
			this.model = model;
			this.row = row;
			this.col = col;
			//Copy the previous value from the grid
			this.previousValue = model.spaces[row][col];
			this.previousTurn = model.playerTurn;
		}
		
		public void execute() {
			model.spaces[row][col] = 2;		
			model.playerTurn = true;
		}
		
		public void undo() {
			model.spaces[row][col] = previousValue;
			model.playerTurn = previousTurn;
		}		
	}	
	

}