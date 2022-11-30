import java.util.*;

public class Curriculum {
	//Class fields
	private int idCounter;
	private int id;
	private String yearEffectivity;
	private List<Course> listCourses = new ArrayList<Course>();
	private Program program;
	
	//Parameterized Constructor
	public Curriculum(String yearEffectivity) {
		this.yearEffectivity = yearEffectivity;
		this.id = this.idCounter;
		this.idCounter++;
	}
	
	//Methods
	public void AddCourse(Course course, int year, int semester) throws Exception {
		Course tempCourse = course;
		tempCourse.setYear(year);
		tempCourse.setSemester(semester);
		if (!this.CheckUnitCount(tempCourse)) {
			this.listCourses.add(tempCourse);
		} else {
			throw new Exception("\nNumber of Units exceeds the limit unit for the semester");
		}
	}
	
	public void RemoveCourse(Course course) {
		
	}
	
	private boolean CheckUnitCount(Course course) {
		int count = course.getUnits();
		for (Course currentCourse : this.listCourses) {
			if (currentCourse.getYear() == course.getYear()) {
				if (currentCourse.getSemester() == course.getSemester()) {
					count += currentCourse.getUnits();
				}
			}
		}
		return count >= 26;
	}
	
	public String GetFullDetails() {
		return "";
	}
}
