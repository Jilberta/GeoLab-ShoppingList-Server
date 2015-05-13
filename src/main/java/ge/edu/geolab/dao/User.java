package ge.edu.geolab.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(schema = "public", name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int id;
    @Column(name = "FB_ID")
    private String fbId;
    @Column(name = "GCM_ID")
    private String gcm_id;

    public int getId() {
        return id;
    }

    public String getFbId() {
        return fbId;
    }

    public String getGcm_id() {
        return gcm_id;
    }
}
