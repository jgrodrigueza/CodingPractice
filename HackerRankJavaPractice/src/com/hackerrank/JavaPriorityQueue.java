//https://www.hackerrank.com/challenges/java-priority-queue/problem

package com.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class StudentSort implements Comparator<StudentJavaPriorityQueue> {

	@Override
	public int compare(StudentJavaPriorityQueue student1, StudentJavaPriorityQueue student2) {
		// CGPA (Desc), First Name (Asc), ID (Asc)
		int cgpaComp = (int) Double.compare(student1.getCgpa(), student2.getCgpa());
		int nameComp = student1.getName().compareTo(student2.getName());
		int idComp = Integer.compare(student1.getId(), student2.getId());
		if (cgpaComp != 0) {
			return -cgpaComp;
		} else if (nameComp != 0) {
			return nameComp;
		} else {
			return idComp;
		}
	}
}

class StudentJavaPriorityQueue {

	private int id;
	private String name;
	private double cgpa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public StudentJavaPriorityQueue(int id, String name, double cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.cgpa = cgpa;
	}

}

class Priorities {

	public List<StudentJavaPriorityQueue> getStudents(List<String> events) {
		int id = 1;
		List<StudentJavaPriorityQueue> temp = new ArrayList<StudentJavaPriorityQueue>();
		for (String event : events) {
			if (!event.equalsIgnoreCase("SERVED")) {
				String[] st = event.split(" ");
				String name = st[0];
				String cgpa = st[1];
				temp.add(new StudentJavaPriorityQueue(id, st[1], Double.parseDouble(st[2])));
				id++; // Increment the ID.
			} else {
				Collections.sort(temp, new StudentSort());
				if (temp.size() > 0) {
					temp.remove(0); // As it os sorted, we serve the first element.
				}
			}
		}
		return temp;
	}
}

public class JavaPriorityQueue {
	private final static Scanner scan = new Scanner(System.in);
	private final static Priorities priorities = new Priorities();

	public static void main(String[] args) {
		int totalEvents = Integer.parseInt(scan.nextLine());
		List<String> events = new ArrayList<>();

		while (totalEvents-- != 0) {
			String event = scan.nextLine();
			events.add(event);
		}

		List<StudentJavaPriorityQueue> students = priorities.getStudents(events);

		if (students.isEmpty()) {
			System.out.println("EMPTY");
		} else {
			for (StudentJavaPriorityQueue st : students) {
				System.out.println(st.getName());
			}
		}
	}
}