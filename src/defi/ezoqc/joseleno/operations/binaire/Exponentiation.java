package defi.ezoqc.joseleno.operations.binaire;

public class Exponentiation extends AbsBinaryOperation {

	@Override
	public double calculer(double valeur1, double valeur2) {
		
		return Math.pow(valeur1, valeur2);
	}

}
