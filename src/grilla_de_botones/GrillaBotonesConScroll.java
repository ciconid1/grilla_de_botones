package grilla_de_botones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GrillaBotonesConScroll {
	
	// ----------------------------- Variables
	private static boolean imprimir;
	// --------------------------------------- 
	
	/////////////////////////////////////////////////////// MAIN
	public static void main(String[] args) {
	        // Configurar la ventana
	        JFrame ventana = new JFrame("Grilla de Botones con Scroll");
	        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        ventana.setSize(800, 600);

	        // Crear la grilla de botones --------------------------------------------------------- cantidad de filas y columnas aqui
	        int filas = 17, 
	        	columnas = 100,
	        	tamanoCelda = 32;
	        JPanel panelGrilla = crearGrillaDeBotones(filas, columnas, tamanoCelda);

	        // Crear el JScrollPane con la grilla de botones y agregarlo a la ventana
	        JScrollPane scrollConGrilla = crearScrollConGrilla(panelGrilla);
	        ventana.add(scrollConGrilla);

	        ventana.setVisible(true);
	    }
	//////////////////////////////////////////////////////////////////
	
    public static JScrollPane crearScrollConGrilla(JPanel panelGrilla) {
        // Crear un JScrollPane y agregarle el panel de la grilla
        JScrollPane scrollPane = new JScrollPane(panelGrilla);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        return scrollPane;
    }

    public static JPanel crearGrillaDeBotones(int filas, int columnas, int tamanoCelda) {
        imprimir = false;

        // Establecer el layout como GridLayout para organizar los botones en una grilla
        JPanel panelGrilla = new JPanel(new GridLayout(filas, columnas));

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
                    	// Espacio libre
                    	if(!imprimir && boton.getBackground() == Color.white) {
                    		boton.setBackground(Color.gray);
                    		imprimir = true;
                    	}
                    	// BloqueSolido
                    	if(!imprimir && boton.getBackground() == Color.gray) {
                    		boton.setBackground(Color.red);
                    		imprimir = true;
                    	}
                    	// LadrilloSolido
                    	if(!imprimir && boton.getBackground() == Color.red) {
                    		boton.setBackground(Color.yellow);
                    		imprimir = true;
                    	}
                    	// BloqueDePregunta
                    	if(!imprimir && boton.getBackground() == Color.yellow) {
                    		boton.setBackground(Color.green);
                    		imprimir = true;
                    	}
                    	// Tuberia
                    	if(!imprimir && boton.getBackground() == Color.green) {
                    		boton.setBackground(Color.orange);
                    		imprimir = true;
                    	}
                    	// Goomba
                    	if(!imprimir && boton.getBackground() == Color.orange) {
                    		boton.setBackground(Color.blue);
                    		imprimir = true;
                    	}
                    	// KoopaTroopa
                    	if(!imprimir && boton.getBackground() == Color.blue) {
                    		boton.setBackground(Color.black);
                    		imprimir = true;
                    	}
                    	// BuzzyBeetle
                    	if(!imprimir && boton.getBackground() == Color.black) {
                    		boton.setBackground(Color.pink);
                    		imprimir = true;
                    	}
                    	// Spiny
                    	if(!imprimir && boton.getBackground() == Color.pink) {
                    		boton.setBackground(Color.white);
                    		imprimir = true;
                    	}
                    		
                    	                    	
                    	//Imprimir por consola todas las entidades
                        if(imprimir) {
                        	for(Component c : panelGrilla.getComponents()) {
                        		if (c instanceof JButton) {
                        			JButton b = (JButton) c;
                        			if(b.getBackground() == Color.yellow) {
                            			System.out.println("BloqueDePregunta::" + b.getText());
                            		}
                            		if(b.getBackground() == Color.red) {
                            			System.out.println("LadrilloSolido::" + b.getText());
                            		}
                            		if(b.getBackground() == Color.green) {
                            			System.out.println("Tuberia::" + b.getText());
                            		}
                            		if(b.getBackground() == Color.gray) {
                            			System.out.println("BloqueSolido::" + b.getText());
                            		}
                            		if(b.getBackground() == Color.black) {
                            			System.out.println("BuzzyBeetle::" + b.getText());
                            		}
                            		if(b.getBackground() == Color.orange) {
                            			System.out.println("Goomba::" + b.getText());
                            		}
                            		if(b.getBackground() == Color.blue) {
                            			System.out.println("KoopaTroopa::" + b.getText());
                            		}
                            		if(b.getBackground() == Color.pink) {
                            			System.out.println("Spiny::" + b.getText());
                            		}
                        		}
                        	}
                        }
                        imprimir = false;
                        System.out.println("#------------------- AQUI TIENE SU MAPA AMO --------------------------------");
                        }
                    }
                );

                // Añadir el botón al panel
                panelGrilla.add(boton);
            }
        }
        
        return panelGrilla;
        
     
    }

   
    
    
}
