package c;

import java.util.HashMap;
import java.util.Map;

public class Context {
    Map<VarIdent,InternalTypeRepresentation> content;
    public Context(){content = new HashMap<VarIdent,InternalTypeRepresentation>();}

}
