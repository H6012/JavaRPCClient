/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpcclient;

/**
 *
 * @author David Powell
 */
import java.util.*;
import org.apache.xmlrpc.*;
import org.apache.xmlrpc.client.*;
import java.net.URL;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;


public class JavaRPCClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          try {
        /*
         XmlRpcClient server = new XmlRpcClient("http://localhost/RPC2"); 
         
         Vector params = new Vector();
         
         params.addElement(new Integer(17));
         params.addElement(new Integer(13));

         Object result = server.execute("sample.sum", params);

         int sum = ((Integer) result).intValue();
         System.out.println("The sum is: "+ sum);
         */
        
        System.out.println("XML-RPC Client call to : http://localhost:1080");
	XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
	config.setServerURL(new URL("http://localhost:1080"));
	XmlRpcClient client = new XmlRpcClient();
	client.setConfig(config);
	Object[] params = new Object[] { new Integer(10),new Integer(17) };
	Integer response = (Integer) client.execute("miot.sum", params);
	System.out.println("Message : " + response);
        
        
        Object[] dbparams = new Object[] { new String("fname") , new String("david") };
	String dbresponse = (String) client.execute("miot.lookup", dbparams);
	System.out.println("DB Message : " + dbresponse);
        
        
	Integer dbresponse2 = (Integer) client.execute("miot.lookup2", params);
	System.out.println("DB2 Message : " + dbresponse2);
        
                        
      } catch (Exception exception) {
         System.err.println("JavaRPC Client: " + exception);
      }
   }
   
    
}
