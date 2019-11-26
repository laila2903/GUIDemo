package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

   //De her var for checkbox elementene
    @FXML private Label pizzaOrderLabel;
    @FXML private CheckBox pepperoniCheckBox;
    @FXML private CheckBox pinappleCheckBox;
    @FXML private CheckBox baconCheckBox;

    //De her er for choicebox elementene
    @FXML private ChoiceBox choiceBox;
    @FXML private Label choiceBoxLabel;

    //De her er for combobox delen
    @FXML private ComboBox comboBox;
    @FXML private Label comboBoxLabel;

    //De her er for radiobuttons
    @FXML private RadioButton PhpRadioButton;
    @FXML private RadioButton javaRadioButton;
    @FXML private RadioButton CsharpRadioButton;
    @FXML private RadioButton cplusplusRadioButton;
    @FXML private Label radioButtonLabel;
    private ToggleGroup favLangToggleGroup;


    //dette oppdaterer choicebox labelet
    public void choiceBoxButtonPushed (){
        choiceBoxLabel.setText("My favourite fruit is: \n"+choiceBox.getValue().toString());
    }


    // Dette er for checkbox eksemplet
    public void setOrderButtonPushed()
    {
        String order = "Toppings are: ";    //starter texten i label med dette

        if(pinappleCheckBox.isSelected()){    //velger hvilken checkboks som er presset som vi legger til i texten i label
            order+="\npinapple";                //hvis pinaple blir presset, så skal det legges pinaple til.
        }

        if(pepperoniCheckBox.isSelected()){
            order+="\npepperoni";
        }

        if(baconCheckBox.isSelected()){
            order+="\nbacon";
        }

        this.pizzaOrderLabel.setText(order); //nå setter man order stringen inn i labelen når order pizza knappen blir presset på
    }

    //metode for å oppdatere combobox label  når den er comboboksen er endret
    public void combboBoxWasUpdated (){
        this.comboBoxLabel.setText("Course selected: \n"+comboBox.getValue().toString());
    }

    //metode hvor labelet for radiobuttons forandrer seg etter hva vi har valgt i radiobuttons

    public void radioButtonChanged (){ //for at dette skal fungere må man i scenebuilder connecte alle radiobuttone i OnAction id til denne metoden
        //hvis togglegruppen har endret seg ved at en av radiobuttonene har blir presset og radiobutton som er valgt er lik C++
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.cplusplusRadioButton)){
            radioButtonLabel.setText("The selected item is: C++");
        }
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.CsharpRadioButton)){
            radioButtonLabel.setText("The selected item is: C#");
        }
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.javaRadioButton)){
            radioButtonLabel.setText("The selected item is: Java");
        }
        if(this.favLangToggleGroup.getSelectedToggle().equals(this.PhpRadioButton)){
            radioButtonLabel.setText("The selected item is: PHP");
        }
    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        pizzaOrderLabel.setText("");

        //dette er for å konfiguere choicbox eksemplet
        choiceBoxLabel.setText(""); //starter med ingenting i labelet
        choiceBox.getItems().add("Apples");  //dette leger til elementer i choiceboxen
        choiceBox.getItems().add("Bananas");
        choiceBox.getItems().addAll("Apples", "Oranges", "Strawberries");
        choiceBox.setValue("Apples"); //choiceboksen starter alltid med å vise apples før man foretar valg

        //Dette er for å konfiguere comboboxen
        comboBox.getItems().add("Comp130");
        comboBox.getItems().addAll("Comp1008","Mgmt2003", "mgmt345");
        comboBoxLabel.setText("");

        //Dette er for å konfiguere radiobuttons
        radioButtonLabel.setText("");
        //putte alle radiobuttons i en toggle group sånn at bare en av dem slår seg på
        favLangToggleGroup = new ToggleGroup();
        //putte alle i samme gruppe slik at programmet vet at alle er i en gruppe og kun en kan bli valgt
        this.cplusplusRadioButton.setToggleGroup(favLangToggleGroup);
        this.CsharpRadioButton.setToggleGroup(favLangToggleGroup);
        this.javaRadioButton.setToggleGroup(favLangToggleGroup);
        this.PhpRadioButton.setToggleGroup(favLangToggleGroup);

    }


}
