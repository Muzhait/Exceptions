package DZ_Seminar_3;

import DZ_Seminar_3.FileWorks.WriteInFileException;
import DZ_Seminar_3.InputWorks.InputString;

import static DZ_Seminar_3.FileWorks.FileWorks.printAll;
import static DZ_Seminar_3.InputWorks.InputString.*;

import static DZ_Seminar_3.Preparing.Preparing.*;

public class Main {
    public static void main(String[] args) throws WriteInFileException {
        InputAb();
        if (more) {
            printAll(abonentArrayList);
        }
    }
}
