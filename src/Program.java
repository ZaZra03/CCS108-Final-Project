
public class Program {
	// Class Fields
	private static int idCounter = 1;
	private int id;
	private String name;
	private Curriculum curriculum;

	// Getters
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Curriculum getCurriculum() {
		return this.curriculum;
	}
	
	// Parameterized Constructor
	public Program(String name) {
		this.id = idCounter;
		this.name = name;
		idCounter++;
	}

	// Methods
	public void AddCurriculum(String yearEffectivity) throws Exception {
		if (this.curriculum == null) {
			this.curriculum = new Curriculum(yearEffectivity);
		} else {
			throw new Exception("\nThis Program already contains a Curriculum");
		}
	}
	
	public void DeleteCurriculum() throws Exception {
		if (this.curriculum != null) {
			this.curriculum = null;
		} else {
			throw new Exception("\nThis Program does not contain a Curriculum");
		}
	}

	public String GetProgramDetails() {
		return "\nPROGRAM ID : " + this.id + "\nPROGRAM NAME : " + this.name;
	}
	
	public String GetFullDetails() {
		return "\nPROGRAM ID : " + this.id + "\nPROGRAM NAME : " + this.name
				+ "\n\n===== CURRICULUM CONTENTS =====\n" + this.curriculum.GetFullDetails();
	}
}
