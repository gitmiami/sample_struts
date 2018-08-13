package list;

import java.util.ArrayList;

class Member  {


    private String memberId;

	private ArrayList<Person> personList ;


    public ArrayList<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(ArrayList<Person> personList) {
		this.personList = personList;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}




}