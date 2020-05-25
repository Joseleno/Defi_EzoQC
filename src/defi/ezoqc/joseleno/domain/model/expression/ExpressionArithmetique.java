package defi.ezoqc.joseleno.domain.model.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import defi.ezoqc.joseleno.aplication.util.FiltreMap;
import defi.ezoqc.joseleno.aplication.util.IFiltre;
import defi.ezoqc.joseleno.domain.interfaces.IBinaryOperation;
import defi.ezoqc.joseleno.domain.interfaces.IUnitOperation;
import defi.ezoqc.joseleno.domain.model.operateur.Operateur;
import defi.ezoqc.joseleno.domain.model.operateur.OperateurMap;

public class ExpressionArithmetique {

	private OperateurMap operateurs;
	private FiltreMap filtres;

	public ExpressionArithmetique(OperateurMap operateurs, FiltreMap filtres) {

		this.operateurs = operateurs;
		this.filtres = filtres;

	}

	private String trouverValeurNumerique(String expressition, int position) {
		int inicio = position;
		while (position < expressition.length()
				&& ((expressition.charAt(position) == '.') || (Character.isDigit(expressition.charAt(position)))))
			position++;
		return expressition.substring(inicio, position);
	}

	private Object changerValeurNumerique(String strValor) {
		if (strValor.contains("."))
			return Double.parseDouble(strValor);
		else
			return Integer.parseInt(strValor);
	}

	private String trouverOperateur(String expressition, int position) {
		int inicio = position;

		if (position < expressition.length()) {
			if (operateurs.get(expressition.charAt(position)).getOperation() instanceof IBinaryOperation) {
				position++;
			} else {
				while ((position < expressition.length()) && (Character.isAlphabetic(expressition.charAt(position))))
					position++;
			}
		}
		return expressition.substring(inicio, position);
	}

	private Operateur getOperateur(String strOperateur) {
		return operateurs.get(strOperateur.charAt(0));
	}


	private List<Object> getInFixa(String expressition) {
		List<Object> tokens = new ArrayList<Object>();
		int i = 0;
		Object token;
		while (i < expressition.length()) {
			char c = expressition.charAt(i);
			if (c != ' ') {
				if (Character.isDigit(c)) {
					String strValor = trouverValeurNumerique(expressition, i);
					if ((tokens.size() >= 1) && (tokens.get(tokens.size() - 1) instanceof Operateur)) {
						Operateur ultOperateur = (Operateur) tokens.get(tokens.size() - 1);
						if ((ultOperateur.getSymbole() == '+') || (ultOperateur.getSymbole() == '-')) {
							if ((tokens.size() == 1)
									|| ((tokens.size() >= 2) && (tokens.get(tokens.size() - 2) instanceof Operateur))) {
								strValor = ultOperateur.getSymbole() + strValor;
								tokens.remove(tokens.size() - 1);
							}
						}
					}
					token = changerValeurNumerique(strValor);
					i = i + strValor.length();
				} else if ((c == '(') || (c == ')')) {
					token = String.valueOf(c);
					i++;
				} else {
					String strOperateur = trouverOperateur(expressition, i);
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

	private List<Object> getPosFixa(String expressition) {
		Stack<Object> pilhaoperateurs = new Stack<Object>();
		List<Object> posFixa = new ArrayList<Object>();

		for (Object token : this.getInFixa(expressition)) {
			if ((token instanceof Operateur)) {
				Operateur Operateur = (Operateur) token;
				while ((!pilhaoperateurs.empty()) && (!pilhaoperateurs.peek().equals("("))
						&& (Operateur.compareTo((Operateur) pilhaoperateurs.peek()) <= 0)) {
					posFixa.add(pilhaoperateurs.pop());
				}
				pilhaoperateurs.add(Operateur);
			} else if (token.equals("(")) {
				pilhaoperateurs.push(token);
			} else if (token.equals(")")) {
				while (!pilhaoperateurs.peek().equals("(")) {
					posFixa.add(pilhaoperateurs.pop());
				}
				pilhaoperateurs.pop();
			} else {
				posFixa.add(token);
			}
		}
		while (!pilhaoperateurs.empty()) {
			posFixa.add(pilhaoperateurs.pop());
		}
		return posFixa;
	}


	public String caluler(String expressition) throws ArithmeticException {
		IFiltre filtre = filtres.get(expressition);
		if (filtre != null) {
			return filtre.getResultat();
		} else {
			Stack<Object> posfixa = new Stack<Object>();
			for (Object token : this.getPosFixa(expressition)) {
				if ((token instanceof Integer) || (token instanceof Double)) {
					posfixa.push(token);
				} else if (((Operateur) token).getOperation() instanceof IUnitOperation) {
					Object valor = posfixa.pop();
					IUnitOperation opUnaria = (IUnitOperation) ((Operateur) token).getOperation();
					if (valor instanceof Integer) {
						posfixa.push(opUnaria.calculer((Integer) valor));
					} else {
						posfixa.push(opUnaria.calculer((Double) valor));
					}
				} else if (((Operateur) token).getOperation() instanceof IBinaryOperation) {
					Object valor2 = posfixa.pop();
					Object valor1 = posfixa.pop();
					IBinaryOperation opBinaria = (IBinaryOperation) ((Operateur) token).getOperation();

					if ((valor1 instanceof Integer) && (valor2 instanceof Integer)) {
						posfixa.push(opBinaria.calculer((Integer) valor1, (Integer) valor2));
					} else if ((valor1 instanceof Double) && (valor2 instanceof Double))
						posfixa.push(opBinaria.calculer((Double) valor1, (Double) valor2));
					else if ((valor1 instanceof Integer) && (valor2 instanceof Double))
						posfixa.push(opBinaria.calculer((Integer) valor1, (Double) valor2));
					else if ((valor1 instanceof Double) && (valor2 instanceof Integer))
						posfixa.push(opBinaria.calculer((Double) valor1, (Integer) valor2));
				}
			}

			Object object = posfixa.pop();
			if (object instanceof Integer)
				return String.valueOf(object);
			else
				return String.format("%.1f", object);
		}
	}
}
