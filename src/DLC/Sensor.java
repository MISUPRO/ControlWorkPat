package DLC;

interface Sensor {
    void addObserver(Observer observer); // добавление наблюдателя
    void removeObserver(Observer observer); // удаление наблюдателя
    void notifyObservers(); // уведомление всех наблюдателей
}