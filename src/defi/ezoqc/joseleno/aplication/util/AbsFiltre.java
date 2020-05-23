package defi.ezoqc.joseleno.aplication.util;

public abstract class AbsFiltre implements IFiltre{

	  private String expression;
	   private String resultat;

	    protected AbsFiltre(String expression, String resultat) {
	        this.expression = expression;
	        this.resultat = resultat;
	    }

	   

		@Override
		public String filtre(String expression) {
			
			String result = null;
			
			if(this.expression.equals(expression)) {
				result = this.resultat;
			}
			return result;
		}

		@Override
		public String getExpression() {
			
			return expression;
		}

		@Override
		public String getResultat() {
			
			return resultat;
		}

}
