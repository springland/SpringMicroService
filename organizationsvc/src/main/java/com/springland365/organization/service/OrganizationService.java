package com.springland365.organization.service;

import com.springland365.organization.model.Organization;
import com.springland365.organization.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrganizationService {
    @Autowired
    OrganizationRepository  repository;

    public Organization getOrganization(String organizationId)
    {
        return this.repository.findById(organizationId).get();
    }

    public void saveOrg(Organization org){
        org.setId( UUID.randomUUID().toString());

        repository.save(org);

    }
    public void updateOrg(Organization org){
        repository.save(org);
    }

    public void deleteOrg(Organization org){
        repository.delete(org);
    }
}
