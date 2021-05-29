package it.faraday.agriturismo.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Ordinazioni")
public class Ordinazione {

    @Id
    @Column(name = "id_ordinazione")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORD_SEQ_GEN")
    @SequenceGenerator(name = "ORD_SEQ_GEN", sequenceName = "ordinazioni_id_ordinazione_seq", allocationSize = 1)
    private Integer id;

    @Basic
    private Date data;


    public Ordinazione() {

    }


    public Integer getId() {
        return id;
    }

    public Ordinazione setId(Integer id) {
        this.id = id;
        return this;
    }

    public Date getData() {
        return data;
    }

    public Ordinazione setData(Date data) {
        this.data = data;
        return this;
    }

	@Override
	public String toString() {
		return "Ordinazione{" + "id=" + id + ", data=" + data + '}';
	}

}
