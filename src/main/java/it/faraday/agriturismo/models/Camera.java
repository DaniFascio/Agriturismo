package it.faraday.agriturismo.models;

import javax.persistence.*;

@Entity
@Table(name = "camere")
public class Camera {

	@Id
	@Basic
	private int numero;

	@Basic
	private float prezzo;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_camera")
	private Tipo tipoCamera;

	public Camera() {
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public Tipo getTipoCamera() {
		return tipoCamera;
	}

	public void setTipoCamera(Tipo tipoCamera) {
		this.tipoCamera = tipoCamera;
	}

	public String getTipoCameraString() {
		return tipoCamera.descrizione;
	}

	@Override
	public String toString() {
		return "Camera{" + "numero=" + numero + ", prezzo=" + prezzo + ", tipoCamera='" + tipoCamera.descrizione + '\'' + '}';
	}

	@Entity
	@Table(name = "tipi_camere")
	public static class Tipo {

		@Id
		@Column(name = "id_tipo_camera")
		private Integer id;

		@Basic
		private String descrizione;

		public Tipo() {
		}

		public Integer getId() {
			return id;
		}

		public Tipo setId(Integer id) {
			this.id = id;
			return this;
		}

		public String getDescrizione() {
			return descrizione;
		}

		public Tipo setDescrizione(String descrizione) {
			this.descrizione = descrizione;
			return this;
		}

		@Override
		public String toString() {
			return "Tipo{" + descrizione + '}';
		}

	}

}
