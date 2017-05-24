//Scott Glass
//Jordon Phillips
package assignment3;

import java.util.ArrayList;
import java.util.Comparator;

public class SearchUtil {

	/**
	 * 
	 * @param <T>
	 *            The type of elements contained in the list
	 * @param list
	 *            An ArrayList to search through. This ArrayList is assumed to
	 *            be sorted according to the supplied comparator. This method
	 *            has undefined behavior if the list is not sorted.
	 * @param item
	 *            The item to search for
	 * @param cmp
	 *            Comparator for comparing Ts or a super class of T
	 * @return true if "item" exists in "list", false otherwise
	 */
	public static <T> boolean binarySearch(ArrayList<T> list, T item, Comparator<? super T> cmp) {
		{
			try {

				// calculate midpoint to cut set in half
				int mid = (list.size()) / 2;
					if (cmp.compare(list.get(mid), item) > 0) {
						// key is in lower subset
						ArrayList<T> lowArr = new ArrayList<T>();
						for (int i = 0; i < mid; i++) {
							lowArr.add(list.get(i));
						}
						return binarySearch(lowArr, item, cmp);
					} else if (cmp.compare(list.get(mid), item) < 0) {
						// key is in upper subset
						ArrayList<T> highArr = new ArrayList<T>();
						for (int i = list.size(); i > mid+1; i--) {
							highArr.add(0, list.get(i - 1));
						}
						return binarySearch(highArr, item, cmp);
					} else {
						// key has been found
						if (list.get(mid) == item) {
							return true;
						} else {
							return false;
						}
					}
			} catch (Exception e) {
				return false;
			}

		}
	}
}
