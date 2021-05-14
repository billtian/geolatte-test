package tech.kungfu.examples.geolattetest;

import lombok.*;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystem;

import javax.persistence.*;

@Data
@EqualsAndHashCode(of = "id")
@Entity
public class Place {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  private String name;

  @Convert(converter = CrsStringConverter.class)
  private CoordinateReferenceSystem spatialRef;

  private Point position;
}
