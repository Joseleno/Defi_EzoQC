package defi.ezoqc.joseleno.infrastructure;

public interface IBinaryOperation extends IOperation {

	int calculer(int valeur1, int valeur2);
    double calculer(int valeur1, double valeur2);
    double calculer(double valeur1, int valeur2);
    double calculer(double valeur1, double valeur2);

}
