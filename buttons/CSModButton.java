package me.cirex.client.gui.csgogui.buttons;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.text.html.CSS;

import de.Hero.settings.Setting;
import me.cirex.client.Client;
import me.cirex.client.gui.csgogui.buttons.setting.CSSetting;
import me.cirex.client.gui.csgogui.buttons.setting.settings.CSSettingCheck;
import me.cirex.client.gui.csgogui.buttons.setting.settings.CSSettingCombo;
import me.cirex.client.gui.csgogui.buttons.setting.settings.CSSettingDouble;
import me.cirex.client.module.Module;
import net.minecraft.client.gui.GuiScreen;

public class CSModButton extends CSButton {

	public Module mod;

	public CSModButton(int x, int y, int width, int height, int color, String displayString, Module mod) {
		super(x, y, width, height, color, displayString);
		this.mod = mod;
		initSettings();
	}

	private void initSettings() {
		int y = 110;
		int x = this.x + 100;
		for (int i = 0; i < Client.setmgr.getSettings().size(); i++) {
			Setting s = Client.setmgr.getSettings().get(i);
			if (s.getParentMod() == this.mod) {
				if (s.isCheck()) {

					CSSettingCheck check = new CSSettingCheck(x, y, y, x, s);

					settings.add(check);

					y += 13;
				}
				if (s.isSlider()) {

					CSSettingDouble doubleset = new CSSettingDouble(x, y, 0, 0, s);

					settings.add(doubleset);

					y += 15;

				}
				if (s.isCombo()) {
					int yplus = y;

					CSSettingCombo combo = new CSSettingCombo(x, y, 70, mc.fontRendererObj.FONT_HEIGHT + 2, s);
					settings.add(combo);

					for (int i1 = 0; i1 < s.getOptions().size(); i1++) {
						y += fr.FONT_HEIGHT + 2;
						if (y > 100 + GuiScreen.width - 220) {
							y = 0;
							x += mc.fontRendererObj.getStringWidth(s.displayName) + 50;
						}

					}

					y += fr.FONT_HEIGHT + 5;

				}

				if (y > 100 + GuiScreen.width - 220) {
					y = 0;
					x += mc.fontRendererObj.getStringWidth(s.displayName) + 50;
				}

			}
		}
	}

	public ArrayList<CSSetting> settings = new ArrayList<CSSetting>();

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {

		int color = this.isHovered(mouseX, mouseY) ? Client.getClientColor() : 0xFFFFFFFF;

		if (this.mod.isEnabled()) {
			color = Client.getClientColorDarker();
		}

		if (this.isCurrentMod()) {
			color = Client.getClientColor();
		}

		fr.drawString(displayString, x, y, color);

		for (CSSetting cs : settings) {
			if (isCurrentMod()) {
				cs.drawScreen(mouseX, mouseY, partialTicks);
			}
		}

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {

		if (this.isHovered(mouseX, mouseY)) {

			if (mouseButton == 0 && isHovered(mouseX, mouseY) && Client.csgogui.currentCategory != null
					&& Client.csgogui.currentCategory.category == this.mod.getCategory()) {
				this.mod.toggle();

			} else if (mouseButton == 1) {
				try {

				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		}
		for (CSSetting cs : settings) {
			if (isCurrentMod()) {
				cs.mouseClicked(mouseX, mouseY, mouseButton);
			}
		}

		super.mouseClicked(mouseX, mouseY, mouseButton);
	}

	public boolean isHovered(int mouseX, int mouseY) {
		boolean hoveredx = mouseX > this.x && mouseX < this.x + this.width;
		boolean hoveredy = mouseY > this.y && mouseY < this.y + this.height;
		return hoveredx && hoveredy;
	}

	private boolean isCurrentMod() {
		return Client.csgogui.currentCategory != null && Client.csgogui.currentCategory.currentMod != null
				&& Client.csgogui.currentCategory.currentMod == this;
	}

	@Override
	public void initButton() {
		initSettings();

		super.initButton();
	}

}
