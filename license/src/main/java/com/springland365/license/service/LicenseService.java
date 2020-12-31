package com.springland365.license.service;

import com.springland365.license.clients.OrganizationDiscoveryClient;
import com.springland365.license.clients.OrganizationFeignClient;
import com.springland365.license.clients.OrganizationRestTemplateClient;
import com.springland365.license.model.License;
import com.springland365.license.model.Organization;
import com.springland365.license.repository.ILicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseService {
    @Autowired
    ILicenseRepository  licenseRepository;

    @Autowired
    OrganizationFeignClient organizationFeignClient;

    @Autowired
    OrganizationRestTemplateClient organizationRestClient;

    @Autowired
    OrganizationDiscoveryClient organizationDiscoveryClient;

    private Organization retrieveOrgInfo(String organizationId, String clientType){
        Organization organization = null;

        switch (clientType) {
            case "feign":
                System.out.println("I am using the feign client");
                organization = organizationFeignClient.getOrganization(organizationId);
                break;
            case "rest":
                System.out.println("I am using the rest client");
                organization = organizationRestClient.getOrganization(organizationId);
                break;
            case "discovery":
                System.out.println("I am using the discovery client");
                organization = organizationDiscoveryClient.getOrganization(organizationId);
                break;
            default:
                organization = organizationRestClient.getOrganization(organizationId);
        }

        return organization;
    }
    public License getLicense(String organizationId , String licenseId , String clientType)
    {

        Organization org = retrieveOrgInfo(organizationId, clientType);

        return License.builder()
                .organizationId(org.getId())
                .organizationName(org.getName())
                .contactEmail(org.getContactEmail())
                .contactPhone(org.getContactPhone())
                .contactName(org.getContactName())
                .build();

    }

    public List<License> getLicensesByOrg(String organizationId)
    {
        return this.licenseRepository.findByOrganizationId(organizationId);
    }

    public void saveLicense(License license)
    {
        this.licenseRepository.save(license);
    }

    public void updateLicense(License license)
    {
        this.licenseRepository.save(license);
    }

    public void deleteLicense(License license)
    {
        this.licenseRepository.delete(license);
    }

}
