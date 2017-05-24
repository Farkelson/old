package assignment1;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{
		numRows = d.length; // d.length is the number of 1D arrays in the 2D array
		if(numRows == 0)
			numColumns = 0;
		else
			numColumns = d[0].length; // d[0] is the first 1D array
		data = new int[numRows][numColumns]; // create a new matrix to hold the data
		// copy the data over
		for(int i=0; i < numRows; i++) 
			for(int j=0; j < numColumns; j++)
				data[i][j] = d[i][j];
	}
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public boolean equals(Object o)
	{
		if(!(o instanceof Matrix)) // make sure the Object we're comparing to is a Matrix
			return false;
		Matrix m = (Matrix)o; // if the above was not true, we know it's safe to treat 'o' as a Matrix
		if(numRows!=m.numRows||numColumns!=m.numColumns){
			return false;
		}
		for(int i=0; i < m.numRows; i++) 
			for(int j=0; j < m.numColumns; j++)
				if(data[i][j] != m.data[i][j]){
					return false;
				}
		return true;
	}
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{
		String s="";
		for (int i = 0; i<numRows; i++){
			for(int j=0;j<numColumns; j++){
				s+= (data[i][j]+" ");
				if(j==numColumns-1){
					s+=("\n");
				}
			}
		}
		return s;
	}
	
	public Matrix times(Matrix m)
	{
		if (numColumns!=m.numRows){
			System.out.println("ERROR: Matrices are not compatible for multiplication!");
			return null;
		}
		Matrix a = new Matrix (new int [numRows][m.numColumns]);
		for(int i=0; i<numRows;i++){
			for(int j=0; j<m.numColumns;j++){
				for(int k=0; k<numColumns;k++){
					a.data[i][j]+=(data[i][k]*m.data[k][j]);
				}
			}
		}
		return a;
	}
	
	public Matrix plus(Matrix m)
	{
		if (numColumns!=m.numColumns || numRows!=m.numRows){
			System.out.println("ERROR: Matrices are not compatible for addition!");
			return null;
		}
		Matrix b = new Matrix (new int [numRows][m.numColumns]);
		for(int i=0; i<numRows;i++){
			for(int j=0; j<m.numColumns;j++){
				b.data[i][j] =(data[i][j]+m.data[i][j]);
			}
		}
		return b;
	}
}