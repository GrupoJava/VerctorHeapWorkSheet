/**
 * Universidad del Valle de Guatemala
 * Algoritmos y Estructura de Datos
 * Sección: 10
 * 20/08/2015
 * Hoja de Trabajo 4
 *
 */

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;

import java.awt.Color;


// TODO: Auto-generated Javadoc
/**
 * The Class InterfazGrafica.
 */
public class InterfazGrafica {

		/** The frame. */
		private JFrame frame;
		
		/** The slider. */
		private JSlider slider;
		
		/** The label. */
		private JLabel label;
		
		/** The txt ingrese a los. */
		private JTextField txtIngreseALos;
		
		/** The fc. */
		private JFileChooser fc;
		
		/** The file. */
		private File file;
		
		/** The btn seleccionar archivo. */
		//private Calculadora<Integer> calculadora = new Calculadora<Integer>();
		private JButton btnSeleccionarArchivo;
		
		/** The button calcular. */
		private JButton buttonCalcular;
		
		/** The text area. */
		private JTextArea textArea;
		
		/** The metodo. */
		private int metodo=1;
		
			
	/*		
				VectorHeap vector = new VectorHeap();
				vector.add(new Paciente("Juan Perez","Yo no","C"));
				vector.add(new Paciente("aNDA","LE","A"));
				vector.add(new Paciente("jO","hANNA","E"));
				vector.add(new Paciente("jEIMMY","MIMI","B"));
				
				System.out.println(((Paciente)vector.poll()).getPrioridad());
				System.out.println(((Paciente)vector.poll()).getPrioridad());
				System.out.println(((Paciente)vector.poll()).getPrioridad());
				System.out.println(((Paciente)vector.poll()).getPrioridad());
				
				
			}
}*/

		 /**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						InterfazGrafica window = new InterfazGrafica();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		/**
		 * Instantiates a new interfaz grafica.
		 */
		public InterfazGrafica(){
			initialize();
		}
		
		/**
		 * Initialize.
		 */
		public void initialize(){
			frame = new JFrame();
			frame.setBounds(100, 100, 587, 381);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblEmergencia = new JLabel("Cruz Roja Emer.");
			lblEmergencia.setForeground(Color.RED);
			lblEmergencia.setFont(new Font("Tahoma", Font.BOLD, 50));
			lblEmergencia.setBounds(10, 11, 582, 106);
			frame.getContentPane().add(lblEmergencia);
			
			btnSeleccionarArchivo = new JButton("Seleccionar Archivo");
			btnSeleccionarArchivo.setBounds(362, 128, 174, 23);
			btnSeleccionarArchivo.addActionListener(new Evento());
			frame.getContentPane().add(btnSeleccionarArchivo);
			
			txtIngreseALos = new JTextField();
			txtIngreseALos.setText("Ingrese a los pacientes...");
			txtIngreseALos.setBounds(20, 128, 332, 23);
			frame.getContentPane().add(txtIngreseALos);
			txtIngreseALos.setColumns(10);
			
			buttonCalcular = new JButton("Ordenar Pacientes");
			buttonCalcular.setBounds(20, 164, 174, 23);
			buttonCalcular.addActionListener(new Evento());
			frame.getContentPane().add(buttonCalcular);
			
			JLabel lblResultados = new JLabel("Resultados:");
			lblResultados.setBounds(20, 199, 100, 21);
			frame.getContentPane().add(lblResultados);
			
			textArea = new JTextArea();
			textArea.setBounds(20, 218, 306, 113);
			frame.getContentPane().add(textArea);
			
			JTextPane textPane = new JTextPane();
			textPane.setForeground(Color.RED);
			textPane.setText("      ___ RED CROSS \n __|   |__\n[__   __] EMERGENCY\n__|    |\n__|    |\n__|    | PATIENTS\n__|__|");
			textPane.setBounds(362, 175, 154, 140);
			frame.getContentPane().add(textPane);
			
			fc = new JFileChooser();
			
			
		}
		

		/**
		 * The Class Evento.
		 */
		private class Evento implements ActionListener{


			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent a) {
			
				if(a.getSource()==btnSeleccionarArchivo){
					int returnVal = fc.showOpenDialog(frame);
			        if (returnVal == JFileChooser.APPROVE_OPTION) {
			        	System.out.println("Seleccion");
			            file = fc.getSelectedFile();
			            txtIngreseALos.setText(file.getAbsolutePath());
			        } 
				}else if(a.getSource()==buttonCalcular){
							try {
								Emergencia emergencia = new Emergencia();
								emergencia.entrarPacientes(file.getAbsolutePath());
								textArea.setText(emergencia.devolverPacientesEnOrden());
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				}
			}
		}
}


	