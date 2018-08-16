package tic_tac_toe;

public class Board {
private int BoardSize;
private char Symbol1;
//private char Symbol2;
private char boardArray[][];
private int elements;
public static final int aWin=1;
public static final int bWin=2;
public static final int draw=3;
public static final int incomplete=4;
public static final int invalid=5;
public static final int alreadyOccupied=6;
	 Board(int BoardSize,char Symbol1,char Symbol2)
	{
		this.BoardSize=BoardSize;
		boardArray=new char[BoardSize][BoardSize];
		for(int i=0;i<BoardSize;i++)
		{
			for(int j=0;j<BoardSize;j++)
				boardArray[i][j]=' ';
		}
		this.Symbol1=Symbol1;
		//this.Symbol2=Symbol2;
	}
	public int status(int x,int y,char Symbol)
	{
		if(x>=BoardSize||x<0||y<0||y>=BoardSize)
			return invalid;
		if(boardArray[x][y]!=' ')
			return alreadyOccupied;
		boardArray[x][y]=Symbol;
		elements++;
		int count=0;
		
		if(elements<2*BoardSize-1)
			return incomplete;
		for(int i=0;i<BoardSize;i++)
		{
			if(boardArray[x][i]==Symbol)
				count++;
			else 
				break;
		}
		if(count==BoardSize)
			return Symbol==Symbol1?aWin:bWin;
		count =0;
		for(int i=0;i<BoardSize;i++)
		{
			if(boardArray[i][y]==Symbol)
				count++;
			else 
				break;
		}
		if(count==BoardSize)
			return Symbol==Symbol1?aWin:bWin;
		count=0;
		int countX=0;
		for(int i=0;i<BoardSize;i++)
		{
			if(boardArray[i][i]==Symbol)
				count++;
			if(boardArray[i][BoardSize-i-1]==Symbol)
				countX++;
		}
		if(count==BoardSize||countX==BoardSize)
			return Symbol==Symbol1?aWin:bWin;
		if(elements==BoardSize*BoardSize)
			return draw;
		
		return incomplete;
		
		
	}
	public void print() {
		for(int i=0;i<BoardSize*5;i++)
		{
			System.out.print("-");
		}
		System.out.println();
		for(int i=0;i<BoardSize;i++)
		{
			for(int j=0;j<BoardSize;j++)
			{
				System.out.print("| "+boardArray[i][j]+" |");
			}
			System.out.println();
		}
		for(int i=0;i<BoardSize*5;i++)
		{
			System.out.print("-");
		}
		System.out.println();
	}
}
