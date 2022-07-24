package osakitsukiko.rezehack.utils;

import osakitsukiko.rezehack.modules.Module;

import java.util.ArrayList;

/*
    Is there really a need for a Settings manager?
    Cant each setting be binded to the module directly?
    TODO: Look into binding setting directly to module bypassing the SettingsManager
*/

public class SettingsManager {
    public static ArrayList<Setting> settings;

    public static void init() {
        settings = new ArrayList<>();
    }

    public static void register(Setting setting) {
        settings.add(setting);
    }

    public static Setting getSetting(Module parent, String name) {
        for (Setting setting : settings) {
            if (parent.equals(setting.parent) && name.equalsIgnoreCase(setting.name)) return setting;
        }
        return null;
    }

    public static ArrayList<Setting> getSettings(Module parent) {
        ArrayList<Setting> sets = new ArrayList<>();
        for (Setting setting : settings) {
            if (setting.parent.equals(parent)) sets.add(setting);
        }
        return sets;
    }
}
