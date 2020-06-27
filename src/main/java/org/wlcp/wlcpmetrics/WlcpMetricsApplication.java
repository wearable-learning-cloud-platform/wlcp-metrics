package org.wlcp.wlcpmetrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class WlcpMetricsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WlcpMetricsApplication.class, args);
	}

}
