package devsearch.images.ws.ui.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devsearch.images.ws.exception.RestApiImagesException;
import devsearch.images.ws.ui.request.ProfileImageRequest;
import devsearch.images.ws.ui.response.ProfileImageResponse;

@RestController
@RequestMapping("images")
public class ImageController {

    @PostMapping("/profile")
    public ProfileImageResponse addProfileImage(@RequestBody ProfileImageRequest profileRequest)
	    throws RestApiImagesException {
	return null;

    }
}
