package com.sgh.sgh.Entity;

import java.util.Date;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "sesion")
public class Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "login_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date login_time;

    @Column(name = "logout_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date logout_time;

    @Column(name = "agente", nullable = false)
    public String agente;

    @Column(name = "usuario_id", nullable = false)
    public Integer usuario_id;
}
