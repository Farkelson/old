package getShorty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

import getShorty.GetShorty.CorrDist;

public class GetShorty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kattio s = new Kattio(System.in, System.out);

		while(s.hasMoreTokens()){

//			String[] firstLine = s.getInt();
			int interNum = s.getInt();
			int corrNum = s.getInt();

			ArrayList<LinkedList<Integer>> intersections = new ArrayList<LinkedList<Integer>>();

			for(int i = 0; i<corrNum; i++){
				int corridorSource = s.getInt();
				int corridorDest = s.getInt();
				int corridorWeight = s.getInt();
				intersections.get(corridorSource).add(corridorDest);
				intersections.get(corridorDest).add(corridorSource);
			}
			
			ArrayList<Integer> dist = new ArrayList<Integer>(corrNum);
			ArrayList<Integer> prev = new ArrayList<Integer>(corrNum);
			
			for(int x: dist){
				dist.set(x, -1);
				prev.set(x, -1);
			}
			
			dist.set(0, 0);
			
			PriorityQueue<CorrDist> pq = new PriorityQueue<CorrDist>(interNum, new Comparator<CorrDist>() {
				public int compare(CorrDist v1, CorrDist v2) {
					return Integer.compare(v1.dist, v2.dist);
				}
			});
			pq.add(new CorrDist(0, 0));
			
			while (!pq.isEmpty()){
				CorrDist x = pq.poll();
				for(int y: intersections.get(x.node)){
				}
			}
			
			
		}
	}
	
	static class NodeDist {
		public int node;
		public int dist;
		
		public NodeDist(int node, int dist){
			this.node = node;
			this.dist = dist;
		}
	}
	
	static class CorrDist {
		public int node;
		public int dist;
		
		public CorrDist(int node, int dist){
			this.node = node;
			this.dist = dist;
		}
	}

}
