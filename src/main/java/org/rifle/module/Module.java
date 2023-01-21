package org.rifle.module;

import org.rifle.Rifle;
import org.rifle.manager.CommandMap;
import org.rifle.console.logger.ModuleLogger;
import org.rifle.utils.DataFolder;

import java.io.File;

/**
 * @author Huyemt
 */

public abstract class Module implements IModule {
    private final CommandMap commandMap = new CommandMap();
    private ModuleDescription moduleDescription;
    private ModuleLogger logger;
    private DataFolder dataFolder;
    private boolean initialized = false;
    protected boolean selected = false;

    @Override
    public void onLoad() {

    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onQuit() {

    }

    @Override
    public void onDisable() {

    }

    protected abstract String getModuleName();
    protected abstract String getModuleVersion();
    protected abstract String[] getModuleAuthors();

    protected String getModuleWebsite() {
        return "~";
    }

    protected String getModuleStringDescription() {
        return "~";
    }

    public void init(String main) {
        if (initialized)
            return;
        String name = getModuleName().trim().replace("  ", " ").replace(" ", "_");

        initialized = true;
        moduleDescription = new ModuleDescription(main, name, getModuleVersion(), getModuleWebsite(), getModuleStringDescription(), getModuleAuthors());
        logger = new ModuleLogger(name);
        dataFolder = new DataFolder(Rifle.getInstance().getDataFolder().getMainPath() + File.separator + "modules");
    }

    @Override
    public final CommandMap getCommandMap() {
        return commandMap;
    }

    @Override
    public final ModuleDescription getModuleDescription() {
        return moduleDescription;
    }

    @Override
    public ModuleLogger getLogger() {
        return logger;
    }

    @Override
    public DataFolder getDataFolder() {
        return dataFolder;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public final void setSelected(boolean selected) {
        if (selected == isSelected())
            return;

        this.selected = selected;
        if (selected)
            onSelected();
        else
            onQuit();
    }

    @Override
    public String toString() {
        return getModuleName();
    }
}