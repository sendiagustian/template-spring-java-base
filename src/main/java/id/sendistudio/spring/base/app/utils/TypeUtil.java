package id.sendistudio.spring.base.app.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
public class TypeUtil {

    String genereateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @AllArgsConstructor
    public static class StringRowMapper implements RowMapper<String> {

        private String name;

        @Override
        public String mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
            return rs.getString(name);
        }
    }

}
