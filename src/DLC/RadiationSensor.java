package DLC;

import java.util.ArrayList;
import java.util.List;

// датчик радиации
public class RadiationSensor implements Sensor{
    private int radiationLevel; // уровень радиации
    private final List<Observer> observers = new ArrayList<>(); // список наблюдателей

    // устанавливаем значение радиации и уведомляем наблюдателей
    public void setRadiationLevel(int radiationLevel) {
        this.radiationLevel = radiationLevel;
        notifyObservers();
    }

    // получение текущего значения радиации
    public int getRadiationLevel() {
        return radiationLevel;
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
