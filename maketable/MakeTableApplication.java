package org.example.maketable;

import org.example.maketable.TelemetryRestAPI.FileReader;
import org.example.maketable.TelemetryRestAPI.TelemetryModel;
import org.example.maketable.TelemetryRestAPI.TelemetryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class MakeTableApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakeTableApplication.class, args);
	}


		@Bean
		public CommandLineRunner Telemetry (TelemetryRepo telemetryRepo){
			return args -> {
				while (true) {
					FileReader R = new FileReader();
					String data = R.getData();
					TelemetryModel T1 = new TelemetryModel(data);
					telemetryRepo.save(T1);
					Thread.sleep(6000);
				}
			};
		}
}