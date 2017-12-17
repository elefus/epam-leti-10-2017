package com.epam.jf.dementyev.homework;

import java.math.BigDecimal;
import java.util.List;

public class Task21 extends com.epam.jf.common.homework.Task21 {

    @Override
    public double calcResistance(List<IMeasurement> measurements) {
        if (measurements == null) {
            throw new IllegalArgumentException("measurements is null");
        }
        double r = 0;
        if (!measurements.isEmpty()) {
            BigDecimal ui = new BigDecimal(0);
            BigDecimal ii = new BigDecimal(0);
            for (IMeasurement m : measurements) {
                BigDecimal u = new BigDecimal(m.getVoltage());
                BigDecimal i = new BigDecimal(m.getCurrent());
                ui = ui.add(u.multiply(i));
                ii = ii.add(i.pow(2));
            }
            r = ui.divide(ii, 6, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
        return r;
    }
}
