package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sun.net.ssl.HttpsURLConnection;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;


@RestController
@RequestMapping("/v1")
@SuppressWarnings("deprecation")
public class OAuthRequest {
	
	@RequestMapping(value = "/twitter", method = RequestMethod.POST)
	public List<String> PoststatusUpdate(@RequestBody Notes notes) {
		System.out.println("Twiterr Status --------- >>"+notes.getNotes());
		List<String> ResponseList = new ArrayList<String>();
		try {
			String TwitterUrl ="https://api.twitter.com/1.1/statuses/update.json";
			TwitterUrl = TwitterUrl + "?status=" + notes.getNotes().replace(" ", "%20"); 
			HttpResponse apiResponse = executeHttpPost(TwitterUrl);
			if (200 == apiResponse.getStatusLine().getStatusCode()) {
				ResponseList.add(" Successful: "+ notes.getNotes() );
				System.out.println("200 OK");
			} else {
				ResponseList.add(" Unsuccessful");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseList;
	}
	protected static HttpsURLConnection connection;
	public OAuthConsumer Authentication() throws IOException {
	//	Properties properties = getProperties();
		String consumerKeyStr = "xxxxxxxxxxxxxxxxxxxx";
		String consumerSecretStr ="xxxxxxxxxxxxxxxxxxx";
		String accessTokenStr = "xxxxxxxxxxxxxxxxxxxxx";
		String accessTokenSecretStr = "xxxxxxxxxxxxxxxxxxx";
		OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKeyStr, consumerSecretStr);
		oAuthConsumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);
		return oAuthConsumer;
	}

	
	@SuppressWarnings({ "resource" })
	protected HttpResponse executeHttpPost(String apiUrl) throws OAuthMessageSignerException,
			OAuthExpectationFailedException, OAuthCommunicationException, IOException {
		HttpPost request = new HttpPost(apiUrl);
		Authentication().sign(request);
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(request);
		return response;
	}
   
	@SuppressWarnings({ "unused", "deprecation" })
	public HttpResponse executeHttpGet(String apiUrl) throws OAuthMessageSignerException,
			OAuthExpectationFailedException, OAuthCommunicationException, IOException {
		HttpGet request = new HttpGet(apiUrl);
		Authentication().sign(request);
		@SuppressWarnings("resource")
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(request);
		return response;
	}
	
	

}
