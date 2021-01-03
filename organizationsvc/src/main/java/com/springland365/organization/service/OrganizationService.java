package com.springland365.organization.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springland365.organization.model.Organization;
import com.springland365.organization.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class OrganizationService {
    @Autowired
    OrganizationRepository  repository;

    @HystrixCommand
    public Organization getOrganization(String organizationId)
    {
        return this.repository.findById(organizationId).get();
    }

    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(
                            name="execution.isolation.thread.timeoutInMilliseconds",
                            value="12000")
            }

    )
    public void saveOrg(Organization org){
        org.setId( UUID.randomUUID().toString());

        repository.save(org);

    }

    @HystrixCommand
    public void updateOrg(Organization org){
        repository.save(org);
    }

    @HystrixCommand(
            commandProperties = {
                    @HystrixProperty(
                            name="execution.isolation.thread.timeoutInMilliseconds",
                            value="12000")
            }

    )
    public void deleteOrg(Organization org){
        repository.delete(org);
    }


    @HystrixCommand(
            fallbackMethod = "buildFallback",
            threadPoolKey = "licenseByOrgThreadPool",
            threadPoolProperties =
                    {@HystrixProperty(name = "coreSize",value="30"),
                            @HystrixProperty(name="maxQueueSize", value="10") }
    )
    public Organization runRandomLong(String organizationId)  {
        Random rand = new Random();
        int randomNum = rand.nextInt((3 - 1) + 1) + 1;

        if (randomNum==3)
        {
            try {
                Thread.sleep(11000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return Organization.builder().name("RandomLong")
                .id("RandomLongTest")
                .contactEmail("test@yahoo.com")
                .build();



    }

    public Organization buildFallback(String organizationId)
    {
        return Organization.builder().name("Fallback")
                .id("Fallback")
                .contactEmail("fallback@yahoo.com")
                .build();

    }

}
