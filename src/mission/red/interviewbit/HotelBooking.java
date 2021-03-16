package mission.red.interviewbit;

import java.util.ArrayList;
import java.util.Comparator;

public class HotelBooking {

    public class Schedule{
        Integer start;
        Integer end;

        public Schedule(final Integer start, final Integer end) {
            this.start = start;
            this.end = end;
        }
    }
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

        ArrayList<Schedule> input = new ArrayList<>();
        for (int i = 0; i < arrive.size(); i++) {
            input.add(new Schedule(arrive.get(i), depart.get(i)));
        }

        input.sort(Comparator.comparingInt(x -> x.end));

        int availableRoom = K;

        Schedule curr = input.get(0);

        for (int i = 1; i < input.size(); i++) {
            if(input.get(i).start <= curr.end){
                availableRoom++;
                if(availableRoom > K){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
