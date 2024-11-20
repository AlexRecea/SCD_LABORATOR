import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ClientSimplu {

        public static void main(String[] args)throws Exception{
                Socket socket=null;
                try {

                        InetAddress address =InetAddress.getByName("localhost");

//se putea utiliza varianta alternativă: InetAddress.getByName("127.0.0.1")

                        socket = new Socket(address,1900);

                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
// Output is automatically flushed  by PrintWriter:

                        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);

//                        for(int i = 0; i < 10; i ++) {
//                                out.println("mesaj " + i);
//                                String str = in.readLine();
//                                System.out.println(str);//aşteaptă răspuns
//                        }
                        Scanner scanner = new Scanner(System.in);
                        for (int i=0 ; i<10 ; i++){
//                                System.out.println("<>");
                                String raspuns = scanner.nextLine();
                                out.println(raspuns);
                                String str = in.readLine(); // citeste
                                System.out.println("S:" + str);

                        }

                        out.println("END");        //trimite mesaj care determină serverul să închidă conexiunea

                }
                catch (Exception ex) {ex.printStackTrace();}
                finally{
                        socket.close();
                }
        }
}
