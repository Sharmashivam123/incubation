package com.incubation.strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement-
Given an Apache log file, return IP address(es) which accesses the site most often.     
our log is in this format (Common Log Format). One entry per line.
10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] "GET /a.gif HTTP/1.0" 200 234     
Log file entries are passsed as an array.     
NOTE: In case of tie, this returns a comma-separated list of the IP addresses. Tie is not mentioned explicitly in the exercise on purpose.

Signature:
                String findTopIpaddress(String[] lines){
                }

Test Cases:
Input:
String lines[] = new String[]{
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234"};
Output : 10.0.0.1

Input: 
String  lines[] = new String[]{
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:59 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.3 - logan [10/Dec/2000:12:34:59 -0500] \"GET /d.gif HTTP/1.0\" 200 234",};
Output - 10.0.0.1,10.0.0.2

 * @author Hp
 *
 */
public class ApacheLog {

	static String findTopIpaddress(String[] lines){
		Map<String, Integer> map = new HashMap<>();
		for(String s : lines) {
			int index = s.indexOf(" ");
			String ip = s.substring(0, index);
			map.compute(ip, (k, v)->v==null?1:1+v);
		}
		int max = 0;
		for(int x : map.values()) {
			max = Math.max(x, max);
		}
		
		StringBuilder sb = new StringBuilder();
		for(String key : map.keySet()) {
			if(map.get(key)==max) {
				sb.append(key+",");
			}
		}
		return sb.substring(0, sb.length()-1);
    }
	public static void main(String []args) {
		String  lines[] = new String[]{
                "10.0.0.1 - frank [10/Dec/2000:12:34:56 -0500] \"GET /a.gif HTTP/1.0\" 200 234",
                "10.0.0.1 - frank [10/Dec/2000:12:34:57 -0500] \"GET /b.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:58 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.2 - nancy [10/Dec/2000:12:34:59 -0500] \"GET /c.gif HTTP/1.0\" 200 234",
                "10.0.0.3 - logan [10/Dec/2000:12:34:59 -0500] \"GET /d.gif HTTP/1.0\" 200 234",};
		System.out.println(findTopIpaddress(lines));
	}
}
