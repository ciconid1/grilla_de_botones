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

	        ventana.setLocationRelativeTo(null);
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
                String texto =  (x * 32 - 396) + "," + ((y * 32) - 12);  // Los índices permanecen igual para el texto
                JButton boton = new JButton(texto);
                

                boton.setFont(new Font("Arial", Font.PLAIN, 8));
                boton.setBackground(Color.white);

                // Establecer tamaño preferido del botón
                boton.setPreferredSize(new Dimension(tamanoCelda, tamanoCelda));
                
                // Alinear texto a la izquierda
                boton.setHorizontalTextPosition(SwingConstants.CENTER);
                boton.setVerticalTextPosition(SwingConstants.TOP); 


                // Agregar un ActionListener para manejar los eventos de clic en cada botón
                boton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    	// Espacio libre
                    	if(!imprimir && boton.getBackground() == Color.white) {
                    		boton.setBackground(Color.gray);
                    		boton.setIcon(new ImageIcon((getClass().getResource("/sprites/bloque_solido.gif"))));
                    		imprimir = true;
                    	}
                    	// BloqueSolido
                    	if(!imprimir && boton.getBackground() == Color.gray) {
                    		boton.setBackground(Color.red);
                    		boton.setIcon(new ImageIcon((getClass().getResource("/sprites/ladrillo_solido.gif"))));
                    		imprimir = true;
                    	}
                    	// LadrilloSolido
                    	if(!imprimir && boton.getBackground() == Color.red) {
                    		boton.setBackground(Color.yellow);
                    		boton.setIcon(new ImageIcon((getClass().getResource("/sprites/bloque_pregunta.gif"))));
                    		imprimir = true;
                    	}
                    	// BloqueDePregunta
                    	if(!imprimir && boton.getBackground() == Color.yellow) {
                    		boton.setBackground(Color.green);
                    		boton.setIcon(new ImageIcon((getClass().getResource("/sprites/tuberia.gif"))));
                    		imprimir = true;
                    	}
                    	// Tuberia
                    	if(!imprimir && boton.getBackground() == Color.green) {
                    		boton.setBackground(Color.orange);
                    		boton.setIcon(new ImageIcon((getClass().getResource("/sprites/goomba.gif"))));
                    		imprimir = true;
                    	}
                    	// Goomba
                    	if(!imprimir && boton.getBackground() == Color.orange) {
                    		boton.setBackground(Color.blue);
                    		boton.setIcon(new ImageIcon((getClass().getResource("/sprites/koopa_troopa.gif"))));
                    		imprimir = true;
                    	}
                    	// KoopaTroopa
                    	if(!imprimir && boton.getBackground() == Color.blue) {
                    		boton.setBackground(Color.black);
                    		boton.setIcon(new ImageIcon((getClass().getResource("/sprites/buzzy_beetle.gif"))));
                    		imprimir = true;
                    	}
                    	// BuzzyBeetle
                    	if(!imprimir && boton.getBackground() == Color.black) {
                    		boton.setBackground(Color.pink);
                    		boton.setIcon(new ImageIcon((getClass().getResource("/sprites/spiny.gif"))));
                    		imprimir = true;
                    	}
                    	// Spiny
                    	if(!imprimir && boton.getBackground() == Color.pink) {
                    		boton.setBackground(Color.white);
                    		boton.setIcon(new ImageIcon((getClass().getResource("/sprites/empty32x32.png"))));
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
//                        System.out.println("Hilos: " + Thread.currentThread().getThreadGroup().activeCount());
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
