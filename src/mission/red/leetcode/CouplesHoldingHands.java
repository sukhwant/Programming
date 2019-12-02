package mission.red.leetcode;

/**
 * https://leetcode.com/problems/couples-holding-hands/submissions/
 * 
 * @author sukhwanp
 *
 */
public class CouplesHoldingHands {

	public static void main(String[] args) {
		int[] input = { 0, 2, 1, 3 };
		CouplesHoldingHands couplesHoldinghands = new CouplesHoldingHands();

		System.out.println(couplesHoldinghands.minSwapsCouples(input));
	}

	private static int getPartner(int x) {
		return x % 2 == 0 ? x + 1 : x - 1;
	}

	private static int getGroup(int index) {
		return index % 2 == 0 ? index + 1 : index - 1;
	}

	private static int getGroupNumber(int index) {
		return index / 2;
	}

	private static int getStartElementOfGroup(int groupNumber) {
		return groupNumber * 2;
	}

	private int minSwapsCouples(int[] input) {
		boolean[] visited = new boolean[input.length / 2];
		int connectedComponent = 0;

		// iterate for all group
		for (int currGroup = 0; currGroup < visited.length; currGroup++) {
			if (!visited[currGroup]) {
				connectedComponent++;
				int start = -1;
				int currIndex = getStartElementOfGroup(currGroup);
//				System.out.println("Group number - " + currGroup + " Index number - " + currIndex);

				while (start != currGroup) {

					// Find partner and mark it visited.
					int partnerIndex = searchForPartner(currIndex, input);
					int nextIndexInGroup = getGroup(partnerIndex);
					int groupNumber = getGroupNumber(partnerIndex);
//					System.out.println("PartnerIndex - " + partnerIndex + " NextIndex - " + nextIndexInGroup
//							+ " groupNumber - " + groupNumber);

					visited[groupNumber] = true;
					start = groupNumber;
					currIndex = nextIndexInGroup;
				}
			}
			visited[currGroup] = true;
		}
		return visited.length - connectedComponent;
	}

	private int searchForPartner(int index, int[] input) {
		int partner = getPartner(input[index]);
		for (int i = 0; i < input.length; i++) {
			if (input[i] == partner) {
				return i;
			}
		}
		System.out.println("Should not come here....");
		return -1;
	}

}
