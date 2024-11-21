package dev.thew.regions.handler.command;

import dev.thew.regions.Regions;
import dev.thew.regions.handler.command.command.BaseCommandExecutor;
import dev.thew.regions.handler.Handler;
import dev.thew.regions.handler.region.RegionHandler;
import dev.thew.regions.handler.regionType.RegionTypeHandler;
import org.bukkit.command.PluginCommand;

public final class CommandService implements Handler {

    private final Regions instance;
    private final RegionHandler regionHandler;
    private final RegionTypeHandler regionTypeHandler;

    public CommandService(final Regions instance, final RegionHandler regionHandler, final RegionTypeHandler regionTypeHandler) {
        this.instance = instance;
        this.regionHandler = regionHandler;
        this.regionTypeHandler = regionTypeHandler;
    }

    @Override
    public void load() {
        hookCommand();
    }

    @Override
    public void shutdown() {}

    private void hookCommand() {
        PluginCommand command = instance.getCommand("base");
        if (command != null) command.setExecutor(new BaseCommandExecutor(regionHandler, regionTypeHandler));
    }
}