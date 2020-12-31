package com.springland365.organization.respository;

import com.springland365.organization.model.Organization;
import com.springland365.organization.repository.OrganizationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ActiveProfiles("test")
public class OrganizationRespsitoryTest {
    @Autowired
    OrganizationRepository repo ;

    @Test
    public void test()
    {

        Organization org = Organization.builder()
                            .id("org1")
                            .name("test org")
                            .contactPhone("203-550-5581")
                            .contactEmail("test@email.com")
                            .contactName("test contact")
                            .build();

        repo.save(org);

        Optional<Organization>  result = repo.findById("org1");

        assertEquals(result.get() , org);
    }
}
