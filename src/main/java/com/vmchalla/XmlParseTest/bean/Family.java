package com.vmchalla.XmlParseTest.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * This pojo contains the members of a family in a list.
 * Later let us try to put that in a Tree Structure.
 * @author Vmchalla
 *
 */
public class Family {
	private List<Member> members=new ArrayList<Member>();

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	@Override
	public String toString() {
		return "Family \n[members=\n" + members + "] \n";
	}
	
	public boolean addMember(Member member){
		return members.add(member);
	}
	
	//A method that created a tree structure of the list given and sends back the DataStructure.
	

}
