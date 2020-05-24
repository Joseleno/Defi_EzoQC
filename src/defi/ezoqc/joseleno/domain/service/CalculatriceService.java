package defi.ezoqc.joseleno.domain.service;

import defi.ezoqc.joseleno.aplication.util.FiltreAddition;
import defi.ezoqc.joseleno.aplication.util.FiltreMap;
import defi.ezoqc.joseleno.domain.interfaces.ICalculatriceService;
import defi.ezoqc.joseleno.domain.model.expression.ExpressionArithmetique;
import defi.ezoqc.joseleno.domain.model.operateur.Operateur;
import defi.ezoqc.joseleno.domain.model.operateur.OperateurMap;
import defi.ezoqc.joseleno.domain.model.operation.binaire.Addition;

public class CalculatriceService implements ICalculatriceService{

	private ExpressionArithmetique ea;
	
	public CalculatriceService() {
		OperateurMap opMap = new OperateurMap();
		opMap.register(new Operateur('+', 0, new Addition()));
		
		FiltreMap mapFiltre = new FiltreMap();
		mapFiltre.register(new FiltreAddition());
	}
	
	public String calculer(String expression) {
        try {
            return expression;
        } catch (ArithmeticException ae) {
            return ae.getMessage();
        }
	}
}
