public class DockOccupiedPlaceException extends Exception {
    public DockOccupiedPlaceException(int i) {
        super("На месте " + i + "уже стоит лодка");
    }
}
