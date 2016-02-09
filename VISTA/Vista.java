package VISTA;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MODELO.Modelo;
import CONTROLADOR.Controlador;

public class Vista extends JFrame implements ActionListener{

    private JTextArea JtaVector, JtaResul;
    private JTextField JtfAgrega;
    private JButton JbOrdenar, JbAgregar, JbLimpiar;
    private JComboBox JcbMetodos;
    private Border borde;

    Modelo mod = new Modelo();

    public Vista()
    {
        super("Metodos de Ordenamiento");

        Container content = getContentPane();
        content.setLayout(new GridLayout(2,2));

        borde = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        content.add(crearP00());
        content.add(crearP01());
        content.add(crearP10());
        content.add(crearP11());

        JbAgregar.addActionListener(this);
        JcbMetodos.addActionListener(this);
        JbOrdenar.addActionListener(this);
        JbLimpiar.addActionListener(this);

        setSize(800,350);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    private JPanel crearP00()
    {
        JPanel p = new JPanel(new BorderLayout());

        TitledBorder tituloBorde = BorderFactory.createTitledBorder(borde, "Vector");
        p.setBorder(tituloBorde);

        JtaVector = new JTextArea();
        JtaVector.setEditable(false);

        JScrollPane scroll = new JScrollPane(JtaVector);

        p.add(scroll, BorderLayout.CENTER);

        return p;
    }

    private JPanel crearP01()
    {
        JPanel p = new JPanel(new FlowLayout());

        TitledBorder tituloBorde = BorderFactory.createTitledBorder(borde, "Ingresar Datos");
        p.setBorder(tituloBorde);

        JtfAgrega = new JTextField(20);
        p.add(JtfAgrega);

        JbAgregar = new JButton("Agregar");
        p.add(JbAgregar);

        return p;
    }

    private JPanel crearP10()
    {
        JPanel p = new JPanel(new BorderLayout());

        TitledBorder tituloBorde = BorderFactory.createTitledBorder(borde, "Resultado");
        p.setBorder(tituloBorde);

        JtaResul = new JTextArea();
        JtaResul.setEditable(false);

        JScrollPane scroll = new JScrollPane(JtaResul);

        p.add(scroll, BorderLayout.CENTER);

        return p;
    }

    private JPanel crearP11()
    {
        JPanel p = new JPanel(new FlowLayout());
        TitledBorder tituloBorde = BorderFactory.createTitledBorder(borde, "Métodos");
        p.setBorder(tituloBorde);

        JcbMetodos = new JComboBox();
        JcbMetodos.addItem("Seleccione");
        JcbMetodos.addItem("Burbuja");
        JcbMetodos.addItem("Burbuja con señal");
        JcbMetodos.addItem("Sacudida");
        JcbMetodos.addItem("Inserción binaria");
        JcbMetodos.addItem("Inserción directa");
        JcbMetodos.addItem("Selección directa");
        JcbMetodos.addItem("Shell");
        JcbMetodos.addItem("QuickSort");
        JcbMetodos.addItem("HeapSort");
        p.add(JcbMetodos);

        JbOrdenar = new JButton("Ordenar");
        JbOrdenar.setEnabled(false);
        p.add(JbOrdenar);

        JbLimpiar = new JButton("Limpiar");
        JbLimpiar.setEnabled(false);
        p.add(JbLimpiar);

        return p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == JbAgregar)
        {
            try
            {
                mod.getVector().add(Integer.parseInt(JtfAgrega.getText()));
                mod.setVector(mod.getVector());
                JtaVector.setText(mod.getVector() + " ");
                JtfAgrega.setText("");
                JtfAgrega.requestFocus();
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(null,"Error, solamente números","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(JcbMetodos.getSelectedIndex() == 1)
        {
            JbOrdenar.setEnabled(true);
            JbLimpiar.setEnabled(true);

            if(e.getSource() == JbOrdenar)
            {
                JtaResul.setText("" + Controlador.mBurbujaMen(mod));
            }

            if(e.getSource() == JbLimpiar)
            {
                JtaResul.setText("");
            }
        }
        else if(JcbMetodos.getSelectedIndex() == 2)
        {
            JbOrdenar.setEnabled(true);
            JbLimpiar.setEnabled(true);

            if(e.getSource() == JbOrdenar)
            {
                JtaResul.setText("" + Controlador.mBurbujaSenal(mod));
            }

            if(e.getSource() == JbLimpiar)
            {
                JtaResul.setText("");
            }
        }
        else if(JcbMetodos.getSelectedIndex() == 3)
        {
            JbOrdenar.setEnabled(true);
            JbLimpiar.setEnabled(true);

            if(e.getSource() == JbOrdenar)
            {
                JtaResul.setText("" + Controlador.mSacudida(mod));
            }

            if(e.getSource() == JbLimpiar)
            {
                JtaResul.setText("");
            }
        }
        else if(JcbMetodos.getSelectedIndex() == 4)
        {
            JbOrdenar.setEnabled(true);
            JbLimpiar.setEnabled(true);

            if(e.getSource() == JbOrdenar)
            {
                JtaResul.setText("" + Controlador.mInsercionBinaria(mod));
            }

            if(e.getSource() == JbLimpiar)
            {
                JtaResul.setText("");
            }
        }
        else if(JcbMetodos.getSelectedIndex() == 5)
        {
            JbOrdenar.setEnabled(true);
            JbLimpiar.setEnabled(true);

            if(e.getSource() == JbOrdenar)
            {
                JtaResul.setText("" + Controlador.mInsercionDirecta(mod));
            }

            if(e.getSource() == JbLimpiar)
            {
                JtaResul.setText("");
            }
        }
        else if(JcbMetodos.getSelectedIndex() == 6)
        {
            JbOrdenar.setEnabled(true);
            JbLimpiar.setEnabled(true);

            if(e.getSource() == JbOrdenar)
            {
                JtaResul.setText("" + Controlador.mSeleccionDirecta(mod));
            }

            if(e.getSource() == JbLimpiar)
            {
                JtaResul.setText("");
            }
        }
        else if(JcbMetodos.getSelectedIndex() == 7)
        {
            JbOrdenar.setEnabled(true);
            JbLimpiar.setEnabled(true);

            if(e.getSource() == JbOrdenar)
            {
                JtaResul.setText("" + Controlador.mShell(mod));
            }

            if(e.getSource() == JbLimpiar)
            {
                JtaResul.setText("");
            }
        }
        else if(JcbMetodos.getSelectedIndex() == 8)
        {
            JbOrdenar.setEnabled(true);
            JbLimpiar.setEnabled(true);

            if(e.getSource() == JbOrdenar)
            {
                JtaResul.setText("" + Controlador.mQickSort(mod,0,(mod.getVector().size()-1)));
            }

            if(e.getSource() == JbLimpiar)
            {
                JtaResul.setText("");
            }
        }
        else if(JcbMetodos.getSelectedIndex() == 9)
        {
            JbOrdenar.setEnabled(true);
            JbLimpiar.setEnabled(true);

            if(e.getSource() == JbOrdenar)
            {
                JtaResul.setText("" + Controlador.mHeapSort(mod));
            }

            if(e.getSource() == JbLimpiar)
            {
                JtaResul.setText("");
            }
        }
    }
}
