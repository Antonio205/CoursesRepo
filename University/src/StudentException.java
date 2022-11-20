public class StudentException extends  Exception {
    public StudentException(String message) {
        super(message);
    }

    public StudentException(String message, Throwable e){
        super(message, e);
    }
}
