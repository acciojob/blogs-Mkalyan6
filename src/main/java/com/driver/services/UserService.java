package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository3;

    @Autowired
    ImageRepository imageRepository3;

    @Autowired
    BlogRepository blogRepository3;

    public User createUser(String username, String password){
        User user=new User(username,password);
        userRepository3.save(user);
        return user;
    }

    public void deleteUser(int userId){
        Optional<User> optionalUser=userRepository3.findById(userId);
        User user=optionalUser.get();
        if(user.getBlogList().size()>0){
            // means this user has written some blogs, by deleting this user, and his works should be deleted
            for(Blog blog: user.getBlogList()){
                Integer blogId= blog.getBlogId();

                // every blog may have images includes init, if present delete those image from database
                if(blog.getImageList().size()>0){
                    for(Image image: blog.getImageList()){
                        // delete the image from the database;
                        imageRepository3.deleteById(image.getImageId());
                    }
                }

                blogRepository3.deleteById(blog.getBlogId());
            }
        }
         // delete the user
         userRepository3.deleteById(user.getUserId());

    }

    public User updateUser(Integer id, String password){
        Optional<User>optionalUser=userRepository3.findById(id);
        User user=optionalUser.get();
        user.setPassword(password);
        userRepository3.save(user);
        return user;

    }
}
