package nl.gussio.beaverball.screen;

public class ScreenManager {

	public static Screen currentScreen;
	
	public void setCurrentScreen(Screen s){
		currentScreen = s;
	}
	
	public Screen getCurrentScreen(){
		return currentScreen;
	}
	
	public static Screen getStaticScreen(){
		return currentScreen;
	}
	
	
	
}
