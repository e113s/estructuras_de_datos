package CONTROLADOR;

import MODELO.Modelo;

import javax.swing.*;
import java.util.Vector;


public class Controlador {

    public static Vector mBurbujaMen(Modelo mod)
    {
        int i,j;
        int AUX;
        int cont = 1;
        Vector<Integer> v = mod.getVector();

        for(i = 0; i < v.size() - 1; i++)
        {
            for(j = v.size() - 1; j > i; j--)
            {
                if(v.get(j - 1) > v.get(j))
                {
                    AUX = v.get(j - 1);
                    v.set(j - 1, v.get(j));
                    v.set(j,AUX);
                }
            }
        }
        return v;
    }

    public static Vector mBurbujaSenal(Modelo mod)
    {
        int i,j;
        int AUX;
        boolean BAND;
        Vector<Integer> v = mod.getVector();

        i = 1;
        BAND = false;

        while((i <= v.size() - 1) && (BAND == false))
        {
            BAND  = true;
            for(j = 0; j < v.size() - 1; j++)
            {
                if(v.get(j) > v.get(j+1))
                {
                    AUX = v.get(j);
                    v.set(j, v.get(j+1));
                    v.set(j+1,AUX);
                    BAND = false;
                }
            }
            i++;
        }

        return v;
    }

    public static Vector mSacudida(Modelo mod)
    {
        int i,k;
        int IZQ, DER;
        int AUX;
        int cont = 1;
        Vector<Integer> v = mod.getVector();

        IZQ = 2;
        DER = v.size();
        k = v.size();

        while(DER >= IZQ)
        {
            for(i = v.size() - 1; i > 0; i--)
            {
                if(v.get(i -1) > v.get(i))
                {
                    AUX = v.get(i-1);
                    v.set(i-1,v.get(i));
                    v.set(i,AUX);
                    k = i;
                }
            }

            IZQ = k + 1;

            for(i = 0; i < v.size() - 1; i++)
            {
                if(v.get(i) > v.get(i+1))
                {
                    AUX = v.get(i);
                    v.set(i,v.get(i+1));
                    v.set(i+1,AUX);
                    k = i;
                }
            }

            DER = k - 1;
        }

        return v;
    }

    public static Vector mInsercionBinaria(Modelo mod)
    {
        int i,m,j;
        int IZQ, DER;
        int AUX;
        Vector<Integer> v = mod.getVector();

        for(i = 1; i < v.size(); i++)
        {
            AUX = v.get(i);
            IZQ = 0;
            DER = i - 1;

            while(IZQ <= DER)
            {
                m = ((IZQ + DER) / 2);

                if(AUX <= v.get(m))
                {
                    DER = m - 1;
                }
                else
                {
                    IZQ = m + 1;
                }

            }

            j = i - 1;

            while(j >= IZQ)
            {
                v.set(j+1,v.get(j));
                j--;
            }

            v.set(IZQ,AUX);
        }

        return v;
    }

    public static Vector mInsercionDirecta(Modelo mod)
    {
        int i,k;
        int AUX;
        Vector<Integer> v = mod.getVector();

        for (i = 1; i < v.size(); i++)
        {
            AUX = v.get(i);
            k = i - 1;

            while ((k >= 0) && (AUX < v.get(k)))
            {
                v.set(k+1,v.get(k));
                k--;
            }
            v.set(k+1,AUX);
        }

        return v;
    }

    public static Vector mSeleccionDirecta(Modelo mod)
    {
        int i,j,k;
        int MENOR;
        Vector<Integer> v = mod.getVector();

        for(i = 0; i < v.size() - 1; i++)
        {
            MENOR = v.get(i);
            k = i;

            for(j = i + 1; j < v.size(); j++)
            {
                if(v.get(j) < MENOR)
                {
                    MENOR = v.get(j);
                    k = j;
                }
            }

            v.set(k,v.get(i));
            v.set(i,MENOR);
        }

        return v;
    }

    public static Vector mShell(Modelo mod)
    {
        
    }

    public static Vector mQickSort(Modelo mod, int INI, int FIN)
    {
        
    }

    public static Vector mHeapSort(Modelo mod)
    {
        insertaMonticulo(mod.getVector());
        eliminaMonticulo(mod.getVector());

        return mod.getVector();
    }

    public static Vector eliminaMonticulo(Vector<Integer> v)
    {
        int i,k;
        int IZQ, DER, AP;
        int AUX;
        boolean BAND;
        int MAYOR;

        for(i = v.size() - 1; i > 1; i--)
        {
            AUX = v.get(i);
            v.set(i,v.get(1));
            IZQ = 2;
            DER = 3;
            k = 1;
            BAND = true;

            while((IZQ < i) && (BAND))
            {
                MAYOR = v.get(IZQ);
                AP = IZQ;

                if((MAYOR < v.get(DER)) && (DER != i))
                {
                    MAYOR = v.get(DER);
                    AP = DER;
                }

                if(AUX < MAYOR)
                {
                    v.set(k,v.get(AP));
                    k = AP;
                }
                else
                {
                    BAND = false;
                }

                IZQ = k*2;
                DER = IZQ + 1;
            }

            v.set(k,AUX);
        }

        return v;
    }

    public static Vector insertaMonticulo(Vector<Integer> v)
    {
        int i,k;
        int AUX;
        boolean BAND;

        for(i = 1; i < v.size(); i++)
        {
            k = i;
            BAND = true;

            while((k >= 1) && (BAND))
            {
                BAND = false;

                if(v.get(k) > v.get((k/2)))
                {
                    AUX = v.get((k/2));
                    v.set((k/2),v.get(k));
                    v.set(k,AUX);
                    k = (k/2);
                    BAND = true;
                }
            }
        }
        return v;
    }
}
