package com.springland365.license.service;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscoveryService {
    @Autowired
    RestTemplate restTemplate ;

    @Autowired
    private EurekaClient discoveryClient;

    public List<String> getEurekaServices() {
        List<String> services = new ArrayList<String>();

        discoveryClient.getApplications().getRegisteredApplications().stream()
                .forEach(
                        application -> {
                            application.getInstances().forEach(
                                    instance ->
                                    {

                                        services.add(String.format("%s:%s:%d", instance.getAppName(), instance.getIPAddr() , instance.getPort()));
                                    }
                            );

                        }

                );

        return services;
    }
}
