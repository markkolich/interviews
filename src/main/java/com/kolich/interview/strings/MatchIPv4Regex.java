package com.kolich.interview.strings;

import static java.util.regex.Pattern.compile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchIPv4Regex {

	public static void main(String[] args) {
		
		// ^(?:[0-9]{1,3}\.){3}[0-9]{1,3}$
		
		final Pattern p = compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
		
		final String[] ips = new String[]{
			"255.255.255.255",
			"0.0.0.0",
			"256.255.255.255",
			"192.168.1.256",
			"192.168.1.0",
			"256.256.256.256",
		};
		
		for(int i = 0; i < ips.length; i++) {
			final Matcher m = p.matcher(ips[i]);
			System.out.println(ips[i] + " -> " + m.matches());
		}
		
	}

}
