
package com.aquicksoft.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data

public class Icon {
    
    public String cloud_key;
    public String friendly_url;
    public String image_name;
    public String s3_url;    

}
