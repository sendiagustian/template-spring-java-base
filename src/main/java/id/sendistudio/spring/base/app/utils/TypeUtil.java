package id.sendistudio.spring.base.app.utils;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
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

    public String generateOTP(Integer digit) {
        String otp = "";
        for (int i = 0; i < digit; i++) {
            otp += (int) (Math.random() * 10);
        }
        return otp;
    }

    public BigInteger generateExpiredAtByDay(Integer dayPlus) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(dayPlus);
        Timestamp timestamp = Timestamp.valueOf(tomorrow);
        return BigInteger.valueOf(timestamp.getTime());
    }

    public BigInteger generateExpiredAtByHour(Integer hourPlus) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusHours(hourPlus);
        Timestamp timestamp = Timestamp.valueOf(tomorrow);
        return BigInteger.valueOf(timestamp.getTime());
    }

    public BigInteger generateExpiredAtByMinute(Integer minutePlus) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusMinutes(minutePlus);
        Timestamp timestamp = Timestamp.valueOf(tomorrow);
        return BigInteger.valueOf(timestamp.getTime());
    }

    public Integer getPagginationOffset(Integer page, Integer size) {
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

        private String columnName;

        @Override
        public String mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
            return rs.getString(columnName);
        }
    }

    @AllArgsConstructor
    public static class IntegerRowMapper implements RowMapper<Integer> {

        private String columnName;

        @Override
        public Integer mapRow(@NonNull ResultSet rs, int rowNum) throws SQLException {
            return rs.getInt(columnName);
        }
    }

}
