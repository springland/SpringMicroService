package com.springland365.license.controller;

import com.springland365.license.model.License;
import com.springland365.license.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/organizations/{organizationId}/licenses")
public class LicenseController {

    @Autowired
    LicenseService licenseService;

    @GetMapping("/")
    public List<License> getLicenses(@PathVariable("organizationId") String orgainizationId )
    {
        return this.licenseService.getLicensesByOrg(orgainizationId);
    }

    @GetMapping("/{licenseId}")
    public License getLicenses(
            @PathVariable("organizationId") String orgainizationId ,
            @PathVariable("licenseId") String licenseId
    )
    {
        return this.licenseService.getLicense(orgainizationId , licenseId , "");
    }

    @GetMapping(value="/{licenseId}/{clientType}")
    public License getLicensesWithClient( @PathVariable("organizationId") String organizationId,
                                          @PathVariable("licenseId") String licenseId,
                                          @PathVariable("clientType") String clientType) {

        return licenseService.getLicense(organizationId,licenseId, clientType);
    }
    @PostMapping("/")
    public void saveLicense(@RequestBody License license)
    {
        this.licenseService.saveLicense(license);
    }

}
