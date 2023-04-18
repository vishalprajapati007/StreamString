import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
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
    

    //@Test	
    public void streamfilter() {
    	
    	ArrayList<String> name = new ArrayList<String>();
    	name.add("Abhi");
    	name.add("Adity");
    	name.add("demo");
    	name.add("visii");
    	name.add("Anmol");
    	
    	// for find name start with A
    	Long V=  name.stream().filter(s -> s.startsWith("A")).count();
    	System.out.println(V);
    	
    	
        long D= Stream.of("Abhi","Adity","Don","Visii","Anmol").filter(s->
       {
    	   s.startsWith("A");
    	   return true;
       }).count();
        
       System.out.println(D);
       
       // print all from arraylist 
       name.stream().filter(s-> s.length()>4).limit(2).forEach(s->System.out.println(s));
    	
       }
    
   // @Test
    public void stringMap()
    {
    	ArrayList<String> name = new ArrayList<String>();
    	name.add("Don");
    	name.add("Rekha");
    	name.add("Sanket");
    	
    	//print last letter "a" is.
    	Stream.of("Abhi","Ahemad","Bkhshay","Rama","Nobita").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
    	// print letter in uppercase
    	
         List<String> abc = Arrays.asList("Abhi","Ahemad","Bkhshay","Rama","Nobita");
         
         abc.stream().filter(s->s.startsWith("B")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
         
         //marging 2 list
         
         Stream<String> xyz = Stream.concat(name.stream(), abc.stream());
        // xyz.sorted().forEach(s->System.out.println(s));
    	boolean flag= xyz.anyMatch(s->s.equalsIgnoreCase("Rekha"));
    	System.out.println(flag);
    	Assert.assertTrue(flag);
    }
    
    @Test
    public void stramColllect()
    {
    	
        List<String>ls=	Stream.of("Aman","Ankit","Amit","Vishal","Deep").filter(s->s.startsWith("A")).map(s->s.toUpperCase())
    	.collect(Collectors.toList());
    	System.out.println(ls.get(2));
    	
    	//interview exp
    	
    	//print uniq number from array = 1,2,2,3,5,5,9
    	// short the array = 2nd print
    	
    	List<Integer> value= Arrays.asList(1,2,2,3,5,5,9);
    	//value.stream().distinct().forEach(s->System.out.println(s));
    	
    	List<Integer>vp= value.stream().distinct().sorted().collect(Collectors.toList());
    	System.out.println(vp.get(1));
    	
    	
    	
    }
}
