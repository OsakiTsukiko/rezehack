package osakitsukiko.rezehack.utils;

import osakitsukiko.rezehack.modules.Module;

import java.util.ArrayList;

public class Setting<T> {
    String name, display_name, description;
    Module parent;
    T value, min, max, defaultVal;
    ArrayList<T> options;
    Type type;

    public String getName() { return name; }
    public String getDisplayName() { return display_name; }
    public String getDescription() { return description; }
    public Module getParent() { return parent; }
    public T getValue() { return value; }
    public T getDefaultVal() { return defaultVal; }
    public T getMin() { return min; }
    public T getMax() { return max; }
    public ArrayList<T> getOptions() { return options; }
    public Type getType() { return type; }

    public void setValue(T value) { this.value = value; }

    public Setting(String name, String display_name, String description, Module parent, T value) {
        this.name = name;
        this.display_name = display_name;
        this.description = description;
        this.parent = parent;
        this.value = value;
        this.defaultVal = value;
        this.type = Type.BOOLEAN;
    }

    public Setting(String name, String display_name, String description, Module parent, T value, T min, T max) {
        this.name = name;
        this.display_name = display_name;
        this.description = description;
        this.parent = parent;
        this.value = value;
        this.defaultVal = value;
        this.min = min;
        this.max = max;
        if (value instanceof Float) this.type = Type.FLOAT;
        else this.type = Type.INTEGER;
    }

    public Setting(String name, String display_name, String description, Module parent, ArrayList<T> options, T value) {
        this.name = name;
        this.display_name = display_name;
        this.description = description;
        this.parent = parent;
        this.value = value;
        this.defaultVal = value;
        this.options = options;
        this.type = Type.STRING;
    }

    public String getCorrectString(String stringIn) {
        if (this.value instanceof String) {
            for (String s : (ArrayList<String>) options) {
                if (s.equalsIgnoreCase(stringIn)) return s;
            }
            return null;
        }
        return null;
    } // uh

    public enum Type {
        BOOLEAN,
        FLOAT,
        INTEGER,
        STRING
    }
}
