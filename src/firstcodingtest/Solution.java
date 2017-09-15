package firstcodingtest;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution {

	public static void main(String[] args) {

		Solution sol = new Solution();

		List<String> group1 = new ArrayList<String>();

		group1.add("apple");
		group1.add("apple");

		List<String> group2 = new ArrayList<String>();

		group2.add("banana");
		group2.add("anything");
		group2.add("banana");

		List<List<String>> codeList = new ArrayList<List<String>>();
		codeList.add(group1);
		codeList.add(group2);

		List<String> shoppingCart = new ArrayList<String>();
		shoppingCart.add("orange");
		shoppingCart.add("apple");
		shoppingCart.add("apple");
		shoppingCart.add("banana");
		shoppingCart.add("orange");
		shoppingCart.add("banana");

		System.out.println(sol.checkWinner(codeList, shoppingCart));
	}

	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	public int checkWinner(List<List<String>> codeList, List<String> shoppingCart) {
		// WRITE YOUR CODE HERE
		

		int i = 0;
		int groupsVerified = 0;
		//iterate through groups
		while (groupsVerified < codeList.size() && i < shoppingCart.size()) {
			
			// take first group
			Iterator<List<String>> groups = codeList.iterator();
			List<String> group = groups.next();
			groupsVerified = 0;
			
			while (groupsVerified < codeList.size() && i < shoppingCart.size()) {
				
				boolean groupOK = verifyGroup(group, shoppingCart, i);

				if (groupOK) {
					i += group.size();
					groupsVerified++;
					if (groupsVerified < codeList.size())
						group = groups.next();
				} else {
					i++;
				}
			}
		}
		if (groupsVerified==codeList.size()) {
			return 1;
		} else {
			return 0;
		}
	}
	// METHOD SIGNATURE ENDS

	private boolean verifyGroup(List<String> group, List<String> shoppingCart, int index) {
		// the items must be exactly the same, except for the term anything
		//if (group.size() != shoppingCart.size())
		//	return false;
//		if (shoppingCart.size()-index < group.size())
//			return false;

		Iterator<String> cartItems = shoppingCart.iterator();
		Iterator<String> groupItems = group.iterator();
		
		//skip elements already cheked
		for (int i=0; i<index; i++) {
			if (cartItems.hasNext())
				cartItems.next();
		}
		
		if (!cartItems.hasNext())
			return false;
		
		// iterate through group items
		while (groupItems.hasNext()) {
			// take an item
			String gItem = groupItems.next();
			
			if (!cartItems.hasNext())
				return false;
			
			String cItem = cartItems.next();

			if (gItem.equalsIgnoreCase("anything"))
				continue;
			if (!gItem.equalsIgnoreCase(cItem))
				return false;
		}
		return true;
	}
}