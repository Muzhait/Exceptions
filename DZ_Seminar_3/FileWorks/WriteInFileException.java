package DZ_Seminar_3.FileWorks;

import java.io.IOException;

public class WriteInFileException extends IOException {
    public WriteInFileException(String message, Throwable cause) {

        super(message, cause);
    }
}