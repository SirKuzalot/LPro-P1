public class VCons implements IValue {
    private final IValue head;
    private final IValue strictTail;
    private final java.util.function.Supplier<IValue> lazyTail;
    private final boolean isLazy;

    // Strict cons
    public VCons(IValue head, IValue tail) {
        this.head = head;
        this.strictTail = tail;
        this.lazyTail = null;
        this.isLazy = false;
    }
    // Lazy cons
    public VCons(IValue head, java.util.function.Supplier<IValue> lazyTail) {
        this.head = head;
        this.strictTail = null;
        this.lazyTail = lazyTail;
        this.isLazy = true;
    }
    public IValue getHead() { return head; }
    public IValue getTail() {
        if (isLazy) return lazyTail.get();
        else return strictTail;
    }
    public String toStr() {
        return head.toStr() + "::" + getTail().toStr();
    }
}