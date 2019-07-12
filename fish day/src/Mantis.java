

public class Mantis extends Thread {
	public static long time = System.currentTimeMillis();
	static int mc=7;
	public void run() {    
	 
	     try {
			Fish.MS.acquire();
		    msg("first transportation:  first group:"+"fish " +Fish.gp1[0]+" "+"fish "+Fish.gp1[1]+" "+"fish "+Fish.gp1[2]+"   second group:"+"fish "+ Fish.gp2[0]+" "+"fish " +Fish.gp2[1]+" "+"fish "+ Fish.gp2[2] + "  last group: "+"fish " +Fish.gp5[0]);
		    Fish.MC.release();
		    Fish.MC.release();
		    Fish.MC.release();
		    Fish.MC.release();
		    Fish.MC.release();
		    Fish.MC.release();
		    Fish.MC.release();
		    msg("first transportation arrived, going back");
		    Thread.sleep(5000);
			msg("second transportation:  third group:"+"fish "+ Fish.gp3[0]+" "+"fish "+Fish.gp3[1]+" "+"fish "+Fish.gp3[2]+"   fourth group:"+"fish "+ Fish.gp4[0]+" "+"fish " +Fish.gp4[1]+" "+"fish "+ Fish.gp4[2]);
			msg("done the transportation");
			msg("Mantis taking break");
			Thread.sleep(10000);
			msg("mantis waks fish up");
			Fish.wake.release();
			Fish.last.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	     
	}
	     
	public void msg(String m) {
		System.out.println("[" + (System.currentTimeMillis()-time) + "]" + Thread.currentThread().getName() + ":" + m);
	}
}
