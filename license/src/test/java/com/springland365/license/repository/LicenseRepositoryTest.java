package com.springland365.license.repository;

import com.springland365.license.model.License;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ActiveProfiles("test")
@SpringBootTest
public class LicenseRepositoryTest {
    @Autowired
    ILicenseRepository  licenseRepository ;
    @Test
    public void testCRUD()
    {
        String licenseId = "test_license_id";
        String organizationId = "test_organizationId";
        License license = License.builder()
                            .licenseId(licenseId)
                            .organizationId(organizationId)
                            .licenseType("seat")
                            .licenseMax(10)
                            .licenseAllocated(2)
                            .productName("test_product_name")
                            .build();
        licenseRepository.save(license);

        License result = licenseRepository.findByOrganizationIdAndLicenseId( organizationId , licenseId );
        assertEquals(result , license);

        licenseRepository.delete(license);
        result = licenseRepository.findByOrganizationIdAndLicenseId( organizationId , licenseId );
        assertNull(result);

    }
}
