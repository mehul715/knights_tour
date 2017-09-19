
import java.io.EOFException;
import java.*;
class Main {
	private final static int SIZE = 8;
	private final static int solve[][] = new int[8][8];
	private final static int xPos[] = {2, 1, -1, -2, -2, -1, 1, 2};
	private final static int yPos[] = {-1, -2, -2, -1, 1, 2, 2, 1};
	public static void main(String args[]) throws EOFException
	{
		for (int x = 0; x < SIZE; x++)
			for (int y = 0; y < SIZE; y++)
				solve[x][y] = -1;
		solve[0][0] = 0;

		if (possibleMove( solve, xPos, yPos, 0,0,1))
			{
				for (int x = 0; x < SIZE; x++)
				{
					for (int y = 0; y < SIZE; y++)
						System.out.print(solve[x][y] + "\t");
					System.out.println();
				}
		
			}
	
	}//END OF MAIN
	static boolean possibleMove(int solve[][], int xPos[],int yPos[],int x, int y, int totalS)
	{
		int k, nextX, nextY;
		if (totalS == SIZE * SIZE)
			return true;
		for (k = 0; k < SIZE; k++)
		{
			nextX = x + xPos[k];nextY = y + yPos[k];
			if (nextX >= 0 && nextY >= 0 && nextX < SIZE  && nextY < SIZE && solve[nextX][nextY] == -1)
			{
				solve[nextX][nextY] = totalS;
				if (possibleMove(solve, xPos, yPos,nextX, nextY, totalS+1))
					return true;
				else
					solve[nextX][nextY] = -1;
			}
		}

		return false;
	}
	
}//END OF CLASS