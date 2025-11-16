package com.p1nero.tcrmodfilter.service;

import net.minecraftforge.fml.loading.moddiscovery.AbstractJarFileModLocator;

import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 加载在service层需要
 */
public class EmptyModLocator extends AbstractJarFileModLocator {

    @Override
    public Stream<Path> scanCandidates() {
        return Stream.empty();
    }

    @Override
    public String name() {
        return "";
    }

    @Override
    public void initArguments(Map<String, ?> arguments) {

    }

}
