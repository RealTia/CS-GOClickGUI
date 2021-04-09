package me.cirex.client.gui.csgogui.setting;

import java.util.ArrayList;

import me.cirex.client.module.Module;

public class Setting {

	private String name;
	private Module parent;
	public String displayName;
	private String mode;

	private String sval;
	private ArrayList<String> options;
	public String standardsval;

	
	private boolean bval;
	public boolean standardbval;
	
	
	private double dval;
	private double min;
	private double max;
	public double standarddval;
	private boolean onlyint = false;

	public Setting(String name, String displayName, Module parent, String sval, ArrayList<String> options) {
		this.name = name;
		this.displayName = displayName;
		this.parent = parent;
		this.sval = sval;
		this.standardsval = sval;
		this.options = options;
		this.mode = "Combo";
	}

	public Setting(String name, String displayName, Module parent, boolean bval) {
		this.name = name;
		this.displayName = displayName;
		this.standardbval = bval;
		this.parent = parent;
		this.bval = bval;
		this.mode = "Check";
		
	}

	public Setting(String name, String displayName, Module parent, double dval, double min, double max,
			boolean onlyint) {
		this.name = name;
		this.displayName = displayName;
		this.parent = parent;
		this.dval = dval;
		this.standarddval = dval;
		this.min = min;
		this.max = max;
		this.onlyint = onlyint;
		this.mode = "Slider";
	}

	public String getName() {
		return name;
	}

	public Module getParentMod() {
		return parent;
	}

	public String getValString() {
		return this.sval;
	}

	public void setValString(String in) {
		this.sval = in;
	}

	public ArrayList<String> getOptions() {
		return this.options;
	}

	public boolean getValBoolean() {
		return this.bval;
	}

	public void setValBoolean(boolean in) {
		this.bval = in;
	}

	public double getValDouble() {
		if (this.onlyint) {
			this.dval = (int) dval;
		}
		return this.dval;
	}

	public void setValDouble(double in) {
		this.dval = in;
	}

	public double getMin() {
		return this.min;
	}

	public double getMax() {
		return this.max;
	}

	public boolean isCombo() {
		return this.mode.equalsIgnoreCase("Combo") ? true : false;
	}

	public boolean isCheck() {
		return this.mode.equalsIgnoreCase("Check") ? true : false;
	}

	public boolean isSlider() {
		return this.mode.equalsIgnoreCase("Slider") ? true : false;
	}

	public boolean onlyInt() {
		return this.onlyint;
	}
}
