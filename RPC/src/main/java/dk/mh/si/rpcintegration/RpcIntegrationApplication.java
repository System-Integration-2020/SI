package dk.mh.si.rpcintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class RpcIntegrationApplication {

    public static void main(String[] args) {

        SpringApplication.run(RpcIntegrationApplication.class, args);
        CustomerDAO c = new CustomerDAO();
        try{
        System.out.println(c.testMetode());
        }
        catch (SQLException e){
            System.out.println(e);
        }

    }

}
