package com.springland365.organization.repository;

import com.springland365.organization.model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository  extends CrudRepository<Organization, String> {
    public Optional<Organization> findById(String id);

    public Organization save(Organization orginzation);
}
