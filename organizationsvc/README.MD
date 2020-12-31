Spent more than 2 days working on why the organiation service does not bootstrap from configuration server. Finally found it was the spring cloud 2020.0.0 change
Need to add the below explicatly to enable bootstrap from configuration server

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-bootstrap</artifactId>
			<version>3.0.0-M5</version>
		</dependency>

