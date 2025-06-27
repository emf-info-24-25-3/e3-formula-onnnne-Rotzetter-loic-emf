package models;

import java.text.DecimalFormat;

public class Pneu {
    private TypePneu type;
    private double pression;

    public Pneu(TypePneu type, double pression) {
        this.type = type;
        this.pression = pression;
    }

    public TypePneu getType() {
        return type;
    }

    public double getPression() {
        return pression;
    }

    @Override
    public String toString() {
        DecimalFormat d1 = new DecimalFormat("#.f1");
        return "Pneu [type=" + type + ", pression =" + d1.format(pression); 
    }
}
