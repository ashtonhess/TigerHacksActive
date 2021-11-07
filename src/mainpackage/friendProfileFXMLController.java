package mainpackage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Author: Jacob
 */
public class friendProfileFXMLController implements Initializable, PropertyChangeListener {

    @FXML
    private Text friendNameText;

    @FXML
    private ImageView userPicImageView;

    @FXML
    private Text activeBetsText;

    @FXML
    private ListView<?> activeBetsListView;

    @FXML
    private ListView<?> closedBetsListView;

    @FXML
    private Text closedBetsText;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        daModel = new loginFXMLModel();
//        daModel.addPropertyChangeListener(this);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (evt.getPropertyName().equals("textToChangePropertyChangeID")) {
            //System.out.println("Some shit");
//            textToChange.setText((String)evt.getNewValue());
        }
    }

    @FXML
    void donePressed(ActionEvent event) throws IOException {

        //code

        ScreenController.addScreen("loginFXML", FXMLLoader.load(getClass().getResource("loginFXML.fxml")));
        ScreenController.activate("loginFXML");


    }
//    @FXML
//    private void handleDaButton(ActionEvent event) {
//        daModel.changeDaText();
//    }
}
