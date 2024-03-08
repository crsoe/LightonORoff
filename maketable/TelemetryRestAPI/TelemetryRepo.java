package org.example.maketable.TelemetryRestAPI;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TelemetryRepo extends JpaRepository<TelemetryModel, Float> {
}
