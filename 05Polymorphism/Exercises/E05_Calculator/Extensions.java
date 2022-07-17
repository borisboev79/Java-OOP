package OOP.Polymorphism_Exercise.E05_Calculator;

public abstract class Extensions {
    public static InputInterpreter buildInterpreter(CalculationEngine engine){
        return new InputInterpreter(engine);
    };
}
