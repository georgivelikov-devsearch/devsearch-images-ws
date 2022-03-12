package devsearch.images.ws.service.impl;

import javax.xml.bind.DatatypeConverter;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import devsearch.images.ws.service.ImageService;
import devsearch.images.ws.ui.model.response.FileStackResponse;

@Service
public class ImageServiceFileStackImpl implements ImageService {
    String fileStackUrl = "https://www.filestackapi.com/api/store/s3?key={key}&filename={name}&type={type}";

    @Override
    public String saveImageAndReturnURL(String base64EncodedSource, String newFileName) {
	String[] array = base64EncodedSource.split(",");
	String encodedString = array[1];
	byte[] content = DatatypeConverter.parseBase64Binary(encodedString);

	RestTemplate restTemplate = new RestTemplate();

	// TODO !!!! filestack.com api key - AnEmTECOR4qEhZPsQS4D0z - should be private
	HttpEntity<byte[]> request = new HttpEntity<byte[]>(content);
	HttpEntity<FileStackResponse> response = restTemplate.exchange(fileStackUrl, HttpMethod.POST, request,
		FileStackResponse.class, "AnEmTECOR4qEhZPsQS4D0z", newFileName, "image/png");

	return response.getBody().getUrl();
    }
}
