package assignment8;

public class GoodHashFunctor implements HashFunctor {

	public int hash(String item) {

		String total = "" + 1;
		char[] x = item.toCharArray();
		for (int i = 0; i < x.length && total.length() < 15; i++) {
			int y = x[i];
			total = total + y;
		}
		return (int) Math.abs(Long.parseLong(total));
	}

}
