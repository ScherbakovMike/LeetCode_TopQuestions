package LinkedInTop;

public class CanPlaceFlowers {

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    short count = 0;
    short i = 0;
    while (count < n && i < flowerbed.length) {
      if (flowerbed[i] == 0
          && ((((i - 1) < 0) || flowerbed[i - 1] == 0)
              && ((i + 1) >= flowerbed.length || flowerbed[i + 1] == 0))) {
        count++;
        flowerbed[i] = 1;
      }
      i++;
    }
    return count == n;
  }

  public static void main(String[] args) {
    //    var flowerbed = new int[]{1, 0, 0, 0, 1};
    //    System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, 1));
    //    System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, 2));

    var flowerbed = new int[] {0, 0, 0, 0, 0};
    System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, 2));

    //    var flowerbed = new int[]{0, 0, 1, 0, 1};
    //    System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, 1));

    //    var flowerbed = new int[]{1, 0, 0, 0, 0, 0, 0, 1};
    //    System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, 2));
    //    System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, 3));

    //    var flowerbed = new int[]{1, 0, 1, 0, 0, 0, 0, 0};
    //    System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, 2));

    //    var flowerbed = new int[]{1, 0, 1, 0, 0, 0, 0, 0, 0};
    //    System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, 3));

    //    var flowerbed = new int[]{1, 0, 1, 0, 1, 0, 1};
    //    System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, 1));

    //    var flowerbed = new int[]{1, 0, 0, 0, 1, 0, 0};
    //    System.out.println(new CanPlaceFlowers().canPlaceFlowers(flowerbed, 2));
  }
}
