import java.util.ArrayList;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Test1 {
   // @Test
	public void Demo() {
		
	ArrayList<String> name = new ArrayList<String>();
	name.add("Abhi");
	name.add("Adity");
	name.add("demo");
	name.add("visii");
	name.add("Anmol");
	int count = 0;

	for(int i=0; i<name.size(); i++)
	{
	 String s= name.get(i);
	 if(s.startsWith("A"))
	 {
	     count++;
	 }
	}
	 System.out.println(count);
	}
    
 //   @Test	
    public void streamfilter() {
    	
    	ArrayList<String> name = new ArrayList<String>();
    	name.add("Abhi");
    	name.add("Adity");
    	name.add("demo");
    	name.add("visii");
    	name.add("Anmol");
    	
    	Long V=  name.stream().filter(s -> s.startsWith("A")).count();
    	System.out.println(V);
    	
        long D= Stream.of("Bbhi","Bhemad","Bkhshay","Ram","Nobita").filter(s->
       {
    	   s.startsWith("A");
    	   return true;
       }).count();
        
       System.out.println(D);
       
       name.stream().filter(s-> s.length()>4).forEach(s->System.out.println(s));
    	
       }
    
    @Test
    public void stringMap()
    {
    	Stream.of("Bbhi","Bhemad","Bkhshay","Rama","Nobita").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
    }
}
