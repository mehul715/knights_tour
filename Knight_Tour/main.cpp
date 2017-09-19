      #include <iostream>
    #include <iomanip>
    using namespace std;
    int solve[8][8];
    const int size=8;
    bool possibleMove(int solve[][8], int xPos[],int yPos[],int x, int y, int totalS);
    int xPos[] = {2, 1, -1, -2, -2, -1, 1, 2};
    int yPos[] = {-1, -2, -2, -1, 1, 2, 2, 1};
    int main()
    {

    for (int x = 0; x < size; ++x)
    {
        for (int y = 0; y < size; ++y)
            solve[x][y] = -1;
    }
    solve[0][0]=0;
        if (possibleMove( solve, xPos, yPos, 0,0,1))
		{

			for (int x = 0; x < size; x++)
			{
				for (int y = 0; y < size; y++)
					cout<<setw(5)<<solve[x][y];
                    cout<<endl;
			}
		}
    return 0;

    }//END OF MAIN

    bool possibleMove( int solve[][8], int xPos[],int yPos[],int x, int y, int totalS)
    {
        int k, nextX, nextY;
    if (totalS == size * size)
        return true; // solved
    for (k = 0; k < size; k++)
    {
			nextX = x + xPos[k];nextY = y + yPos[k];
			if (nextX >= 0 && nextY >= 0 && nextX < size && nextY < size && solve[nextX][nextY] == -1)
			{
				solve[nextX][nextY] = totalS;
				if (possibleMove(solve, xPos, yPos,nextX, nextY, totalS+1))
					return true;
				else
					solve[nextX][nextY] = -1;
			}
    }
    return false;
    }//END OF POSSIBLEMOVE
