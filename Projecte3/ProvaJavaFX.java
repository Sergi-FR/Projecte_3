package Projecte3;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import Projecte3.TipusCursos.CursColectiu;
import Projecte3.TipusCursos.CursCompeticio;
import Projecte3.TipusCursos.CursIndividual;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ProvaJavaFX extends Application {

    TextField txtDni;
    TextField txtNom;
    TextField txtCognom;
    TextField txtSexe;
    TextField txtNumFamilia;
    TextField txtNivellClient;

    TextField txtID;
    TextField txtNomMonitor;
    TextField txtData;
    TextField txtDataFi;
    TextField txtHoraInici;
    TextField txtHoraFi;
    TextField txtAforament;
    TextField txtNivellCurs;
    TextField txtPreu;

    TableView<Client> tblClients;
    TableView<CursIndividual> tblCursI;
    TableView<CursColectiu> tblCursCol;
    TableView<CursCompeticio> tblCursComp;

    Tab tab1;
    ChoiceBox ChoiceBox_Hora_Inici = new ChoiceBox();
    ChoiceBox ChoiceBox_duracio = new ChoiceBox();

    GridPane gp = new GridPane();
    Label lblhora_inici = new Label("Hora_Inici: ");
    Label lbl_duracio = new Label("Duració: ");

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage escenari) throws SQLException {

        BorderPane contenidor = new BorderPane();

        contenidor.setTop(partSuperior());
        contenidor.setBottom(partInferior());
        contenidor.setLeft(partEsquerra());
        contenidor.setRight(partDreta());
        contenidor.setCenter(formulariCentral());

        Scene escena = new Scene(contenidor);

        escenari.setScene(escena);
        escenari.setMinHeight(300);
        escenari.setMinWidth(300);
        escenari.show();

    }

    private Pane partSuperior() {

        HBox hb2 = new HBox();
        Label lblTitol = new Label("SKILINK");
        lblTitol.setFont(new Font("Arial", 50));
        hb2.getChildren().add(lblTitol);
        hb2.setAlignment(Pos.CENTER);

        return hb2;
    }

    private Pane partInferior() {

        HBox hinferior = new HBox();
        Button btn1 = new Button("Llogar");
        Button btn2 = new Button("Netejar");
        Button btn3 = new Button("Sortir");

        btn1.setOnAction(e -> {
            try {
                LlogarCurs();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        btn2.setOnAction(e -> NetejarDades());
        btn3.setOnAction(e -> Platform.exit());

        hinferior.getChildren().addAll(btn1, btn2, btn3);
        hinferior.setAlignment(Pos.CENTER);

        return hinferior;
    }

    private void NetejarDades() {
        txtDni.setText("");
        txtNom.setText("");
        txtCognom.setText("");
        txtSexe.setText("");
        txtNumFamilia.setText("");
        txtNivellClient.setText("");

        txtID.setText("");
        txtData.setText("");
        txtDataFi.setText("");
        txtHoraInici.setText("");
        txtHoraFi.setText("");
        txtNivellCurs.setText("");
        txtNomMonitor.setText("");
        txtAforament.setText("");
        txtPreu.setText("");

        ChoiceBox_Hora_Inici.setValue("");
        ChoiceBox_duracio.setValue("");

        // Part per treure la selecció de les taules
        tblClients.getSelectionModel().select(null);
        tblCursI.getSelectionModel().select(null);
        tblCursCol.getSelectionModel().select(null);
        tblCursComp.getSelectionModel().select(null);
    }

    private void LlogarCurs() throws SQLException {

        Connection con = ConnexioBD.getConnection();

        // comprovar si ha seleccionat un curs individual
        if (tab1.isSelected()) {
            CallableStatement cs = con.prepareCall("call comprovarCurs_Individual(?,?,?,?)");
            cs.setString(1, txtDni.getText());
            cs.setInt(2, Integer.parseInt(txtID.getText()));
            // Ho passem el Objecte getValue a String per a després passar-lo a Time
            cs.setTime(3, Time.valueOf(String.valueOf(ChoiceBox_Hora_Inici.getValue())));
            cs.setInt(4, Integer.parseInt(String.valueOf(ChoiceBox_duracio.getValue())));
            cs.execute();

            Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
            alerta.setTitle("Fet");
            alerta.setContentText("Curs inidividual llogat correctament");
            alerta.showAndWait();
        } else {

            try {
                CallableStatement cs = con.prepareCall("call comprovar_curs(?,?)");
                cs.setString(1, txtDni.getText());
                cs.setInt(2, Integer.parseInt(txtID.getText()));

                if (cs.execute()) {
                    Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
                    alerta.setTitle("Fet");
                    alerta.setContentText("Curs llogat correctament");
                    alerta.showAndWait();
                } else {
                    Alert alerta2 = new Alert(Alert.AlertType.ERROR);
                    alerta2.setTitle("Error");
                    alerta2.setContentText("El Client no esta federat");
                    alerta2.showAndWait();
                }

            } catch (SQLException e) {
                System.out.println("No s'ha pogut llogar el curs.");
            }

        }

    }

    private Pane partDreta() throws SQLException {

        VBox vlateral = new VBox();
        vlateral.setAlignment(Pos.CENTER);
        vlateral.setSpacing(15);

        TabPane tp = new TabPane();
        tab1 = new Tab("Individuals", cursosIndividuals());
        Tab tab2 = new Tab("Col·lectius", cursosColectius());
        Tab tab3 = new Tab("Competició", cursosCompeticio());

        tp.getTabs().addAll(tab1, tab2, tab3);
        vlateral.getChildren().addAll(tp);
        return vlateral;

    }

    private Pane cursosIndividuals() throws SQLException {

        CursIndividual cursI = new CursIndividual();

        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);

        tblCursI = new TableView<>();
        TableColumn<CursIndividual, Integer> colID = new TableColumn<>("id");
        TableColumn<CursIndividual, String> colMonitor = new TableColumn<>("nomMonitor");
        TableColumn<CursIndividual, LocalDate> colData = new TableColumn<>("data");
        TableColumn<CursIndividual, Double> colPreu = new TableColumn<>("preu");
        tblCursI.getColumns().addAll(colID, colPreu, colData, colMonitor);

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMonitor.setCellValueFactory(new PropertyValueFactory<>("nomMonitor"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));

        tblCursI.getItems().addAll(cursI.consultaCursIndividualBD());

        vb.getChildren().add(tblCursI);

        // afegim un listener per detectar canvis de seleccio en la tableview de clients
        tblCursI.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                CursIndividual curs = (CursIndividual) newValue;

                if (curs != null) {
                    // movem a la pantalla les dades del client seleccionat

                    txtID.setText(String.valueOf(curs.getId()));
                    txtNomMonitor.setText(curs.getNomMonitor());
                    txtData.setText(String.valueOf(curs.getData()));
                    txtPreu.setText(String.valueOf(curs.getPreu()));
                    ChoiceBox_Hora_Inici.getValue();
                    ChoiceBox_duracio.getValue();
                }
            }
        });

        return vb;

    }

    private Pane cursosColectius() throws SQLException {

        CursColectiu cursCL = new CursColectiu();

        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);

        tblCursCol = new TableView<>();
        TableColumn<CursColectiu, Integer> colID = new TableColumn<>("id");
        TableColumn<CursColectiu, String> colMonitor = new TableColumn<>("nomMonitor");
        TableColumn<CursColectiu, LocalDate> colData = new TableColumn<>("data");
        TableColumn<CursColectiu, Integer> colAforament = new TableColumn<>("aforament");
        TableColumn<CursColectiu, LocalTime> colHora_Inici = new TableColumn<>("hora_inici");
        TableColumn<CursColectiu, LocalTime> colHora_Fi = new TableColumn<>("hora_final");
        TableColumn<CursColectiu, Double> colPreu = new TableColumn<>("preu");
        tblCursCol.getColumns().addAll(colID, colData, colMonitor, colAforament, colPreu, colHora_Inici,
                colHora_Fi);

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMonitor.setCellValueFactory(new PropertyValueFactory<>("nomMonitor"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colAforament.setCellValueFactory(new PropertyValueFactory<>("aforament"));
        colHora_Inici.setCellValueFactory(new PropertyValueFactory<>("hora_inici"));
        colHora_Fi.setCellValueFactory(new PropertyValueFactory<>("hora_final"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));

        tblCursCol.getItems().addAll(cursCL.consultaCursColectiuBD());

        vb.getChildren().add(tblCursCol);

        // afegim un listener per detectar canvis de seleccio en la tableview de clients
        tblCursCol.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                CursColectiu curs = (CursColectiu) newValue;

                if (curs != null) {
                    // movem a la pantalla les dades del client seleccionat
                    txtID.setText(String.valueOf(curs.getId()));
                    txtNomMonitor.setText(curs.getNomMonitor());
                    txtData.setText(String.valueOf(curs.getData()));
                    txtAforament.setText(String.valueOf(curs.getAforament()));
                    txtHoraInici.setText(String.valueOf(curs.getHora_inici()));
                    txtHoraFi.setText(String.valueOf(curs.getHora_final()));
                    txtPreu.setText(String.valueOf(curs.getPreu()));
                }
            }
        });

        return vb;
    }

    private Pane cursosCompeticio() throws SQLException {

        CursCompeticio cursCOM = new CursCompeticio();

        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);

        tblCursComp = new TableView<>();
        TableColumn<CursCompeticio, Integer> colID = new TableColumn<>("ID");
        TableColumn<CursCompeticio, LocalDate> colData = new TableColumn<>("Data");
        TableColumn<CursCompeticio, String> colMonitor = new TableColumn<>("NomMonitor");
        TableColumn<CursCompeticio, String> colNivellCurs = new TableColumn<>("NivellCurs");
        TableColumn<CursCompeticio, LocalTime> colHora_Inici = new TableColumn<>("hora_inici");
        TableColumn<CursCompeticio, LocalTime> colHora_Fi = new TableColumn<>("hora_final");
        TableColumn<CursCompeticio, Double> colPreu = new TableColumn<>("Preu");
        tblCursComp.getColumns().addAll(colID, colData, colMonitor, colNivellCurs, colPreu, colHora_Inici, colHora_Fi);

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colMonitor.setCellValueFactory(new PropertyValueFactory<>("nomMonitor"));
        colNivellCurs.setCellValueFactory(new PropertyValueFactory<>("nivell_curs"));
        colHora_Inici.setCellValueFactory(new PropertyValueFactory<>("hora_inici"));
        colHora_Fi.setCellValueFactory(new PropertyValueFactory<>("hora_final"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));

        tblCursComp.getItems().addAll(cursCOM.consultaCursCompeticioBD());

        vb.getChildren().add(tblCursComp);

        tblCursComp.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                CursCompeticio curs = (CursCompeticio) newValue;

                if (curs != null) {
                    // movem a la pantalla les dades del client seleccionat
                    txtID.setText(String.valueOf(curs.getId()));
                    txtNomMonitor.setText(curs.getNomMonitor());
                    txtData.setText(String.valueOf(curs.getData()));
                    txtDataFi.setText(String.valueOf(curs.getData()));
                    txtNivellCurs.setText(String.valueOf(curs.getNivell_curs()));
                    txtHoraInici.setText(String.valueOf(curs.getHora_inici()));
                    txtHoraFi.setText(String.valueOf(curs.getHora_final()));
                    txtPreu.setText(String.valueOf(curs.getPreu()));
                }
            }
        });

        return vb;
    }

    private Pane partEsquerra() throws SQLException {

        Client c = new Client();

        VBox vlateral = new VBox();
        vlateral.getChildren().add(new Label("Barra navegació"));
        vlateral.setAlignment(Pos.CENTER);

        tblClients = new TableView<>();
        TableColumn<Client, String> colDni = new TableColumn<>("dni");
        TableColumn<Client, String> colNom = new TableColumn<>("nom");
        TableColumn<Client, String> colCognom = new TableColumn<>("cognom");
        TableColumn<Client, String> colSexe = new TableColumn<>("sexe");
        TableColumn<Client, String> colNumFamilia = new TableColumn<>("num_familia");
        TableColumn<Client, String> colNivellClient = new TableColumn<>("nivell");
        tblClients.getColumns().addAll(colDni, colNom, colCognom, colSexe);

        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colCognom.setCellValueFactory(new PropertyValueFactory<>("cognom"));
        colSexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        colNumFamilia.setCellValueFactory(new PropertyValueFactory<>("num_familia"));
        colNivellClient.setCellValueFactory(new PropertyValueFactory<>("nivell"));

        tblClients.getItems().addAll(c.consultaClientBD());

        vlateral.getChildren().add(tblClients);

        // afegim un listener per detectar canvis de seleccio en la tableview de clients
        tblClients.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Client client = (Client) newValue;

                if (client != null) {
                    // movem a la pantalla les dades del client seleccionat
                    txtDni.setText(client.getDni());
                    txtNom.setText(client.getNom());
                    txtCognom.setText(client.getCognom());
                    txtSexe.setText(client.getSexe());
                    txtNumFamilia.setText(String.valueOf(client.getNum_familia()));
                    txtNivellClient.setText(String.valueOf(client.getNivell()));
                }
            }
        });

        return vlateral;
    }

    private GridPane formulariCentral() {

        // GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);

        Label lblTitolClient = new Label("DADES USUARI");
        lblTitolClient.setFont(new Font("Arial", 30));
        lblTitolClient.setAlignment(Pos.CENTER);

        Label lblDni = new Label("DNI: ");
        txtDni = new TextField();
        Label lblNom = new Label("Nom: ");
        txtNom = new TextField();
        Label lblCognom = new Label("Cognom: ");
        txtCognom = new TextField();
        Label lblSexe = new Label("Sexe: ");
        txtSexe = new TextField();
        Label lblNumFamilia = new Label("NumFamiliaNombrosa: ");
        txtNumFamilia = new TextField();
        Label lblNivellClient = new Label("NivellClient: ");
        txtNivellClient = new TextField();

        Label lblTitolCurs = new Label("DADES CURS");
        lblTitolCurs.setFont(new Font("Arial", 30));
        lblTitolCurs.setAlignment(Pos.CENTER);

        Label lblID = new Label("ID_Curs: ");
        txtID = new TextField();
        Label lblData = new Label("DataInici: ");
        txtData = new TextField();
        Label lblDataFi = new Label("DataFi: ");
        txtDataFi = new TextField();
        Label lblHoraInici = new Label("HoraInici: ");
        txtHoraInici = new TextField();
        Label lblHoraFi = new Label("HoraFi: ");
        txtHoraFi = new TextField();
        Label lblnivell = new Label("NivellCurs: ");
        txtNivellCurs = new TextField();
        Label lblnomMonitor = new Label("DNI_Monitor: ");
        txtNomMonitor = new TextField();
        Label lblAforament = new Label("Aforament: ");
        txtAforament = new TextField();
        Label lblPreu = new Label("Preu: ");
        txtPreu = new TextField();

        tblCursI.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                CursIndividual curs = (CursIndividual) newValue;

                if (curs != null) {
                    // Si el curs seleccionat es un indiivudal, li ensenyem al client les altres
                    // opcions per a poder llogar un curs individual
                    lblhora_inici.setVisible(true);
                    ChoiceBox_Hora_Inici.setVisible(true);
                    lbl_duracio.setVisible(true);
                    ChoiceBox_duracio.setVisible(true);
                }
                if (curs == null) {
                    // Si el curs seleccionat no es individual, no es mostrarà els checkBox
                    lblhora_inici.setVisible(false);
                    ChoiceBox_Hora_Inici.setVisible(false);
                    lbl_duracio.setVisible(false);
                    ChoiceBox_duracio.setVisible(false);
                }
            }
        });

        ChoiceBox_Hora_Inici.getItems().add("09:00:00");
        ChoiceBox_Hora_Inici.getItems().add("10:00:00");
        ChoiceBox_Hora_Inici.getItems().add("11:00:00");
        ChoiceBox_Hora_Inici.getItems().add("16:00:00");
        ChoiceBox_Hora_Inici.getItems().add("17:00:00");

        ChoiceBox_duracio.getItems().add("1");
        ChoiceBox_duracio.getItems().add("2");
        ChoiceBox_duracio.getItems().add("3");
        ChoiceBox_duracio.getItems().add("4");
        ChoiceBox_duracio.getItems().add("5");
        ChoiceBox_duracio.getItems().add("6");

        gp.add(lblTitolClient, 0, 0);
        gp.add(lblDni, 0, 1);
        gp.add(txtDni, 1, 1);
        gp.add(lblNom, 0, 2);
        gp.add(txtNom, 1, 2);
        gp.add(lblCognom, 0, 3);
        gp.add(txtCognom, 1, 3);
        gp.add(lblSexe, 0, 4);
        gp.add(txtSexe, 1, 4);
        gp.add(lblNumFamilia, 0, 5);
        gp.add(txtNumFamilia, 1, 5);
        gp.add(lblNivellClient, 0, 6);
        gp.add(txtNivellClient, 1, 6);
        gp.add(lblTitolCurs, 0, 7);
        gp.add(lblID, 0, 8);
        gp.add(txtID, 1, 8);
        gp.add(lblData, 0, 9);
        gp.add(txtData, 1, 9);
        gp.add(lblDataFi, 0, 10);
        gp.add(txtDataFi, 1, 10);
        gp.add(lblHoraInici, 0, 11);
        gp.add(txtHoraInici, 1, 11);
        gp.add(lblHoraFi, 0, 12);
        gp.add(txtHoraFi, 1, 12);
        gp.add(lblnivell, 0, 13);
        gp.add(txtNivellCurs, 1, 13);
        gp.add(lblnomMonitor, 0, 14);
        gp.add(txtNomMonitor, 1, 14);
        gp.add(lblAforament, 0, 15);
        gp.add(txtAforament, 1, 15);
        gp.add(lblPreu, 0, 16);
        gp.add(txtPreu, 1, 16);
        gp.add(lblhora_inici, 0, 18);
        gp.add(ChoiceBox_Hora_Inici, 1, 18);
        gp.add(lbl_duracio, 0, 20);
        gp.add(ChoiceBox_duracio, 1, 20);

        return gp;
    }

}
