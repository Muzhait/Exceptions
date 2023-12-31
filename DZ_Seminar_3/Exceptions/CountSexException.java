package DZ_Seminar_3.Exceptions;

public class CountSexException extends IllegalArgumentException{
    private int needed;
    private int entered;
    public CountSexException(int needed, int entered) {
        super("Количество полей пола не соответствует необходимому\n  Введено " + entered + ", необходимо " + needed);
        this.needed = needed;
        this.entered = entered;
    }
}
