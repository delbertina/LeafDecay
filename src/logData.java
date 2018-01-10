import javafx.concurrent.Task;

import java.io.*;
import java.util.ArrayList;

public class logData {
    private int lines;
    private int joins;
    private int leaves;
    private int chats;

    private ArrayList<String> chatTimes;
    private int[][] chatPoints;
    private int chatStart;

    private ArrayList<String> joinTimes;
    private int[][] joinPoints;
    private int joinStart;

    private ArrayList<String> leaveTimes;
    private int[][] leavePoints;
    private int leaveStart;

    private File latestLog;

    public logData() throws IOException{

        this.lines = 0;
        this.joins = 0;
        this.leaves = 0;
        this.chats = 0;

        this.chatTimes = new ArrayList<>();
        this.chatPoints = new int[12][24];
        this.joinTimes = new ArrayList<>();
        this.joinPoints = new int[12][24];
        this.leaveTimes = new ArrayList<>();
        this.leavePoints = new int[12][24];

        this.latestLog = new File("src/latest.txt");
    }

    public int[][] getChatPoints(){
        return this.chatPoints;
    }

    public int[][] getJoinPoints(){
        return this.joinPoints;
    }

    public int[][] getLeavePoints(){
        return this.leavePoints;
    }

    private void setChatPoints(int[][] input){
        this.chatPoints = input;
    }

    private void setJoinPoints(int[][] input){
        this.joinPoints = input;
    }

    private void setLeavePoints(int[][] input){
        this.leavePoints = input;
    }

    public void eatFile() throws InterruptedException{
        //count the lines in file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(latestLog));

            String line = reader.readLine();
            String joinMessage = "joined the game";
            String leaveMessage = "left the game";
            String chatMessage = "async chat thread";

            while (line != null) {
                if (line.toLowerCase().contains(joinMessage.toLowerCase())) {
                    this.joinTimes.add(line.charAt(1) + "" + line.charAt(2) + ":" + line.charAt(4) + line.charAt(5));
                    if (joins == 0) {
                        this.joinStart = Integer.parseInt(line.charAt(1) + line.charAt(2) + "");
                    }
                    joins++;
                } else if (line.toLowerCase().contains(leaveMessage.toLowerCase())) {
                    this.leaveTimes.add(line.charAt(1) + "" + line.charAt(2) + ":" + line.charAt(4) + line.charAt(5));
                    if (leaves == 0) {
                        this.leaveStart = Integer.parseInt(line.charAt(1) + line.charAt(2) + "");
                    }
                    leaves++;
                } else if (line.toLowerCase().contains(chatMessage.toLowerCase())) {
                    this.chatTimes.add(line.charAt(1) + "" + line.charAt(2) + ":" + line.charAt(4) + line.charAt(5));
                    if (chats == 0) {
                        this.chatStart = Integer.parseInt(line.charAt(1) + line.charAt(2) + "");
                    }
                    chats++;
                }
                lines++;
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Task task1 = new Task<Void>() {
            @Override
            public Void call() {
                setChatPoints(breakTimes(chatTimes));
                return null;
            }
        };

        Thread thread1 = new Thread(task1);

        Task task2 = new Task<Void>() {
            @Override
            public Void call() {
                setJoinPoints(breakTimes(joinTimes));
                return null;
            }
        };

        Thread thread2 = new Thread(task2);

        Task task3 = new Task<Void>() {
            @Override
            public Void call() {
                setLeavePoints(breakTimes(leaveTimes));
                return null;
            }
        };

        Thread thread3 = new Thread(task3);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Lines: " + lines + "\nJoins: " + joins + "\nLeaves: " + leaves + "\nChats: " + chats);
    }

    private int[][] breakTimes(ArrayList<String> inputTimes){
        int[][] tempPoints = new int[24][12];
        int tempHour = 0;
        int tempFiveMin = 0;

        //initialize chatPoints
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 12; j++) {
                tempPoints[i][j] = 0;
            }
        }

