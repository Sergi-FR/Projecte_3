

import java.util.ArrayList;

import javax.swing.event.ChangeListener;

import Clients.Client;
import Cursos.Curs;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SkilinkApp extends Application {

    TextField txtdni;
    TextField txtnom;
    TextField txtcognom1;
    TextField txtsexe;
    TextField txtnaix;
    TextField txttelefon;
    TextField txtemail;
    TextField txtcomptebancari;

    public static void main(String[] args) {

        Application.launch(args);

    }

    public void start(Stage escenari) throws Exception {

        BorderPane contenidor = new BorderPane();

        contenidor.setTop(PartSuperior());
        // contenidor.setBottom();
        // contenidor.setRight();
        contenidor.setLeft(LateralEsquerre());
        contenidor.setCenter(FormulariCentral());

        Scene escena = new Scene(contenidor);
        escenari.setMinHeight(600);
        escenari.setMinWidth(900);

        escenari.setScene(escena);

        escenari.show();
    }

    private HBox PartSuperior() {

        HBox hcapçelera = new HBox();
        Label titol = new Label("Inscripcio a Cursos");

        hcapçelera.getChildren().add(titol);
        hcapçelera.setAlignment(Pos.CENTER);

        return hcapçelera;

    }

    private GridPane FormulariCentral() {

        GridPane Gcentre = new GridPane();
        Label lbldni = new Label("DNI: ");
        txtdni = new TextField();
        Label lblnom = new Label("Nom: ");
        txtnom = new TextField();
        Label lblcognom1 = new Label("Primer Cognom: ");
        txtcognom1 = new TextField();
        Label lblsexe = new Label("Genere: ");
        txtsexe = new TextField();
        Label lblnaix = new Label("Data naixament: ");
        txtnaix = new TextField();
        Label lbltelefon = new Label("Telefon: ");
        txttelefon = new TextField();
        Label lblemail = new Label("Gmail: ");
        txtemail = new TextField();
        Label lblcomptebancari = new Label("CCC: ");
        txtcomptebancari = new TextField();

        Gcentre.add(lbldni, 0, 0);
        Gcentre.add(txtdni, 1, 0);
        Gcentre.add(lblnom, 0, 1);
        Gcentre.add(txtnom, 1, 1);
        Gcentre.add(lblcognom1, 0, 2);
        Gcentre.add(txtcognom1, 1, 2);
        Gcentre.add(lblsexe, 0, 3);
        Gcentre.add(txtsexe, 1, 3);
        Gcentre.add(lblnaix, 0, 4);
        Gcentre.add(txtnaix, 1, 4);
        Gcentre.add(lbltelefon, 0, 5);
        Gcentre.add(txttelefon, 1, 5);
        Gcentre.add(lblemail, 0, 6);
        Gcentre.add(txtemail, 1, 6);
        Gcentre.add(lblcomptebancari, 0, 7);
        Gcentre.add(txtcomptebancari, 1, 7);

        Gcentre.setAlignment(Pos.CENTER);

        return Gcentre;

    }

    private VBox LateralEsquerre() {

        VBox vesquerra = new VBox();
        vesquerra.setAlignment(Pos.CENTER);

        TableView<Client> tblClients = new TableView<Client>();
        TableColumn<Client, String> colDni = new TableColumn<Client, String>("DNI");
        TableColumn<Client, String> colnom = new TableColumn<Client, String>("Nom");
        TableColumn<Client, String> colcognom1 = new TableColumn<Client, String>("Cognom1");
        TableColumn<Client, String> colcognom2 = new TableColumn<Client, String>("Cognom2");
        tblClients.getColumns().addAll(colDni, colnom, colcognom1, colcognom2);

        consultaBDClients();

        tblClients.getItems().add(clients);

        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        colcognom1.setCellValueFactory(new PropertyValueFactory<>("cognom1"));
        colcognom2.setCellValueFactory(new PropertyValueFactory<>("cognom2"));

        vesquerra.getChildren().add(tblClients);
        return vesquerra;

    }

}
