package com.springland365.organization.controller;

import com.springland365.organization.model.Organization;
import com.springland365.organization.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="v1/organizations")
public class OrganizationController {

    @Autowired
    protected OrganizationService  service ;

    @GetMapping("/{orgainzationId}")
    public Organization  getOrganization(@PathVariable("orgainzationId") String organizationId)
    {
        return this.service.getOrganization(organizationId);
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
