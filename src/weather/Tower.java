package weather;

import aircraft.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower {

    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        try {
            if (observers.contains(flyable) == true) {
                return;
            }
            observers.add(flyable);
        } catch (Exception e) {
            System.out.println("Can not register a new flyable.");
        }
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}