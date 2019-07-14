
import java.util.Comparator;

public class sortbyDis implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		resname res1=(resname) o1;
		resname res2=(resname) o2;
		if(res1.getDistance()>res2.getDistance()) {return 1;}
		return 0;
	}
	

}
