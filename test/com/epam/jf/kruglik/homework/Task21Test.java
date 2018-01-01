package com.epam.jf.kruglik.homework;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class Task21Test {

    @Test
    void calcResistance() {
        ArrayList<Task21.IMeasurement> meas = new ArrayList<>();
        meas.add(new Task21.Measurement(0.1,0.27));
        meas.add(new Task21.Measurement(0.2,0.56));
        meas.add(new Task21.Measurement(0.3,0.9));
        meas.add(new Task21.Measurement(0.4,1.18));
        meas.add(new Task21.Measurement(0.5,1.49));
        meas.add(new Task21.Measurement(0.6,1.79));
        meas.add(new Task21.Measurement(0.7,2.05));
        meas.add(new Task21.Measurement(0.8,2.42));
        meas.add(new Task21.Measurement(0.9,2.68));
        meas.add(new Task21.Measurement(1.0,3.01));
        meas.add(new Task21.Measurement(1.1,3.35));
        meas.add(new Task21.Measurement(1.2,3.56));
        meas.add(new Task21.Measurement(1.3,3.85));
        meas.add(new Task21.Measurement(1.4,4.18));
        meas.add(new Task21.Measurement(1.5,4.48));
        meas.add(new Task21.Measurement(1.6,4.79));
        meas.add(new Task21.Measurement(1.7,5.12));
        meas.add(new Task21.Measurement(1.8,5.45));
        meas.add(new Task21.Measurement(1.9,5.68));
        meas.add(new Task21.Measurement(2.0,5.9));
        assertTrue(((new Task21().calcResistance(meas)) - 2.98944250)<=0.000001);
    }
}