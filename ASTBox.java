public class ASTBox implements ASTNode {
    ASTNode n1;

    ASTBox(ASTNode n1) {
        this.n1 = n1;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError
    {
        IValue v = n1.eval(e);
        if (v instanceof VInt) {
            return new VBox((VInt) v);
        } else if (v instanceof VBool) {
            return new VBox((VBool) v);
        } else if (v instanceof VFun) {
            return new VBox((VFun) v);
        } else if (v instanceof VBox) {
            return (VBox) v;
        } else {
            throw new InterpreterError("Boxing only works for int, bool, function, or box values");
        }
    }

    
}
