import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ServerSimplu {
    public static void main(String[] args) throws IOException{

        ServerSocket ss=null;
        Socket socket=null;
        try{
            String line="";
            ss = new ServerSocket(1900);    //crează obiectul serversocket
            System.out.println("astept conexuni");

            socket = ss.accept(); //incepe aşteptarea pe portul 1900

//în momentul în care un client s-a conectat ss.accept() returnează
//un socket care identifică conexiunea
//crează fluxurile de intrare/ieşire
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            PrintWriter out = new PrintWriter(
                    new BufferedWriter(new OutputStreamWriter(
                            socket.getOutputStream())),true);

            Scanner scanner = new Scanner(System.in);
            while(!line.equals("END")){
                line = in.readLine(); //citeste datele de la client
                System.out.println("C:" + line);
                //out.println("ECHO "+ line);       //trimite date la client

                String raspuns = scanner.nextLine();
                out.println(raspuns);
            }

        }catch(Exception e){e.printStackTrace();}
        finally{
            ss.close();
            if(socket!=null) socket.close();
        }
    }
}
