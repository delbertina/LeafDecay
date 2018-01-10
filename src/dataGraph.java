import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class dataGraph extends Application {

    @Override
    public void start(Stage stage) throws IOException, InterruptedException{
        stage.setTitle("Data Graph");
        final CategoryAxis xAxisChat = new CategoryAxis();
        final NumberAxis yAxisChat = new NumberAxis();
        final BarChart<String, Number> ac =
                new BarChart<>(xAxisChat, yAxisChat);
        ac.setTitle("Chat ");
        xAxisChat.setLabel("Hour");
        yAxisChat.setLabel("Instances");

        logData chatLog = new logData();
        chatLog.eatFile();
        chatLog.exportData();
        int[][] chatLogPoints = chatLog.getChatPoints();

        //make all the series
        XYChart.Series<String, Number> series1Chat = new XYChart.Series<>();
        series1Chat.setName("1");
        XYChart.Series<String, Number> series2Chat = new XYChart.Series<>();
        series2Chat.setName("2");
        XYChart.Series<String, Number> series3Chat = new XYChart.Series<>();
        series3Chat.setName("3");
        XYChart.Series<String, Number> series4Chat = new XYChart.Series<>();
        series4Chat.setName("4");
        XYChart.Series<String, Number> series5Chat = new XYChart.Series<>();
        series5Chat.setName("5");
        XYChart.Series<String, Number> series6Chat = new XYChart.Series<>();
        series6Chat.setName("6");
        XYChart.Series<String, Number> series7Chat = new XYChart.Series<>();
        series7Chat.setName("7");
        XYChart.Series<String, Number> series8Chat = new XYChart.Series<>();
        series8Chat.setName("8");
        XYChart.Series<String, Number> series9Chat = new XYChart.Series<>();
        series9Chat.setName("9");
        XYChart.Series<String, Number> series10Chat = new XYChart.Series<>();
        series10Chat.setName("10");
        XYChart.Series<String, Number> series11Chat = new XYChart.Series<>();
        series11Chat.setName("11");
        XYChart.Series<String, Number> series12Chat = new XYChart.Series<>();
        series12Chat.setName("12");

        //loop and add the data
        for(int i=0;i<12;i++){
            series1Chat.getData().add(new XYChart.Data<>(i+1+"", chatLogPoints[i][0]));
            series2Chat.getData().add(new XYChart.Data<>(i+1+"", chatLogPoints[i][1]));
            series3Chat.getData().add(new XYChart.Data<>(i+1+"", chatLogPoints[i][2]));
            series4Chat.getData().add(new XYChart.Data<>(i+1+"", chatLogPoints[i][3]));
            series5Chat.getData().add(new XYChart.Data<>(i+1+"", chatLogPoints[i][4]));
            series6Chat.getData().add(new XYChart.Data<>(i+1+"", chatLogPoints[i][5]));
            series7Chat.getData().add(new XYChart.Data<>(i+1+"", chatLogPoints[i][6]));
            series8Chat.getData().add(new XYChart.Data<>(i+1+"", chatLogPoints[i][7]));
            series9Chat.getData().add(new XYChart.Data<>(i+1+"", chatLogPoints[i][8]));
            series10Chat.getData().add(new XYChart.Data<>(i+1+"", chatLogPoints[i][9]));
            series11Chat.getData().add(new XYChart.Data<>(i+1+"", chatLogPoints[i][10]));
            series12Chat.getData().add(new XYChart.Data<>(i+1+"", chatLogPoints[i][11]));
        }

        final CategoryAxis xAxisJoin = new CategoryAxis();
        final NumberAxis yAxisJoin = new NumberAxis();
        final BarChart<String, Number> bc =
                new BarChart<>(xAxisJoin, yAxisJoin);
        bc.setTitle("Join ");
        xAxisJoin.setLabel("Hour");
        yAxisJoin.setLabel("Instances");

        int[][] joinLogPoints = chatLog.getJoinPoints();

        //make all the series
        XYChart.Series<String, Number> series1Join = new XYChart.Series<>();
        series1Join.setName("1");
        XYChart.Series<String, Number> series2Join = new XYChart.Series<>();
        series2Join.setName("2");
        XYChart.Series<String, Number> series3Join = new XYChart.Series<>();
        series3Join.setName("3");
        XYChart.Series<String, Number> series4Join = new XYChart.Series<>();
        series4Join.setName("4");
        XYChart.Series<String, Number> series5Join = new XYChart.Series<>();
        series5Join.setName("5");
        XYChart.Series<String, Number> series6Join = new XYChart.Series<>();
        series6Join.setName("6");
        XYChart.Series<String, Number> series7Join = new XYChart.Series<>();
        series7Join.setName("7");
        XYChart.Series<String, Number> series8Join = new XYChart.Series<>();
        series8Join.setName("8");
        XYChart.Series<String, Number> series9Join = new XYChart.Series<>();
        series9Join.setName("9");
        XYChart.Series<String, Number> series10Join = new XYChart.Series<>();
        series10Join.setName("10");
        XYChart.Series<String, Number> series11Join = new XYChart.Series<>();
        series11Join.setName("11");
        XYChart.Series<String, Number> series12Join = new XYChart.Series<>();
        series12Join.setName("12");

        //loop and add the data
        for(int i=0;i<12;i++){
            series1Join.getData().add(new XYChart.Data<>(i+1+"", joinLogPoints[i][0]));
            series2Join.getData().add(new XYChart.Data<>(i+1+"", joinLogPoints[i][1]));
            series3Join.getData().add(new XYChart.Data<>(i+1+"", joinLogPoints[i][2]));
            series4Join.getData().add(new XYChart.Data<>(i+1+"", joinLogPoints[i][3]));
            series5Join.getData().add(new XYChart.Data<>(i+1+"", joinLogPoints[i][4]));
            series6Join.getData().add(new XYChart.Data<>(i+1+"", joinLogPoints[i][5]));
            series7Join.getData().add(new XYChart.Data<>(i+1+"", joinLogPoints[i][6]));
            series8Join.getData().add(new XYChart.Data<>(i+1+"", joinLogPoints[i][7]));
            series9Join.getData().add(new XYChart.Data<>(i+1+"", joinLogPoints[i][8]));
            series10Join.getData().add(new XYChart.Data<>(i+1+"", joinLogPoints[i][9]));
            series11Join.getData().add(new XYChart.Data<>(i+1+"", joinLogPoints[i][10]));
            series12Join.getData().add(new XYChart.Data<>(i+1+"", joinLogPoints[i][11]));
        }

        final CategoryAxis xAxisLeave = new CategoryAxis();
        final NumberAxis yAxisLeave = new NumberAxis();
        final BarChart<String, Number> cc =
                new BarChart<>(xAxisLeave, yAxisLeave);
        cc.setTitle("Leave ");
        xAxisLeave.setLabel("Hour");
        yAxisLeave.setLabel("Instances");

        int[][] leaveLogPoints = chatLog.getLeavePoints();

        //make all the series
        XYChart.Series<String, Number> series1Leave = new XYChart.Series<>();
        series1Leave.setName("1");
        XYChart.Series<String, Number> series2Leave = new XYChart.Series<>();
        series2Leave.setName("2");
        XYChart.Series<String, Number> series3Leave = new XYChart.Series<>();
        series3Leave.setName("3");
        XYChart.Series<String, Number> series4Leave = new XYChart.Series<>();
        series4Leave.setName("4");
        XYChart.Series<String, Number> series5Leave = new XYChart.Series<>();
        series5Leave.setName("5");
        XYChart.Series<String, Number> series6Leave = new XYChart.Series<>();
        series6Leave.setName("6");
        XYChart.Series<String, Number> series7Leave = new XYChart.Series<>();
        series7Leave.setName("7");
        XYChart.Series<String, Number> series8Leave = new XYChart.Series<>();
        series8Leave.setName("8");
        XYChart.Series<String, Number> series9Leave = new XYChart.Series<>();
        series9Leave.setName("9");
        XYChart.Series<String, Number> series10Leave = new XYChart.Series<>();
        series10Leave.setName("10");
        XYChart.Series<String, Number> series11Leave = new XYChart.Series<>();
        series11Leave.setName("11");
        XYChart.Series<String, Number> series12Leave = new XYChart.Series<>();
        series12Leave.setName("12");

        //loop and add the data
        for(int i=0;i<12;i++){
            series1Leave.getData().add(new XYChart.Data<>(i+1+"", leaveLogPoints[i][0]));
            series2Leave.getData().add(new XYChart.Data<>(i+1+"", leaveLogPoints[i][1]));
            series3Leave.getData().add(new XYChart.Data<>(i+1+"", leaveLogPoints[i][2]));
            series4Leave.getData().add(new XYChart.Data<>(i+1+"", leaveLogPoints[i][3]));
            series5Leave.getData().add(new XYChart.Data<>(i+1+"", leaveLogPoints[i][4]));
            series6Leave.getData().add(new XYChart.Data<>(i+1+"", leaveLogPoints[i][5]));
            series7Leave.getData().add(new XYChart.Data<>(i+1+"", leaveLogPoints[i][6]));
            series8Leave.getData().add(new XYChart.Data<>(i+1+"", leaveLogPoints[i][7]));
            series9Leave.getData().add(new XYChart.Data<>(i+1+"", leaveLogPoints[i][8]));
            series10Leave.getData().add(new XYChart.Data<>(i+1+"", leaveLogPoints[i][9]));
            series11Leave.getData().add(new XYChart.Data<>(i+1+"", leaveLogPoints[i][10]));
            series12Leave.getData().add(new XYChart.Data<>(i+1+"", leaveLogPoints[i][11]));
        }

        //make tabs
        TabPane tabPane = new TabPane();
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 800, 600);

        //Chat Tab
        Tab chatMsgs = new Tab();
        chatMsgs.setText("  Chat  ");
        chatMsgs.setContent(ac);
        chatMsgs.setClosable(false);
        tabPane.getTabs().add(chatMsgs);

        //Join Tab
        Tab joinMsgs = new Tab();
        joinMsgs.setText("  Join  ");
        joinMsgs.setContent(bc);
        joinMsgs.setClosable(false);
        tabPane.getTabs().add(joinMsgs);

        //Leave Tab
        Tab leaveMsgs = new Tab();
        leaveMsgs.setText("  Leave  ");
        leaveMsgs.setContent(cc);
        leaveMsgs.setClosable(false);
        tabPane.getTabs().add(leaveMsgs);

        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        borderPane.setCenter(tabPane);

        ac.getData().addAll(series1Chat,series2Chat,series3Chat,series4Chat,series5Chat,series6Chat,series7Chat,series8Chat,series9Chat,series10Chat,series11Chat,series12Chat);
        bc.getData().addAll(series1Join,series2Join,series3Join,series4Join,series5Join,series6Join,series7Join,series8Join,series9Join,series10Join,series11Join,series12Join);
        cc.getData().addAll(series1Leave,series2Leave,series3Leave,series4Leave,series5Leave,series6Leave,series7Leave,series8Leave,series9Leave,series10Leave,series11Leave,series12Leave);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}