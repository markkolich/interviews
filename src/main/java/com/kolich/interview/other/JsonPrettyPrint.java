package com.kolich.interview.other;

//pretty print a json string




public class JsonPrettyPrint {
	public static String insertTabs(int tabCount)
	{
		StringBuffer sb=new StringBuffer();
		int tempTab=0;
		while(tempTab<tabCount)
		{
			sb.append('\t');
			tempTab++;
		}
		return sb.toString();
	}
	public static String pretty(String s)
	{
		String ans="";
		StringBuffer sb=new StringBuffer();
		int tabCount=0;
		for(int i =0;i<s.length();i++)
		{
			char c=s.charAt(i);
			if(c=='{' || c=='[')
			{
			tabCount++;
			sb.append(c);
			sb.append('\n');
			sb.append(insertTabs(tabCount));
			}
			else if(c==',')
			{
				sb.append(c);
				sb.append('\n');
			
			sb.append(insertTabs(tabCount));
			}
			else if(c=='}' || c==']')
			{
				sb.append('\n');
				tabCount--;
				sb.append(insertTabs(tabCount));
				sb.append(c);
			}
			else if(c =='\n' || c =='\r')
				continue;
			else 
			sb.append(c);
		}
		//System.out.println(sb.toString());
		ans=sb.toString();
		return ans;
	}
	public static void main(String args[])
	{
		//System.out.println(s);
		//System.out.println(s);
		 String s="{\"First-Element\":1,\"Second-Element\":[\"first\":1,\"second\":2,\"third\":3],\"Last Element\":3,precision:\"zip\"}";
		 System.out.println(s);
		 System.out.println("---------------------------------------------------------------------------\nPretty printed");
		
		System.out.println(pretty(s));
		
	}
}


/*
 * {
  "First-Element":1,
  "Second-Elemnent:
  					[
  					 "first":1,
 					 "second":2],
  "Last Element":3
  }
 * */
//{ First-Element:1,Second-Elemnent:["first":1, "second":2], "Last Element":3}