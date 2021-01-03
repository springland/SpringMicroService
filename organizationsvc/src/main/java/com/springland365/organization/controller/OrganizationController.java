package com.springland365.organization.controller;

import com.springland365.organization.model.Organization;
import com.springland365.organization.service.OrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="v1/organizations")
public class OrganizationController {

    @Autowired
    protected OrganizationService  service ;

    Logger logger = LoggerFactory.getLogger(OrganizationController.class);
    @GetMapping("/{orgainzationId}")
    public Organization  getOrganization(@PathVariable("orgainzationId") String organizationId)
    {
        return this.service.getOrganization(organizationId);
    }

    @GetMapping("/random/{orgainzationId}")
    public Organization  getOrganizationRandomLong(@PathVariable("orgainzationId") String organizationId)
    {
        logger.info(" get Organization Random Long");
        return this.service.runRandomLong(organizationId);
    }

    @PutMapping("/{organizationId}")
    public void updateOrganization(@PathVariable("organizationId") String orgId , @RequestBody  Organization org)
    {
        this.service.updateOrg(org);
    }

    @PostMapping("/{organizationId}")
    public void saveOrganization(@PathVariable("organizationId") String orgId , @RequestBody  Organization org)
    {
        this.service.saveOrg(org);
    }

    @DeleteMapping("/organizationId")
    public void deleteOrganization(@PathVariable("organizationId") String orgId , @RequestBody  Organization org)
    {
        this.service.deleteOrg(org);
    }

}
