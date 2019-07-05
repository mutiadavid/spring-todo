/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.helpers;

import com.fasterxml.uuid.Generators;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 *
 * @author musembi
 */
@Service
public class PrimaryKeyValue {

    public UUID getKey() {
        UUID x = Generators.timeBasedGenerator().
                generate();
        return x;
    }

    public String getCurrentTimeStamp(Date date) {
        String strDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(date);
        return strDate;
    }

    public Date Gettimestamp(long timestamp) throws ParseException {
    Timestamp timestamp1=new Timestamp(timestamp);
    return  Date.from(LocalDateTime.ofInstant(timestamp1.toInstant(), ZoneId.systemDefault()).atZone(ZoneId.systemDefault()).toInstant());
    
    }

    public String RoundOffuP(double Amount,
            int decimalPlaces) {

        return (String.format("%." + decimalPlaces + "f",
                Amount));
    }

    public double RoundOffDown(double Amount,
            int decimalPlaces) {
        BigDecimal bigDecimal = new BigDecimal(Amount);
        bigDecimal.setScale(decimalPlaces,
                RoundingMode.HALF_DOWN);
        return bigDecimal.doubleValue();
    }

    public long RoundTolong(double Amount) {
        return Math.round(Amount);
    }

    public UUID ConvertStringToUuid(String value) {
        return UUID.fromString(value);
    }
}
