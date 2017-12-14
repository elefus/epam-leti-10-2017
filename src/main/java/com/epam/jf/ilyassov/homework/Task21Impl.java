package com.epam.jf.ilyassov.homework;

import com.epam.jf.common.homework.Task21;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Task21Impl extends Task21 {

    public static void main(String[] args) {
        Task21 task = new Task21Impl();
        List<IMeasurement> measurements=new LinkedList<>();
        IMeasurementImpl iMeasurement1 = new IMeasurementImpl(0.1,0.5);
        IMeasurementImpl iMeasurement2 = new IMeasurementImpl(0.2,0.6);
        IMeasurementImpl iMeasurement3 = new IMeasurementImpl(0.3,0.7);
        measurements.add(iMeasurement1);
        measurements.add(iMeasurement2);
        measurements.add(iMeasurement3);

        System.out.println(task.calcResistance(measurements));

    }

    @Override
    public BigDecimal calcResistance(List<IMeasurement> measurements) {
        double UI = 0;
        double I=0;
        for (int i = 0; i < measurements.size(); i++) {
            UI+=measurements.get(i).getCurrent()*measurements.get(i).getVoltage();
            I+=measurements.get(i).getCurrent()*measurements.get(i).getCurrent();
        }
        BigDecimal bigDecimal=new BigDecimal(UI/I);
        BigDecimal decimal = bigDecimal.setScale(6, BigDecimal.ROUND_DOWN);

        return decimal;
    }
}
