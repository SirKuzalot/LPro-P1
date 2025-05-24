public class ASTCons implements ASTNode {
    ASTNode head, tail;
    boolean isLazy;
    public ASTCons(ASTNode head, ASTNode tail, boolean isLazy) {
        this.head = head;
        this.tail = tail;
        this.isLazy = isLazy;
    }
    public IValue eval(Environment<IValue> e) throws InterpreterError {
        IValue h = head.eval(e);
        if (isLazy) {
            return new VCons(h, () -> {
                try {
                    return tail.eval(e);
                } catch (InterpreterError ex) {
                    throw new RuntimeException(ex);
                }
            });
        } else {
            return new VCons(h, tail.eval(e));
        }
    }
}