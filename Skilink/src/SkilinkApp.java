import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import Conn.ConexioBD;
import Cursos.Curs;
import Cursos.CursCol;
import Cursos.CursComp;
import Cursos.CursInd;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

public class SkilinkApp extends Application {

    TextField txtdni;
    TextField txtnom;
    TextField txtcognom;
    TextField txtsexe;
    TextField txtnaix;
    TextField txttelefon;
    TextField txtemail;
    TextField txtcomptebancari;

    TextField txtid;
    TextField txtmonitor;
    TextField txtdata;
    TextField txtpreu;

    TextField txthorainiciInd;
    TextField txtduracio;

    // Col
    TextField txtaforament;
    TextField txthorainiciCol;
    TextField txthorafinalCol;
    // Comp
    TextField txtnivell;
    TextField txthorainiciComp;
    TextField txthorafinalComp;
    TextField txtDatafinal;

    Tab tab1;
    Tab tab2;
    Tab tab3;

    public static void main(String[] args) {

        Application.launch(args);

    }

    public void start(Stage escenari) throws Exception {

        BorderPane contenidor = new BorderPane();

        contenidor.setTop(partSuperior());
        contenidor.setBottom(partInferiror());
        contenidor.setRight(lateralDret());
        contenidor.setLeft(lateralEsquerre());
        contenidor.setCenter(formulariCentral());

        Scene escena = new Scene(contenidor);
        escenari.setMinHeight(900);
        escenari.setMinWidth(1200);

        escenari.setScene(escena);
        escenari.show();
    }

    // Metode que mostra el titol de la part superior
    // ########################################################
    private HBox partSuperior() {

        HBox hcapçelera = new HBox();
        Label titol = new Label("Inscripció a Cursos");
        titol.setFont(Font.font("Arial", 30));

        hcapçelera.getChildren().add(titol);
        hcapçelera.setAlignment(Pos.CENTER);

        return hcapçelera;

    }

