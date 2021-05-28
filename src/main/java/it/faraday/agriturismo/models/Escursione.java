package it.faraday.agriturismo.models;

import javax.persistence.*;
import java.util.Date;

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_meta")
	private Escursione.Meta meta;

	public Escursione() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	@Override
	public String toString() {
		return "Escursione{" + "id=" + id + ", prezzo=" + prezzo + ", meta=" + meta + '}';
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
