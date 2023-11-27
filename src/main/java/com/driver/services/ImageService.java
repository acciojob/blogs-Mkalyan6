package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image=new Image(description,dimensions);

        // BIDIRECTIONAL MAPPING
        Optional<Blog> blogOptional=blogRepository2.findById(blogId);
        Blog blog=blogOptional.get();
        image.setBlog(blog);

        blog.getImageList().add(image);

        blogRepository2.save(blog);

        return image;

    }

    public void deleteImage(Integer id){
        // delete this image data from the blog lis for a particular blog
        Optional<Image>optionalImage=imageRepository2.findById(id);
        Image image=optionalImage.get();
        Blog blog=image.getBlog();

        // Bidirectional Mapping
        blog.getImageList().remove(image);

        imageRepository2.deleteById(image.getId());


    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

        // find the image by id provided
        Optional<Image> imageOptional=imageRepository2.findById(id);
        Image image=imageOptional.get();

        String array[]=image.getDimensions().split("X");
        String StrLen=array[0];
        String StrWid=array[1];

        double len=Double.parseDouble(StrLen);
        double wid=Double.parseDouble(StrWid);
        double imageArea=len*wid;

        // decode screendimensions into value
        String[] arrayOfScreen =screenDimensions.split("X");
        String StrLenScreen=arrayOfScreen[0];
        String StrWidScreen=arrayOfScreen[1];

        double lenOfScreen=Double.parseDouble(StrLenScreen);
        double widOfScreen=Double.parseDouble(StrWidScreen);
        double screenArea=lenOfScreen*widOfScreen;

        int noOfImages=(int)(screenArea/imageArea);

        return  noOfImages;
    }
}
