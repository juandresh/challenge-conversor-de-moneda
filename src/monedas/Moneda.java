package monedas;

public class Moneda {

    private String nombre;
    private double usd;
    private double ars;
    private double brl;
    private double cop;

    public Moneda(String nombre, double usd, double ars, double brl, double cop) {
        this.nombre = nombre;
        this.usd = usd;
        this.ars = ars;
        this.brl = brl;
        this.cop = cop;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public double getArs() {
        return ars;
    }

    public void setArs(double ars) {
        this.ars = ars;
    }

    public double getBrl() {
        return brl;
    }

    public void setBrl(double brl) {
        this.brl = brl;
    }

    public double getCop() {
        return cop;
    }

    public void setCop(double cop) {
        this.cop = cop;
    }

    @Override
    public String toString() {
        return "Moneda{" +
                "nombre='" + nombre + '\'' +
                ", usd=" + usd +
                ", ars=" + ars +
                ", brl=" + brl +
                ", cop=" + cop +
                '}';
    }
}
