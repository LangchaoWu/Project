

public class resname {
	public String name;
	public String XCoordinate; 
	public String YCoordinate;
	public double distance;
	public void setName(String name) {
		this.name = name;
	}
	public void setX(String x) {
		this.XCoordinate=x;
		
	}
	public void setY(String y) {
		this.YCoordinate =y;
	}
	public String getName() {
		return name;
	}
	public String getX() {
		return XCoordinate;	
	}
	public String getY() {
		return YCoordinate;
	}
	public void setDistance(double d) {
		this.distance =d;
	}
	public double getDistance() {
		return distance;
	}
	
	 

}
