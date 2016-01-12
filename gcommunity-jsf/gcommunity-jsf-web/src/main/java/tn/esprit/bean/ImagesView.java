package tn.esprit.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import entities.Model3D;
 
@ManagedBean
public class ImagesView {
     
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
      
        for (int i = 1; i <= 12; i++) {
            images.add("model" + i + ".jpg");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}
