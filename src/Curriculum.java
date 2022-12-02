import java.util.*;

public class Curriculum {
	// Class Fields
	private static int idCounter = 1;
	private int id;
	private String yearEffectivity;
	private List<AcademicTerm> listPeriods = new ArrayList<AcademicTerm>();

	// Parameterized Constructor
	public Curriculum(String yearEffectivity) {
		this.id = idCounter;
		this.yearEffectivity = yearEffectivity;
		idCounter++;

		this.listPeriods.add(new AcademicTerm(1, 1));
		this.listPeriods.add(new AcademicTerm(1, 2));
		this.listPeriods.add(new AcademicTerm(2, 1));
		this.listPeriods.add(new AcademicTerm(2, 2));
		this.listPeriods.add(new AcademicTerm(3, 1));
		this.listPeriods.add(new AcademicTerm(3, 2));
		this.listPeriods.add(new AcademicTerm(4, 1));
		this.listPeriods.add(new AcademicTerm(4, 2));
	}

	// Methods
	public void AddCourseOnPeriod(Course course, int year, int semester) throws Exception {
		if (year < 1 || year > 4 || semester < 1 || semester > 2) {
			throw new Exception("\nYear count does not follow the allowable period (4 Years and 2 Semester per Year)");
		} else if (!this.CheckFor(course)) {
			for (AcademicTerm period : this.listPeriods) {
				if (period.getYear() == year) {
					if (period.getSemester() == semester) {
						period.AddCourse(course);
					}
				}
			}
		} else {
			throw new Exception("\nThis course is already inside one of the periods");
		}
	}
	
	public void RemoveCourseInCurriculum(Course course) throws Exception {
		for (AcademicTerm period : listPeriods) {
			if (period.getListCourses().contains(course)) {
				period.RemoveCourse(course);
				return;
			}
		}
		throw new Exception("\nThis course is not found in this curriculum");
	}

	private boolean CheckFor(Course course) {
		boolean isExisting = false;

		for (AcademicTerm period : listPeriods) {
			if (period.getListCourses().contains(course)) {
				isExisting = true;
			}
		}
		return isExisting;
	}

	public String GetFullDetails() {
		String details = "\nCURRICULUM ID : " + this.id + "\nYEAR OF EFFECTIVITY: " + this.yearEffectivity
				+ "\n\n===== LIST OF COURSES INSIDE THE CURRICULUM =====\n";

		for (int i = 0; i < this.listPeriods.size(); i++) {
			details += this.listPeriods.get(i).GetFullDetails() + "\n";
		}

		return details;
	}
}
