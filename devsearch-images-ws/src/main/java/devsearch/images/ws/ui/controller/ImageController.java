package devsearch.images.ws.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devsearch.images.ws.exception.RestApiImagesException;
import devsearch.images.ws.service.ImageService;
import devsearch.images.ws.ui.model.request.ProfileImageRequest;
import devsearch.images.ws.ui.model.response.ImageResponse;

@RestController
@RequestMapping("images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/profile")
    public ImageResponse addProfileImage(@RequestBody ProfileImageRequest profileRequest)
	    throws RestApiImagesException {

	String imageUrl = imageService.saveImageAndReturnURL(profileRequest.getProfilePictureBase64(),
		profileRequest.getProfilePrivateId());

	ImageResponse response = new ImageResponse();
	response.setProfilePictureUrl(imageUrl);

	return response;
    }
}
