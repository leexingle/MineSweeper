import java.util.*;

import javax.swing.ImageIcon;

public class BombSquare extends GameSquare
{
	private boolean thisSquareHasBomb = false;
	public static final int MINE_PROBABILITY = 10;
	private int numSurroundBomb;
	private boolean opened;

	public BombSquare(int x, int y, GameBoard board)
	{
		super(x, y, "images/blank.png", board);

		Random r = new Random();
		thisSquareHasBomb = (r.nextInt(MINE_PROBABILITY) == 0);
	}

	public boolean getThisSquareHasBomb(){
		return thisSquareHasBomb;
	}
	
	public int calculateSurroundBomb(){
		numSurroundBomb = 0;

		for (int i = this.yLocation -1; i<= this.yLocation + 1; i++){
			for (int j = this.xLocation -1; j<= this.xLocation + 1; j++){
				BombSquare neighborSquare = (BombSquare) board.getSquareAt(j,i);

				if(neighborSquare != null){
					if (neighborSquare.getThisSquareHasBomb()){
					numSurroundBomb++;
					}
				}
				
			
			}
		}
        return numSurroundBomb;
    }

	
	
	public void clicked(){
		opened = true;
		//if is a bomb
		if (thisSquareHasBomb){
			setImage("images/bomb.png");
		}
		//else call calculate bomb funct and display corresponding img
		else{
			numSurroundBomb = calculateSurroundBomb();
			switch(numSurroundBomb){
				case(0):
					setImage("images/0.png");
					// open surrounding square

					for (int i = this.yLocation -1; i<= this.yLocation + 1; i++){
						for (int j = this.xLocation -1; j<= this.xLocation + 1; j++){
							
							if (i == this.yLocation && j == this.xLocation) {
								continue;
							}
							
							BombSquare neighborSquare = (BombSquare) board.getSquareAt(j,i);
							
							if(neighborSquare != null && neighborSquare.opened != true){
								neighborSquare.clicked();
								
							}
						}
					}
					break;
				case(1):
					setImage("images/1.png");
					break;
				case(2):
					setImage("images/2.png");
					break;
				case(3):
					setImage("images/3.png");
					break;
				case(4):
					setImage("images/4.png");
					break;
				case(5):
					setImage("images/5.png");
					break;
				case(6):
					setImage("images/6.png");
					break;
				case(7):
					setImage("images/7.png");
					break;
				case(8):
					setImage("images/8.png");
					break;
				case(9):
					setImage("images/9.png");
					break;
			}
		}
	}
}
