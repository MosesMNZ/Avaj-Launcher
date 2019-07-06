package aircraft;

import weather.Logger;
import weather.WeatherTower;
import weather.Simulation;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower = Simulation.weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);

        this.coordinates.setLatitude(coordinates.getLatitude());
        this.coordinates.setLongitude(coordinates.getLongitude());
        this.coordinates.setHeight(coordinates.getHeight());
        registerTower(weatherTower);
    }

    @Override
    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);

        switch (weather) {
            case "RAIN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 5);
                if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
                Logger.log("Helicopter#" + this.name + "(" + this.id + ") Oooh! Nooooo! Sick and tied of this rain!");
                break;
            case "FOG":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 1);
                if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
                Logger.log("Helicopter#" + this.name + "(" + this.id + ") Fogs again!!!!");
                break;
            case "SUN":
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 10);
                if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
                Logger.log("Helicopter#" + this.name + "(" + this.id + ") Yesss! The sun is out");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
                Logger.log("Helicopter#" + this.name + "(" + this.id + ") I hate this snow!");
                break;
            default:
                return ;
        }

        if(this.coordinates.getHeight() <= 0){
            Logger.log("Helicopter#" + this.name + "(" + this.id + ") Has landed");
            Logger.log("Tower says : Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower");
            weatherTower.unregister(this);
        }


    }

    public void registerTower(WeatherTower weatherTower){
        Logger.log("Tower says : Helicopter#" + this.name + "(" + this.id + ") registered to weather tower");

    }
}
