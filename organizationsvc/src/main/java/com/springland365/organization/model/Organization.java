package com.springland365.organization.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="organizations")
public class Organization {

    @Id
    @Column(name="organization_id" , nullable = false)
    protected String id ;
    @Column(name="name" , nullable = false)
    protected String name ;
    @Column(name="contact_name")
    protected String contactName ;
    @Column(name="contact_email")
    protected String contactEmail;
    @Column(name="contact_phone")
    protected String contactPhone ;
}
