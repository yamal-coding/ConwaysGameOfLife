package com.conway.entities;

public class Cell {
	public enum State {
		DEAD(" "), ALIVE("\u25A1");
		
		private String symbol;
		
		private State(String symbol) {
			this.symbol = symbol;
		}
		
		@Override
		public String toString() {
			return symbol;
		}
	}
	
	private State state;
	private boolean changeInNextTurn;
	
	public Cell() {
		this.state = State.DEAD;
		this.changeInNextTurn = false;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void changeState(){
		changeInNextTurn = false;
		if (state == State.ALIVE)
			state = State.DEAD;
		else
			state = State.ALIVE;
	}
	
	public boolean isAlive() {
		return state == State.ALIVE ? true : false;
	}
	
	public boolean mustChangeInNextTurn() {
		return changeInNextTurn;
	}
	
	public void setChangeInNextTurn(boolean change) {
		this.changeInNextTurn = change;
	}
	
	@Override
	public String toString() {
		return state.toString();
	}
}
