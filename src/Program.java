

public class Program {
	// Class Fields
	private static int idCounter = 1;
	private int id;
	private String name;
	private Curriculum curriculum;

	/**
	 * Parameterized Constructor
	 * 
	 * @param name
	 */
	public Program(String name) {
		this.id = idCounter;
		this.name = name;
		idCounter++;
	}
	
	// Getters
	/**
	 * @return
	 */
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return
	 */
	public Curriculum getCurriculum() {
		return this.curriculum;
	}
	

	// Methods
	
	/**
	 * Adds curriculum into the program
	 * Creates a new Curriculum object passing the yearEffectivity as its parameter
	 * A Curriculum won't be added if the program already has as curriculum
	 * 
	 * @param yearEffectivity
	 * @throws Exception
	 */
	public void AddCurriculum(String yearEffectivity) throws Exception {
		if (this.curriculum == null) {
			this.curriculum = new Curriculum(yearEffectivity);
		} else {
			throw new Exception("\nThis Program already contains a Curriculum");
		}
	}
	
	/**
	 * Deletes the curriculum of the program if it has one.
	 * If the program do not have a Curriculum object assigned, a prompt will show.
	 * 
	 * @throws Exception
	 */
	public void DeleteCurriculum() throws Exception {
		if (this.curriculum != null) {
			this.curriculum = null;
		} else {
			throw new Exception("\nThis Program does not contain a Curriculum");
		}
	}

	/**
	 * Displays the details of the program.
	 * It shows the Program ID and name.
	 * 
	 * @return
	 */
	public String GetProgramDetails() {
		return "\nPROGRAM ID : " + this.id + "\nPROGRAM NAME : " + this.name;
	}
	
	/**
	 * Displays the full details of the program.
	 * It includes the program ID, name, and the full details of its 
	 * curriculum object.
	 * 
	 * @return
	 */
	public String GetFullDetails() {
		return "\nPROGRAM ID : " + this.id + "\nPROGRAM NAME : " + this.name
				+ "\n\n===== CURRICULUM CONTENTS =====\n" + this.curriculum.GetFullDetails();
	}
}
