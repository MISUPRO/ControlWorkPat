package DLC;

import java.util.ArrayList;
import java.util.List;

// датчик перепада давления
public class PressureDifferenceSensor implements Sensor{
    private double pressureDifference; // значение перепада давления
    private final List<Observer> observers = new ArrayList<>(); // список наблюдателей

    // устанавливаем значение перепада давления и уведомляем наблюдателей
    public void setPressureDifference(double pressureDifference) {
        this.pressureDifference = pressureDifference;
        notifyObservers();
    }

    // получение текущего значения давления
    public double getPressureDifference() {
        return pressureDifference;
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