package osakitsukiko.rezehack.modules;

// import osakitsukiko.rezehack.modules.combat.*;
import osakitsukiko.rezehack.modules.misc.*;
// import osakitsukiko.rezehack.modules.movement.*;
import osakitsukiko.rezehack.modules.render.*;

import java.util.ArrayList;
import java.util.Comparator;

public class ModuleManager {
    public static ArrayList<Module> modules;

    public static void init() {
        modules = new ArrayList<>();

        modules.add(new Fullbright());
        modules.add(new Test());

        modules.sort(Comparator.comparing(object -> object.name));
    }

    public static Module getModule(String name) {
        Module m = null;
        for (Module module : modules) {
            if (name.equalsIgnoreCase(module.name)) m = module;
        }
        return m;
    }

    public static ArrayList<Module> getModulesInCategory(Module.Category category) {
        ArrayList<Module> cat = new ArrayList<>();
        for (Module module : modules) {
            if (module.category.equals(category)) cat.add(module);
        }
        return cat;
    }

    public static ArrayList<String> getModuleNames() {
        ArrayList<String> names = new ArrayList<>();
        for (Module module : modules) {
            names.add(module.getName());
        }
        return names;
    }
}
