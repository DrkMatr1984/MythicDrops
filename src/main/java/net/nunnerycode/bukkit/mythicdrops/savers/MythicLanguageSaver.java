package net.nunnerycode.bukkit.mythicdrops.savers;

import com.conventnunnery.libraries.config.ConventConfiguration;
import java.util.Iterator;
import java.util.Map;
import net.nunnerycode.bukkit.mythicdrops.api.MythicDrops;
import net.nunnerycode.bukkit.mythicdrops.api.savers.ConfigSaver;

public class MythicLanguageSaver implements ConfigSaver {

	private MythicDrops plugin;

	public MythicLanguageSaver(MythicDrops plugin) {
		this.plugin = plugin;
	}

	@Override
	public synchronized void save() {
		ConventConfiguration c = getPlugin().getLanguageYAML();
		if (c == null) {
			return;
		}
		Iterator<Map.Entry<String, String>> iterator = getPlugin().getLanguageManager().getMessages().entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			c.getFileConfiguration().set(entry.getKey(), entry.getValue());
		}
		c.save();
	}

	public MythicDrops getPlugin() {
		return plugin;
	}
}
