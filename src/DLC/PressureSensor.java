package DLC;

import java.util.ArrayList;
import java.util.List;

// датчик давления
public class PressureSensor implements Sensor{
    private double pressure; // значение давления
    private final List<Observer> observers = new ArrayList<>(); // список наблюдателей

    // устанавливаем значение радиации и уведомляем наблюдателей
    public void setPressure(double pressure) {
        this.pressure = pressure;
        notifyObservers();
    }

    // получение текущего значения давления
    public double getPressure() {
        return pressure;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}