package defi.ezoqc.joseleno.operations.binaire;

public class Division extends AbsBinaryOperation {

	@Override
	public double calculer(double valeur1, double valeur2) {
		if(valeur2 == 0) {
			throw new ArithmeticException("Erreur*");
		}
		return valeur1/valeur2;
	}

}
