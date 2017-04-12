package com.sqlite.tfnews2;

public class News {
	public int ID=-1;
	public String name;
	public String part;

	public String toString(){
		String result="";
		result += this.part;
		return result;
	}
}