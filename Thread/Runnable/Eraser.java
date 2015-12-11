
package Eraser;

public class Eraser implements Runnable{
	private boolean active;	
	private String mask;	

	public Eraser(){
		this('*');
	}

	public Eraser(char maskChar){
		active = true;
		mask = "\010" + maskChar;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	public void run(){
		while(isActive()){
			System.out.print(mask);
			try{
				// sleep 100ms
				Thread.currentThread().sleep(100);
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}
