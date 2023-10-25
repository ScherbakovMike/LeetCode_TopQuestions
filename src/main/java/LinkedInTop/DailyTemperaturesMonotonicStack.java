package LinkedInTop;

import java.util.Arrays;
import java.util.LinkedList;

public class DailyTemperaturesMonotonicStack {

  public int[] dailyTemperatures(int[] temperatures) {
    var n = temperatures.length;
    var answer = new int[n];
    var stack = new LinkedList<Integer>();

    for (var currDay = 0; currDay < n; currDay++) {
      var currentTemp = temperatures[currDay];
      // pop until the current day's temperature is not
      // warmer the temperature at the top of the stack
      while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
        var prevDay = stack.pop();
        answer[prevDay] = currDay - prevDay;
      }
      stack.push(currDay);
    }

    return answer;
  }

  public static void main(String[] args) {
    var temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
    // [1, 1, 4, 2, 1, 1, 0, 0]
    System.out.println(Arrays.toString(
        new DailyTemperaturesMonotonicStack().dailyTemperatures(temperatures)));
  }
}
