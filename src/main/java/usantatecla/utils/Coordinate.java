package usantatecla.utils;

public interface Coordinate {
	
	boolean isNull();
	Direction getDirection(Coordinate coordinate);
	boolean inHorizontal(Coordinate coordinate);
	boolean inVertical(Coordinate coordinate);
	boolean inMainDiagonal();

}