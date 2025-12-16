package c;

import java.util.Stack;

public class Environment{
    private Stack<Context> contextStack;
    private Signature signature;
    public Environment(){contextStack = new Stack<>();signature = new Signature();}
    public void pushContext(){contextStack.push(new Context());}
    public void popContext(){contextStack.pop();}
    public void pushLocalVar(VarIdent id, InternalTypeRepresentation type){contextStack.peek().content.put(id,type);}
    public void pushGlobalFun(FunIdent id, InternalFunTypeRepresentation funType){signature.put(id,funType);}
    public boolean typeCheckFunAndExtractRetType(InternalTypeRepresentation[] args, FunIdent id,ReferenceContainer<InternalTypeRepresentation> out){return signature.typeCheckArgTypesAndExtractRetType(args,id,out);}
    public boolean tryGetVar(VarIdent id, ReferenceContainer<InternalTypeRepresentation> out){
        for(int i = contextStack.size()-1;i>=0;i--){
            InternalTypeRepresentation res;
            if((res = contextStack.get(i).content.get(id)) !=null){
                out.setReference(res);
                return true;
            }
        } return false;
    }
}
