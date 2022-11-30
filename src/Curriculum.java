import java.util.List;

public class Curriculum {
	//Class fields
	private int idCounter;
	private int id;
	private String yearEffectivity;
	private List<Course> listCourse;
	private Program program;
	
	//Parameterized Constructor
	public Curriculum(String yearEffectivity) {
		this.yearEffectivity = yearEffectivity;
	}
	
	//Methods
	public void AddCourse(Course course, int term, int semester) {
		
	}
	
	public void RemoveCourse(Course course) {
		
	}
	
	public String GetFullDetails() {
		return "";
	}
}
