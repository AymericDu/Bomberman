package bomberman.entity;

import java.util.Timer;
import java.util.TimerTask;

public class BombTimer extends Timer{
		protected Timer timer;
		protected TimerTask task;
		protected long delay;
		
		/**
		 * 
		 * @param delay of the bomb
		 * @param task : Task to do when timer is over, when you create a TimerTask you must implement a method run();
		 */
		public BombTimer(long delay, TimerTask task){
			this.timer= new Timer();
			this.task = task;
		}
		
		/**
		 * Method to run the timer
		 */
		public void runBomb(){
			this.timer.schedule(this.task,this.delay);
		}
		
		
		/*	Example of Timer, it works 
		 * 
		 * public static void main(String[] args) {
			TimerTask task = new TimerTask() {
				
				@Override
				public void run() {
					System.out.println("bonjour");
				}
			};
			BombTimer timer = new BombTimer(0,task);  <--- maybe we don't need the delay in the constructor because we fix it with the method schedule below 
			timer.schedule(task, 500);
	}
	*/
		
		
}
