
import java.net.URL;
import java.io.*;

public class TocHw3 {
public static void main(String[] args) throws IOException, NumberFormatException{
       
     // URL
	if(args.length < 3)
	{
		System.out.println("No input Or input Error");
		return ;
	}
	String net = args[0];
	URL url = new URL(net);
	BufferedReader in = new BufferedReader(  new InputStreamReader(url.openStream(),"UTF-8"));
	//System.out.println(args[1]+" "+args[2]+"a"+args[3]+"a");
	String inputtown =args[1];
	String inputroad =args[2]; 
	String inputyearstr =args[3];
	int inputyear = Integer.parseInt(args[3]);
	//System.out.println(inputtown + " " + inputroad + " " + (inputyear+1) );
	
	String inputLine;
	int count = 0 ;
	int total = 0 ;
    while ((inputLine = in.readLine()) != null)
    {
    	//System.out.println(new String(inputLine.getBytes("UTF-8"),"UTF-8"));
    	
    	String the_town = findtown(inputLine);
    	String the_yearstr = findyear(inputLine);
    	String the_road = findroad(inputLine);
    	String the_pricestr = findprice(inputLine);
    	if(inputLine.length()>2 &&the_yearstr != null && the_pricestr!=null)
    	{	
		int the_year = Integer.parseInt(the_yearstr);
        	int the_price = Integer.parseInt(the_pricestr);
		//System.out.println(the_town + " " + the_year + " " +the_road);
        	
    		if(inputtown.equals(the_town) && (inputyear*100) < the_year && the_road.contains(inputroad)  )
    		{
    			//System.out.println("myanswer : "+the_town + " " + the_yearstr + " " + the_road + " " + the_pricestr );
    			count++;
    			total += the_price ; 
    		}
    		
    	}
    	
    		
    	
    }
    if(count != 0)
    	System.out.println((total/count));
    in.close();
    //System.out.println("Finish"+count);
	}
	
	static String findtown(String line) throws IOException
	{
		
		String all[] = line.split("\"|:|,|}");
		int choose = 0;
		for(int i = 0 ; i < all.length ; i++)
		{
			
			if(choose == 1 && all[i].length() > 1)
			{
				return all[i];
				
			}
			if("鄉鎮市區".equals(all[i]))
			{
				choose = 1 ;
			}
			
		}
		return null;
		
	}
	static String findyear(String line)
	{
		
		String all[] = line.split("\"|:|,|}");
		int choose = 0;
		for(int i = 0 ; i < all.length ; i++)
		{
			
			if(choose == 1 && all[i].length() > 1)
			{
				return all[i];
				
			}
			if("交易年月".equals(all[i]))
			{
				choose = 1 ;
			}
			
		}
		return null;
		
	}
	static String findroad(String line)
	{
		
		String all[] = line.split("\"|:|,|}");
		int choose = 0;
		for(int i = 0 ; i < all.length ; i++)
		{
			
			if(choose == 1 && all[i].length() > 1)
			{
				return all[i];
				
			}
			if("土地區段位置或建物區門牌".equals(all[i]))
			{
				choose = 1 ;
			}
			
		}
		return null;
		
	}
	static String findprice(String line) throws IOException
	{
		
		String all[] = line.split("\"|:|,|}");
		int choose = 0;
		for(int i = 0 ; i < all.length ; i++)
		{
			
			if(choose == 1 && all[i].length() > 1)
			{
				return all[i];
				
			}
			if("總價元".equals(all[i]))
			{
				choose = 1 ;
			}
			
		}
		return null;
		
	}


}