    // Metode que mostra el formulari central
    // ########################################################
    private GridPane formulariCentral() {

        GridPane Gcentre = new GridPane();
        Label titolClient = new Label("Dades Client");
        titolClient.setFont(Font.font("Arial", 30));

        // Dades Client
        Label lbldni = new Label("DNI: ");
        txtdni = new TextField();
        Label lblnom = new Label("Nom: ");
        txtnom = new TextField();
        Label lblcognom = new Label("Cognom: ");
        txtcognom = new TextField();
        Label lblsexe = new Label("Genere: ");
        txtsexe = new TextField();
        Label lblnaix = new Label("Data naixament: ");
        txtnaix = new TextField();
        Label lbltelefon = new Label("Telefon: ");
        txttelefon = new TextField();
        Label lblemail = new Label("Correu electronic: ");
        txtemail = new TextField();
        Label lblcomptebancari = new Label("CCC: ");
        txtcomptebancari = new TextField();

        // Dades Curs
        Label titolCurs = new Label("Dades Curs");
        titolCurs.setFont(Font.font("Arial", 30));

        Label lblid = new Label("ID: ");
        txtid = new TextField();

        Label lblmonitor = new Label("Monitor: ");
        txtmonitor = new TextField();

        Label lbldata = new Label("Data: ");
        txtdata = new TextField();

        Label lblpreu = new Label("Preu: ");
        txtpreu = new TextField();

        // Dades Curs Ind
        Label titolCursInd = new Label("Dades Curs Individual");
        titolCursInd.setFont(Font.font("Arial", 20));

        Label lblhorainiciInd = new Label("Hora inici: ");
        txthorainiciInd = new TextField();

        Label lblduracio = new Label("Duració: ");
        txtduracio = new TextField();

        // Dades Curs Col
        Label titolCursCol = new Label("Dades Curs Colectiu");
        titolCursCol.setFont(Font.font("Arial", 20));

        Label lblaforament = new Label("Aforament: ");
        txtaforament = new TextField();

        Label lblhorainiciCol = new Label("Hora inici: ");
        txthorainiciCol = new TextField();

        Label lblhorafinalCol = new Label("Hora Final: ");
        txthorafinalCol = new TextField();

        // Dades Curs Comp
        Label titolCursComp = new Label("Dades Curs Competició");
        titolCursComp.setFont(Font.font("Arial", 20));

        Label lblnivell = new Label("Nivell: ");
        txtnivell = new TextField();

        Label lblhorainiciComp = new Label("Hora inici: ");
        txthorainiciComp = new TextField();

        Label lblhorafinalComp = new Label("Hora Final: ");
        txthorafinalComp = new TextField();

        Label lbldatafianl = new Label("Data Final: ");
        txtDatafinal = new TextField();

        // Insertar dades clients grid pane
        Gcentre.add(titolClient, 0, 0);
        Gcentre.add(lbldni, 0, 1);
        Gcentre.add(txtdni, 1, 1);
        Gcentre.add(lblnom, 0, 2);
        Gcentre.add(txtnom, 1, 2);
        Gcentre.add(lblcognom, 0, 3);
        Gcentre.add(txtcognom, 1, 3);
        Gcentre.add(lblsexe, 0, 4);
        Gcentre.add(txtsexe, 1, 4);
        Gcentre.add(lblnaix, 0, 5);
        Gcentre.add(txtnaix, 1, 5);
        Gcentre.add(lbltelefon, 0, 6);
        Gcentre.add(txttelefon, 1, 6);
        Gcentre.add(lblemail, 0, 7);
        Gcentre.add(txtemail, 1, 7);
        Gcentre.add(lblcomptebancari, 0, 8);
        Gcentre.add(txtcomptebancari, 1, 8);

        // Insertar dades cursos grid pane
        Gcentre.add(titolCurs, 0, 9);
        Gcentre.add(lblid, 0, 10);
        Gcentre.add(txtid, 1, 10);
        Gcentre.add(lblmonitor, 0, 11);
        Gcentre.add(txtmonitor, 1, 11);
        Gcentre.add(lbldata, 0, 12);
        Gcentre.add(txtdata, 1, 12);
        Gcentre.add(lblpreu, 0, 13);
        Gcentre.add(txtpreu, 1, 13);

        Gcentre.add(titolCursInd, 0, 14);
        Gcentre.add(lblhorainiciInd, 0, 15);
        Gcentre.add(txthorainiciInd, 1, 15);
        Gcentre.add(lblduracio, 0, 16);
        Gcentre.add(txtduracio, 1, 16);

        Gcentre.add(titolCursCol, 0, 17);
        Gcentre.add(lblaforament, 0, 18);
        Gcentre.add(txtaforament, 1, 18);
        Gcentre.add(lblhorainiciCol, 0, 19);
        Gcentre.add(txthorainiciCol, 1, 19);
        Gcentre.add(lblhorafinalCol, 0, 20);
        Gcentre.add(txthorafinalCol, 1, 20);

        Gcentre.add(titolCursComp, 0, 21);
        Gcentre.add(lblnivell, 0, 22);
        Gcentre.add(txtnivell, 1, 22);
        Gcentre.add(lblhorainiciComp, 0, 23);
        Gcentre.add(txthorainiciComp, 1, 23);
        Gcentre.add(lblhorafinalComp, 0, 24);
        Gcentre.add(txthorafinalComp, 1, 24);
        Gcentre.add(lbldatafianl, 0, 25);
        Gcentre.add(txtDatafinal, 1, 25);

        Gcentre.setAlignment(Pos.CENTER);

        return Gcentre;

    }

