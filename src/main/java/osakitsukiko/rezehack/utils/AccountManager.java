package osakitsukiko.rezehack.utils;

import net.minecraft.client.util.Session;
import osakitsukiko.rezehack.mixin.MinecraftClientAccessor;

import java.util.ArrayList;
import java.util.Optional;

import static osakitsukiko.rezehack.RezeHack.mc;

public class AccountManager {
    protected static void setSession(Session session) {
        ((MinecraftClientAccessor) mc).setSession(session);
        mc.getSessionProperties().clear();
    }

    public static boolean crackedLogin(String name) {
        setSession(new Session(name, "", "", Optional.empty(), Optional.empty(), Session.AccountType.MOJANG));
        return true;
    }
}
