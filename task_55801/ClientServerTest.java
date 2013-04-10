package task_55801;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Evgen
 * Date: 29.03.13
 * Time: 21:47
 * To change this template use File | Settings | File Templates.
 */
public class ClientServerTest {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException {

        TestClient client = new TestClient();
        while (true){
            System.out.print("Enter request: ");
            String request = in.nextLine();
            client.setRequest(request);
            System.out.println(client.getResponse());
        }

    }
}
