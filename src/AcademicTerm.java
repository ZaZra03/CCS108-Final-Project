import java.util.*;

public class AcademicTerm {
	// Class Fields
	private int year;
	private int semester;
	private List<Course> listCourses = new ArrayList<Course>();

	// Getters
	public int getYear() {
		return this.year;
	}

	public int getSemester() {
		return this.semester;
	}

	public List<Course> getListCourses() {
		return this.listCourses;
	}

	// Parameterized Constructor
	public AcademicTerm(int year, int semester) {
		this.year = year;
		this.semester = semester;
	}

	// Methods
	public void AddCourse(Course course) throws Exception {
		if (!this.CheckUnitCount(course)) {
			this.listCourses.add(course);
		} else {
			throw new Exception("\nNumber of Units exceeds the limit unit for the semester");
		}

	}

	public void RemoveCourse(Course course) throws Exception {
		if (this.listCourses.contains(course)) {
			this.listCourses.remove(course);
		} else {
			throw new Exception("\nThis Course is not found on this Period");
		}
	}

	private boolean CheckUnitCount(Course course) {
		int count = course.getUnits();
		for (Course currentCourse : this.listCourses) {
			count += currentCourse.getUnits();
		}
		return count >= 26;
	}

	public String GetFullDetails() {
		String details = "";

		if (this.year == 1) {
			if (this.semester == 1) {
				details += "\n--- FIRST YEAR - FIRST SEMESTER ---\n";
			} else {
				details += "\n--- FIRST YEAR - SECOND SEMESTER ---\n";
			}
		} else if (this.year == 2) {
			if (this.semester == 1) {
				details += "\n--- SECOND YEAR - FIRST SEMESTER ---\n";
			} else {
				details += "\n--- SECOND YEAR - SECOND SEMESTER ---\n";
			}
		} else if (this.year == 3) {
			if (this.semester == 1) {
				details += "\n--- THIRD YEAR - FIRST SEMESTER ---\n";
			} else {
				details += "\n--- THIRD YEAR - SECOND SEMESTER ---\n";
			}
		} else {
			if (this.semester == 1) {
				details += "\n--- FOURTH YEAR - FIRST SEMESTER ---\n";
			} else {
				details += "\n--- FOURTH YEAR - SECOND SEMESTER ---\n";
			}
		}

		if (!this.listCourses.isEmpty()) {
			for (Course currentCourse : this.listCourses) {
				details += currentCourse.GetFullDetails() + "\n";
			}
		} else {
			details += "\nNO COURSES SET\n";
		}
		return details;
	}
}
