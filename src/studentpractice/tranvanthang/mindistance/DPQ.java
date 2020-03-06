package studentpractice.tranvanthang.mindistance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.lang.Comparable;

public class DPQ {
	///////// Dijkstra su dung priority queue
	private int n;// //so dinh
	private int[] dist;// /distace
	private Set<Integer> mark;// ////danh dau cac dinh da xet
	public List<List<Node_list>> list_ke;
	public PriorityQueue<Node_pq> pq;

	public DPQ(int a) {
		n = a;
		dist = new int[a];
		mark = new HashSet<Integer>();
		pq = new PriorityQueue<Node_pq>();
	}

	public void Dijkstra() {
		//this.list_ke = list_ke;
		while (mark.size() != n) {
			int u = pq.remove().dinh;
			mark.add(u);
			fixed(u);
		}
	}

	public void fixed(int u) {
		for (int i = 0; i < list_ke.get(u).size(); i++) {
			Node_list v = list_ke.get(u).get(i);
			if (!mark.contains(v.dinh_ke)) {
				int newdistance = dist[u] + v.sub_distance;
				if (newdistance < dist[v.dinh_ke]) {
					dist[v.dinh_ke] = newdistance;
				}
				pq.add(new Node_pq(v.dinh_ke, dist[v.dinh_ke]));

			}
		}
	}
	public void getData(String filename){
		
	}

	public static void main(String[] args) {
		DPQ dpq = new DPQ(5);
		dpq.list_ke = new ArrayList<List<Node_list>>();
		for (int i = 0; i < dpq.n; i++) {
			List<Node_list> temp = new ArrayList<Node_list>();
			dpq.list_ke.add(temp);
		}
		dpq.pq.add(new Node_pq(0, 0));
		dpq.dist[0] = 0;
		// Inputs for the DPQ graph
		dpq.list_ke.get(0).add(new Node_list(1, 9));
		dpq.list_ke.get(0).add(new Node_list(2, 6));
		dpq.list_ke.get(0).add(new Node_list(3, 5));
		dpq.list_ke.get(0).add(new Node_list(4, 3));
		dpq.list_ke.get(2).add(new Node_list(1, 2));
		dpq.list_ke.get(2).add(new Node_list(3, 4));
		///////////nho  bo sung them tinh nang doc tu file 

		
		///init
		for (int i = 1; i < 5; i++) {
			dpq.dist[i] = 100;
		}
		dpq.Dijkstra();
		for (int i = 0; i < dpq.dist.length; i++)
			System.out.println(1 + " den " + (i + 1) + " la " + dpq.dist[i]);

	}
}

// ///Node_pq la Node de danh cho pq
class Node_pq implements Comparable<Node_pq> {
	public int dinh;;
	public int distance;// /// la khoang canh nho nhat hien tai tinh tu dinh dang xet den dinh nguon

	public Node_pq() {

	}

	public Node_pq(int dinh, int distance) {
		this.dinh = dinh;
		this.distance = distance;
	}

	// ////compare nay thuc chat de su dung khi heap cua preority quenethoi
	public int compareTo(Node_pq node2) {
		if (this.distance > node2.distance)
			return 1;
		if (this.distance < node2.distance)
			return -1;

		return 0;
	}
}

// //Node nay danh cho list
class Node_list {
	public int dinh_ke;;
	public int sub_distance;// /// la khoang canh tu dinh ddang xet den dinh
							// (dinh_ke)

	public Node_list() {

	}

	public Node_list(int dinh_ke, int sub_distance) {
		this.dinh_ke = dinh_ke;
		this.sub_distance = sub_distance;
	}
}
