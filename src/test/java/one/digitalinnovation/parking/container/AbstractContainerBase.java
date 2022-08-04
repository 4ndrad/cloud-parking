package one.digitalinnovation.parking.container;

import org.testcontainers.containers.MySQLContainer;

public abstract class AbstractContainerBase {

    static final MySQLContainer MY_SQL_CONTAINER;
   
    static {
    	 MY_SQL_CONTAINER = new MySQLContainer("mysql:10-alpine");
    	 MY_SQL_CONTAINER.start();
    	 
    	 System.out.println("***********" + MY_SQL_CONTAINER.getJdbcUrl());
    	 
    	 System.setProperty("spring.datasource.url", MY_SQL_CONTAINER.getJdbcUrl());
    	 System.setProperty("spring.datasource.url", MY_SQL_CONTAINER.getUsername());
    	 System.setProperty("spring.datasource.url", MY_SQL_CONTAINER.getPassword());

    }
}
