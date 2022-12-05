import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static List<Program> listPrograms = new ArrayList<Program>();
	static List<Course> listCourses = new ArrayList<Course>();

	/**
	 * Contains the main menu of the program
	 * if an error occurs when creating a new program or course,
	 * they are return in the main menu.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// while loop to continuously loop the program until the user wishes to exit
		while (true) {
			// try-catch statement to ensure the user will enter proper input
			try {
				System.out.println("\nMain Menu. Please select an Operation");
				System.out.println("1. Create New Program");
				System.out.println("2. Create New Course");
				System.out.println("3. Display Program List");
				System.out.println("4. Display Course List");
				System.out.println("5. Edit College Program");
				System.out.println("6. Exit");
				System.out.print(">> ");

				int response = Integer.parseInt(in.readLine());

				if (response < 1 || response > 6) {
					throw new NumberFormatException();
				}

				outer: switch (response) {
				case 1:
					//CreateNewProgram() method call
					CreateNewProgram();
					break;
				case 2:
					//CreateNewCourse() method call
					CreateNewCourse();
					break;
				case 3:
					//DsiplayProgramList() method call
					DisplayProgramList();
					break;
				case 4:
					//DisplayCourseList() method call
					DisplayCourseList();
					break;
				case 5:
					/*
					 * All of the available programs is displayed when 
					 * editing a college program.
					 * Id is used to select the program to edit.
					 * If the program exists, the EditCollegeProgram() method is called
					 * If it does not exist, a prompt will show.
					 * 
					 */
					System.out.println("\nEditing a College Program...");
					DisplayProgramList();
					System.out.print("\nPlease Enter College Program ID: ");
					int programId = Integer.parseInt(in.readLine());
					for (Program program : listPrograms) {
						if (program.getId() == programId) {
							EditCollegeProgram(program);
							break outer;
						}
					}
					throw new Exception("\nCollege Program ID: " + programId + " is not found. Returning to Main Menu");
					//Exits the program
				case 6:
					System.out.println("\nClosing Program");
					System.exit(0);
				}
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid Input. Returning to Main Menu...");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	/**
	 * Creates a new Program class object and uses the 
	 * String name input as its parameter.
	 * If the String name is empty, the user will be returned to the Main mennu.
	 * If the input is valid, a new Program class object is made.
	 * 
	 * @throws Exception
	 */
	public static void CreateNewProgram() throws Exception {
		System.out.println("\nCreating a new Program...");
		System.out.print("\nEnter the Program's Name: ");
		String name = in.readLine();

		if (name.isBlank()) {
			throw new Exception("\nProgram's Name cannot be empty. Returning to Main Menu...");
		}
		Program program = new Program(name);
		listPrograms.add(program);
		System.out.println("\nProgram Created! Opening Program's Menu...");
		EditCollegeProgram(program);
	}

	/**
	 *Creates a new course and is saved in the courses list of the Main class
	 *Asks for the informations of the Course object and it will be used for the 
	 *Course class' parameters.
	 *If one of the important informations(Course code, description, number of units)
	 * asked is invalid or left blank, the user will be returned
	 *to the Main Menu.
	 *If all the inputs are valid, a new Course object is created and is added into the 
	 *courses list of the Main class
	 * 
	 * @throws Exception
	 */
	public static void CreateNewCourse() throws Exception {
		System.out.println("\nCreating a new Course...");
		System.out.print("\nEnter the Course's Code: ");
		String courseCode = in.readLine();
		System.out.print("Enter the Course's Description: ");
		String description = in.readLine();
		System.out.print("Enter the Number of Units: ");
		int units = Integer.parseInt(in.readLine());
		System.out.print("Enter the Pre-Requisite Course (Leave Blank if None): ");
		String preRequisite = in.readLine();
		System.out.print("Enter the Co-Requisite Course (Leave Blank if None): ");
		String coRequisite = in.readLine();

		if (courseCode.isBlank() || description.isBlank() || units < 1) {
			throw new Exception("\nOne of inputs is Invalid. Returning to Main Menu...");
		}

		Course course = new Course(courseCode, description, units, preRequisite, coRequisite);
		listCourses.add(course);
		System.out.println("\nCourse Created! Returning to Main Menu...");
	}

	/**
	 * If there are no programs yet, a prompt will show saying that the list is empty. 
	 * Otherwise the method displays all of the Programs inside the list of Programs together with their
	 * details.
	 * @throws Exception
	 */
	public static void DisplayProgramList() throws Exception {
		if (!listPrograms.isEmpty()) {
			System.out.println("\nDisplaying All Programs inside the List...");
			for (Program program : listPrograms) {
				System.out.println(program.GetProgramDetails() + "\n");
			}
		} else {
			throw new Exception("\nProgram List is Empty. Please add some Programs first!");
		}
	}

	/**
	 * If there are no courses yet, a prompt will show saying that the list is empty. 
	 * Otherwise the method displays all of the Courses inside the list of Courses together with their
	 * details.
	 * @throws Exception
	 */
	public static void DisplayCourseList() throws Exception {
		if (!listCourses.isEmpty()) {
			System.out.println("\nDisplaying All Courses inside the List...");
			for (Course course : listCourses) {
				System.out.println(course.GetCourseDetails() + "\n");
			}
		} else {
			throw new Exception("\nCourse List is Empty. Please add some Courses first!");
		}
	}

	/**
	 * This method acts as a sub menu to edit a College Program
	 * If an error occurs when performing one of the operations,
	 * the user will be returned to the Main Menu.
	 * The method uses a Program object as its parameter, the object passed into the method
	 * is the Program object that is going to undergo editing.
	 * 
	 * @param program
	 */
	public static void EditCollegeProgram(Program program) {
		// while loop to continuously loop the program until the user wishes to exit
		while (true) {
			// try-catch statement to ensure the user will enter proper input
			try {
				System.out.println("\nProgram Menu. Select an Operation");
				System.out.println("1. Add Curriculum");
				System.out.println("2. Add Course");
				System.out.println("3. Remove Course");
				System.out.println("4. Display Program Details");
				System.out.println("5. Delete Curriculum");
				System.out.println("6. Delete College Program");
				System.out.println("7. Back to Main Menu");
				System.out.print(">> ");

				int response = Integer.parseInt(in.readLine());

				if (response < 1 || response > 7) {
					throw new NumberFormatException();
				}

				outer: switch (response) {
				/*
				 * Case 1 adds a curriculum into the selected program.
				 * The year of effectivity is needed for this operation as it is the 
				 * parameter passed into the constructor of the Curriculum class.
				 * If the input is empty or invalid, the user is returned to the Program Meny
				 * If it is valid, a new Curriculum object is made and the user is returned to the Program
				 * Menu.
				 */
				case 1:
					System.out.println("\nAdding Curriculum to " + program.getName() + "...");
					System.out.print("\nEnter Curriculum's Year of Effectivity: ");
					String yearEffectivity = in.readLine();
					if (yearEffectivity.isBlank()) {
						throw new Exception("\nYear of Effectivity cannot be blank. Returning to Program Menu...");
					}
					program.AddCurriculum(yearEffectivity);
					System.out.println("\nCurriculum Added! Returning to Program Menu...");
					break;
					/*
					 * A course cannot be added in a Program object if it does not have a 
					 * Curriculum object
					 * The method asks for the informations of the Course object which is going
					 * to be passed into the parameters of the Course class' Constructor.
					 * IF the Course's ID does not exist, a prompt will show.
					 */
				case 2:
					if (program.getCurriculum() != null) {
						System.out.println("\nAdding a Course to the Curriculum...");
						DisplayCourseList();
						System.out.print("\nEnter Course ID: ");
						int courseId = Integer.parseInt(in.readLine());
						System.out.print("Enter the Academic Year (1-4): ");
						int year = Integer.parseInt(in.readLine());
						System.out.print("Enter the Semester (1-2): ");
						int semester = Integer.parseInt(in.readLine());
						for (Course course : listCourses) {
							if (course.getId() == courseId) {
								program.getCurriculum().AddCourseOnPeriod(course, year, semester);
								System.out.println("\nCourse Added to Curriculum! Returning to Program Menu...");
								break outer;
							}
						}
						throw new Exception("\nCourse ID: " + courseId + " not found. Returning to Program Menu...");
					} else {
						throw new Exception("\nThis program have no Curriculum added yet. Returning to Program Menu...");
					}
					/*
					 * Removes a course in the Program's Curriculum
					 * ID is used to search for the Course inside the Curriculum
					 * It is removed if found.
					 * If it is not found a prompt will show.
					 * The Operation cannot be executed if the program does not have a 
					 * Curriculum yet.
					 */
				case 3:
					if (program.getCurriculum() != null) {
						System.out.println("\nRemoving a Course in the Curriculum...");
						DisplayCourseList();
						System.out.print("\nEnter Course ID: ");
						int courseId = Integer.parseInt(in.readLine());
						for (Course course : listCourses) {
							if (course.getId() == courseId) {
								program.getCurriculum().RemoveCourseInCurriculum(course);
								System.out.println("\nCourse Removed from Curriculum! Returning to Program Menu...");
								break outer;
							}
						}
						throw new Exception("\nCourse ID: " + courseId + " not found. Returning to Program Menu...");
					} else {
						throw new Exception("\nThis program have no Curriculum added yet. Returning to Program Menu...");
					}
					/*
					 * Displays the Program's full details, including the program's ID, name, and the program curriculum's full 
					 * details. 
					 * If there is no curriculum yet in the program, a prompt will show saying that theere is no curriculum yet
					 * and then the user will be returned to the program menu 
					 */
				case 4:
					if (program.getCurriculum() != null) {
						System.out.println("\nDisplaying " + program.getName() + " Full Details...");
						System.out.println(program.GetFullDetails());
						break;
					} else {
						throw new Exception("\nThis program have no Curriculum added yet. Returning to Program Menu...");
					}
					/*
					 * Deletes the program's Curriculum, a confirmation is added to avoid accidental deletion
					 * The user's input is validated, if the input is invalid the user is returned to the program menu
					 * After deletion, the user goes back to the program menu.
					 */
				case 5:
					System.out.println("\nWarning! Deleting this Program's Curriculum...");
					System.out.println(
							"\nThere is no way to recover the Curriculum after deletion. \nAre you sure to delete this Program's Curriculum?");
					System.out.println("1. Delete Curriculum");
					System.out.println("2. Cancel");
					System.out.print(">> ");

					response = Integer.parseInt(in.readLine());

					if (response < 1 || response > 2) {
						throw new NumberFormatException();
					}

					if (response == 1) {
						System.out.println("\nProceeding to delete the Program's Curriculum...");
						program.DeleteCurriculum();
						System.out.println("Program's Curriculum has been deleted!");
					} else {
						System.out.println("\nReturning to Program Menu...");
					}
					break;
					/*
					 * Deletes the program that is being edited, a confirmation is added to avoid accidental deletion
					 * The user's input is validated, if the input is invalid the user is returned to the program menu
					 * After deletion, the user goes back to the program menu.
					 */
				case 6:
					System.out.println("\nWarning! Deleting this Program...");
					System.out.println(
							"\nThere is no way to recover this Program after deletion. \nAre you sure to delete this Program?");
					System.out.println("1. Delete Program");
					System.out.println("2. Cancel");
					System.out.print(">> ");

					response = Integer.parseInt(in.readLine());

					if (response < 1 || response > 2) {
						throw new NumberFormatException();
					}

					if (response == 1) {
						System.out.println("\nProceeding to delete this Program...");
						listPrograms.remove(program);
						System.out.println("This Program has been deleted! Returning to Main Menu...");
						return;
					} else {
						System.out.println("\nReturning to Program Menu...");
						break;
					}
					//Returns to the Main menu from the Program menu
				case 7:
					System.out.println("\nReturning to Main Menu...");
					return;
				}
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid Input. Returning to Program Menu...");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
}
