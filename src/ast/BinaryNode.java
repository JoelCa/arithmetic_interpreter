package ast;

public abstract class BinaryNode extends AbstractArithmeticNode {
    protected AbstractArithmeticNode myExpLeft;
    protected AbstractArithmeticNode myExpRight;

    public BinaryNode(AbstractArithmeticNode exp1, AbstractArithmeticNode exp2) {
        this.myExpLeft = exp1;
        this.myExpRight = exp2;
    }
    
    public AbstractArithmeticNode getLeft() {
    	return myExpLeft;
    }
    
    public AbstractArithmeticNode getRight() {
    	return myExpRight;
    }
}
