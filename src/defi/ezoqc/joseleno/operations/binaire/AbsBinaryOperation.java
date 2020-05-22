package defi.ezoqc.joseleno.operations.binaire;

import defi.ezoqc.joseleno.infrastructure.IBinaryOperation;

public abstract class AbsBinaryOperation implements IBinaryOperation {
	
	public int calculer(int valeur1, int valeur2) {
        return (int) this.calculer((double) valeur1, (double) valeur2);
    }

    public double calculer(int valeur1, double valeur2) {
        return this.calculer((double) valeur1, valeur2);
    }

    public double calculer(double valeur1, int valeur2) {
        return this.calculer(valeur1, (double) valeur2);
    }

}
