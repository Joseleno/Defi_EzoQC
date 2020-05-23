package defi.ezoqc.joseleno.domain.model.operation.unitaire;

import defi.ezoqc.joseleno.domain.model.operation.AbsUnitOperation;

public class Sqrt extends AbsUnitOperation {

	@Override
	public double calculer(double valeur) {

		return Math.sqrt(valeur);
	}

}
