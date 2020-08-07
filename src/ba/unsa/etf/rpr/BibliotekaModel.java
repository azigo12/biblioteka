package ba.unsa.etf.rpr;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BibliotekaModel {
    //ovdje smo mogli postaviri arrayList ali onda ga ne bismo mogli povezati sa kontrolom kao što je choice box
    private ObservableList<Knjiga> knjige = FXCollections.observableArrayList();
    private SimpleObjectProperty<Knjiga> trenutnaKnjiga = new SimpleObjectProperty<>();

    public ObservableList<Knjiga> getKnjige() {
        return knjige;
    }

    public void napuni() {
        knjige.add(new Knjiga("Ivo Andric", "Travnička hronika", "123456"));
        knjige.add(new Knjiga("Oprah Vinfri","Ono što sasvim sigurno znam", "6541332"));
        knjige.add(new Knjiga("Vedran Ljubović", "Programiranje C i C++", "741852"));
        trenutnaKnjiga.set(null);
    }

    public void setKnjige(ObservableList<Knjiga> knjige) {
        this.knjige = knjige;
    }

    public Knjiga getTrenutnaKnjiga() {
        return trenutnaKnjiga.get();
    }

    public SimpleObjectProperty<Knjiga> trenutnaKnjigaProperty() {
        return trenutnaKnjiga;
    }

    public void setTrenutnaKnjiga(Knjiga trenutnaKnjiga) {
        this.trenutnaKnjiga.set(trenutnaKnjiga);
    }
}
