package osakitsukiko.rezehack.modules.render;

import net.minecraft.client.option.SimpleOption;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import osakitsukiko.rezehack.modules.Module;
import osakitsukiko.rezehack.utils.Setting;

import java.util.ArrayList;

public class Fullbright extends Module {
    public Fullbright() {
        super("fullbright", "Fullbright", Category.RENDER, "Lights up your world!");
        fb_type_options.add("gamma");
        fb_type_options.add("night_vision");

    }

    ArrayList<String> fb_type_options = new ArrayList<String>();
    public Setting<String> fb_type = register(new Setting("type", "Type", "type of fullbright", this, fb_type_options, "night_vision"));

    @Override
    public void onUpdate() {
        if (fb_type.getValue().equalsIgnoreCase("night_vision")) {
            mc.player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 500, 0));
        }
    }

    @Override
    public void onDisable() {
        if (fb_type.getValue().equalsIgnoreCase("night_vision"))
            mc.player.removeStatusEffect(StatusEffects.NIGHT_VISION);
    }

}
