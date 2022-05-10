
import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) throws IOException {

        String hostName = null;
        int portNumber = 7777;
        DataOutputStream outt;

        if (args.length != 2) {
            System.err.println(
                    "Usage: CONNECT <USER>");
            hostName = "localhost";
            portNumber = 7777;
            // System.exit(1);
        } else {
            hostName = args[0];
            portNumber = Integer.parseInt(args[1]);
        }

        try {
            Socket echoSocket = new Socket(hostName, portNumber);

            PrintWriter out
                    = new PrintWriter( echoSocket.getOutputStream() , true);

            BufferedReader in
                    = new BufferedReader(
                    new InputStreamReader( echoSocket.getInputStream() ));

            BufferedReader teclado
                    = new BufferedReader(
                    new InputStreamReader( System.in ) );

            String userInput;
            boolean entrar = false;
            while (!entrar) {
                userInput = teclado.readLine();


                String[] entrada = userInput.split(" ");
                if (entrada[0].equals("CONNECT") || entrada[0].equals("connect")) {

                    System.out.println("Hola," + entrada[1]);
                    entrar = true;
                } else {
                    System.err.println(
                            "Usage: CONNECT <USER>");
                }
            }
            while ((userInput = teclado.readLine()) != null) {



                        if( userInput.trim().equals(".") ) {
                            out.println(userInput);
                            break;}
                                else {
/*
                            outt = new DataOutputStream(echoSocket.getOutputStream());
                            outt.writeUTF(userInput);
*/
                            out.println( userInput ) ;
                        }
                        System.out.println("user: " + in.readLine());
                    }




        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to "
                    + hostName);
            System.exit(1);
        }
    }


}