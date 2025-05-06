package com.example.employee.util;

import org.springframework.beans.factory.annotation.Value;
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.exceptions.BadRequestException;
import io.imagekit.sdk.exceptions.ForbiddenException;
import io.imagekit.sdk.exceptions.InternalServerException;
import io.imagekit.sdk.exceptions.TooManyRequestsException;
import io.imagekit.sdk.exceptions.UnauthorizedException;
import io.imagekit.sdk.exceptions.UnknownException;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.results.*;
import io.imagekit.sdk.utils.Utils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Service
public class ImageKitService {

    private final ImageKit imageKit;
    public ImageKitService(ImageKit imageKit) {
        this.imageKit = imageKit;
    }
    public Result uploadFromBytes(MultipartFile file) throws InternalServerException, BadRequestException, UnknownException, ForbiddenException, TooManyRequestsException, UnauthorizedException, IOException {
        File tempFile = multipartFileToFile(file);
        byte[] bytes = Utils.fileToBytes(tempFile);
        FileCreateRequest fileCreateRequest = new FileCreateRequest(bytes, file.getOriginalFilename());
        fileCreateRequest.setUseUniqueFileName(false);
        Result result = ImageKit.getInstance().upload(fileCreateRequest);
        if (result != null && result.getUrl() != null) {
            return result;
        } else {
            return null;
        }
    }


    public static File multipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(System.getProperty("java.io.tmpdir") + "/" + multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        return file;
    }
}
