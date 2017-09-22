package hackerrank.algorithms;
import java.util.Scanner;

public class DFSBiggestRegion {

	private static boolean isInRange(int[][] matrix, int row, int col) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		
		return (row>=0 && row < rows &&
				col>=0 && col < cols &&
				matrix[row][col]==1);
	}
	
	public static int dfs(int[][] matrix, int row, int col) {
		if (!isInRange(matrix, row, col)) {
			return 0;
		}
		matrix[row][col] = 0;//mark as visited
		
		int regionCount = 1;//count myself
		
		for (int i=row-1; i<=row+1; i++) {
			for (int j=col-1; j<=col+1; j++) {
				if (i!=row || j!=row) 
					regionCount+=dfs(matrix, i, j);
			}
		}
		return regionCount;
	}
	
	public static int getBiggestRegion(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int maxR = 0;
		int curR = 0;
		for(int row = 0 ; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				
				if (matrix[row][col]==1) {
					curR = dfs(matrix, row, col);
					if (curR>maxR) 
						maxR = curR;
				}
				
			}
		}
		return maxR;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int grid[][] = new int[n][m];
		for (int grid_i = 0; grid_i < n; grid_i++) {
			for (int grid_j = 0; grid_j < m; grid_j++) {
				grid[grid_i][grid_j] = in.nextInt();
			}
		}
		System.out.println(getBiggestRegion(grid));
		in.close();
	}
}