    // Metode que mostre les taula de Clients a la esquerra
    // ########################################################
    private VBox lateralEsquerre() {

        VBox vesquerra = new VBox();
        Label lblEsquerra = new Label("Clients");
        lblEsquerra.setFont(Font.font("Arial", 30));

        vesquerra.setAlignment(Pos.CENTER);
        Client c1 = new Client();

        TableView<Client> tblClients = new TableView<Client>();
        TableColumn<Client, String> colDni = new TableColumn<Client, String>("DNI");
        TableColumn<Client, String> colnom = new TableColumn<Client, String>("Nom");
        TableColumn<Client, String> colcognom = new TableColumn<Client, String>("Cognom");
        TableColumn<Client, String> coltelefon = new TableColumn<Client, String>("Telefon");
        TableColumn<Client, String> colemail = new TableColumn<Client, String>("Correu Electronic");
        TableColumn<Client, String> colCCC = new TableColumn<Client, String>("CCC");
        TableColumn<Client, String> colNivell = new TableColumn<Client, String>("Nivell");
        TableColumn<Client, String> colNFam = new TableColumn<Client, String>("N.Familia Nombrosa");
        tblClients.getColumns().addAll(colDni, colnom, colcognom, coltelefon, colemail, colCCC,
                colNivell, colNFam);

        try {
            tblClients.getItems().addAll(c1.consultaBDClients());
        } catch (SQLException e) {
            System.out.println("Error al carregar els clients");
        }

        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colcognom.setCellValueFactory(new PropertyValueFactory<>("cognom"));
        coltelefon.setCellValueFactory(new PropertyValueFactory<>("telefon"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colCCC.setCellValueFactory(new PropertyValueFactory<>("ccc"));
        colNivell.setCellValueFactory(new PropertyValueFactory<>("nivell"));
        colNFam.setCellValueFactory(new PropertyValueFactory<>("num_familia"));

        tblClients.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observableValue, Object oldvalue, Object newvalue) {
                Client client = (Client) newvalue;

                if (client != null) {
                    txtdni.setText(client.getDni());
                    txtnom.setText(client.getNom());
                    txtcognom.setText(client.getCognom());
                    txtsexe.setText(client.getSexe());
                    txtnaix.setText(String.valueOf(client.getData_naix()));
                    txttelefon.setText(client.getTelefon());
                    txtemail.setText(client.getEmail());
                    txtcomptebancari.setText(client.getCcc());
                }

            }

        });

