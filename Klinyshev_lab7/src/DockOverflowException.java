public class DockOverflowException extends Exception {
    public DockOverflowException() {
        super("В доке нет свободных мест");
    }
}
