import java.lang.reflect.Field;

class Hand{
 private int amount;
    public Hand(){
        System.out.println("Hand Bro is a professional IT developer");
    }
    public void setAmount(int input){
        this.amount = input;
    }
    public int getAmount(){
        return this.amount;
    }
}

class Bro extends Hand{
    public Bro(){
        System.out.println("I go to school by bus");
    }
    public Bro(int input) throws Exception {
        System.out.println("Bro set input");
        Field field =this.getClass().getSuperclass().getDeclaredField("amount");field.setAccessible(true);field.set(this, input);
    }
}

public class Test{
    public static void main(String args[]) throws Exception {
        Bro bro = new Bro(50000);
        Field field =bro.getClass().getSuperclass().getDeclaredField("amount");field.setAccessible(true);
        System.out.println(field.get(bro));
    }
}