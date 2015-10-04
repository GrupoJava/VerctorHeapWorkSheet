

// TODO: Auto-generated Javadoc
/**
 * The Class Paciente.
 *
 * @param <E> the element type
 */
public class Paciente<E> implements Comparable<E>{
	
	/** The nombre paciente. */
	private String nombrePaciente;
	
	/** The enfermedad. */
	private String enfermedad;
	
	/** The prioridad. */
	private String prioridad;

	/**
	 * Instantiates a new paciente.
	 *
	 * @param nombrePaciente the nombre paciente
	 * @param enfermedad the enfermedad
	 * @param prioridad the prioridad
	 */
	public Paciente(String nombrePaciente, String enfermedad, String prioridad) {
		super();
		this.nombrePaciente = nombrePaciente;
		this.enfermedad = enfermedad;
		this.prioridad = prioridad;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(E paciente) {
		// TODO Auto-generated method stub
		return this.prioridad.compareTo(((Paciente ) paciente).getPrioridad());
	}

	/**
	 * Gets the nombre paciente.
	 *
	 * @return the nombre paciente
	 */
	public String getNombrePaciente() {
		return nombrePaciente;
	}

	/**
	 * Sets the nombre paciente.
	 *
	 * @param nombrePaciente the new nombre paciente
	 */
	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	/**
	 * Gets the enfermedad.
	 *
	 * @return the enfermedad
	 */
	public String getEnfermedad() {
		return enfermedad;
	}

	/**
	 * Sets the enfermedad.
	 *
	 * @param enfermedad the new enfermedad
	 */
	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}

	/**
	 * Gets the prioridad.
	 *
	 * @return the prioridad
	 */
	public String getPrioridad() {
		return prioridad;
	}

	/**
	 * Sets the prioridad.
	 *
	 * @param prioridad the new prioridad
	 */
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	
}