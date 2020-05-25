package defi.ezoqc.joseleno.aplication.util;

import java.util.HashMap;
import java.util.Map;

public class FiltreMap {
	
	 private Map<String, IFiltre> map = new HashMap<String,IFiltre>();

	    public void register(IFiltre filtre) {
	        this.map.put(filtre.getExpression(), filtre);
	    }

	    public IFiltre get(String expression) {
	        return this.map.get(expression);
	    }

}
