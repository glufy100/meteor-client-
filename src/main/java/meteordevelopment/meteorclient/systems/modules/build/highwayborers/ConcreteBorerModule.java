package meteordevelopment.meteorclient.systems.modules.build.highwayborers;

import meteordevelopment.meteorclient.events.world.TickEvent;
import net.minecraft.util.math.BlockPos;

public class ConcreteBorerModule extends BorerModule {

    public ConcreteBorerModule() {
        super("concrete-borer", "Implémentation concrète du BorerModule", 3, 3, 0, 0);
    }

    @Override
    public void onTick(TickEvent.Pre event) {
        if (mc.player == null || mc.world == null) return;
        playerPos = mc.player.getBlockPos();

        // Réinitialiser le compteur de paquets toutes les secondes pour éviter les blocages
        if (System.currentTimeMillis() - lastUpdateTime > 1000) {
            packets = 0;
            lastUpdateTime = System.currentTimeMillis();
        }

        // Utiliser l'implémentation choisie en fonction du mode
        if (mode.get() == Shape.HIGHWAY) {
            doHighway4(playerPos);
        } else {
            do2x3(playerPos);
        }
    }
}