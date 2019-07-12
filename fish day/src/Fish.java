
import java.util.Vector;
import java.util.concurrent.Semaphore;
public class Fish extends Thread{
	private static final int groupSize = 3;
	private static final int totalFishnumber = 13;
	public static long time = System.currentTimeMillis();	
	static int count=0;
	int fishName=0;
    static Semaphore mutex=new Semaphore(1);
	static Semaphore group=new Semaphore(0);
	static Semaphore MS=new Semaphore(0); //counting semaphore for mantis
	static Semaphore MC=new Semaphore(7); //counting semaphore for mantis capacity
	static Semaphore wake=new Semaphore(0);//mantis tell fish can leave
	static Semaphore last=new Semaphore(0);//last fish call mantis 
	static int cc=13;//counter for the last fish leave
	static int gp1[]=new int[3]; //arrays for store fish name and group
	static int gp2[]=new int[3];
	static int gp3[]=new int[3];
	static int gp4[]=new int[3];
	static int gp5[]=new int[1];
   public Fish(int i) {
	   fishName=i;
   }
	public void run() {
	
		try {
				mutex.acquire();
				count ++;
				if(count % groupSize==0 || count == totalFishnumber) {
					if(count == 3) {
						gp1[2]=fishName;
						msg("group 1");
						Thread.sleep(1000);
					}
					if(count == 6) {
						gp2[2]=fishName;
						msg("group 2");
						Thread.sleep(1000);
					}
					if(count == 9) {
						gp3[2]=fishName;
						msg("group 3");
						Thread.sleep(1000);
					}
					if(count == 12) {
						gp4[2]=fishName;
						msg("group 4");
						Thread.sleep(1000);
					}
					if (count == totalFishnumber) {
						gp5[0]=fishName;
						msg("last group 5");
						Thread.sleep(1000);
					}
				    mutex.release();
				    group.release();
				    group.release();
				    Thread.sleep(10000);
				     }
				else {
					    	if(count < 3) {
					    		if(count == 1) {
					    			gp1[0]=fishName;
					    			msg("waiting");
					    			Thread.sleep(1000);
					    		}
								gp1[1]=fishName;
								msg("waiting");
							}
							if(count < 6) {
								if(count == 4) {
									gp2[0]=fishName;
									msg("waiting");
									Thread.sleep(1000);
								}
								gp2[1]=fishName;
								msg("waiting");
							}
							if(count < 9) {
								if(count == 7) {
									gp3[0]=fishName;
									msg("waiting");
									Thread.sleep(1000);
								}
								gp3[1]=fishName;
								msg("waiting");
								Thread.sleep(1000);
							}
							if(count < 12) {
								if(count ==10) {
									gp4[0]=fishName;
									msg("waiting");
									Thread.sleep(1000);
								}
								gp4[1]=fishName;
								msg("waiting");
								Thread.sleep(1000);
							}
							mutex.release();
					        group.acquire();
						    Thread.yield();
				}

				}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(count == totalFishnumber) {
			MS.release();
			try {
				mutex.acquire();
				MC.acquire();
				mutex.release();
				
		} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
			
			}
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			wake.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wake.release();
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		msg("leave");
		cc--;
		mutex.release();
		if(cc==0) {
			last.release();
            msg("Mantis can leave too.");		
 		}
		
	}
		
		
		
		
	
public void msg(String m) {
	System.out.println("[" + (System.currentTimeMillis()-time) + "]" + Thread.currentThread().getName() + ":" + m);
}
}
