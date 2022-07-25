package osakitsukiko.rezehack.modules.misc;

import osakitsukiko.rezehack.modules.Module;
import osakitsukiko.rezehack.utils.Setting;

public class Test extends Module {
    public Test() {
        super("test", "Test", Category.MISC, "O _ O");
    }

    Setting<Boolean> boolean_setting = register(new Setting<>("spamtheconsole", "Spam The Console", "DO IT! DO IT! DO IT!", this, true));
    Setting<Integer> int_setting = register(new Setting("leinteger", "Le Integer", "Magic!", this, 10, 0, 100));

    @Override
    public void onUpdate() {
        if ( boolean_setting.getValue() == true ) {
            System.out.println("TICK > OWO");
        }
    }
}
