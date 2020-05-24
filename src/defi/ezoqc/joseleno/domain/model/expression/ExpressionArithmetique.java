package defi.ezoqc.joseleno.domain.model.expression;

import java.util.ArrayList;
import java.util.List;

import defi.ezoqc.joseleno.aplication.util.FiltreMap;
import defi.ezoqc.joseleno.domain.interfaces.IBinaryOperation;
import defi.ezoqc.joseleno.domain.model.operateur.Operateur;
import defi.ezoqc.joseleno.domain.model.operateur.OperateurMap;

public class ExpressionArithmetique {

	private OperateurMap operateurs;
	private FiltreMap filtres;

	public ExpressionArithmetique(OperateurMap operateurs, FiltreMap filtres) {

		this.operateurs = operateurs;
		this.filtres = filtres;

	}

	private String chercherValeurNumerique(String expression, int position) {
		int debut = position;

		while (position < expression.length()
				&& ((expression.charAt(position) == '-') || (Character.isDigit(expression.charAt(position))))) {
			position++;
		}
		return expression.substring(debut, position);

	}

	private Object changerValeurNumerique(String valeur) {
		Object aux = null;

		if (valeur.contains(".")) {
			aux = Double.parseDouble(valeur);
		} else {
			Integer.parseInt(valeur);
		}

		return aux;
	}

	private String chercherOperateur(String expression, int position) {
		int debut = position;

		if (position < expression.length()) {
			if (operateurs.get(expression.charAt(position)).getOperation() instanceof IBinaryOperation) {
				position++;
			} else {
				while ((position < expression.length() && (Character.isAlphabetic(expression.charAt(position))))) {
					position++;
				}
			}

		}

		return expression.substring(debut, position);
	}

	private Operateur getOperateur(String strOperateur) {
		return operateurs.get(strOperateur.charAt(0));
	}

	private List<Object> getInfixeNotationList(String expression) {

		List<Object> tokens = new ArrayList<Object>();
		int i = 0;
		Object token;

		while (i < expression.length()) {
			char c = expression.charAt(i);
			if (c != ' ') {
				if (Character.isDigit(c)) {
					String strValeur = chercherValeurNumerique(expression, i);
					if ((tokens.size() >= 1) && (tokens.get(tokens.size() - 1) instanceof Operateur)) {
						Operateur lastOperateur = (Operateur) tokens.get(tokens.size() - 1);
						if ((lastOperateur.getSymbole() == '+') || (lastOperateur.getSymbole() == '-')) {
							if ((tokens.size() == 1)
									|| ((tokens.size() >= 2) && (tokens.get(tokens.size() - 2) instanceof Operateur))) {
								strValeur = lastOperateur.getSymbole() + strValeur;
								tokens.remove(tokens.size() - 1);
							}
						}
					}

					token = changerValeurNumerique(strValeur);
					i = i + strValeur.length();

				} else if ((c == '(') || (c == ')')) {
					token = String.valueOf(c);
					i++;
				} else {
					String strOperateur = chercherOperateur(expression, i);
					token = this.getOperateur(strOperateur);
					i = i + strOperateur.length();
				}
				tokens.add(token);

			} else {
				i++;
			}
		}

		return tokens;
	}

}
