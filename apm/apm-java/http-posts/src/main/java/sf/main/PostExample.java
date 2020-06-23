package sf.main;

import java.util.concurrent.*;
//import org.apache.commons.io.IOUtils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.RequestBody;
import okhttp3.FormBody;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class PostExample {

  public static void main(String[] args) throws IOException {
    int x = 1;
    while (x <= 1000 )
      {  
  	OkHttpClient client = new OkHttpClient();
  	RequestBody formBody = new FormBody.Builder()
        	.add("message", "HelloWorld")
        	.build();
    	Request request = new Request.Builder()
        	.url("https://localhost:5000")
        	.post(formBody)
        	.build();
	try {
    		Response response = client.newCall(request).execute();
    		// Do something with the response.
		} catch (IOException e) {
     			System.out.println("Response error occurred");
			}
        System.out.println(x);
 	x++;
        try {
       	      TimeUnit.SECONDS.sleep(1);
       	}
 	catch (InterruptedException e) {
     		System.out.println("Timing error occurred");
       	} // catch
      } // while loop
  } // main
} // class
