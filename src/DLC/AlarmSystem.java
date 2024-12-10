package DLC;

// сигнализация
public class AlarmSystem implements Observer {
    private final RadiationSensor radiationSensor; // датчик радиации
    private final PressureSensor pressureSensor; // датчик давления
    private final PressureDifferenceSensor pressureDifferenceSensor; // датчик перепада давления

    // все датчики в конструкторе
    public AlarmSystem(RadiationSensor radiationSensor, PressureSensor pressureSensor, PressureDifferenceSensor pressureDifferenceSensor) {
        this.radiationSensor = radiationSensor;
        this.pressureSensor = pressureSensor;
        this.pressureDifferenceSensor = pressureDifferenceSensor;

        // уведомления от всех датчиков
        radiationSensor.addObserver(this);
        pressureSensor.addObserver(this);
        pressureDifferenceSensor.addObserver(this);
    }

    @Override
    public void update() {
        checkAlarm(); // проверяем все условия при каждом уведомлении
    }

    // условия аварийной сигнализации
    private void checkAlarm() {
        if (radiationSensor.getRadiationLevel() > 15) {
            System.out.println("Авария! Уровень радиации превышает норму!" + " (Норма 15) " +"Текущее значение"+ radiationSensor.getRadiationLevel());
        }
        if (pressureSensor.getPressure() == 0 || pressureSensor.getPressure() > 120) {
            System.out.println("Авария! Давление находится вне допустимых пределов!" + " (Давление 0 или больше 120) " +"Текущее значение"+ pressureSensor.getPressure());
        }
        if (pressureDifferenceSensor.getPressureDifference() > 50) {
            System.out.println("Авария! Перепад давления превышает норму!" + " (Перепад давления больше 50) " +"Текущее значение "+ pressureDifferenceSensor.getPressureDifference());
        }
    }
}
