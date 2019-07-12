

public class Main {

public static void main(String[] args)
{    
	 Mantis mantis=new Mantis();
	 Thread ms=new Thread(mantis,"Mantis");
	 Thread thread[] = new Thread[14];
     for (int i = 1; i < 14; i++)
     {
         thread[i] = new Thread(new Fish(i), "fish " + i);
     }
     for (int i = 1; i < 14; i++)
     {
         thread[i].start();
     }
     ms.start();
	
	
	
}
}