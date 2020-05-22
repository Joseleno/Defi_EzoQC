package defi.ezoqc.joseleno.utils;

import defi.ezoqc.joseleno.infrastructure.IOperation;

public class Operateur implements Comparable<Operateur>{
	
	private char symbole;
	private int ordre;
	private IOperation operation;
	
	
	public Operateur(char symbole, int ordre, IOperation operation) {
		this.symbole = symbole;
		this.ordre = ordre;
		this.operation = operation;
	}
	
	public char getSymbole() {
		return symbole;
	}

	public IOperation getOperation() {
		return operation;
	}

	public int getOrdre() {
		return ordre;
	}

	@Override
	public int compareTo(Operateur o) {
		// TODO Auto-generated method stub
		return 0;
	}

	





}
