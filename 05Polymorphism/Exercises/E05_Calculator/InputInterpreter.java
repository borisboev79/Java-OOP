package OOP.Polymorphism_Exercise.E05_Calculator;

public class InputInterpreter {
    private CalculationEngine engine;
    private MemoryOperation tempMemory;

    public InputInterpreter(CalculationEngine engine) {
        this.engine = engine;
        this.tempMemory = new MemoryOperation();
        }

    public boolean interpret(String input) {
        try {
            if (!input.equals("mr")) {
                engine.pushNumber(Integer.parseInt(input));
            } else {
                engine.pushNumber(tempMemory.getResult());
            }
        } catch (Exception ex) {
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }

    public Operation getOperation(String operation) {

        if (operation.equals("*")) {
            return new MultiplicationOperation();
        } else if (operation.equals("/")) {
            return new DivisionOperation();
        } else if (operation.equals("ms")) {
            return tempMemory;
        }
        return null;
    }
}
