public class Rounding {
  public static void main(String[] args) {
    double x = 12.7;
    x--;
    int y = (int) Math.round(x);
    y -= 5;
    y++;
    System.out.printf("y = %d\n", y);
  }
}
