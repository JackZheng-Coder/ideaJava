package com.horsman.corejava;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @ClassName:
 * @Description:
 * @author:
 * @date:
 * @Version:
 * @Copyright:
 */
public class ZonedTimes {
    public static void main(String[] args) {
        ZonedDateTime apollo11launch = ZonedDateTime.of(1969,7,16,9,32,0,0,
                ZoneId.of("America/New_York"));
        System.out.println("apollo11launch:"+apollo11launch);

        Instant instant = apollo11launch.toInstant();
        System.out.println("instant:"+instant);

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("UTC"));
        System.out.println("zonedDateTime:"+zonedDateTime);
    }
}
