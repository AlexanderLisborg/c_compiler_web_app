package alexander.webc;

import c.Typedsyn.Type;
import org.yaml.snakeyaml.util.Tuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TypeChecker {
    /// The environment is a stack of Contexts. The stack handles variable scopes. A context is a map from  variable
    /// names to their types.
    private Stack<Map<String,c.Typedsyn.Type>> env;
    /// Signature. This is a map of function names to their return types and argument types.
    private Map<String, Tuple<c.Typedsyn.Type, ArrayList<Type>>> sig;

    public TypeChecker()
    {
        // Init collections
        env = new Stack<>();
        sig = new HashMap<>();
        // Init start values..?
        // Insert built in functions...
    }
    // From abstract syntax tree to typed syntax tree...
    public c.Typedsyn.Program typeCheck(c.Absyn.Program program)
    {
        throw new UnsupportedOperationException("Not supported yet.");

        // Begin recursive visitation of the syntax tree. Can be done with a composite visitor<Typed,>...
    }
}
