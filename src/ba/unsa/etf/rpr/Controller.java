package ba.unsa.etf.rpr;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Controller {
    public ChoiceBox<Knjiga> choiceBox;
    public TextField fldAutor;
    public TextField fldNaslov;
    public TextField fldISBN;

    private BibliotekaModel model = new BibliotekaModel();

    public Controller() {
        model.napuni();
    }

    //igra ulogu pomoćnog konstruktora, tj metode koja se poziva u onom trenutku kada se prozor kreira
    @FXML
    public void initialize() {
        choiceBox.setItems(model.getKnjige());
        //listener klasa je klasa koja prati promjene određenog propertija i izvršava kod u slučaju njegove promjene
        model.trenutnaKnjigaProperty().addListener(
                (obs, oldKnjiga, newKnjiga) -> {
                    if(oldKnjiga != null) {
                        fldAutor.textProperty().unbindBidirectional(oldKnjiga.autorProperty());
                        fldNaslov.textProperty().unbindBidirectional(oldKnjiga.naslovProperty());
                        fldISBN.textProperty().unbindBidirectional(oldKnjiga.ISBNProperty());
                        choiceBox.getItems().remove(oldKnjiga);
                        choiceBox.getItems().add(new Knjiga(fldAutor.getText(),fldNaslov.getText(),fldISBN.getText()));
                    }
                    if(newKnjiga == null) {
                        fldAutor.setText("");
                        fldNaslov.setText("");
                        fldISBN.setText("");
                    }
                    else {
                        fldAutor.textProperty().bindBidirectional(newKnjiga.autorProperty());
                        fldNaslov.textProperty().bindBidirectional(newKnjiga.naslovProperty());
                        fldISBN.textProperty().bindBidirectional(newKnjiga.ISBNProperty());
                    }
                }
        );
    }

    public void promjenaKnjige(ActionEvent actionEvent) {
        model.setTrenutnaKnjiga(choiceBox.getValue());
    }

    public void ispisiKnjige(ActionEvent actionEvent) {
        for(Knjiga k : model.getKnjige())
            System.out.println(k);
    }

}
