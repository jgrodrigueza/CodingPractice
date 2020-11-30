//https://www.hackerrank.com/challenges/java-sort/problem

package com.hackerrank;

import java.util.*;

class Student {
	private int id;
	private String fname;
	private double cgpa;

	public Student(int id, String fname, double cgpa) {
		super();
		this.id = id;
		this.fname = fname;
		this.cgpa = cgpa;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public double getCgpa() {
		return cgpa;
	}
}

class StudentSort implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		// CGPA (Desc), First Name (Asc), ID (Asc)
		int cgpaComp = (int) Double.compare(student1.getCgpa(), student2.getCgpa());
		int nameComp = student1.getFname().compareTo(student2.getFname());
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

//Complete the code
public class JavaSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());

		List<Student> studentList = new ArrayList<Student>();
		while (testCases > 0) {
			int id = in.nextInt();
			String fname = in.next();
			double cgpa = in.nextDouble();

			Student st = new Student(id, fname, cgpa);
			studentList.add(st);

			testCases--;
		}
		Collections.sort(studentList, new StudentSort());
		for (Student st : studentList) {
			System.out.println(st.getFname());
		}
	}
}
