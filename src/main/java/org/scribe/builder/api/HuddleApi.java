package org.scribe.builder.api;

import java.net.URISyntaxException;

import org.scribe.extractors.AccessTokenExtractor;
import org.scribe.extractors.JsonTokenExtractor;
import org.scribe.extractors.TokenExtractor20Impl;
import org.scribe.model.*;

public class HuddleApi extends DefaultApi20
{

	public HuddleApi() throws URISyntaxException
	{
	}
	
	private static final String AUTHORIZE_URL = "%srequest?response_type=code&client_id=%s&redirect_uri=%s";
	//private static final String ACCESS_TOKEN  = "%sgrant_type=authorization_code&client_id=%s&redirect_uri=%s";
	final String _HUDDLEAUTHSERVER = "http://login.huddle.dev/";

	@Override
	public String getAccessTokenEndpoint() {
		return _HUDDLEAUTHSERVER + "token/";
	}

	@Override
	public String getAuthorizationUrl(OAuthConfig config) {
		return String.format(AUTHORIZE_URL,  _HUDDLEAUTHSERVER, config.getApiKey(),config.getCallback());
	}
	
	@Override
	public Verb getAccessTokenVerb()
	{
		return Verb.POST;
	}
	
	@Override
	public AccessTokenExtractor getAccessTokenExtractor()
	{
	    return new JsonTokenExtractor();
	}
}
