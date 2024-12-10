package DLC;

public class Alarm {
    public static void main(String[] args) {
        // экземпляры датчики
        RadiationSensor radiationSensor = new RadiationSensor();
        PressureSensor pressureSensor = new PressureSensor();
        PressureDifferenceSensor pressureDifferenceSensor = new PressureDifferenceSensor();

        // система сигнализации
        AlarmSystem alarmSystem = new AlarmSystem(radiationSensor, pressureSensor, pressureDifferenceSensor);

        // устанавливаем значения датчиков для аварийной системы
        radiationSensor.setRadiationLevel(20); // Сработает сигнализация по радиации
        pressureSensor.setPressure(130);       // Сработает сигнализация по давлению
        pressureDifferenceSensor.setPressureDifference(60); // Сработает сигнализация по перепаду давления
    }
}