package Algorithms;

import java.util.HashMap;
import java.util.Map;

public class Function {
    Map<String,Algorithm> function;

    public Function(Map function) {
        this.function = function;
    }

    public Function() {
        function = new HashMap<>();
        function.put("FunctionOne",new IncrementSpectraOnOne());
        function.put("FunctionTwo",new IncrementSpectraOnTwo());
    }

    public Map getFunction() {
        return function;
    }

    public void setFunction(Map function) {
        this.function = function;
    }
}
