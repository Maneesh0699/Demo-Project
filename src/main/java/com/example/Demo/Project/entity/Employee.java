package com.example.Demo.Project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Eid;
	private String Ename;
	private String Eadress;
	private long Esalary;
	public int getEid() {
		return Eid;
	}
	public void setEid(int eid) {
		Eid = eid;
	}
	public String getEname() {
		return Ename;
	}
	public void setEname(String ename) {
		Ename = ename;
	}
	public String getEadress() {
		return Eadress;
	}
	public void setEadress(String eadress) {
		Eadress = eadress;
	}
	public long getEsalary() {
		return Esalary;
	}
	public void setEsalary(long esalary) {
		Esalary = esalary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int eid, String ename, String eadress, long esalary) {
		super();
		Eid = eid;
		Ename = ename;
		Eadress = eadress;
		Esalary = esalary;
	}
	@Override
	public String toString() {
		return "Emplyee [Eid=" + Eid + ", Ename=" + Ename + ", Eadress=" + Eadress + ", Esalary=" + Esalary + "]";
	}
	
	
	
	
	

}
