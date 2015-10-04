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


/**
 *
 * El objetivo de este programa es utilizar VectorHep con un Comparador para ordenar en orden de prioridad a los pacientes de un hospital
 *
 * Se introduce un archivo de texto con tres datos de los pacientes separados de comas
 * Deveulve en orden de prioridad, siendo la A de mas urgencia, a los pacientes
 */
public class InterfazGrafica2 {

		private JFrame frame;
		private JSlider slider;
		private JLabel label;
		private JTextField txtIngreseALos;
		private JFileChooser fc;
		private File file;
		//private Calculadora<Integer> calculadora = new Calculadora<Integer>();
		private JButton btnSeleccionarArchivo;
		private JButton buttonCalcular;
		private JTextArea textArea;
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

		 public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						InterfazGrafica2 window = new InterfazGrafica2();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
		public InterfazGrafica2(){
			initialize();
		}
		
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
		

		private class Evento implements ActionListener{


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
								Emergencia2 emergencia = new Emergencia2();
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


	