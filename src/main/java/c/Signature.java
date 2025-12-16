package c;

import java.util.HashMap;
import java.util.Map;

public class Signature {
    private Map<FunIdent,InternalFunTypeRepresentation> content;
    public Signature(){content = new HashMap<FunIdent,InternalFunTypeRepresentation>();}
    public void put(FunIdent funIdent, InternalFunTypeRepresentation funTypeRepresentation){content.put(funIdent,funTypeRepresentation);}
    public boolean tryGet(FunIdent funIdent, ReferenceContainer<InternalFunTypeRepresentation> out){
        InternalFunTypeRepresentation res = content.get(funIdent);
        if(res != null){
            out.setReference(res);
            return true;
        } else return false;
    }
    public boolean typeCheckArgTypesAndExtractRetType(InternalTypeRepresentation[] argTypes, FunIdent id,ReferenceContainer<InternalTypeRepresentation> out){
        ReferenceContainer<InternalFunTypeRepresentation> out2 = new ReferenceContainer<>();
        if(tryGet(id, out2)){
            if(argTypes==null){
                if(out2.value.types==null || out2.value.types.length==0){throw new RuntimeException("FunType " + id + " has no ret type");}
                if(out2.value.types.length == 1){
                    out.setReference(out2.value.types[0]);
                    return true;
                }
                return false;
            }
            if(argTypes.length != out2.value.types.length-1)
                return false;
            for(int i=0; i<argTypes.length; i++){
                if(!argTypes[i].equals(out2.value.types[i+1])){return false;}
            }
            out.setReference(out2.value.types[0]);
            return true;
        } return false;
    }
}
