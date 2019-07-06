package aircraft;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter;

    protected  Aircraft(String name, Coordinates coordinates){
        this.id = idCounter;
        nextId();
		 if (name == null || coordinates == null)
		 {
		 	name = "Unknown";
		 	coordinates = new Coordinates(0,0,0);
		 }
		 else
		 {
		 	this.name = name;
		 	this.coordinates = coordinates;
		 }
    }

    private long nextId(){
        return this.idCounter++;
    }
}
