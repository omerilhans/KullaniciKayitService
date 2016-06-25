package com.android.entity;

import com.android.base.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Device")
public class Device extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "registrationId")
    private String registrationId;
    @Column(name = "cihazBilgisi")
    private String cihazBilgisi;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getCihazBilgisi() {
        return cihazBilgisi;
    }

    public void setCihazBilgisi(String cihazBilgisi) {
        this.cihazBilgisi = cihazBilgisi;
    }

}
