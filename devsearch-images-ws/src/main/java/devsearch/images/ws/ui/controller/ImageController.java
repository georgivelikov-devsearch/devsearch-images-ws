package devsearch.images.ws.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devsearch.images.ws.exception.RestApiImagesException;
import devsearch.images.ws.service.ImageService;
import devsearch.images.ws.ui.model.request.DeveloperImageRequest;
import devsearch.images.ws.ui.model.request.ProjectImageRequest;
import devsearch.images.ws.ui.model.response.DeveloperImageResponse;
import devsearch.images.ws.ui.model.response.ProjectImageResponse;

@RestController
@RequestMapping("images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/developer")
    public DeveloperImageResponse addDeveloperImage(@RequestBody DeveloperImageRequest imageRequest)
	    throws RestApiImagesException {

	String imageUrl = imageService.saveImageAndReturnURL(imageRequest.getDeveloperPictureBase64(),
		imageRequest.getDeveloperId());

	DeveloperImageResponse response = new DeveloperImageResponse();
	response.setDeveloperPictureUrl(imageUrl);

	return response;
    }

    @PostMapping("/project")
    public ProjectImageResponse addProjectImage(@RequestBody ProjectImageRequest imageRequest)
	    throws RestApiImagesException {

	String imageUrl = imageService.saveImageAndReturnURL(imageRequest.getProjectPictureUrl(),
		imageRequest.getProjectId());

	ProjectImageResponse response = new ProjectImageResponse();
	response.setPictureUrl(imageUrl);

	return response;
    }
}
