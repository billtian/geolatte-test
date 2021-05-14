package tech.kungfu.examples.geolattetest;

import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.geolatte.geom.json.GeolatteGeomModule;;
import org.geolatte.geom.builder.DSL;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GeolatteTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeolatteTestApplication.class, args);
	}

	@Bean
	CommandLineRunner init(PlaceRepository repo) {
		return (String... strings) -> {
			Place p1 = new Place();
			p1.setName("p1");
			p1.setPosition(new Point(DSL.g(114, 39), CoordinateReferenceSystems.WGS84));
			p1.setSpatialRef(CoordinateReferenceSystems.WGS84);
			repo.save(p1);
		};
	}

	@Bean
	public GeolatteGeomModule jacksonGeolatteGeomModule() {
		return new GeolatteGeomModule();
	}

}
