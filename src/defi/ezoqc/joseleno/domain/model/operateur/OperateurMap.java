package defi.ezoqc.joseleno.domain.model.operateur;

import java.util.HashMap;
import java.util.Map;

public class OperateurMap {

	private Map<Character,Operateur> map = new HashMap<Character,Operateur>();

    public void register(Operateur operateur) {
        this.map.put(operateur.getSymbole(), operateur);
    }

    public Operateur get(char symbole) {
        return this.map.get(symbole);
    }
}
