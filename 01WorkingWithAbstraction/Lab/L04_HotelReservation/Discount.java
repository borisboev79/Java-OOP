package OOP.WorkingWithAbstraction_Lab.L04_HotelReservation;

public enum Discount {
    VIP(0.8),
    SECOND_VISIT(0.9),
    NONE(1);

    private double priceAfterDiscount;

    Discount(double priceAfterDiscount) {
        this.priceAfterDiscount = priceAfterDiscount;
    }

    public double getPriceAfterDiscount() {
        return priceAfterDiscount;
    }

    public static Discount parse(String str) {
        switch (str) {
            case "VIP":
                return VIP;
            case "SecondVisit":
                return SECOND_VISIT;
            case "None":
                return NONE;
            default:
                throw new IllegalArgumentException("Unknown enum value" + str);
        }
    }
}
