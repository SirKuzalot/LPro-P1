public class ASTIf implements ASTNode {
    ASTNode cond;
    ASTNode thenn;
    ASTNode elsee;

    ASTIf(ASTNode cond, ASTNode thenn, ASTNode elsee) {
        this.cond = cond;
        this.thenn = thenn;
        this.elsee = elsee;
    }

    public IValue eval(Environment<IValue> e) throws InterpreterError {
        VBool b = (VBool) cond.eval(e);
        if (b.getval()) {
            return thenn.eval(e);
        } else {
            return elsee.eval(e);
        }
    }
    
}
