package com.springland365.license.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Organization {
    String id ;
    String name ;
    String contactName ;
    String contactEmail ;
    String contactPhone ;

}
