package osakitsukiko.rezehack.modules;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Formatting;
import osakitsukiko.rezehack.RezeHack;
import osakitsukiko.rezehack.command.Command;
import osakitsukiko.rezehack.utils.Setting;
import osakitsukiko.rezehack.utils.SettingsManager;

import java.util.ArrayList;

public class Module {
    protected final MinecraftClient mc = MinecraftClient.getInstance();
    public ArrayList<Setting> settings;

    String name, display_name, description;
    Category category;
    boolean enabled; // , drawn;
    int bind;

    public Module(String name, String display_name, Category category, String description) {
        this.settings = new ArrayList<>();
        this.name = name;
        this.display_name = display_name;
        this.description = description;
        this.category = category;
        this.enabled = false;
        // this.drawn = true;
        this.bind = 0;
    }

    public String getName() {
        return name;
    }
    public String getDisplayName() {
        return display_name;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    /* public boolean isDrawn() {
        return drawn;
    } */

    public int getBind() {
        return bind;
    }

    public void setEnabled(boolean enabled) {
        if (enabled) enable();
        else disable();
    }

    /* public void setDrawn(boolean drawn) {
        this.drawn = drawn;
    } */

    public void setBind(int bind) {
        this.bind = bind;
    }

    public String getDescription() {return description;}

    public void enable() {
        enabled = true;
        // to make global settings and add a way to enable/disable this
        if(RezeHack.mc != null) Command.sendMessage(name + Formatting.GREEN + " enabled!");
        RezeHack.EVENT_BUS.subscribe(this);
        onEnable();
    }

    public void disable() {
        enabled = false;
        if(RezeHack.mc != null) Command.sendMessage(name + Formatting.RED + " disabled!");
        RezeHack.EVENT_BUS.unsubscribe(this);
        onDisable();
    }

    public void toggle() {
        if (enabled) disable();
        else enable();
    }

    public void onEnable() {}

    public void onDisable() {}

    public void onUpdate() {}

    public void onRender(MatrixStack matrices) {}

    public Setting register(Setting setting) {
        SettingsManager.register(setting);
        this.settings.add(setting);
        return setting;
    }

    public enum Category {
        COMBAT("Combat"),
        MISC("Misc"),
        RENDER("Render"),
        MOVEMENT("Movement");

        String name;

        Category(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

}
