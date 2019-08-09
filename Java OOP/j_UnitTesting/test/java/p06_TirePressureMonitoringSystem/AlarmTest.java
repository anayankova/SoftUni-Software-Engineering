package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class AlarmTest {

    @Test
    public void alarmShouldBeOnIfOutOfRange(){
        Alarm alarm = new Alarm();
        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.0);
        alarm.setSensor(sensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void alarmShouldBeOffIfInRange() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm = new Alarm();

        Field sensorField = Alarm.class.getDeclaredField("sensor");
        sensorField.setAccessible(true);

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(18.0);
        
        sensorField.set(alarm, sensor);

        Assert.assertFalse(alarm.getAlarmOn());
    }

}