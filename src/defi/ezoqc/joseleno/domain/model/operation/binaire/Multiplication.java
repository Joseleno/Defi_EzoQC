package defi.ezoqc.joseleno.domain.model.operation.binaire;

import defi.ezoqc.joseleno.domain.model.operation.AbsBinaryOperation;

public class Multiplication extends AbsBinaryOperation {

	@Override
	public double calculer(double valeur1, double valeur2) {

		return valeur1 * valeur2;
	}

}