        //calculate chat messages graph
        for (String numberStr : inputTimes) {
            switch (numberStr.charAt(0) + "" + numberStr.charAt(1)) {
                case "01":
                    tempHour = 0;
                    break;
                case "02":
                    tempHour = 1;
                    break;
                case "03":
                    tempHour = 2;
                    break;
                case "04":
                    tempHour = 3;
                    break;
                case "05":
                    tempHour = 4;
                    break;
                case "06":
                    tempHour = 5;
                    break;
                case "07":
                    tempHour = 6;
                    break;
                case "08":
                    tempHour = 7;
                    break;
                case "09":
                    tempHour = 8;
                    break;
                case "10":
                    tempHour = 9;
                    break;
                case "11":
                    tempHour = 10;
                    break;
                case "12":
                    tempHour = 11;
                    break;
                case "13":
                    tempHour = 12;
                    break;
                case "14":
                    tempHour = 13;
                    break;
                case "15":
                    tempHour = 14;
                    break;
                case "16":
                    tempHour = 15;
                    break;
                case "17":
                    tempHour = 16;
                    break;
                case "18":
                    tempHour = 17;
                    break;
                case "19":
                    tempHour = 18;
                    break;
                case "20":
                    tempHour = 19;
                    break;
                case "21":
                    tempHour = 20;
                    break;
                case "22":
                    tempHour = 21;
                    break;
                case "23":
                    tempHour = 22;
                    break;
                case "24":
                    tempHour = 23;
                    break;
            }

            switch (numberStr.charAt(3) + "" + numberStr.charAt(4)) {
                case "00":
                case "01":
                case "02":
                case "03":
                case "04":
                    tempFiveMin = 0;
                    break;
                case "05":
                case "06":
                case "07":
                case "08":
                case "09":
                    tempFiveMin = 1;
                    break;
                case "10":
                case "11":
                case "12":
                case "13":
                case "14":
                    tempFiveMin = 2;
                    break;
                case "15":
                case "16":
                case "17":
                case "18":
                case "19":
                    tempFiveMin = 3;
                    break;
                case "20":
                case "21":
                case "22":
                case "23":
                case "24":
                    tempFiveMin = 4;
                    break;
                case "25":
                case "26":
                case "27":
                case "28":
                case "29":
                    tempFiveMin = 5;
                    break;
                case "30":
                case "31":
                case "32":
                case "33":
                case "34":
                    tempFiveMin = 6;
                    break;
                case "35":
                case "36":
                case "37":
                case "38":
                case "39":
                    tempFiveMin = 7;
                    break;
                case "40":
                case "41":
                case "42":
                case "43":
                case "44":
                    tempFiveMin = 8;
                    break;
                case "45":
                case "46":
                case "47":
                case "48":
                case "49":
                    tempFiveMin = 9;
                    break;
                case "50":
                case "51":
                case "52":
                case "53":
                case "54":
                    tempFiveMin = 10;
                    break;
                case "55":
                case "56":
                case "57":
                case "58":
                case "59":
                    tempFiveMin = 11;
                    break;
            }

            tempPoints[tempHour%12][tempFiveMin] += 1;
        }

        return tempPoints;
    }

    public void exportData(){
        //Delimiter used in CSV file
        final String COMMA_DELIMITER = ",";
        final String NEW_LINE_SEPARATOR = "\n";
        //CSV file header
        final String FILE_HEADER = "id,hour,fiveMin,instances";
        String fileName = "src/output.txt";

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);

            //Write the CSV file header
            fileWriter.append(FILE_HEADER);

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a object list to the CSV file
            for(int i=0;i<24;i++) {
                for (int j = 0; j < 12; j++) {
                    fileWriter.append(0 + "");
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(i + "");
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(j + "");
                    fileWriter.append(COMMA_DELIMITER);
                    fileWriter.append(String.valueOf(chatPoints[i][j]));
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }
            }


            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }

    }
}