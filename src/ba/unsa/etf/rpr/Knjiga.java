package ba.unsa.etf.rpr;

import javafx.beans.property.SimpleStringProperty;

public class Knjiga implements Comparable<Knjiga> {
    //obzirom da ćemo koristiti dvojsmjerno povezivanje, nećemo kao tip atributa koristiti string, već:
    private SimpleStringProperty autor, naslov, ISBN;

    public Knjiga() {
        this.autor = new SimpleStringProperty("");
        this.naslov = new SimpleStringProperty("");
        this.ISBN = new SimpleStringProperty("");
    }


    public Knjiga(String autor, String naslov, String ISBN) {
        this.autor = new SimpleStringProperty(autor);
        this.naslov = new SimpleStringProperty(naslov);
        this.ISBN = new SimpleStringProperty(ISBN);
    }

    public String getAutor() {
        return autor.get();
    }

    public SimpleStringProperty autorProperty() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor.set(autor);
    }

    public String getNaslov() {
        return naslov.get();
    }

    public SimpleStringProperty naslovProperty() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov.set(naslov);
    }

    public String getISBN() {
        return ISBN.get();
    }

    public SimpleStringProperty ISBNProperty() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN.set(ISBN);
    }

    @Override
    public String toString() {
        return autor.get() + ", " + naslov.get();
    }

    @Override
    public int compareTo(Knjiga o) {
        int d = this.ISBN.get().compareTo(o.ISBN.get());
        if(d == 0)
            d = this.naslov.get().compareTo(o.naslov.get());
        if(d == 0)
            d = this.autor.get().compareTo(o.autor.get());
        return d;
    }
}
