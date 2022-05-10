package KimuraStore.Enity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperSlide implements RowMapper<Slide> {
    @Override
    public Slide mapRow(ResultSet resultSet, int i) throws SQLException {
        Slide slide = new Slide();
        slide.setId(resultSet.getInt("id"));
        slide.setImage(resultSet.getString("image"));
        return slide;
    }
}
