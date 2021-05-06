package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "camere")
public class Camera {

    @Id
    @Column(name = "id_camera")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BS_SEQ_GEN")
    @SequenceGenerator(name = "BS_SEQ_GEN", sequenceName = "Carrello_id_seq", allocationSize = 1)
    private Integer id;

    @Basic
    private Integer numero;

    @Basic
    private boolean stato;

    public Camera(){
    List<Camera> list = new ArrayList<Camera>();
    }


}
