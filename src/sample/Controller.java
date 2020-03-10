package sample;
import javafx.collections.FXCollections;
import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.event.ActionEvent;
import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.chart.XYChart;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private JFXButton buttonjfx1;

    @FXML
    private PieChart PieChart1;

    @FXML
    private BarChart<String, Number> BarChart1;

    @FXML
    private JFXComboBox<String> cb1;

    @FXML
    private TextField Text1;


    @FXML
    private JFXButton buttonjfx2;

    @FXML
    private PieChart PieChart2;

    @FXML
    private BarChart<String, Number> BarChart2;

    @FXML
    private JFXComboBox<String> cb2;

    @FXML
    private TextField Text2;

    @FXML
    private JFXButton buttonjfx3;

    @FXML
    private PieChart PieChart3;

    @FXML
    private BarChart<String, Number> BarChart3;

    @FXML
    private JFXComboBox<String> cb3;

    @FXML
    private TextField Text3;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> options = FXCollections.observableArrayList("Pie Chart", "Bar Chart");
        cb1.setItems(options);
        cb1.setValue("Pie Chart");
        cb2.setItems(options);
        cb2.setValue("Pie Chart");
//        cb3.setItems(options);
//        cb3.setValue("Pie Chart");
        BarChart1.setVisible(false);
        PieChart1.setVisible(false);
        BarChart2.setVisible(false);
        PieChart2.setVisible(false);
