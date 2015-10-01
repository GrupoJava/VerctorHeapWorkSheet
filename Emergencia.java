import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class Emergencia{
	private Vector<Paciente> pacientes = new Vector<Paciente>();
	
	public void entrarPacientes(String file) throws FileNotFoundException{
		File archivo = new File(file);
		String palabra = "";
		String[] palabras;
		BufferedReader br = new BufferedReader(new FileReader(file));
	    String line = null;
        try {
			while ((line = br.readLine()) != null) {
			    palabras=line.split(",");
			    pacientes.add(new Paciente(palabras[0].replace(" ", ""), palabras[1].replace(" ", ""),palabras[2].replace(" ", "")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	
	public String devolverPacientesEnOrden(){
		String pacientesEnOrden="";
		VectorHeap heap = new VectorHeap(pacientes);
		while(heap.iterator().hasNext()){
			Paciente paciente = (Paciente) heap.poll();
			pacientesEnOrden=pacientesEnOrden+paciente.getNombrePaciente()+" "+","+paciente.getEnfermedad()+" "+","+paciente.getPrioridad()+"\n";
		}
		return pacientesEnOrden;
	}
}