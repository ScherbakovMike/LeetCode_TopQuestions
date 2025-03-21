package Array.SortColors;

public class SortColors {

    public static int[] sortColors(int[] colors) {
        var pos0 = 0;
        var pos2 = colors.length - 1;
        var i = 0;
        while (i <= pos2) {
            if (colors[i] == 2) {
                if (i == pos2) {
                    i++;
                    pos2--;
                    continue;
                }
                // move this number to the end
                var buf = colors[pos2];
                colors[pos2] = colors[i];
                colors[i] = buf;
                pos2--;
            } else if (colors[i] == 0) {
                if (i == pos0) {
                    i++;
                    pos0++;
                    continue;
                }
                // move this number to the beginning
                var buf = colors[pos0];
                colors[pos0] = colors[i];
                colors[i] = buf;
                pos0++;
            } else i++;
        }
        return colors;
    }

    public static void main(String[] args) {
        var colors = new int[]{2, 0, 2, 1, 1, 0};
//        var colors = new int[]{1, 1, 0, 2};
//        var colors = new int[]{0,1,0};
//        var colors = new int[]{2, 1, 1, 0, 0};
        var result = sortColors(colors);
        for (var color : result) {
            System.out.print(color + " ");
        }
    }
}