//        BarChart3.setVisible(false);
//        PieChart3.setVisible(false);
//        PieChart3.setVisible(false);
    }


    public void buttonpiechart1(ActionEvent event) {
        if (cb1.getValue() == "Pie Chart") {
            try {
                BarChart1.setVisible(false);
                PieChart1.setVisible(true);
                int size = Integer.parseInt(Text1.getText());
                Scheduling s = new Scheduling();
                int o[] =  new int[99999];
                int bt[] = new int[99999];
                int p[] = new int[99999];
                for(int i = 0; i < size; i++) {
                    o[i] = i+1;
                }

                Random rand = new Random();

                for (int i = 0; i < size; i++)
                    bt[i] = rand.nextInt((20-2)+1)+1;
                for (int i = 0; i < size; i++)
                    p[i] = rand.nextInt((40-2)+1)+1;

                double FCFS = s.FCFS(bt,size);
                double SJF = s.SJF(o,bt,size);
                double Priority = s.Priority(o,bt,size,p);
                double RR = s.RR(bt,size);


                ObservableList<PieChart.Data> chart = FXCollections.observableArrayList(
                        new PieChart.Data("FCFS Scheduling", FCFS),
                        new PieChart.Data("SJF Scheduling", SJF),
                        new PieChart.Data("Priority Scheduling", Priority),
                        new PieChart.Data("RoundRobin Scheduling", RR));
                PieChart1.setData(chart);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (cb1.getValue() == "Bar Chart") {
            try {
                PieChart1.setVisible(false);
                BarChart1.setVisible(true);

                int size = Integer.parseInt(Text1.getText());
                Scheduling s = new Scheduling();
                int o[] =  new int[99999];
                int bt[] = new int[99999];
                int p[] = new int[99999];
                for(int i = 0; i < size; i++) {
                    o[i] = i+1;
                }

                Random rand = new Random();

                for (int i = 0; i < size; i++)
                    bt[i] = rand.nextInt((20-2)+1)+1;
                for (int i = 0; i < size; i++)
                    p[i] = rand.nextInt((40-2)+1)+1;

                double FCFS = s.FCFS(bt, size);
                double SJF = s.SJF(o, bt,size);
                double Priority = s.Priority(o, bt,size,p);
                double RR = s.RR(bt,size);

                BarChart1.setData(Data(Text1.getText(), FCFS,
                        SJF, Priority, RR));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    private ObservableList<Series<String, Number>> Data(String len, double FCFS, double SJF, double Priority, double RR) {


        ObservableList<Series<String, Number>> answer = FXCollections.observableArrayList();
        Series<String, Number> FCFSSeries = new Series<String, Number>();
        Series<String, Number> SJFSeries = new Series<String, Number>();
        Series<String, Number> PrioritySeries = new Series<String, Number>();
        Series<String, Number> RRSeries = new Series<String, Number>();

        FCFSSeries.setName("FCFS Scheduling");
        SJFSeries.setName("SJF Scheduling");
        PrioritySeries.setName("Priority Scheduling");
        RRSeries.setName("RoundRobin Scheduling");

        FCFSSeries.getData().add(new XYChart.Data<String, Number>(len, FCFS));
        SJFSeries.getData().add(new XYChart.Data<String, Number>(len, SJF));
        PrioritySeries.getData().add(new XYChart.Data<String, Number>(len,Priority));
        RRSeries.getData().add(new XYChart.Data<String, Number>(len, RR));


        answer.addAll(FCFSSeries, SJFSeries, PrioritySeries, RRSeries);
        return answer;
    }









    public void buttonpiechart2(ActionEvent event) {
        if (cb2.getValue() == "Pie Chart") {
            try {
                BarChart2.setVisible(false);
                PieChart2.setVisible(true);
                int size = Integer.parseInt(Text2.getText());
                Scheduling s = new Scheduling();
                int wt[] = new int[99999];
                Random rand = new Random();
                wt[0] = 0;
                for(int i=1;i<=size;i++ ) {
                    wt[i] = rand.nextInt((1000-2)+1)+2;
                }



                double FCFSD = s.FCFSD(wt,size);
                double SSTF = s.SSTF(wt,size);
                double LOOK = s.LOOK(wt,size);
                double CLOOK = s.CLOOK(wt,size);
                double SCAN = s.SCAN(wt,size);
                double CSCAN = s.CSCAN(wt,size);



                ObservableList<PieChart.Data> chart = FXCollections.observableArrayList(
                        new PieChart.Data("FCFS Scheduling", FCFSD),
                        new PieChart.Data("SSTF Scheduling", SSTF),
                        new PieChart.Data("LOOK Scheduling", LOOK),
                        new PieChart.Data("CLOOK Scheduling", CLOOK),
                        new PieChart.Data("SCAN Scheduling", SCAN),
                        new PieChart.Data("CSCAN Scheduling", CSCAN));

                PieChart2.setData(chart);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (cb2.getValue() == "Bar Chart") {
            try {
                PieChart2.setVisible(false);
                BarChart2.setVisible(true);

                int size = Integer.parseInt(Text2.getText());
                Scheduling s = new Scheduling();
                int wt[] = new int[99999];
                Random rand = new Random();
                wt[0] = 0;
                for(int i=1;i<=size;i++ ) {
                    wt[i] = rand.nextInt((1000-2)+1)+2;
                }



                double FCFSD = s.FCFSD(wt,size);
                double SSTF = s.SSTF(wt,size);
                double LOOK = s.LOOK(wt,size);
                double CLOOK = s.CLOOK(wt,size);
                double SCAN = s.SCAN(wt,size);
                double CSCAN = s.CSCAN(wt,size);

                BarChart2.setData(Data(Text2.getText(), FCFSD,
                        SSTF, LOOK, CLOOK,SCAN,CSCAN));

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    private ObservableList<Series<String, Number>> Data(String len, double FCFSD, double SSTF, double LOOK, double CLOOK, double SCAN, double CSCAN) {

        ObservableList<Series<String, Number>> answer = FXCollections.observableArrayList();
        Series<String, Number> FCFSDSeries = new Series<String, Number>();
        Series<String, Number> SSTFSeries = new Series<String, Number>();
        Series<String, Number> LOOKSeries = new Series<String, Number>();
        Series<String, Number> CLOOKSeries = new Series<String, Number>();
        Series<String, Number> SCANSeries = new Series<String, Number>();
        Series<String, Number> CSCANSeries = new Series<String, Number>();


        FCFSDSeries.setName("FCFSD Scheduling");
        SSTFSeries.setName("SSTF Scheduling");
        LOOKSeries.setName("LOOK Scheduling");
        CLOOKSeries.setName("CLOOK Scheduling");
        SCANSeries.setName("SCAN Scheduling");
        CSCANSeries.setName("CSCAN Scheduling");


        FCFSDSeries.getData().add(new XYChart.Data<String, Number>(len, FCFSD));
        SSTFSeries.getData().add(new XYChart.Data<String, Number>(len, SSTF));
        LOOKSeries.getData().add(new XYChart.Data<String, Number>(len,LOOK));
        CLOOKSeries.getData().add(new XYChart.Data<String, Number>(len, CLOOK));
        SCANSeries.getData().add(new XYChart.Data<String, Number>(len, SCAN));
        CSCANSeries.getData().add(new XYChart.Data<String, Number>(len, CSCAN));


        answer.addAll(FCFSDSeries, SSTFSeries, LOOKSeries, CLOOKSeries, SCANSeries, CSCANSeries);
        return answer;
    }



}






