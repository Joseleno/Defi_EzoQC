package defi.ezoqc.joseleno.domain.model.operateur;

import java.util.Objects;

import defi.ezoqc.joseleno.domain.interfaces.IOperation;

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
		
		return Integer.compare(this.ordre, o.ordre);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) 
			return true;
		if (!(o instanceof Operateur))
			return false;
		Operateur operateur = (Operateur) o;
		return symbole == operateur.symbole;
	}

	@Override
	public int hashCode() {
		return Objects.hash(symbole);
	}

	@Override
	public String toString() {
		return ""+symbole;
	}


}
