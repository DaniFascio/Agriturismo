package it.faraday.agriturismo.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "escursioni")
public class Escursione {

	@Id
	@Column(name = "id_escursione")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESCURSIONI_SEQ_GEN")
	@SequenceGenerator(name = "ESCURSIONI_SEQ_GEN", sequenceName = "escursioni_id_escursione_seq", allocationSize = 1)
	private Integer id;

	@Basic
	private float prezzo;

	@Basic
	private Date data;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "escursioni_personale",
			joinColumns = @JoinColumn(name = "id_escursione"),
			inverseJoinColumns = @JoinColumn(name = "id_personale"))
	private List<Personale> PersonaleEscursioni;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_meta")
	private Escursione.Meta meta;

	public Escursione() {

	}

	public Integer getId() {
		return id;
	}

	public Escursione setId(Integer id) {
		this.id = id;
		return this;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public Escursione setPrezzo(float prezzo) {
		this.prezzo = prezzo;
		return this;
	}

	public Date getData() {
		return data;
	}

	public Escursione setData(Date data) {
		this.data = data;
		return this;
	}

	public List<Personale> getPersonaleEscursioni() {
		return PersonaleEscursioni;
	}

	public Escursione setPersonaleEscursioni(List<Personale> personaleEscursioni) {
		PersonaleEscursioni = personaleEscursioni;
		return this;
	}

	public Meta getMeta() {
		return meta;
	}

	public Escursione setMeta(Meta meta) {
		this.meta = meta;
		return this;
	}

	@Override
	public String toString() {
		return "Escursione{" + "id=" + id + ", prezzo=" + prezzo + ", data=" + data + ", PersonaleEscursioni=" +
				PersonaleEscursioni + ", meta=" + meta + '}';
	}

	@Entity
	@Table(name = "mete")
	public static class Meta {

		@Id
		@Column(name = "id_meta")
		private Integer id;

		@Basic
		private String nome;

		public Meta() {
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		@Override
		public String toString() {
			return "Meta{" + "nome='" + nome + '\'' + '}';
		}

	}



}
