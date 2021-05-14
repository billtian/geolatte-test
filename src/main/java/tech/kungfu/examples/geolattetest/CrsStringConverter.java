package tech.kungfu.examples.geolattetest;

import lombok.extern.log4j.Log4j2;
import org.geolatte.geom.crs.CoordinateReferenceSystem;
import org.geolatte.geom.crs.CrsId;
import org.geolatte.geom.crs.CrsRegistry;
import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;

@Log4j2
@Component
public class CrsStringConverter implements AttributeConverter<CoordinateReferenceSystem, String> {

  @Override
  public String convertToDatabaseColumn(CoordinateReferenceSystem crs) {
    return null == crs ? null : crs.getCrsId().toString();
  }

  @Override
  public CoordinateReferenceSystem convertToEntityAttribute(String crsid) {
    if (null == crsid || crsid.isEmpty())
      return null;
    CoordinateReferenceSystem crs = null;
    try {
      crs = CrsRegistry.getCoordinateReferenceSystem(CrsId.parse(crsid), null);
    }
    catch (Exception e) {
      log.error("create crs failed. {}", e.getMessage());
    }
    return crs;
  }
}
