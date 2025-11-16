package com.p1nero.tcrmodfilter.service;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.loading.ImmediateWindowHandler;
import org.slf4j.Logger;
import settingdust.preloading_tricks.api.PreloadingTricksCallback;
import settingdust.preloading_tricks.api.PreloadingTricksModManager;

import java.util.Set;

/**
 * gl版本过低时移除加速渲染
 */
public class TCRModFilterCallback implements PreloadingTricksCallback {
    public static final Logger LOGGER = LogUtils.getLogger();
    @Override
    public void onSetupMods() {
        String glVersion = ImmediateWindowHandler.getGLVersion();
        String[] parts = glVersion.split("\\.");
        int major;
        int minor;
        major = Integer.parseInt(parts[0]);
        minor = Integer.parseInt(parts[1]);
        if(major < 4 || (major == 4 && minor < 6)) {
            PreloadingTricksModManager.get().removeById("acceleratedrendering");
            LOGGER.warn("GLVersion < 4.6, acceleratedrendering mod has been removed.");
        }
        PreloadingTricksModManager.get().removeByIds(Set.of("yes_steve_model", "projecte"));
        LOGGER.warn("yes_steve_model mod has been removed, it's incompatible with epic fight.");
    }

}
