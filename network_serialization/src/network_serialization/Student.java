package network_serialization;

import java.io.Serializable;



public class Student implements Serializable {
	
	private int studentAvg;
	private String studentName;
	
	 public Student(int avg, String name) {
		setStudentAvg(avg);
		setStudentName(name);
	}

	public int getStudentAvg() {
		return studentAvg;
	}

	public void setStudentAvg(int studentAvg) {
		this.studentAvg = studentAvg;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	
	
	 
	 
}
