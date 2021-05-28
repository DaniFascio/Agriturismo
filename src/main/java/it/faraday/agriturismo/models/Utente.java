package it.faraday.agriturismo.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "utenti")
public class Utente {

    @Id
    @Column(name = "id_utente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ_GEN")
    @SequenceGenerator(name = "USER_SEQ_GEN", sequenceName = "utenti_id_utente_seq", allocationSize = 1)
    private Integer id;

    @Basic
    private String nome;

    @Basic
    private String cognome;

    @Basic
    private String username;

    @Basic
    private String password;

    @Basic
    private String email;

    @Basic
    @Column(name = "data_nascita")
    private Date dataNascita;


    public Utente(){

    }


    public Integer getId() {
        return id;
    }

    public Utente setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Utente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCognome() {
        return cognome;
    }

    public Utente setCognome(String cognome) {
        this.cognome = cognome;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Utente setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Utente setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Utente setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public Utente setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
        return this;
    }

	@Override
	public String toString() {
		return "Utente{" + "id=" + id + ", nome='" + nome + '\'' + ", cognome='" + cognome + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + ", email='" + email + '\'' + ", dataNascita=" + dataNascita + '}';
	}

}
