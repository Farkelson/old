package fun;

public class Hailstone {

	public static void main(String[] args) {
		Hailstone();		
	}
	public static void Hailstone(){
		int i = 0;
		int n = 1;
		while (i!=1){
			if (n%2 == 0){
				n = n/2;
			}
				else n = 3*n + 1;
			n = i;
			
				
				
			}
			System.out.println(n);
		
	}

}
