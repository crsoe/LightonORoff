
import com.fazecast.jSerialComm.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class ConsoleTerminal {

    private static SerialPort comPorts[];
    private static int port=-1;
    public static SerialPort comPort;
    public static StringBuilder text=new StringBuilder();  // will hiold a line of text to be parse for a float

    static String D;

    public ConsoleTerminal()
    {
        Scanner console = new Scanner(System.in);
        System.out.println("List COM ports");
        // read list of COM ports and display them
        comPorts = SerialPort.getCommPorts();
        if (comPorts.length < 1)           // if no COM ports found exit
        {
            System.out.println("no COM ports found");
            return;
        }
        // print list of COM ports, add to COMportMenu and attach event handler
        for (int i = 0; i < comPorts.length; i++) {
            System.out.println("comPort[" + i + "] = " + comPorts[i].getDescriptivePortName());
        }
        if (comPorts.length == 1)            // if 1 COM port found open it
        {
            port = 0;
            openCOMport();
        } else {
            System.out.print("\nEnter COM port (0, 1, 2 etc) to select serial port ");
            if (console.hasNextInt()) {
                port = console.nextInt();
                openCOMport();
            }
        }
        // loop read characters from keyboard transmit over serial
        //   read characters from serial and display them
        try {
            float x;
            while (true) {
                /*
                ******* No Keyboard input made *******

                // if keyboard token entered read it
                if(System.in.available() > 0)
                {
                    //System.out.println("enter chars ");
                    String s = console.nextLine() + "\n";                       // read text
                    byte[] writeBuffer=s.getBytes() ;
                    comPorts[port].writeBytes(writeBuffer, writeBuffer.length); // transmit it
                    //System.out.println("write " + writeBuffer.length);
                }

                 */
                // read serial port  and display data
                if (comPort.bytesAvailable() > 0) {
                    byte[] data = new byte[10];
                    comPort.readBytes(data, 1);
                    System.out.print((char) data[0]);
                    if ((char) data[0] >= ' ')
                        text.append((char) data[0]);  // if printable append to text
                    else
                        // ****  if end of line parse text for a float value  ****
                        if ((char) data[0] == '\n') {
                            System.out.println("new text array " + text);
                            x = Float.parseFloat(text.toString());
                            this.D = text.toString();
                            System.out.println("*** float value parsed " + x);
                            text.setLength(0);
                            FileWrite();
                        }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        comPorts[port].closePort();
    }

    private void FileWrite() {
        try {
            FileWriter myWriter = new FileWriter("Phototransistor.txt");

            int x = Integer.parseInt(D);

            if (x<20){
                myWriter.write("Light");
            }else {
                myWriter.write("Dark");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

        /*
        ******* Append to the .txt file *******

        try(FileWriter fw = new FileWriter("Phototransistor.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.write(D+"\n");
            //out.println("more text");
        } catch (IOException e) {
            System.out.println("Could not write to file");
        }
    }
 */

    // attempt to open COM port
    static void openCOMport () {
        comPort = SerialPort.getCommPorts()[port];
        System.out.println("attempting to open " + comPorts[port].getDescriptivePortName() + "\n");
        if (!comPort.openPort()) {
            System.out.println("failed to open COM port " + comPorts[port].getDescriptivePortName() + "\n");
            port = -1;
            return;
        }
        System.out.println("Opened COM port " + comPorts[port].getDescriptivePortName() + " OK\n");
        comPort.setBaudRate(9600);
    }


}

