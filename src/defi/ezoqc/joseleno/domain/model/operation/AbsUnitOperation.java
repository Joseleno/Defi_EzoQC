package defi.ezoqc.joseleno.domain.model.operation;

import defi.ezoqc.joseleno.domain.interfaces.IUnitOperation;

public abstract class AbsUnitOperation implements IUnitOperation {

	@Override
	public int calculer(int valeur) {
		return (int) this.calculer((double) valeur);
	}
}
