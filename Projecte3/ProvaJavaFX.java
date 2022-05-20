package Projecte3;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Statement;

import Projecte3.TipusCursos.CursColectiu;
import Projecte3.TipusCursos.CursCompeticio;
import Projecte3.TipusCursos.CursIndividual;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    TextField txtDataFa_Caducitat;
    TextField txtDataFe_Caducitat;
    TextField txtNivell;

    TextField txtID;
    TextField txtData;
    TextField txtDataFi;
    TextField txtHoraInici;
    TextField txtHoraFi;
    TextField txtNomMonitor;
    TextField txtAforament;
    TextField txtPreu;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage escenari) throws Exception {

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
        hb2.getChildren().add(new Label("Titol"));
        hb2.setAlignment(Pos.CENTER);

        return hb2;
    }

    private Pane partInferior() {

        HBox hinferior = new HBox();
        Button btn1 = new Button("Llogar");
        Button btn2 = new Button("Boto 2");
        Button btn3 = new Button("Boto 3");

        hinferior.getChildren().addAll(btn1, btn2, btn3, new Label("Barra d'informació inferior"));
        hinferior.setAlignment(Pos.CENTER);

        return hinferior;
    }

    private Pane partDreta() throws SQLException {

        VBox vlateral = new VBox();
        vlateral.setAlignment(Pos.CENTER);
        vlateral.setSpacing(15);
        vlateral.getChildren().add(new Label("Titol"));

        TabPane tp = new TabPane();
        Tab tab1 = new Tab("Individuals", cursosIndividuals());
        Tab tab2 = new Tab("Col·lectius", cursosColectius());
        Tab tab3 = new Tab("Competició", cursosCompeticio());

        tp.getTabs().addAll(tab1, tab2, tab3);
        vlateral.getChildren().addAll(tp);
        return vlateral;
    }

    private Pane cursosIndividuals() throws SQLException {

        ConnexioBD con = new ConnexioBD();
        con.conectarBD();

        CursIndividual cursI = new CursIndividual();

        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);

        TableView<CursIndividual> tblCursos = new TableView<>();
        TableColumn<CursIndividual, Integer> colID = new TableColumn<>("id");
        TableColumn<CursIndividual, LocalDate> colData = new TableColumn<>("data_curs");
        TableColumn<CursIndividual, String> colMonitor = new TableColumn<>("nomMonitor");
        TableColumn<CursIndividual, Double> colPreu = new TableColumn<>("preu");
        tblCursos.getColumns().addAll(colID, colPreu, colData, colMonitor);

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data_curs"));
        colMonitor.setCellValueFactory(new PropertyValueFactory<>("nomMonitor"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));

        tblCursos.getItems().addAll(cursI.consultaCursIndividualBD());

        vb.getChildren().add(tblCursos);

        // afegim un listener per detectar canvis de seleccio en la tableview de clients
        tblCursos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                CursIndividual curs = (CursIndividual) newValue;

                if (curs != null) {
                    // movem a la pantalla les dades del client seleccionat
                    txtID.setText(String.valueOf(curs.getId()));
                    txtData.setText(String.valueOf(curs.getData()));
                    txtNomMonitor.setText(curs.getNomMonitor());
                    txtPreu.setText(String.valueOf(curs.getPreu()));
                    // acabar ficant si vull ficar més dades del client
                }
            }
        });

        con.desconectarBD();
        return vb;
    }

    private Pane cursosColectius() throws SQLException {

        ConnexioBD con = new ConnexioBD();
        con.conectarBD();

        CursColectiu cursCL = new CursColectiu();

        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);

        TableView<CursColectiu> tblCursos = new TableView<>();
        TableColumn<CursColectiu, Integer> colID = new TableColumn<>("id");
        TableColumn<CursColectiu, String> colMonitor = new TableColumn<>("nomMonitor");
        TableColumn<CursColectiu, LocalDate> colData = new TableColumn<>("data_curs");
        TableColumn<CursColectiu, Integer> colAforament = new TableColumn<>("aforament");
        TableColumn<CursColectiu, LocalTime> colHora_Inici = new TableColumn<>("hora_inici");
        TableColumn<CursColectiu, LocalTime> colHora_Fi = new TableColumn<>("hora_final");
        TableColumn<CursColectiu, Double> colPreu = new TableColumn<>("preu");
        tblCursos.getColumns().addAll(colID, colData, colMonitor, colAforament, colPreu, colHora_Inici,
                colHora_Fi);

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMonitor.setCellValueFactory(new PropertyValueFactory<>("nomMonitor"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data_curs"));
        colAforament.setCellValueFactory(new PropertyValueFactory<>("aforament"));
        colHora_Inici.setCellValueFactory(new PropertyValueFactory<>("hora_inici"));
        colHora_Fi.setCellValueFactory(new PropertyValueFactory<>("hora_final"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));

        tblCursos.getItems().addAll(cursCL.consultaCursColectiuBD());

        vb.getChildren().add(tblCursos);

        // afegim un listener per detectar canvis de seleccio en la tableview de clients
        tblCursos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
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

        con.desconectarBD();
        return vb;
    }

    private Pane cursosCompeticio() {

        VBox vb = new VBox();
        vb.setAlignment(Pos.CENTER);

        TableView<CursCompeticio> tblCursos = new TableView<>();
        TableColumn<CursCompeticio, Integer> colID = new TableColumn<>("ID");
        TableColumn<CursCompeticio, LocalDate> colData = new TableColumn<>("Data");
        TableColumn<CursCompeticio, String> colMonitor = new TableColumn<>("NomMonitor");
        TableColumn<CursCompeticio, String> colNivellCurs = new TableColumn<>("NivellCurs");
        TableColumn<CursCompeticio, LocalTime> colHora_Inici = new TableColumn<>("ID");
        TableColumn<CursCompeticio, LocalTime> colHora_Fi = new TableColumn<>("ID");
        TableColumn<CursCompeticio, Double> colPreu = new TableColumn<>("Preu");
        tblCursos.getColumns().addAll(colID, colData, colMonitor, colNivellCurs, colPreu, colHora_Inici, colHora_Fi);

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colMonitor.setCellValueFactory(new PropertyValueFactory<>("nomMonitor"));
        colNivellCurs.setCellValueFactory(new PropertyValueFactory<>("nivell_curs"));
        colHora_Inici.setCellValueFactory(new PropertyValueFactory<>("hora_inici"));
        colHora_Fi.setCellValueFactory(new PropertyValueFactory<>("hora_final"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));

        tblCursos.getItems().addAll();

        vb.getChildren().add(tblCursos);

        tblCursos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                CursCompeticio curs = (CursCompeticio) newValue;

                if (curs != null) {
                    // movem a la pantalla les dades del client seleccionat
                    txtID.setText(String.valueOf(curs.getId()));
                    txtData.setText(String.valueOf(curs.getData()));
                    txtNomMonitor.setText(curs.getNomMonitor());
                    txtNivell.setText(String.valueOf(curs.getNivell_curs()));
                    txtPreu.setText(String.valueOf(curs.getPreu()));
                    txtHoraInici.setText(String.valueOf(curs.getHora_inici()));
                    txtHoraFi.setText(String.valueOf(curs.getHora_final()));
                    txtPreu.setText(String.valueOf(curs.getPreu()));
                    // acabar ficant si vull ficar més dades del client
                }
            }
        });

        return vb;
    }

    private Pane partEsquerra() throws SQLException {

        ConnexioBD con = new ConnexioBD();
        con.conectarBD();

        Client c = new Client();

        VBox vlateral = new VBox();
        vlateral.getChildren().add(new Label("Barra navegació"));
        vlateral.setAlignment(Pos.CENTER);

        TableView<Client> tblClients = new TableView<>();
        TableColumn<Client, String> colDni = new TableColumn<>("dni");
        TableColumn<Client, String> colNom = new TableColumn<>("nom");
        TableColumn<Client, String> colCognom = new TableColumn<>("cognom");
        TableColumn<Client, String> colSexe = new TableColumn<>("sexe");
        tblClients.getColumns().addAll(colDni, colNom, colCognom, colSexe);

        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colCognom.setCellValueFactory(new PropertyValueFactory<>("cognom"));
        colSexe.setCellValueFactory(new PropertyValueFactory<>("sexe"));

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
                    txtDataFa_Caducitat.setText(String.valueOf(client.getDataFa_caducitat()));
                    txtDataFe_Caducitat.setText(String.valueOf(client.getDataFe_caducitat()));
                    txtNivell.setText(String.valueOf(client.getNivell()));
                    // acabar ficant si vull ficar més dades del client
                }
            }
        });

        con.desconectarBD();
        return vlateral;
    }

    private GridPane formulariCentral() {

        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        Label lblTitolClient = new Label("DADES USUARI");
        lblTitolClient.setFont(new Font("Arial", 30));
        Label lblDni = new Label("DNI: ");
        Label lblNom = new Label("Nom: ");
        Label lblCognom = new Label("Cognom: ");
        Label lblSexe = new Label("Sexe: ");
        Label lblID = new Label("ID_Curs: ");
        Label lblData = new Label("DataInici: ");
        Label lblDataFi = new Label("DataFi: ");
        Label lblHoraInici = new Label("HoraInici: ");
        Label lblHoraFi = new Label("HoraFi: ");
        Label lblnivell = new Label("NivellCurs: ");
        Label lblnomMonitor = new Label("NomMonitor: ");
        Label lblAforament = new Label("Aforament: ");
        Label lblPreu = new Label("Preu: ");
        txtDni = new TextField();
        txtNom = new TextField();
        txtCognom = new TextField();
        txtSexe = new TextField();
        txtID = new TextField();
        txtData = new TextField();
        txtDataFi = new TextField();
        txtHoraInici = new TextField();
        txtHoraFi = new TextField();
        txtNivell = new TextField();
        txtNomMonitor = new TextField();
        txtAforament = new TextField();
        txtPreu = new TextField();

        gp.add(lblTitolClient, 0, 0);
        gp.add(lblDni, 0, 1);
        gp.add(txtDni, 1, 1);
        gp.add(lblNom, 0, 2);
        gp.add(txtNom, 1, 2);
        gp.add(lblCognom, 0, 3);
        gp.add(txtCognom, 1, 3);
        gp.add(lblSexe, 0, 4);
        gp.add(txtSexe, 1, 4);
        gp.add(lblID, 0, 5);
        gp.add(txtID, 1, 5);
        gp.add(lblData, 0, 6);
        gp.add(txtData, 1, 6);
        gp.add(lblDataFi, 0, 7);
        gp.add(txtDataFi, 1, 7);
        gp.add(lblHoraInici, 0, 8);
        gp.add(txtHoraInici, 1, 8);
        gp.add(lblHoraFi, 0, 9);
        gp.add(txtHoraFi, 1, 9);
        gp.add(lblnivell, 0, 10);
        gp.add(txtNivell, 1, 10);
        gp.add(lblnomMonitor, 0, 11);
        gp.add(txtNomMonitor, 1, 11);
        gp.add(lblAforament, 0, 12);
        gp.add(txtAforament, 1, 12);
        gp.add(lblPreu, 0, 13);
        gp.add(txtPreu, 1, 13);

        return gp;
    }

}
