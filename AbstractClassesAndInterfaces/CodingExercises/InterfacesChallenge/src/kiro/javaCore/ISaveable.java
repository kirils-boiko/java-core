package kiro.javaCore;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface ISaveable {
    List<String> read();
    void write(List<String> savedValues);
}
