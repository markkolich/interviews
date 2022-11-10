package com.kolich.interview.other;

import java.util.*;

class Meeting implements Comparable<Meeting> {
	int id,start,end;
	public Meeting(int id,int start, int end) {
		this.id = id;
		this.start = start;
		this.end = end;
	}
	public int compareTo(Meeting o) {
		if(this.start>o.start)
			return 1;
		else if(this.start<o.start) return -1;
		else return 0;
	}
	public String toString() {
		return "{"+this.start+","+this.end+"}";
	}
}
class Conflict{
	List<Integer> meetings;
	int start, end;
	public Conflict(List<Integer> meetings,int start, int end) {
		this.meetings = meetings;
		this.start = start;
		this.end = end;
	}
}
public class ConflictMeetings {
	public static void main(String[] args) {
		int[][] meetings = {
					{12,17},
					{13,16},
					{14,15}
				};
		List<Meeting> list = new ArrayList<>();
		int id = 1;
		for(int i =0;i<meetings.length;i++) {
			
			Meeting m = new Meeting(id,meetings[i][0],meetings[i][1]);
			id++;
			list.add(m);
			
		}
		System.out.println(list);
		Collections.sort(list);
		getConflicts(list);
	}
	public static void getConflicts(List<Meeting> list) {
		
	}
}
