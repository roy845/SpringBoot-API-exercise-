package com.example.demo.dto;

import java.util.List;

public class ArrayInput<T> {
	private List<T> list1;
	private List<T> list2;
	
	  public ArrayInput(List<T> list1, List<T> list2) {
		this.list1 = list1;
		this.list2 = list2;
	}

	public List<T> getList1() {
	        return list1;
	    }

	    public void setList1(List<T> list1) {
	        this.list1 = list1;
	    }

	    public List<T> getList2() {
	        return list2;
	    }

	    public void setList2(List<T> list2) {
	        this.list2 = list2;
	    }
	
}
