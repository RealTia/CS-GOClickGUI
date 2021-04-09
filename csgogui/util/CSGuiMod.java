package me.cirex.client.module.modules.gui;

import de.Hero.settings.Setting;
import me.cirex.client.Client;
import me.cirex.client.gui.csgogui.CSGOGui;
import me.cirex.client.module.Module;
import me.cirex.client.utils.enums.Category;

public class CSGui extends Module {

	public CSGui() {
		super("CSGui", 0, Category.GUI);
		Client.setmgr.rSetting(new Setting("CSGuiOutline", "Outline", this, true));

	}

	@Override
	public void onTick() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onEnable() {
		mc.displayGuiScreen(Client.csgogui);
		this.setEnabled(false);

	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub

	}

}
