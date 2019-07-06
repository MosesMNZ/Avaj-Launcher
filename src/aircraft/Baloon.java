package aircraft;

import weather.Logger;
import weather.Simulation;
import weather.WeatherTower;

public class Baloon  extends Aircraft implements Flyable {

    private WeatherTower weatherTower = Simulation.weatherTower;
    // private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);

        this.coordinates.setLatitude(coordinates.getLatitude());
        this.coordinates.setLongitude(coordinates.getLongitude());
        this.coordinates.setHeight(coordinates.getHeight());
        registerTower(weatherTower);

        // super(name, coordinates);

    }

    @Override
    public void updateConditions(){

        String weather = weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "RAIN":
            this.coordinates.setHeight(this.coordinates.getHeight() - 5);
            if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
            Logger.log("Baloon#" + this.name + "(" + this.id + ") It's Raining!!!");
            break;
            case "FOG":
            this.coordinates.setHeight(this.coordinates.getHeight() - 3);
            if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
            Logger.log("Baloon#" + this.name + "(" + this.id + ") It's Foggy");
            break;
            case "SUN":
            this.coordinates.setHeight(this.coordinates.getHeight() + 4);
            this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
            if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
            Logger.log("Baloon#" + this.name + "(" + this.id + ") It's Sunny");
            break;
            case "SNOW":
            this.coordinates.setHeight(this.coordinates.getHeight() - 15);
            if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
            Logger.log("Baloon#" + this.name + "(" + this.id + ") Snow again!!! I better land this baloon");
            break;
            default:
                return ;
        }

        if(this.coordinates.getHeight() <= 0){
            Logger.log("Baloon#" + this.name + "(" + this.id + ") Has landed");
            Logger.log("Tower says : Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower");
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        Logger.log("Tower says : Baloon#" + this.name + "(" + this.id + ") registered to weather tower");
    }
}
