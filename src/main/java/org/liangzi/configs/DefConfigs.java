package org.liangzi.configs;

import org.liangzi.Core;
import snw.jkook.config.file.FileConfiguration;
import snw.jkook.config.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DefConfigs {
    String fileName = "configs.yml";
    FileConfiguration config;
    File file;

    private static DefConfigs instance = new DefConfigs();

    public DefConfigs() {
    }

    public static DefConfigs getInstance() {
        return instance;
    }

    public void loadConfig() {
        this.createIfNotExist();
        if (!this.getConfig().contains("Settings.Resourcepack-URL")) {
            this.getConfig().set("Settings.Resourcepack-URL", " ");
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Settings.Global")) {
            this.getConfig().set("Settings.Global", true);
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Settings.Load-Command")) {
            this.getConfig().set("Settings.Load-Command", "rpsend");
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Settings.Sensitive")) {
            this.getConfig().set("Settings.Sensitive", false);
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Settings.Load-On-Join")) {
            this.getConfig().set("Settings.Load-On-Join", false);
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Settings.Enable-Pass-Load")) {
            this.getConfig().set("Settings.Enable-Pass-Load", false);
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Resource.Accepted")) {
            this.getConfig().set("Resource.Accepted.Enabled", false);
            this.getConfig().set("Resource.Accepted.Command", "say %PLAYER% ");
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Resource.Declined")) {
            this.getConfig().set("Resource.Declined.Enabled", false);
            this.getConfig().set("Resource.Declined.Command", "say %PLAYER% ");
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Resource.Success")) {
            this.getConfig().set("Resource.Success.Enabled", false);
            this.getConfig().set("Resource.Success.Command", "say %PLAYER% ");
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Resource.Failed")) {
            this.getConfig().set("Resource.Failed.Enabled", false);
            this.getConfig().set("Resource.Failed.Command", "say %PLAYER% ");
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Messages.Accepted.Enabled")) {
            this.getConfig().set("Messages.Accepted.Enabled", true);
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Messages.Declined.Enabled")) {
            this.getConfig().set("Messages.Declined.Enabled", true);
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Messages.Success.Enabled")) {
            this.getConfig().set("Messages.Success.Enabled", true);
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Messages.Failed.Enabled")) {
            this.getConfig().set("Messages.Failed.Enabled", true);
            this.saveConfigs();
        }
        if (!this.getConfig().contains("Messages.Accepted.msg")) {
            //?????????????????????
            this.getConfig().set("Messages.Accepted.msg", "&a????????????????????????????????????");
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Messages.Declined.msg")) {
            this.getConfig().set("Messages.Declined.msg", "&c????????????????????????????????????");
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Messages.Success.msg")) {
            this.getConfig().set("Messages.Success.msg", "&a??????????????????????????????");
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Messages.Failed.msg")) {
            this.getConfig().set("Messages.Failed.msg", "&c???????????????????????????????????????????????????????????????");
            this.saveConfigs();
        }

        if (!this.getConfig().contains("Messages.Error.msg")) {
            this.getConfig().set("Messages.Error.msg", "&6?????????????????????????????????????????????????????????");
            this.saveConfigs();
        }

        YamlConfiguration.loadConfiguration(this.file);
    }

    public void saveConfigs() {
        File configSettingsFile = new File(Core.plugin.getDataFolder() , this.fileName);
        if (this.config != null) {
            try {
                this.getConfig().save(configSettingsFile);
            } catch (IOException var3) {
                Core.plugin.getLogger().error("???????????????????????????" + configSettingsFile, var3);
            }

        }
    }

    public void reloadInfo() {
        File file = new File(Core.plugin.getDataFolder(), this.fileName);
        this.config = YamlConfiguration.loadConfiguration(file);
        File configSettingsFile = new File(Core.plugin.getDataFolder(), this.fileName);
        YamlConfiguration defSettingsConfig = YamlConfiguration.loadConfiguration(configSettingsFile);
        this.config.setDefaults(defSettingsConfig);

    }

    public FileConfiguration getConfig() {
        if (this.config == null) {
            this.reloadInfo();
        }

        return this.config;
    }

    public void createIfNotExist() {
        if (!Core.plugin.getDataFolder().exists()) {
            Core.plugin.getDataFolder().mkdir();
        }

        this.file = new File(Core.plugin.getDataFolder(), this.fileName);
        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException var2) {
                Core.plugin.getLogger().error("?????????????????????" + this.fileName);
            }
        }
    }

}
