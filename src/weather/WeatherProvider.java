package weather;

import aircraft.Coordinates;

import java.util.Random;

public class WeatherProvider {


    private  WeatherProvider(){
    }

    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String weather;
    private String[] type = {"RAIN", "FOG", "SUN", "SNOW"};



    public static WeatherProvider getWeatherProvider() {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        Random random = new Random();
        int index = random.nextInt(4);
        weather = type[index];
        return weather;
    }
}

