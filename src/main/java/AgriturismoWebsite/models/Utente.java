package AgriturismoWebsite.models;

import javax.persistence.*;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @Column(name = "id_utente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BS_SEQ_GEN")
    @SequenceGenerator(name = "BS_SEQ_GEN", sequenceName = "Utente_id_seq", allocationSize = 1)
    private Integer id;

    @Basic
    private String username;

    @Basic
    private String password;

    @Basic
    private String email;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "utenti")
    private Camera camera;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "utenti")
    private Carrello carrello;

    public Utente(){

    }
    

    public Utente(Integer id, String username,String password,String email, Integer id_camera,Integer id_carrello){

    }

    public Utente(String s) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Carrello getCarrello() {
        return carrello;
    }

    public void setCarrello(Carrello carrello) {
        this.carrello = carrello;
    }
}
