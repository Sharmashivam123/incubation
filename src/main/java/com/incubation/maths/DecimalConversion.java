package com.incubation.maths;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement:
Implement the method that provided numerator and denominator
 will return a string representing fraction's decimal form.
Some fractions in decimal form have cyclic decimal points.

 * @author Hp
 *
 */


public class DecimalConversion {
	
	String divide(int num, int den) {
		StringBuilder sb = new StringBuilder();
		sb.append((num/den));
		String recurringSeq = generateRecurringSequence(num, den);
		if(recurringSeq.length()!=0) {
			sb.append(".");
			sb.append(recurringSeq);
		}
		return sb.toString();
	}
	
	String generateRecurringSequence(int num, int den) {
		StringBuilder sb = new StringBuilder();
		num = num%den;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		while(num!=0 && !map.containsKey(num)) {
			map.put(num, sb.length());
			num*=10;
			int q = num/den;
			sb.append(q);
			num %= den;
		}
		
		if(num == 0)return sb.toString();
		
		if(map.containsKey(num)) {
			int startIndex = map.get(num);
			String recurringSeq = sb.substring(startIndex);
			String sub = sb.substring(0, startIndex);
			sb = new StringBuilder();
			sb.append(sub+"(");
			sb.append(recurringSeq+")");
		}
		return sb.toString();
	}
}
