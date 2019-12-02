package leetcode.mission.red;
import java.util.Map;
import java.util.TreeMap;

class MyCalendarThree {

	TreeMap<Integer, Integer> map;

	public MyCalendarThree() {
		this.map = new TreeMap<>();
	}

	public int book(int start, int end) {
		map.put(start, map.getOrDefault(start, 0) + 1);
		map.put(end, map.getOrDefault(end, 0) - 1);
		int ans = 0;
		int ongoing = 0;

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			ongoing += entry.getValue();
			ans = Math.max(ans, ongoing);
		}
		//System.out.println(ans);
		return ans;
	}

	public static void main(String[] args) {
		MyCalendarThree calendar = new MyCalendarThree();

		calendar.book(10, 20); // returns 1
		calendar.book(50, 60); // returns 1
		calendar.book(10, 40); // returns 2
		calendar.book(5, 15); // returns 3
		calendar.book(5, 10); // returns 3
		calendar.book(25, 55); // returns 3
	}
}
