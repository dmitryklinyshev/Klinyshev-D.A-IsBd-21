public class DockNotFoundException extends Exception {
    public DockNotFoundException(int i) {
        super("Не найдена лодка по месту " + i);
    }
}
