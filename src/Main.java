import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        float average = 0, max;
        int people, i, j, numOfCashBox;
        int lineNumber, globalLine, mGlobalLine = 0;

        for (numOfCashBox = 1; numOfCashBox < 6; numOfCashBox++) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("cashbox" + numOfCashBox +".txt"))) {
                for (j = 0; j < 16; j++) {
                    for (i = 0; i < 6; i++) {
                        people = random.nextInt(11) + 1;
                        average += people;
                    }
                    bufferedWriter.write(Float.toString(average / 6) + "\n");
                    average = 0;
                    bufferedWriter.newLine();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        for (numOfCashBox = 1; numOfCashBox < 6; numOfCashBox++) {
            try (Scanner scanner = new Scanner(new File("cashbox" + numOfCashBox + ".txt"))) {
                max = 0;
                lineNumber = 0;
                globalLine = 0;
                while (scanner.hasNext()) {
                    average = Float.parseFloat(scanner.next());
                    if (average > max) {
                        max = average;
                        globalLine = lineNumber;
                    }
                    lineNumber++;
                }
                if(mGlobalLine < globalLine)
                {
                    mGlobalLine = globalLine;
                }

                if(globalLine % 2 == 0){
                    System.out.print(globalLine + "    " + ((globalLine/2) + 8));
                    System.out.println(":30");
                }
                else{
                    System.out.println(globalLine + "    " + ((globalLine/2) + 9) + ":00");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(mGlobalLine % 2 == 0){
            System.out.print("Пик" + "    " + ((mGlobalLine/2) + 8));
            System.out.println(":30");
        }
        else{
            System.out.println("Пик" + "    " + ((mGlobalLine/2) + 9) + ":00");
        }
//           try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("cashbox" + numOfCashBox +".txt"), "UTF-8"))){
//               max = Float.parseFloat(bufferedReader.readLine());
//               if(bufferedReader.readLine() != null){
//                   for (j = 0; j < 16; j++) {
//
//                       lineNumber++;
//                       System.out.println(lineNumber);
//                   }
//               }
//           }
//           catch (IOException ex){
//               ex.printStackTrace();
//           }
    }
}
