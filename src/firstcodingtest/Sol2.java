package firstcodingtest;
import java.util.Collections;
import java.util.List;

public class Sol2 {

	int cornerlevelField(int numRows, int numColumns, List<List<Integer>> field) {
		// WRITE YOUR CODE HERE
		
		int max = -1;
		for (int i=0; i<numColumns; i++) {
			List<Integer> row = field.get(0);
			int maxRow = Collections.max(row);
			
			if (maxRow>max)
				max = maxRow;
		}
		return max;
	}
}