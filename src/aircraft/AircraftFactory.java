package aircraft;

public class AircraftFactory {

    public static Flyable newAircarft(String type, String name, int longitude, int latitude, int height){

        Coordinates coordinates = new Coordinates(longitude,latitude, height);

		 switch (type)
		 {
		 	case "Helicopter":
		 		return new Helicopter(name, coordinates);
		 	case "JetPlane":
		 		return new JetPlane(name, coordinates);
		 	case "Baloon":
		 		return new Baloon(name, coordinates);
		 	default:
		 		return null;
		 }
    }

}
