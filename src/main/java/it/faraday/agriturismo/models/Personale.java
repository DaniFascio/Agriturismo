package it.faraday.agriturismo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "personale")
public class Personale {

	@Id
	@Column(name = "id_personale")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONALE_SEQ_GEN")
	@SequenceGenerator(name = "PERSONALE_SEQ_GEN", sequenceName = "personale_id_personale_seq", allocationSize = 1)
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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_personale")
	private Personale.Tipo tipoPersonale;

	public Personale() {

	}

	public Integer getId() {
		return id;
	}

	public Personale setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getNome() {
		return nome;
	}

	public Personale setNome(String nome) {
		this.nome = nome;
		return this;
	}

	public String getCognome() {
		return cognome;
	}

	public Personale setCognome(String cognome) {
		this.cognome = cognome;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public Personale setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Personale setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Personale setEmail(String email) {
		this.email = email;
		return this;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public Personale setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
		return this;
	}

	@Override
	public String toString() {
		return "Personale{" + "nome=" + nome + ", cognome=" + cognome + ", tipoPersonale='" + tipoPersonale.descrizione + '\'' + '}';
	}

	@Entity
	@Table(name = "tipi_Personale")
	public static class Tipo {

		@Id
		@Column(name = "id_tipo_personale")
		private Integer id;

		@Basic
		private String descrizione;

		public Tipo() {
		}

		public Integer getId() {
			return id;
		}

		public Personale.Tipo setId(Integer id) {
			this.id = id;
			return this;
		}

		public String getDescrizione() {
			return descrizione;
		}

		public Personale.Tipo setDescrizione(String descrizione) {
			this.descrizione = descrizione;
			return this;
		}

		@Override
		public String toString() {
			return "Tipo{" + descrizione + '}';
		}

	}

}
