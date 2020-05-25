package defi.ezoqc.joseleno.domain.service;

import defi.ezoqc.joseleno.aplication.util.FiltreAddition;
import defi.ezoqc.joseleno.aplication.util.FiltreMap;
import defi.ezoqc.joseleno.aplication.util.FiltreSoustration;
import defi.ezoqc.joseleno.domain.model.expression.ExpressionArithmetique;
import defi.ezoqc.joseleno.domain.model.operateur.Operateur;
import defi.ezoqc.joseleno.domain.model.operateur.OperateurMap;
import defi.ezoqc.joseleno.domain.model.operation.binaire.Addition;
import defi.ezoqc.joseleno.domain.model.operation.binaire.Division;
import defi.ezoqc.joseleno.domain.model.operation.binaire.Exponentiation;
import defi.ezoqc.joseleno.domain.model.operation.binaire.Multiplication;
import defi.ezoqc.joseleno.domain.model.operation.binaire.Soustraction;
import defi.ezoqc.joseleno.domain.model.operation.unitaire.Sqrt;

public class CalculatriceService {

	private ExpressionArithmetique expressionArithmetique;

	public CalculatriceService() {
		OperateurMap operateurMap = new OperateurMap();
		operateurMap.register(new Operateur('+', 0, new Addition()));
		operateurMap.register(new Operateur('-', 0, new Soustraction()));
		operateurMap.register(new Operateur('*', 1, new Multiplication()));
		operateurMap.register(new Operateur('/', 1, new Division()));
		operateurMap.register(new Operateur('^', 1, new Exponentiation()));
		operateurMap.register(new Operateur('S', 1, new Sqrt()));

		FiltreMap mapFiltre = new FiltreMap();
		mapFiltre.register(new FiltreAddition());
		mapFiltre.register(new FiltreSoustration());

		this.expressionArithmetique = new ExpressionArithmetique(operateurMap, mapFiltre);
	}

	public String calculer(String expression) {
		try {
			return expressionArithmetique.caluler(expression);
		} catch (ArithmeticException ae) {
			return ae.getMessage();
		}
	}
}
