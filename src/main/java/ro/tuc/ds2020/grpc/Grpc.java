package ro.tuc.ds2020.grpc;

import ro.tuc.ds2020.services.PillboxService;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Order(2)
public class Grpc implements CommandLineRunner {
    private final PillboxService pillboxService;

    @Override
    public void run(String... args) {
        Server server = ServerBuilder.forPort(9090)
                .addService(pillboxService).build();

        try {
            server.start();
            System.out.println("gRPC server started on: " + server.getPort());
            server.awaitTermination();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
