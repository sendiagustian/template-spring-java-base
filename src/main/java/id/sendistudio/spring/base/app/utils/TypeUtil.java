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

    public String genereateUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public Integer getOffset(Integer page, Integer size) {
        Integer offset = 0;

        if (page == 1) {
            offset = 0;
        } else {
            Integer pageFisrt = 1 * size;
            Integer pageRequest = (page * size);
            offset = pageRequest - pageFisrt;
        }

        if ((page - 1) > offset) {
            throw new IllegalArgumentException("Page not found");
        }
        return offset;
    }

    @AllArgsConstructor
    public static class StringRowMapper implements RowMapper<String> {

        private String name;

        @Override
        public String mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
            return rs.getString(name);
        }
    }

    @AllArgsConstructor
    public static class IntegerRowMapper implements RowMapper<Integer> {

        private String name;

        @Override
        public Integer mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
            return rs.getInt(name);
        }
    }

}
