package defi.ezoqc.joseleno.domain.model.expression;

import defi.ezoqc.joseleno.aplication.util.FiltreMap;
import defi.ezoqc.joseleno.domain.model.operateur.OperateurMap;

public class ExpressionArithmetique {

	private OperateurMap operateurs;
	private FiltreMap filtres;
	
	
	public ExpressionArithmetique(OperateurMap operateurs, FiltreMap filtres) {
		
		this.operateurs = operateurs;
		this.filtres = filtres;
		
	}
	
	private String extraireValeurNumerique(String expression, int position) {
		int debut = position;
		
		while(position < expression.length() && 
				((expression.charAt(position) == '-') || (Character.isDigit(expression.charAt(position))))){
			position++;
		}
		return expression.substring(debut, position);
		
	}

	
}
