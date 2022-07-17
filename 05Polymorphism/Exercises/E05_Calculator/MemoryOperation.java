package OOP.Polymorphism_Exercise.E05_Calculator;

import java.util.ArrayDeque;

public class MemoryOperation implements Operation {
    private ArrayDeque<Integer> operands;

    public MemoryOperation() {
        this.operands = new ArrayDeque<>();
    }

    @Override
    public void addOperand(int operand) {
        this.operands.push(operand);
    }

    @Override
    public boolean isCompleted() {
        return false;

    }

    @Override
    public int getResult() {
        return operands.pop();

    }
}
