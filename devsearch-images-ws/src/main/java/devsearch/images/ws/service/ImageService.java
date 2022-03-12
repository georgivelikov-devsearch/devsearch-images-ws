package devsearch.images.ws.service;

public interface ImageService {

    public String saveImageAndReturnURL(String base64EncodedSource, String newFileName);

}
