package mainpackage;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class mainPageController  implements Initializable, PropertyChangeListener {

    public ArrayList<Bet> userBets = new ArrayList<>();

    @FXML
    private NumberAxis yAxis;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private LineChart<String,Number> lineGraph;

    @FXML
    private Button activeBets;

    @FXML
    private Button betRequests;

    @FXML
    private ListView<?> friendBetsList;

    @FXML
    private Label totalBets;

    @FXML
    private Label totalGains;

    @FXML
    private Button newBet;

    @FXML
    private AnchorPane mainPane;

    private XYChart.Series<String,Number> graphSeries;

    int maxAccountValue = 0 ;
    int minAccountValue = 0;
    int overallGains = 0 ;

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lineGraph.setCreateSymbols(true);
/*
        for(int i= 0; i<10; i++){
            userBets.add(ranBet());
        }

 */
        setUpChart();
    }

    public void setUpChart()
    {
        yAxis = new NumberAxis();
        xAxis = new CategoryAxis();
        graphSeries=new XYChart.Series();
        lineGraph.getData().add(graphSeries);
        int i=1;


        for(Bet x: userBets) {

            overallGains += x.betAmount;
            if (maxAccountValue < overallGains) {
                maxAccountValue = overallGains;
            }
            if (minAccountValue > overallGains) {
                minAccountValue = overallGains;

            }
            graphData(i);
            i++;
        }
        yAxis.setLowerBound(minAccountValue-((int)minAccountValue*0.1));
        yAxis.setUpperBound((maxAccountValue+((int)maxAccountValue*0.1)));

    }

    public void graphData(int i){
        if(i==1){
            XYChart.Data<String, Number> graphData = new XYChart.Data("0",0);
            graphSeries.getData().add(graphData);

        }
        XYChart.Data<String, Number> data = new XYChart.Data(Integer.toString(i),overallGains);
        graphSeries.getData().add(data);
        data.getNode().setOnMouseEntered(e -> {
            Label dataLabel = new Label();
            dataLabel.setText("$"+data.getYValue());
            dataLabel.setLayoutX(data.getNode().getLayoutX()+70);
            dataLabel.setLayoutY(data.getNode().getLayoutY()+20);
            mainPane.getChildren().add(dataLabel);
            data.getNode().setOnMouseExited(ei -> {
                mainPane.getChildren().remove(dataLabel);
            });

        });
        if(overallGains < 0){
            graphSeries.getNode().setStyle("-fx-stroke: red");

        }
        else{
            graphSeries.getNode().setStyle("-fx-stroke: lightgreen");
        }


    }
/*
    public Bet ranBet(){
        Random rand = new Random(); //instance of random class

        //generate random values from 0-24
        int ran = rand.nextInt()/10000000;
        System.out.println(ran);

        Bet randBet = new Bet("","",ran,"","",false);
        return randBet;
    }

 */
}