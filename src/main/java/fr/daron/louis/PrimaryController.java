package fr.daron.louis;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class PrimaryController {

    @FXML
    private Button btnAjouter;

    @FXML
    private TextField fieldMail;

    @FXML
    private TextField fieldNom;

    @FXML
    private TextField fieldNumero;

    @FXML
    private TextField fieldPostale;

    @FXML
    private ListView<String> listView = new ListView<>();

    @FXML
    private Text resAjout;

    @FXML
    private TextField fieldId;

    @FXML
    private Button btnSuppr;

    @FXML
    public void initialize() throws SQLException{
        System.out.println("oui");
        System.out.println("entre");
        //On va récupérer tout les contacts présent dans la Bdd
        String reqContact = "SELECT idcontact,nom,numero_de_tel,adresse_mail,adresse_postale FROM contacts";
        ResultSet res = SqlDb.execRequetes(reqContact);
        System.out.println("Requete effectuée ! ");
        ObservableList <String> listeContact = FXCollections.observableArrayList();
        while(res.next()){
            listeContact.add("id : "+ res.getString("idcontact") +" nom : "+res.getString("nom") + " : "+ res.getNString("numero_de_tel") + " mail : " + res.getString("adresse_mail") +" adresse postale : "+ res.getString("adresse_postale"));
            listView.setItems(listeContact);
            System.out.println("Contact ajouté ! ");
        }
    }

    @FXML
    void ajouterContact(ActionEvent event) throws SQLException {
        String nom = fieldNom.getText();
        String numTel = fieldNumero.getText();
        String mail = fieldMail.getText();
        String cdPostal = fieldPostale.getText();
        
        String reqAjout = "INSERT INTO contacts(nom,numero_de_tel,adresse_mail,adresse_postale) VALUES ('" + nom + "','"+numTel + "','" + mail + "','"+ cdPostal +"');";
        System.out.println(reqAjout);

        if(SqlDb.execUpdate(reqAjout) == "Update effectué"){
            fieldNom.setText("");
            fieldNumero.setText("");
            fieldMail.setText("");
            fieldPostale.setText("");
            resAjout.setText("Requete réussie");
        }else{
            resAjout.setText("Requete échoué");
        }
    }

    @FXML
    void supprContact(ActionEvent event) throws SQLException {
        Integer id = Integer.valueOf(fieldId.getText());
        String reqSuppr = "DELETE FROM contacts WHERE idcontact = "+ id +";";
        SqlDb.execUpdate(reqSuppr);
        resAjout.setText("Suppression réussie");
        System.out.println("Supression réussie");
    }


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }


}
