package sf.main;

import java.util.concurrent.*;
//import org.apache.commons.io.IOUtils;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class GetExample {
  OkHttpClient client = new OkHttpClient();

  String run(String url) throws IOException {
    Request request = new Request.Builder()
        .url(url)
        .build();

    try (Response response = client.newCall(request).execute()) {
      return response.body().string();
    }
  }

  public static void main(String[] args) throws IOException {
    int x = 1;
    while (x <= 1000 )
      {    
       
    	GetExample okhttpexample = new GetExample();
	String okhttpresponse = okhttpexample.run("http://httpbin.org/get");

    	CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
              HttpGet apacherequest = new HttpGet("https://github.com");
              CloseableHttpResponse apacheresponse = httpClient.execute(apacherequest);
     	}
        finally {
                  httpClient.close(); //apacheclient request
        } // finally

        System.out.println(x);
 	x++;
        try {
       	      TimeUnit.SECONDS.sleep(1);
       	}
 	catch (InterruptedException e) {
     		System.out.println("error occurred");
       	} // catch
      } // while loop

  } // main

} // class
