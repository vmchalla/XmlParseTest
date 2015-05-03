package com.vmchalla.XmlParseTest.bean;

public class Member {
	
	private String name;
	private int age;
	private String occupation;
	private String relationToFamilyHead;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getRelationToFamilyHead() {
		return relationToFamilyHead;
	}
	public void setRelationToFamilyHead(String relationToFamilyHead) {
		this.relationToFamilyHead = relationToFamilyHead;
	}
	
	public String getRelationTo(Member otherMember){
		
		return null;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", occupation="
				+ occupation + ", relationToFamilyHead=" + relationToFamilyHead
				+ "] \n";
	}
	
	
	
	

}
