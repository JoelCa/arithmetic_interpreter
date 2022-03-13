package ast;

public abstract class BinaryNode implements IArithmeticNode {
    protected IArithmeticNode myExpLeft;
    protected IArithmeticNode myExpRight;

    public BinaryNode(IArithmeticNode exp1, IArithmeticNode exp2) {
        this.myExpLeft = exp1;
        this.myExpRight = exp2;
    }
    
    public IArithmeticNode getLeft() {
    	return myExpLeft;
    }
    
    public IArithmeticNode getRight() {
    	return myExpRight;
    }
}
