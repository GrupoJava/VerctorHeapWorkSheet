

public class Paciente<E> implements Comparable<E>{
	
	private String nombrePaciente;
	private String enfermedad;
	private String prioridad;

	public Paciente(String nombrePaciente, String enfermedad, String prioridad) {
		super();
		this.nombrePaciente = nombrePaciente;
		this.enfermedad = enfermedad;
		this.prioridad = prioridad;
	}

	public int compareTo(E paciente) {
		// TODO Auto-generated method stub
		return this.prioridad.compareTo(((Paciente ) paciente).getPrioridad());
	}

	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	
}