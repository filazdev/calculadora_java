/*
Topicos Avanzados de Programación
Reto1 UML y Eventos
Estudiante: Francisco Ivan Lopez Araiza Zavala
Asesor: Dr. Marco Damián Cortés González
Fecha: 04/10/2023
*/
package calculadora;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Calculadora extends JFrame {

    public Calculadora(){
        //Se establece el tamaño default de la calculadora
        this.setSize(380,480);
        //Se define título en la ventana
        this.setTitle("Calcuadora Básica");
        //Acción al cerrar la ventana
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Posición central de la ventana
        this.setLocationRelativeTo(null);
        //Sin ningún patrón de diseño
        this.setLayout(null);
        //Se impide que se modifique el tamaño de la ventana
        setResizable(false);
        //Se instancia el método componentes
        componentes();
        //Se establece que sea visible
        this.setVisible(true);
    }
    //Se crea método con los componentes que contrendrá la ventana o JFrame
    public void componentes() {
        //Campo de texto donde se visualizarán las operaciones
        campoTexto = new JTextField();
        campoTexto.setBounds(18, 20, 330, 50);
        campoTexto.setBorder(BorderFactory.createLineBorder(Color.black,3));
        campoTexto.setHorizontalAlignment(JTextField.RIGHT);


        //Panel sobre el que se situará el campo de texto
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        //Posición y tamaño del panel
        panel.setBounds(0, 0, 380, 480);
        //Sin ningún diseño
        panel.setLayout(null);
        //Se agrega el campo texto al panel
        panel.add(campoTexto);

        //Panel contenedor de los botones se sitúa dentro del panel anterior
        JPanel panelBotones = new JPanel();
        //Se establece color de fondo
        panelBotones.setBackground(Color.black);
        //Posición y tamaño del panel
        panelBotones.setBounds(18, 90, 330, 330);
        //Sin ningún diseño para poder situar los botones manualmente
        panelBotones.setLayout(null);
        /*Se empleó un layout para la distribución de los botones, se definen filas y columnas
         * y en seguida la separación entre botones vertical y horizontal*/
        //panelBotones.setLayout(new GridLayout(4,4,2,2));
        /*Se omitió el uso del GridLaYout, aunque resultaba muy práctico no admite definir el tamaño del botón
        * porque adopta por default la configuración del layout y la actividad requiere esos valores*/
        
        //Se añade el panel al JFrame o ventana principal
        this.add(panel);
        //Se añade el panel que contendrá los botones
        panel.add(panelBotones);

        /*Se crea el objeto ActionListener que estará a la escucha de los eventos ocurridos en cada botón
          Cada objeto desencadena una accion específica determinada para cada botón*/
        ActionListener boton0 = (ActionEvent e) -> {
            campoTexto.setText(campoTexto.getText() + "1");
        };

        ActionListener boton1 = (ActionEvent e) -> {
            campoTexto.setText(campoTexto.getText() + "2");
        };
        ActionListener boton2 = (ActionEvent e) -> {
            campoTexto.setText(campoTexto.getText() + "3");
        };
        //Botón Suma
        ActionListener boton3 = (ActionEvent e) -> {
            if (!campo) {
                if (campoTexto.getText().equals("")) {
                    num1 = 0.0;
                } else
                    num1 = Double.parseDouble(campoTexto.getText());
                op = "+";
                campoTexto.setText(campoTexto.getText() + " + ");
                campo = true;
            }
        };

        ActionListener boton4 = (ActionEvent e) -> {
            campoTexto.setText(campoTexto.getText() + "4");
        };
        ActionListener boton5 = (ActionEvent e) -> {
            campoTexto.setText(campoTexto.getText() + "5");
        };
        ActionListener boton6 = (ActionEvent e) -> {
            campoTexto.setText(campoTexto.getText() + "6");
        };
        //Botón Resta
        ActionListener boton7 = (ActionEvent e) -> {
            if (!campo) {
                if (campoTexto.getText().equals("")) {
                    num1 = 0.0;
                } else
                    num1 = Double.parseDouble(campoTexto.getText());
                op = "-";
                campoTexto.setText(campoTexto.getText() + " - ");
                campo = true;
            }
        };
        ActionListener boton8 = (ActionEvent e) -> {
            campoTexto.setText(campoTexto.getText() + "7");
        };
        ActionListener boton9 = (ActionEvent e) -> {
            campoTexto.setText(campoTexto.getText() + "8");
        };
        ActionListener boton10 = (ActionEvent e) -> {
            campoTexto.setText(campoTexto.getText() + "9");
        };
        //Botón Multiplicación
        ActionListener boton11 = (ActionEvent e) -> {
            if (!campo) {
                if (campoTexto.getText().equals("")) {
                    num1 = 0.0;
                } else
                    num1 = Double.parseDouble(campoTexto.getText());
                op = "*";
                campoTexto.setText(campoTexto.getText() + " * ");
                campo = true;
            }
        };
        //Botón Borrar
        ActionListener boton12 = (ActionEvent e) -> {
            campoTexto.setText("");
            num1 = 0.0;
            num2 = 0.0;
            campo = false;
        };
        ActionListener boton13 = (ActionEvent e) -> {
            campoTexto.setText(campoTexto.getText() + "0");
        };
        //Botón Resultado o Igual
        ActionListener boton14 = (ActionEvent e) -> {
            if (campo) {
                String contenido = campoTexto.getText();
                int posicion = contenido.indexOf("+") & contenido.indexOf("-") & contenido.indexOf("*") & contenido.indexOf("/");
                String numero2 = contenido.substring(posicion + 1);
                numero2.trim();
                num2 = Double.parseDouble(numero2);
                campo = false;
            }

            switch (op) {
                case "+" -> {
                    campoTexto.setText(Double.toString(num1 + num2));
                    op = "";
                    num1 = 0.0;
                    num2 = 0.0;
                    campo = false;
                }
                case "-" -> {
                    campoTexto.setText(Double.toString(num1 - num2));
                    op = "";
                    num1 = 0.0;
                    num2 = 0.0;
                    campo = false;
                }
                case "*" -> {
                    campoTexto.setText(Double.toString(num1 * num2));
                    op = "";
                    num1 = 0.0;
                    num2 = 0.0;
                    campo = false;
                }
                case "/" -> {
                    if (num2 == 0) {
                        campoTexto.setText("No se permite division entre 0");
                    } else
                        campoTexto.setText(Double.toString(num1 / num2));
                    op = "";
                    num1 = 0.0;
                    num2 = 0.0;
                    campo = false;
                }
            }
        };

        //Botón División
        ActionListener boton15 = (ActionEvent e) -> {
            if (!campo) {
                if (campoTexto.getText().equals("")) {
                    num1 = 0.0;
                } else
                    num1 = Double.parseDouble(campoTexto.getText());
                op = "/";
                campoTexto.setText(campoTexto.getText() + " / ");
                campo = true;
            }
        };

        /*Se crea un array que contiene los botones, se define la posición y el tamaño para cada botón 
        y se agrega el objeto ActionListener previamente creado*/
        JButton boton[] = new JButton[16];
        boton[0] = new JButton("1");
        boton[0].setBounds(2,2,80,80);
        boton[0].addActionListener(boton0);
        boton[1] = new JButton("2");
        boton[1].setBounds(84,2,80,80);
        boton[1].addActionListener(boton1);
        boton[2] = new JButton("3");
        boton[2].setBounds(166,2,80,80);
        boton[2].addActionListener(boton2);
        boton[3] = new JButton("+");
        boton[3].setBounds(248,2,80,80);
        boton[3].addActionListener(boton3);
        boton[4] = new JButton("4");
        boton[4].setBounds(2,84,80,80);
        boton[4].addActionListener(boton4);
        boton[5] = new JButton("5");
        boton[5].setBounds(84,84,80,80);
        boton[5].addActionListener(boton5);
        boton[6] = new JButton("6");
        boton[6].setBounds(166,84,80,80);
        boton[6].addActionListener(boton6);
        boton[7] = new JButton("-");
        boton[7].setBounds(248,84,80,80);
        boton[7].addActionListener(boton7);
        boton[8] = new JButton("7");
        boton[8].setBounds(2,166,80,80);
        boton[8].addActionListener(boton8);
        boton[9] = new JButton("8");
        boton[9].setBounds(84,166,80,80);
        boton[9].addActionListener(boton9);
        boton[10] = new JButton("9");
        boton[10].setBounds(166,166,80,80);
        boton[10].addActionListener(boton10);
        boton[11] = new JButton("*");
        boton[11].setBounds(248,166,80,80);
        boton[11].addActionListener(boton11);
        boton[12] = new JButton("C");
        boton[12].setBounds(2,248,80,80);
        boton[12].addActionListener(boton12);
        boton[13] = new JButton("0");
        boton[13].setBounds(84,248,80,80);
        boton[13].addActionListener(boton13);
        boton[14] = new JButton("=");
        boton[14].setBounds(166,248,80,80);
        boton[14].addActionListener(boton14);
        boton[15] = new JButton("/");
        boton[15].setBounds(248,248,80,80);
        boton[15].addActionListener(boton15);
        
        //Se recorre el array y se agrega cada uno de los botones al panelBotones.
        for (JButton jButton : boton) {
            jButton.setBackground(Color.white);
            panelBotones.add(jButton);
        }

    }

    //Método main
    public static void main(String[]args){
        new Calculadora();
       
        
    }


    //Variables
    JTextField campoTexto;
    Double num1=0.0,num2=0.0;
    String op;
    Boolean campo=false;
}
