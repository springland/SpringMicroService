package com.springland365.license.model;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="license")
public class License {

    @Column(name="license_id" , nullable = false)
    @Id
    protected String licenseId ;


    @Column(name="product_name" , nullable = false)
    protected String productName ;


    @Column(name="organization_id" , nullable = false)
    protected String organizationId ;

    @Transient
    @EqualsAndHashCode.Exclude
    private String organizationName ="";

    @Transient
    @EqualsAndHashCode.Exclude
    private String contactName ="";

    @Transient
    @EqualsAndHashCode.Exclude
    private String contactPhone ="";

    @Transient
    @EqualsAndHashCode.Exclude
    private String contactEmail ="";

    @Column(name="license_type" , nullable = false)
    protected String licenseType ;

    @Column(name="license_max" , nullable=false)
    protected Integer licenseMax ;

    @Column(name="license_allocated" , nullable = false)
    protected Integer licenseAllocated ;

    @Column(name="comment")
    protected String comment ;

}
