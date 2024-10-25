package grilla_de_botones;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrillaBotones extends JPanel {

    private int filas;
    private int columnas;
    private int tamanoCelda;
    private boolean imprimir;
    
    
//    public static void main(String[] args) {
//        // Crear la ventana
//        JFrame ventana = new JFrame("Grilla de Botones Transpuesta");
//        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Configurar la grilla
//        int filas = 17;
//        int columnas = 30;
//        int tamanoCelda = 32;
//
//        GrillaBotones grilla = new GrillaBotones(filas, columnas, tamanoCelda);
//        ventana.add(grilla);
//
//        // Ajustar el tamaño de la ventana
////        ventana.pack();  // Ajusta el tamaño de la ventana automáticamente según el tamaño de los componentes
//        ventana.setSize(800, 600);
//        ventana.setVisible(true);
//        
//        
//        
//        
////        while(true) {
////        	System.out.println(Thread.currentThread().getThreadGroup().activeCount());
////        }
//    }

    public GrillaBotones(int filas, int columnas, int tamanoCelda) {
        this.filas = filas;
        this.columnas = columnas;
        this.tamanoCelda = tamanoCelda;
        
        imprimir = false;

        // Establecer el layout como GridLayout para organizar los botones en una grilla
        this.setLayout(new GridLayout(filas, columnas));

        // Crear los botones y agregarlos al panel en la matriz traspuesta
        for (int y = 0; y < filas; y++) {  // Intercambiar el bucle de filas y columnas
            for (int x = 0; x < columnas; x++) {
                String texto =  (x * 32 + 0) + "," + ((y * 32) - 12);  // Los índices permanecen igual para el texto
                JButton boton = new JButton(texto);
                

                boton.setFont(new Font("Arial", Font.PLAIN, 8));
                boton.setBackground(Color.white);

                // Establecer tamaño preferido del botón
                boton.setPreferredSize(new Dimension(tamanoCelda, tamanoCelda));
                
                // Alinear texto a la izquierda
                boton.setHorizontalTextPosition(SwingConstants.LEFT);
                boton.setMargin(new Insets(0, 0, 0, 0));  // Ajusta el margen izquierdo

                // Agregar un ActionListener para manejar los eventos de clic en cada botón
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	if(!imprimir && boton.getBackground() == Color.yellow) {
                    		boton.setBackground(Color.white);
                    		imprimir = true;
                    	}
                    	if(!imprimir && boton.getBackground() == Color.red) {
                    		boton.setBackground(Color.gray);
                    		imprimir = true;
                    	}
                    	if(!imprimir && boton.getBackground() == Color.green) {
                    		boton.setBackground(Color.red);
                    		imprimir = true;
                    	}
                    	if(!imprimir && boton.getBackground() == Color.gray) {
                    		boton.setBackground(Color.yellow);
                    		imprimir = true;
                    	}
                    	if(!imprimir && boton.getBackground() == Color.white) {
                    		boton.setBackground(Color.green);
                    		imprimir = true;
                    	}
                    		
                    	                    	
                    	//Imprimir por consola todas las entidades
                        if(imprimir) {
                        	for(JButton b : getJButtons()) {
                        		if(b.getBackground() == Color.yellow) {
                        			System.out.println("Moneda::" + b.getText());
                        		}
                        		if(b.getBackground() == Color.red) {
                        			System.out.println("LadrilloSolido::" + b.getText());
                        		}
                        		if(b.getBackground() == Color.green) {
                        			System.out.println("KoopaTroopa::" + b.getText());
                        		}
                        		if(b.getBackground() == Color.gray) {
                        			System.out.println("BloqueSolido::" + b.getText());
                        		}
                        		
                        		
                        	}

                          	
                        }
                        imprimir = false;
                        System.out.println("------------------- AQUI TIENE SU MAPA AMO --------------------------------");
                        }
                    }
                );

                // Añadir el botón al panel
                this.add(boton);
                
                

            }
        }
        
     
        
        
    }

   
    
    
    // Método para obtener un Iterable de los JButtons
    public Iterable<JButton> getJButtons() {
        ArrayList<JButton> buttons = new ArrayList<>();
        Component[] components = this.getComponents(); // Obtiene todos los componentes del JPanel

        for (Component component : components) {
            if (component instanceof JButton) { // Verifica si el componente es un JButton
                buttons.add((JButton) component); // Agrega el botón a la lista
            }
        }
        return buttons; // Devuelve la lista como Iterable
    }
    
    
    
}


