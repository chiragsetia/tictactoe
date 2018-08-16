package tic_tac_toe;

import java.util.Scanner;

public class ticTacToe {
Player P1,P2;
Board board;
private Scanner scanner;
	public ticTacToe()
	{
		play();
	}
private void play() {
	P1=data(1);
	P2=data(2);
	Scanner input=new Scanner(System.in);
	while(P1.getName().equals(P2.getName())||P1.getSymbol()==P2.getSymbol())
	{
		if(P1.getName().equals(P2.getName()))
		{
			
			System.out.println("Name already excited"+"\n"+"Enter new name for player 2");
			String name=input.nextLine();
			P2.setName(name);
		}
		else
		{
			System.out.println("Symbol already excited"+"\n"+"Enter new Symbol for player 2");
			char symbol=input.next().charAt(0);
			P2.setSymbol(symbol);
		}
			
	}
	System.out.println("Enter the size of the board and must be greater or equal than 3");
	
	int boardSize=input.nextInt();
	while(boardSize<3)
	{
		System.out.println("Give a size equal to or greater than 3");
		boardSize=input.nextInt();
	}
	board=new Board(boardSize,P1.getSymbol(),P2.getSymbol());
	int status=Board.incomplete;
	boolean player1trun=true;
	while(status==Board.incomplete||status==Board.alreadyOccupied||status==Board.invalid)
	{
		if(player1trun)
		{
			System.out.println("Enter the coordinates for Player: "+P1.getName());
			System.out.println("Enter the row");
			int x=input.nextInt();
			System.out.println("Enter the column");
			int y=input.nextInt();
			status=board.status(x, y, P1.getSymbol());
			if(status==Board.invalid)
			{
				System.out.println("Invalid coordinate enter again");
			}
			else if(status==Board.alreadyOccupied)
			{
				System.out.println("Coordinated already occupied"+ '\n' +"Enter different coordinantes");
			}
			else
				{
					player1trun=false;
					board.print();
				}
		}
		else
		{
			System.out.println("Enter the coordinates for Player: "+P2.getName());
			System.out.println("Enter the row");
			int x=input.nextInt();
			System.out.println("Enter the column");
			int y=input.nextInt();
			status=board.status(x, y, P2.getSymbol());
			if(status==Board.invalid)
			{
				System.out.println("Invalid coordinate enter again");
			}
			else if(status==Board.alreadyOccupied)
			{
				System.out.println("Coordinated already occupied"+ '\n' +"Enter different coordinantes");
			}
			else
				{
					player1trun=true;
					board.print();
				}
		}
		
	}
	if(status==Board.draw)
		System.out.println("This match is Draw");
	else if(status==Board.aWin)
	{
		System.out.println("Player "+P1.getName()+" wins");
	}
	else
		System.out.println("Player "+P2.getName()+" wins");
	input.close();
		
	}
private Player data(int n)
{
	System.out.println("Enter the name of player "+n);
	scanner = new Scanner(System.in);
	String name=scanner.nextLine();
	System.out.println("Enter the Symbol of player "+n);
	char Symbol=scanner.next().charAt(0);
	//input.close();
	return(new Player(name,Symbol));
}
}
