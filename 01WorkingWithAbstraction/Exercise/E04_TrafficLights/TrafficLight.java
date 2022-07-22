package OOP.WorkingWithAbstraction_Exercise.E04_TrafficLights;

public class TrafficLight {
    private Color currentColor;

    public TrafficLight(Color color) {
        this.currentColor = color;
    }

    public Color getCurrentColor() {
        return currentColor;
    }

    public void changeColor() {
        switch(currentColor) {

            case RED:
                this.currentColor = Color.GREEN;
                break;
            case GREEN:
                this.currentColor = Color.YELLOW;
                break;
            case YELLOW:
                this.currentColor = Color.RED;
                break;
        }
    }
}
