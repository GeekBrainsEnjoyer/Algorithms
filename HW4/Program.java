import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Program {
    public static void main(String[] args) {
        final BinTree bt = new BinTree();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)))) {
            while (true) {
                try {
                    int val = Integer.parseInt(reader.readLine());
                    bt.add(val);
                    System.out.println("finish");

                } catch (Exception ignored) {

                }
            }
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
