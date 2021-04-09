package me.cirex.client;



public final class Client {
	
	public static SettingsManager setmgr;
	public static ModuleManager modmgr;
	public static CSGOGui csgui;
	
	
	public void startClient() {
		setmgr = new SettingsManager();
		modmgr = new ModManager();
		csgui = new CSGOGui();
	}


}
