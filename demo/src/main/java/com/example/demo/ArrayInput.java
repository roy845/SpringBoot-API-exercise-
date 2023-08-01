package com.example.demo;

import java.util.List;

public class ArrayInput {
	private List<Character> list1;
	private List<Character> list2;
	
	  public ArrayInput(List<Character> list1, List<Character> list2) {
		this.list1 = list1;
		this.list2 = list2;
	}

	public List<Character> getList1() {
	        return list1;
	    }

	    public void setList1(List<Character> list1) {
	        this.list1 = list1;
	    }

	    public List<Character> getList2() {
	        return list2;
	    }

	    public void setList2(List<Character> list2) {
	        this.list2 = list2;
	    }
	
}
