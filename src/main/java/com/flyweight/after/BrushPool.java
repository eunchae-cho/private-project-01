package com.flyweight.after;

import java.util.HashMap;
import java.util.Map;

public class BrushPool {

	Map<String, Brush> brushMap = new HashMap<>();

	public Brush getBrush(String pattern) {
		Brush brush = brushMap.get(pattern);
		if (brush == null) {
			System.out.printf(" %s 브러쉬 생성", pattern);
			brush = new Brush(pattern);
			brushMap.put(pattern, brush);
		}
		return brush;
	}
}
