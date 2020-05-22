package defi.ezoqc.joseleno.operations.unitaire;

import defi.ezoqc.joseleno.infrastructure.IUnitOperation;

public abstract class AbsUnitOperation implements IUnitOperation{

	@Override
    public int calculer(int valeur) {
        return (int)this.calculer((double) valeur);
    }
}
