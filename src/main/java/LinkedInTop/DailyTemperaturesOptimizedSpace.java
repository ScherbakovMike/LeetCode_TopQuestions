package LinkedInTop;

import java.util.Arrays;

public class DailyTemperaturesOptimizedSpace {

  public int[] dailyTemperatures(int[] temperatures) {
    var n = temperatures.length;
    var answer = new int[n];
    var hottestTemp = 0;

    for (var currDay = n - 1; currDay >= 0; currDay--) {
      var currentTemp = temperatures[currDay];
      if (currentTemp >= hottestTemp) {
        hottestTemp = currentTemp;
        continue;
      }
      var days = 1;
      while (temperatures[currDay + days] <= currentTemp) {
        days += answer[currDay + days];
      }
      answer[currDay] = days;
    }

    return answer;
  }

  public static void main(String[] args) {
    var temperatures = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
    // [1, 1, 4, 2, 1, 1, 0, 0]
    System.out.println(
        Arrays.toString(new DailyTemperaturesOptimizedSpace().dailyTemperatures(temperatures)));
  }
}
