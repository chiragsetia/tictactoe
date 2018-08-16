package tic_tac_toe;

public class Player {
	private String name;
	private char symbol;
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	Player (String name,char symbol)
	{
		this.setName(name);
		this.setSymbol(symbol);
	}
	

}
