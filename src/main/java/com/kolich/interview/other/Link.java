package com.kolich.interview.other;

public class Link {
	int v;
	Link next;
	public Link(){
		this.next=null;
	}
	public Link(int v)
	{
		this.v=v;
	}
	
	public String toString()
	{
		return this.v +"";
	}
}
