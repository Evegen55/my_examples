package Java8;

public class GenericsChallenge2 {

   public static void main(String[] args) {
      Archer archer = new Archer();
      archer.attack("->");
      archer.attack("->");
      archer.attack("->");
   }

   static class Archer <T> {
      private T t;
      void attack(T t) {
         System.out.println(this.t);
      }
   }
}
