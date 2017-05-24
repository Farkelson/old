import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JList;

public class calculate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(16);
		numbers.add(20);
		numbers.add(24);
		numbers.add(28);
		numbers.add(32);
		numbers.add(36);
		numbers.add(60);
		numbers.add(64);
		numbers.add(56);
		numbers.add(60);
		numbers.add(64);
		numbers.add(68);
		numbers.add(72);
		numbers.add(76);
		numbers.add(92);
		numbers.add(96);
		numbers.add(100);
		numbers.add(104);
		numbers.add(108);
		numbers.add(112);
		numbers.add(136);
		numbers.add(140);
		int offset = 1;
		int index = 0;
		int replaces = 0;
		int hits = 0;
		int misses = 0;
		double bestcpi = Integer.MAX_VALUE;
		int bestIndex = 0;
		int bestOffset = 0;
		int bestHits = 0;
		int bestMisses = 0;
		int bestStorage = 0;
		int cycles = 0;
		LinkedList<Integer> que = new LinkedList<Integer>();
		ArrayList<Integer> bestCache = new ArrayList<Integer>();
		ArrayList<String> bestCacheHit = new ArrayList<String>();
		String zeros = "0000000000000000";

		int rows = (int) Math.pow(2, index);
		while ((1 + (16 - index - offset) + (Math.pow(2, offset) * 8)) * rows <= 930) {
			index++;
			rows = (int) Math.pow(2, index);
			while ((1 + (16 - index - offset) + (Math.pow(2, offset) * 8))* rows <= 930) {
				hits = 0;
				misses = 0;
				cycles = 0;

				ArrayList<Integer> cache = new ArrayList<Integer>();
				ArrayList<String> cacheHit = new ArrayList<String>();

				for (int j = 0; j < rows; j++) {
					cache.add(-1);
				}

				for (int j = 0; j < numbers.size(); j++) {
					String num = Integer.toBinaryString(numbers.get(j));
					num = zeros.substring(num.length()) + num;
					int newIndex = Integer.parseInt(num.substring(16 - (index + offset), 16 - offset),2);
					cache.set(newIndex, Integer.parseInt(num.substring(0,16 - (index + offset))));
				}
				for (int j = 0; j < numbers.size(); j++) {
					String num = Integer.toBinaryString(numbers.get(j));
					num = zeros.substring(num.length()) + num;
					int newIndex = Integer.parseInt(num.substring(16 - (index + offset), 16 - offset),	2);
					if (cache.get(newIndex) == Integer.parseInt(num.substring(0, 16 - (index + offset)))) {
						hits++;
						que.add(j%rows);
						cacheHit.add(numbers.get(j)+ ":HIT");
						cycles++;
					} else {
						misses++;
						if(que.size()>= rows){
							newIndex = que.getFirst();
							que.removeFirst();
							que.add(j%rows);
						}
						else{
							que.add(j%rows);
						}
						cacheHit.add(numbers.get(j)+ ":MISSES");
						cycles += 18+Math.pow(2, offset);
						if (cache.get(newIndex) != -1) {
							replaces++;
						}
						cache.set(newIndex, Integer.parseInt(num.substring(0, 16 - (index + offset))));
					}
				}
				double cpi = cycles/22.0;
				if(cpi<bestcpi){
					bestcpi = cpi;
					bestIndex = index;
					bestOffset = offset;
					bestHits = hits;
					bestMisses = misses;
					bestStorage = (int) ((1 + (16 - index - offset) + (Math.pow(2, offset) * 8))* rows);
					bestCache = new ArrayList<Integer>(cache);
					bestCacheHit = new ArrayList<String>(cacheHit);
				}
				offset++;
			}
			offset=1;
		}
		System.out.println("Best CPI: " + bestcpi);
		System.out.println("Best Index: " + bestIndex);
		System.out.println("Best Offset: " + bestOffset);
		System.out.println("Best Hits: " + bestHits);
		System.out.println("Best Misses: " + bestMisses);
		System.out.println("Best Storage: " + bestStorage);
		for(int i =0; i<bestCache.size();i++){
			String padded = "";
			while(padded.length() < 16 - bestCache.get(i).toString().length()){
				padded = "0" + padded;
			}
			padded += bestCache.get(i);
			System.out.println(padded);
		}
		for(int i =0; i<bestCacheHit.size();i++){
			System.out.println(bestCacheHit.get(i));
		}
		
	}

}
