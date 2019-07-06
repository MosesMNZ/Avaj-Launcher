package aircraft;

import weather.Logger;
import weather.Simulation;
import weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower = Simulation.weatherTower;

    JetPlane(String name, Coordinates coordinates){
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
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
                Logger.log("JetPlane#" + this.name + "(" + this.id + ") Damn you rain! you messed up everything");
                break;
            case "FOG":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
                Logger.log("JetPlane#" + this.name + "(" + this.id + ") Eish!!! Too much fog!!");
                break;
            case "SUN":
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
                Logger.log("JetPlane#" + this.name + "(" + this.id + ") Youpi!!! There is the sun");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 7);
                if(this.coordinates.getHeight() > 100) {this.coordinates.setHeight(100);}
                Logger.log("JetPlane#" + this.name + "(" + this.id + ") Hard to handle things with this snow");
                break;
            default:
                return ;
        }

        if(this.coordinates.getHeight() <= 0){
            Logger.log("JetPlane#" + this.name + "(" + this.id + ") is finally landing");
            Logger.log("Tower says : JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower");
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower){
        Logger.log("Tower says : JetPlane#" + this.name + "(" + this.id + ") registered to weather tower");
    }
}
