Spent more than 2 days working on why the organiation service does not bootstrap from configuration server. Finally found it was the spring cloud 2020.0.0 change
Need to add the below explicatly to enable bootstrap from configuration server

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-bootstrap</artifactId>
			<version>3.0.0-M5</version>
		</dependency>


Need to use
<parent>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-parent</artifactId>
<version>2.3.7.RELEASE</version>
<relativePath/> <!-- lookup parent from repository -->
</parent>
in order to get back netflix components with spring cloud version 

<spring-cloud.version>Hoxton.SR9</spring-cloud.version>


SpringBoot 2.4.0 changes

