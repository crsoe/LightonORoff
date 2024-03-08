package org.example.maketable.TelemetryRestAPI;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TelemetryModel {


    @Id
    @GeneratedValue
    private Long id;

    private String The_Data;
    public TelemetryModel(String the_Data) {
        this.The_Data = the_Data;
    }
}
