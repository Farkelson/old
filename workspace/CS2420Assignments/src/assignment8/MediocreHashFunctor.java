package assignment8;

public class MediocreHashFunctor implements HashFunctor{

	public int hash(String item) {

		int total = 0;
		char[] x = item.toCharArray();
		for (int i = 0; i < x.length; i++) {
			int y = x[i];
			total = total + y;

		}
		return total;
	}

}
