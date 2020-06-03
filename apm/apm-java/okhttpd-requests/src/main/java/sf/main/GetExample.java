package sf.main;

import java.util.concurrent.*;
//import org.apache.commons.io.IOUtils;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


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
    GetExample example = new GetExample();
    while (x <= 1000 )
      {    
          String response = example.run("http://httpbin.org/get");
//        System.out.println(response);
          System.out.println(x);
          try {
                  TimeUnit.SECONDS.sleep(1);
	      }
          catch (InterruptedException e) {
	  	System.out.println("error occurred");
	      } // catch
	  x++;
      } // loop
  } // main
} // class
