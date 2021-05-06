package models;

import repositories.CarrelloRepository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carrello")
public class Carrello {

    @Id
    @Column(name = "id_carrello")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BS_SEQ_GEN")
    @SequenceGenerator(name = "BS_SEQ_GEN", sequenceName = "Carrello_id_seq", allocationSize = 1)
    private Integer id;


    @ManyToOne
    private Utente utente;

    @Basic
    private float costo;

    public Carrello(){
    List<Carrello> list = new ArrayList<Carrello>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
