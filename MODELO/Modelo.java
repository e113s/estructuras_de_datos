package MODELO;

import java.util.Vector;

public class Modelo {

    Vector<Integer> v;

    public Modelo()
    {
        v = new Vector<>();
    }

    public Vector getVector()
    {
        return v;
    }

    public void setVector(Vector<Integer> v)
    {
        this.v = v;
    }
}
