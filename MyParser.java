//Devin Moore 
 
 import java.io.IOException;
 import java.io.StringReader;
 import java.io.FileReader;


 import org.xmlpull.v1.XmlPullParser;
 import org.xmlpull.v1.XmlPullParserException;
 import org.xmlpull.v1.XmlPullParserFactory;

 public class MyParser
 {

     public static void main (String args[])
         throws XmlPullParserException, IOException
     {
         XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
         factory.setNamespaceAware(true);
         XmlPullParser xpp = factory.newPullParser();
         
         MyParser mp = new MyParser();
         xpp.setInput ( new FileReader ( args [0] ) );
         mp.parse(xpp);
	 }
	 
	 
	public void parse(XmlPullParser xpp)
        throws XmlPullParserException, IOException
    {
        int eventType = xpp.getEventType();
        while (eventType != xpp.END_DOCUMENT) {
        	String name = xpp.getName();
            //if(eventType == xpp.START_TAG) 
            //{
            //    System.out.println(xpp.getName());
            //}
            
            //System.out.println(xpp.START_TAG);
            
            if(eventType == xpp.START_TAG){
	            if(xpp.getName().equals("title"))
	            {
	                System.out.println("Title: ");
	                eventType = xpp.next();
	                if(eventType == xpp.TEXT) 
	            	{
	                	System.out.println(xpp.getText());
	                	eventType = xpp.next();
	            	}
	            }
	            if(xpp.getName().equals("link"))
	            {
	                System.out.println("URL: ");
	                eventType = xpp.next();
	                if(eventType == xpp.TEXT) 
	            	{
	                	System.out.println(xpp.getText());
	                	eventType = xpp.next();
	            	}
	            }
	            if(xpp.getName().equals("description"))
	            {
	                System.out.println("Description: ");
	                eventType = xpp.next();
	                if(eventType == xpp.TEXT) 
	            	{
	                	System.out.println(xpp.getText());
	                	eventType = xpp.next();
	            	}
	            } 
	            if(xpp.getName().equals("pubDate"))
	            {
	                System.out.println("Publication Date: ");
	                eventType = xpp.next();
	                if(eventType == xpp.TEXT) 
	            	{
	                	System.out.println(xpp.getText() + "\n\n");
	                	eventType = xpp.next();
	            	}
	            }
            }
            eventType = xpp.next();
        }
    }
}