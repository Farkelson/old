package spidermanWorkout;

import java.io.*;

class spiderman 
{



	static int[]  d = new int[50];
	static int[][]  minh = new int[50][1010];
	static char[][] move = new char[50][1010];

	/*
	 * minh[i][h] = lowest max height above ground to be at height h
	 *             after distances d[0]..d[i]
	 * 
	 * move[i][h] = move to make for distance d[i] to end up at h in
	 *              while achieving minh[i][h]
	 */

	static BufferedReader stdin = 
			new BufferedReader(new InputStreamReader(System.in));
	static StreamTokenizer tokens = new StreamTokenizer(stdin);

	static final int max(int a, int b) 
	{
		return a > b ? a : b;

	}

	static BufferedWriter stdout = 
			new BufferedWriter(new OutputStreamWriter(System.out));


	static int getInt() throws IOException
	{
		tokens.nextToken();
		return (int)Math.round(tokens.nval);
	}

	static final int infty = 1000000000;

	static void solve() throws IOException
	{
		int m = getInt();

		int tot = 0;

		for (int i = 0; i < m; ++i) {
			d[i] = getInt();
			tot += d[i];
		}

		for (int i = 0; i < m; ++i)
			for (int j = 0; j <= tot; ++j)
				minh[i][j] = infty;

		minh[m-1][d[m-1]] = d[m-1];
		move[m-1][d[m-1]] = 'D';
		for (int i = m-2; i >= 0; --i)
			for (int h = 0; h <= tot; ++h) {
				if (minh[i+1][h] != infty) {
					if (h >= d[i]) { // try climbingup from h-d[i]
						if (minh[i][h-d[i]] > minh[i+1][h]) {
							minh[i][h-d[i]] = minh[i+1][h];
							move[i][h-d[i]] = 'U';
						}
					}
					// try climbing down from h + d[i]
					int newminh = max(minh[i+1][h], h+d[i]);
					if (minh[i][h+d[i]] > newminh) {
						minh[i][h+d[i]] = newminh;
						move[i][h+d[i]] = 'D';
					}
				}
			}

		if (minh[0][0] == infty) 
			stdout.write("IMPOSSIBLE");
		else {
			int h = 0;
			for (int i = 0; i < m; ++i) {
				//	System.out.print(move[i][h]);
				stdout.write(move[i][h]);

				if (move[i][h] == 'U') h += d[i];
				else h -= d[i];
			}

		}
		stdout.newLine();
	}



	public static void  main(String[]  s) throws IOException
	{
		int n = getInt();

		for ( ; n > 0; --n)
			solve();
		stdout.close();

	}
}