        vesquerra.getChildren().addAll(lblEsquerra, tblClients);
        return vesquerra;

    }

    // Metode que mostre les taules de Cursos a la dreta
    // ########################################################
    private VBox lateralDret() {

        VBox vdreta = new VBox();
        Label lblDret = new Label("Cursos");
        lblDret.setFont(Font.font("Arial", 30));
        vdreta.setAlignment(Pos.CENTER);

        TabPane tp = new TabPane();

        // Cirdem els metodes de que enplenaran cada Tab
        tab1 = new Tab("Individual", cursInd());
        tab2 = new Tab("Colectiu", cursCol());
        tab3 = new Tab("Competició", cursComp());

        tp.getTabs().addAll(tab1, tab2, tab3);

        vdreta.getChildren().addAll(lblDret, tp);

        return vdreta;

    }

    // Metode per a crear la taula de Cursos individuals
    // ########################################################
    private VBox cursInd() {
        VBox vb = new VBox();
        CursInd cind = new CursInd();

        TableView<CursInd> tblCursInd = new TableView<>();
        TableColumn<CursInd, Integer> colID = new TableColumn<CursInd, Integer>("ID");
        TableColumn<CursInd, String> colMonitor = new TableColumn<CursInd, String>("Monitor");
        TableColumn<CursInd, LocalDate> colDataInici = new TableColumn<CursInd, LocalDate>("Data Curs Inici");
        TableColumn<CursInd, Integer> colPreu = new TableColumn<CursInd, Integer>("Preu");
        tblCursInd.getColumns().addAll(colID, colMonitor, colDataInici, colPreu);

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMonitor.setCellValueFactory(new PropertyValueFactory<>("nom_monitor"));
        colDataInici.setCellValueFactory(new PropertyValueFactory<>("data_curs"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));

        try {
            tblCursInd.getItems().addAll(cind.consultaBDCursosInd());
        } catch (Exception e) {
            System.out.println("Error al carregar els Cursos Individuals");
        }

        tblCursInd.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observableValue, Object oldvalue, Object newvalue) {
                CursInd cursInd = (CursInd) newvalue;

                if (cursInd != null) {
                    txtid.setText(String.valueOf(cursInd.getId()));
                    txtmonitor.setText(cursInd.getNom_monitor());
                    txtdata.setText(String.valueOf(cursInd.getData_curs()));
                    txtpreu.setText(String.valueOf(cursInd.getPreu()));
                }

            }

        });

        vb.getChildren().add(tblCursInd);

        return vb;
    }

    // Metode per a crear la taula de Cursos Colectius
    // ########################################################
    private VBox cursCol() {
        VBox vb = new VBox();
        CursCol ccol = new CursCol();

        TableView<CursCol> tblCursColectius = new TableView<>();
        TableColumn<CursCol, Integer> colID = new TableColumn<CursCol, Integer>("ID");
        TableColumn<CursCol, Integer> colAforament = new TableColumn<CursCol, Integer>("Aforament");
        TableColumn<CursCol, String> colMonitor = new TableColumn<CursCol, String>("Monitor");
        TableColumn<CursCol, LocalDate> colDataFi = new TableColumn<CursCol, LocalDate>("Data Curs");
        TableColumn<CursCol, LocalTime> colInici = new TableColumn<CursCol, LocalTime>("Hora d'inici");
        TableColumn<CursCol, LocalTime> colFi = new TableColumn<CursCol, LocalTime>("Hora de fi");
        TableColumn<CursCol, Integer> colPreu = new TableColumn<CursCol, Integer>("Preu");
        tblCursColectius.getColumns().addAll(colID, colAforament, colMonitor, colDataFi, colInici, colFi, colPreu);

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colAforament.setCellValueFactory(new PropertyValueFactory<>("aforament"));
        colMonitor.setCellValueFactory(new PropertyValueFactory<>("nom_monitor"));
        colDataFi.setCellValueFactory(new PropertyValueFactory<>("data_curs"));
        colInici.setCellValueFactory(new PropertyValueFactory<>("hora_inici"));
        colFi.setCellValueFactory(new PropertyValueFactory<>("hora_final"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));

        try {
            tblCursColectius.getItems().addAll(ccol.consultaBDCursosCol());
        } catch (SQLException e) {
            System.out.println("Error al carregar els Cursos Colectius");
        }

        tblCursColectius.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observableValue, Object oldvalue, Object newvalue) {
                CursCol cursCol = (CursCol) newvalue;

                if (cursCol != null) {
                    txtid.setText(String.valueOf(cursCol.getId()));
                    txtmonitor.setText(cursCol.getNom_monitor());
                    txtaforament.setText(String.valueOf(cursCol.getAforament()));
                    txtdata.setText(String.valueOf(cursCol.getData_curs()));
                    txthorainiciCol.setText(String.valueOf(cursCol.getHora_inici()));
                    txthorafinalCol.setText(String.valueOf(cursCol.getHora_final()));
                    txtpreu.setText(String.valueOf(cursCol.getPreu()));
                }

            }
        });

        vb.getChildren().add(tblCursColectius);

        return vb;
    }

    // Metode per a crear la taula de Cursos de Competició
    // ########################################################
    private VBox cursComp() {
        VBox vb = new VBox();
        CursComp ccomp = new CursComp();

        TableView<CursComp> tblCursComp = new TableView<>();
        TableColumn<CursComp, Integer> colID = new TableColumn<CursComp, Integer>("ID");
        TableColumn<CursComp, String> colNivell = new TableColumn<CursComp, String>("Nivell");
        TableColumn<CursComp, String> colMonitor = new TableColumn<CursComp, String>("Monitor");
        TableColumn<CursComp, LocalDate> colDataInici = new TableColumn<CursComp, LocalDate>("Data Curs Inici");
        TableColumn<CursComp, LocalDate> colDataFi = new TableColumn<CursComp, LocalDate>("Data Curs Final");
        TableColumn<CursComp, LocalTime> colInici = new TableColumn<CursComp, LocalTime>("Hora d'inici");
        TableColumn<CursComp, LocalTime> colFi = new TableColumn<CursComp, LocalTime>("Hora de fi");
        TableColumn<CursComp, Double> colPreu = new TableColumn<CursComp, Double>("Preu");
        tblCursComp.getColumns().addAll(colID, colNivell, colMonitor, colDataInici, colDataFi, colInici, colFi,
                colPreu);

        colID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNivell.setCellValueFactory(new PropertyValueFactory<>("nivell_curs"));
        colMonitor.setCellValueFactory(new PropertyValueFactory<>("nom_monitor"));
        colDataInici.setCellValueFactory(new PropertyValueFactory<>("data_curs"));
        colDataFi.setCellValueFactory(new PropertyValueFactory<>("data_final"));
        colInici.setCellValueFactory(new PropertyValueFactory<>("hora_inici"));
        colFi.setCellValueFactory(new PropertyValueFactory<>("hora_final"));
        colPreu.setCellValueFactory(new PropertyValueFactory<>("preu"));

        try {
            tblCursComp.getItems().addAll(ccomp.consultaBDCursosComp());
        } catch (SQLException e) {
            System.out.println("Error al carregar els Cursos de Competició");
        }

        tblCursComp.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observableValue, Object oldvalue, Object newvalue) {
                CursComp cursComp = (CursComp) newvalue;

                if (cursComp != null) {
                    txtid.setText(String.valueOf(cursComp.getId()));
                    txtmonitor.setText(cursComp.getNom_monitor());
                    txtnivell.setText(cursComp.getNivell_curs());
                    txtdata.setText(String.valueOf(cursComp.getData_curs()));
                    txtDatafinal.setText(String.valueOf(cursComp.getData_final()));
                    txthorainiciComp.setText(String.valueOf(cursComp.getHora_inici()));
                    txthorafinalComp.setText(String.valueOf(cursComp.getHora_final()));
                    txtpreu.setText(String.valueOf(cursComp.getPreu()));

                }

            }
        });

        vb.getChildren().add(tblCursComp);

        return vb;
    }

    // Metode que mostra els botons de la part inferior
    // ########################################################
    private HBox partInferiror() {

        HBox hpeuaplicació = new HBox();

        hpeuaplicació.getChildren().add(inferiorBotons());
        hpeuaplicació.setAlignment(Pos.CENTER);

        return hpeuaplicació;

    }

    private HBox inferiorBotons() {

        HBox hboto = new HBox();

        Button Llogar = new Button("Llogar");
        Button Esborrar = new Button("Esborrar");
        Button Sortir = new Button("Sortir");

        // Cridem els metodes dels events dels botons
        Llogar.setOnAction(event -> {
            llogarCurs();
        });
        Esborrar.setOnAction(event -> {
            esborrar();
        });
        Sortir.setOnAction(event -> {
            Platform.exit();
        });

        hboto.getChildren().addAll(Llogar, Esborrar, Sortir);

        hboto.setAlignment(Pos.CENTER);

        return hboto;

    }

    // Metode per a llogar els clients
    private void llogarCurs() {

        Connection con = ConexioBD.getConnection();

        CallableStatement cs;

        try {

            if (tab1.isSelected()) {
                // Cridem a un procedure que comprova i lloga en cas de que tot siqui correcte
                cs = con.prepareCall("call comprovarCurs_Individual(?,?,?,?)");

                // emplenem la crida
                cs.setString(1, txtdni.getText());
                cs.setInt(2, Integer.parseInt(txtid.getText()));
                cs.setTime(3, Time.valueOf(txthorainiciInd.getText()));
                cs.setInt(4, Integer.parseInt(txtduracio.getText()));

                System.out.println(txthorainiciInd.getText());

                // executem la crida
                cs.execute();

                System.out.println(cs);

            } else {

                // Cridem a un procedure que comprova i lloga en cas de que tot siqui correcte
                cs = con.prepareCall("call comprovar_curs(?,?)");

                // emplenem la crida
                cs.setString(1, txtdni.getText());
                cs.setInt(2, Integer.parseInt(txtid.getText()));

                // executem la crida
                cs.execute();

                System.out.println(cs);

            }

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    // Metode esborrar imputs de formulari central
    private void esborrar() {

        // Esborrar dades client
        txtdni.setText("");
        txtnom.setText("");
        txtcognom.setText("");
        txtsexe.setText("");
        txtnaix.setText("");
        txttelefon.setText("");
        txtemail.setText("");
        txtcomptebancari.setText("");

        // Esborrar dades curs
        txtid.setText("");
        txtmonitor.setText("");
        txtaforament.setText("");
        txtdata.setText("");
        txthorainiciCol.setText("");
        txthorafinalCol.setText("");
        txthorainiciComp.setText("");
        txthorafinalComp.setText("");
        txtpreu.setText("");
        txtnivell.setText("");
        txtDatafinal.setText("");

    }

}
