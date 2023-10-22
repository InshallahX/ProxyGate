package com.jozho.proxygate;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataManager {
    private final File whitelistFile;
    private final Yaml yaml;
    private Map<String, Boolean> whitelistData;

    public DataManager(File whitelistFile) {
        this.whitelistFile = whitelistFile;
        this.yaml = new Yaml();
        this.whitelistData = new HashMap<>();
    }

    public void loadData() {
        try (Reader reader = new FileReader(whitelistFile)) {
            whitelistData = yaml.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveData() {
        try (Writer writer = new FileWriter(whitelistFile)) {
            yaml.dump(whitelistData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Boolean> getWhitelistData() {
        return whitelistData;
    }

    public boolean isWhitelisted(String playerName) {
        return whitelistData.getOrDefault(playerName, false);
    }

    public void addWhitelist(String playerName) {
        whitelistData.put(playerName, true);
    }

    public void removeWhitelist(String playerName) {
        whitelistData.put(playerName, false);
    }

}
