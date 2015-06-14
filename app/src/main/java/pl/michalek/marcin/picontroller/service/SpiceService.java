package pl.michalek.marcin.picontroller.service;

import com.octo.android.robospice.GsonSpringAndroidSpiceService;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Marcin Michalek on 2015-06-14.
 * File belongs to project SendIt!
 */
public class SpiceService extends GsonSpringAndroidSpiceService {
  public static final int CONNECT_TIMEOUT = 30000;
  public static final int READ_TIMEOUT = 30000;

  @Override
  public RestTemplate createRestTemplate() {
    RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());
    //find more complete examples in RoboSpice Motivation app
    //to enable Gzip compression and setting request timeouts.

    // web services support json responses
    GsonHttpMessageConverter jsonConverter = new GsonHttpMessageConverter();
    FormHttpMessageConverter formHttpMessageConverter = new FormHttpMessageConverter();
    StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
    final List<HttpMessageConverter<?>> listHttpMessageConverters = restTemplate.getMessageConverters();

    listHttpMessageConverters.add(jsonConverter);
    listHttpMessageConverters.add(formHttpMessageConverter);
    listHttpMessageConverters.add(stringHttpMessageConverter);
    restTemplate.setMessageConverters(listHttpMessageConverters);
    return restTemplate;
  }

  private ClientHttpRequestFactory getClientHttpRequestFactory() {
    HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
    factory.setReadTimeout(READ_TIMEOUT);
    factory.setConnectTimeout(CONNECT_TIMEOUT);
    return factory;
  }
}
