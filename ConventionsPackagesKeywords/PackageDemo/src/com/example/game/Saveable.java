package com.example.game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface Saveable {
    List<String> read();
    void write(List<String> savedValues);
}
